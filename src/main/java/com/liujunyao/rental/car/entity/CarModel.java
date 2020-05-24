package com.liujunyao.rental.car.entity;

import lombok.Data;

/**
 * car model
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:44
 */
@Data
public class CarModel extends BaseEntity<CarModel> {
  private Integer id;
  /** model name */
  private String name;
}
