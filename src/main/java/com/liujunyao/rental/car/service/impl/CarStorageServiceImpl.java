package com.liujunyao.rental.car.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujunyao.rental.car.common.Result;
import com.liujunyao.rental.car.common.ResultCode;
import com.liujunyao.rental.car.entity.Car;
import com.liujunyao.rental.car.entity.CarStorage;
import com.liujunyao.rental.car.entity.RentalRecord;
import com.liujunyao.rental.car.enums.CarRentStatusEnum;
import com.liujunyao.rental.car.mapper.CarStorageMapper;
import com.liujunyao.rental.car.service.CarService;
import com.liujunyao.rental.car.service.CarStorageService;
import com.liujunyao.rental.car.service.RentalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * car storage service
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午6:56
 */
@Service
public class CarStorageServiceImpl extends ServiceImpl<CarStorageMapper, CarStorage>
    implements CarStorageService {
  @Autowired private RentalRecordService rentalRecordService;
  @Autowired private CarService carService;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Result<Boolean> rent(RentalRecord rentalRecord) {
    int rent = baseMapper.rent(rentalRecord.getModelId());
    if (rent < 1) {
      return Result.tips(ResultCode.NO_CAR_FOR_RENT);
    }
    List<Car> carList =
        carService
            .lambdaQuery()
            .eq(Car::getModelId, rentalRecord.getModelId())
            .eq(Car::getStatus, CarRentStatusEnum.IN_STOCK.getStatus())
            .list();

    if (Objects.isNull(carList) || carList.size() < 1) {
      return Result.tips(ResultCode.NO_CAR_FOR_RENT);
    }
    Car car = carList.get(0);
    car.setStatus(CarRentStatusEnum.RENTED.getStatus());
    carService.updateById(car);

    rentalRecord.setLicenceNumber(car.getLicenseNumber());
    rentalRecord.setCreateTime(new Date());
    return Result.ok(rentalRecordService.save(rentalRecord));
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Result<Boolean> sendBack(String licenceNumber) {
    Car one = carService.lambdaQuery().eq(Car::getLicenseNumber, licenceNumber).one();
    if (Objects.isNull(one)) {
      return Result.tips(ResultCode.CAR_LICENCE_NUMBER_VALID);
    }

    if (CarRentStatusEnum.RENTED.getStatus() == one.getStatus()) {
      one.setStatus(CarRentStatusEnum.IN_STOCK.getStatus());
      carService.saveOrUpdate(one);

      int i = baseMapper.giveBack(one.getModelId());
      rentalRecordService.update(
          Wrappers.<RentalRecord>lambdaUpdate()
              .eq(RentalRecord::getLicenceNumber, licenceNumber)
              .set(RentalRecord::getTermEndTime, new Date()));
    } else {
      return Result.tips(ResultCode.CAR_ALREADY_GIVE_BACK);
    }

    return Result.ok(true);
  }
}
