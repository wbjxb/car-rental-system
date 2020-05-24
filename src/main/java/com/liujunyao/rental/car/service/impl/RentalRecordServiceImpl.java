package com.liujunyao.rental.car.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujunyao.rental.car.entity.RentalRecord;
import com.liujunyao.rental.car.mapper.RentalRecordMapper;
import com.liujunyao.rental.car.service.RentalRecordService;
import org.springframework.stereotype.Service;

/**
 * @author liujunyao
 * @version 1.0
 * @date 2020/5/24 下午8:14
 */
@Service
public class RentalRecordServiceImpl extends ServiceImpl<RentalRecordMapper, RentalRecord>
    implements RentalRecordService {}
