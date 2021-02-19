package com.ckhun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.mapper.EquityRecordMapper;
import com.ckhun.pojo.entity.EquityRecord;
import com.ckhun.service.EquityRecordService;
import org.springframework.stereotype.Service;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:56 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Service
public class EquityRecordServiceImpl extends ServiceImpl<EquityRecordMapper, EquityRecord> implements EquityRecordService {
}
