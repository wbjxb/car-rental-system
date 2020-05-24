package com.liujunyao.rental.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** @author liujunyao */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.liujunyao.rental.car.mapper.**")
public class RentalCarApplication {

  public static void main(String[] args) {
    SpringApplication.run(RentalCarApplication.class, args);
  }
}
