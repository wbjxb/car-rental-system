package com.liujunyao.rental.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * car
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "car")
@NoArgsConstructor
public class Car extends BaseEntity {
  private Integer id;
  /** Case Insensitive */
  private String licenseNumber;

  /** car model */
  private Integer modelId;
  /** rental status 0 in stock 1 rented */
  private Integer status;
  /** car health scraped */
  private Boolean deleted;
}
