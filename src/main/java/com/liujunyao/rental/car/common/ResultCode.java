package com.liujunyao.rental.car.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:23
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
  OK(0, "OK"),

  API_TOO_FREQUENTLY(500001, "access api too frequently."),
  NO_CAR_FOR_RENT(500002, "no car for rent."),
  CAR_LICENCE_NUMBER_VALID(500003, "car licence number valid."),
  CAR_ALREADY_GIVE_BACK(500004, "car already give back."),
  FAILED(1, "Failed");
  private int code;
  private String message;
}
