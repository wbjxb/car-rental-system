package com.liujunyao.rental.car.entity;

import lombok.Data;

/**
 * user for login rent car
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午1:43
 */
@Data
public class User extends BaseEntity {
  private Long id;
  /** first name */
  private String firstName;
  /** last name */
  private String lastName;
  /** area code */
  private String areaCode;
  /** phone number */
  private String phoneNumber;
  /** username for login */
  private String username;
  /** password for login */
  private String password;
}
