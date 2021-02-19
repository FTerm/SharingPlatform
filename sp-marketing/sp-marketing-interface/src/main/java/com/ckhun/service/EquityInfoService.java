package com.ckhun.service;

import com.ckhun.pojo.dto.EquityAddDTO;
import com.ckhun.pojo.dto.EquityEditDTO;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:55 2021/2/19
 * @description :
 * @since : 1.0.0
 */
public interface EquityInfoService {

    /**
     * 创建权益卡
     * @param equityAddDTO
     * @return
     */
    R<?> createEquity(EquityAddDTO equityAddDTO);

    /**
     * 修改折扣信息
     * @param equityEditDTO
     * @return
     */
    R<?> modifyEquity(EquityEditDTO equityEditDTO);

    /**
     * 删除
     * @param equityId
     * @return
     */
    R<?> delEquity(String equityId);

    /**
     * 分页
     * @param pageRequest
     * @return
     */
    PageResult findEquityByPage(PageRequest pageRequest);

}
