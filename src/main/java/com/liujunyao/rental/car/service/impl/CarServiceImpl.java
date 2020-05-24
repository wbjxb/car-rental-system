package com.liujunyao.rental.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujunyao.rental.car.entity.Car;
import com.liujunyao.rental.car.mapper.CarMapper;
import com.liujunyao.rental.car.service.CarService;
import org.springframework.stereotype.Service;

/**
 * car storage service
 *
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午6:56
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {}
