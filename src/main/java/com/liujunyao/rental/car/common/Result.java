package com.liujunyao.rental.car.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:21
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Result<T> {
  private int code;
  private String message;
  private T data;

  public static <T> Result<T> ok(T data) {
    return Result.restResult(ResultCode.OK, data);
  }

  public static <T> Result<T> tips(ResultCode resultCode) {
    return new Result(resultCode.getCode(), resultCode.getMessage(), null);
  }

  public static <T> Result<T> errorMessage(ResultCode resultCode, String message) {
    return new Result(resultCode.getCode(), message, null);
  }

  private static <T> Result<T> restResult(ResultCode resultCode, T data) {
    return new Result(resultCode.getCode(), resultCode.getMessage(), data);
  }
}
