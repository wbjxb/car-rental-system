package com.liujunyao.rental.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * car storage
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 上午11:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("car_storage")
public class CarStorage extends BaseEntity<CarStorage> {
  private Integer id;
  /** car model id */
  private Integer modelId;
  /** redundancy car model name */
  private String modelName;
  /** in stock quantity */
  private Integer inStockQuantity;
}
