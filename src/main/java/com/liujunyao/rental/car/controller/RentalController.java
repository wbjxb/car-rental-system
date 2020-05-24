package com.liujunyao.rental.car.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.liujunyao.rental.car.UserUtil;
import com.liujunyao.rental.car.common.Result;
import com.liujunyao.rental.car.common.ResultCode;
import com.liujunyao.rental.car.entity.CarStorage;
import com.liujunyao.rental.car.entity.RentalRecord;
import com.liujunyao.rental.car.service.CarStorageService;
import com.liujunyao.rental.car.service.RentalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 上午11:49
 */
@RestController
@RequestMapping("/cars")
public class RentalController {
  /** rate limiter basis of scale */
  public static final RateLimiter rateLimiter = RateLimiter.create(100d);

  @Autowired private CarStorageService carStorageService;
  @Autowired private RentalRecordService rentalRecordService;

  /**
   * car storage display
   *
   * @return
   */
  @GetMapping("")
  public Result<List<CarStorage>> listCarStorage() {
    return Result.ok(carStorageService.list());
  }

  /**
   * car rental records
   *
   * @return
   */
  @GetMapping("/rental")
  public Result<List<RentalRecord>> listRentalRecord() {
    return Result.ok(rentalRecordService.list());
  }

  /**
   * rent car
   *
   * @param rentalRecord
   * @return
   */
  @PostMapping("/rental")
  public Result<Boolean> rental(@RequestBody RentalRecord rentalRecord) {
    if (rateLimiter.tryAcquire(1)) {
      RateLimiter rateLimiterForUser = UserUtil.rateLimiterForUser();
      if (rateLimiterForUser.tryAcquire(1)) {
        return carStorageService.rent(rentalRecord);
      } else {
        return Result.tips(ResultCode.API_TOO_FREQUENTLY);
      }
    } else {
      return Result.tips(ResultCode.API_TOO_FREQUENTLY);
    }
  }

  /**
   * give back
   *
   * @param licenceNumber
   * @return
   */
  @PostMapping("/return/{number}")
  public Result<Boolean> returnBack(@PathVariable(value = "number") String licenceNumber) {
    return carStorageService.sendBack(licenceNumber);
  }
}
