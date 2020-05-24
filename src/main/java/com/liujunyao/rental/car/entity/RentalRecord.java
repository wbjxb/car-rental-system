package com.liujunyao.rental.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * rental record
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 上午11:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rental_record")
@NoArgsConstructor
public class RentalRecord extends BaseEntity<RentalRecord> {
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /** user id */
  @TableField(value = "user_id", jdbcType = JdbcType.INTEGER)
  private Integer userId;
  /** car licence number */
  private String licenceNumber;
  /** car model id */
  @NotNull private Integer modelId;

  /** tenancy term start time */
  private Date termStartTime;
  /** tenancy term end time */
  private Date termEndTime;
}
