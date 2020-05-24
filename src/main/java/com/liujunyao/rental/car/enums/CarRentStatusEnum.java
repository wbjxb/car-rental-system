package com.liujunyao.rental.car.enums;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午8:57
 */
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarRentStatusEnum {
  IN_STOCK(0),
  RENTED(1);
  private int status;
}
