package com.liujunyao.rental.car.service.impl;

import com.liujunyao.rental.car.common.Result;
import com.liujunyao.rental.car.common.ResultCode;
import com.liujunyao.rental.car.entity.CarStorage;
import com.liujunyao.rental.car.entity.RentalRecord;
import com.liujunyao.rental.car.service.CarStorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午10:35
 */
@SpringBootTest
class CarStorageServiceImplTest {

  @Autowired private CarStorageService carStorageService;

  @Test
  void rent() {
    RentalRecord rentalRecord = new RentalRecord().setModelId(1).setUserId(123);
    Assertions.assertEquals(
        carStorageService.rent(rentalRecord).getCode(), ResultCode.OK.getCode());
    for (CarStorage carStorage : carStorageService.list()) {
      System.out.println(carStorage.getInStockQuantity());
    }
    rentalRecord.setUserId(124);
    Assertions.assertEquals(
        carStorageService.rent(rentalRecord).getCode(), ResultCode.OK.getCode());
    rentalRecord.setUserId(125);
    Assertions.assertNotEquals(
        carStorageService.rent(rentalRecord).getCode(), ResultCode.OK.getCode());
  }

  @Test
  void sendBack() {

    Result<Boolean> booleanResult = carStorageService.sendBack("粤B1111");
  }
}
