package com.liujunyao.rental.car.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * base entity
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:41
 */
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> implements Serializable {
  /** create time */
  protected Date createTime;
}
