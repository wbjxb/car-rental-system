package com.liujunyao.rental.car.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liujunyao.rental.car.common.Result;
import com.liujunyao.rental.car.entity.CarStorage;
import com.liujunyao.rental.car.entity.RentalRecord;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午6:55
 */
public interface CarStorageService extends IService<CarStorage> {
  /**
   * rent car
   *
   * @param rentalRecord
   * @return
   */
  Result<Boolean> rent(RentalRecord rentalRecord);
  /**
   * give back car
   *
   * @param licenceNumber
   * @return
   */
  Result<Boolean> sendBack(String licenceNumber);
}
