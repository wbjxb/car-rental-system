package com.liujunyao.rental.car.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liujunyao.rental.car.entity.CarStorage;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 上午11:07
 */
public interface CarStorageMapper extends BaseMapper<CarStorage> {
  int rent(Integer modelId);

  int giveBack(Integer modelId);
}
