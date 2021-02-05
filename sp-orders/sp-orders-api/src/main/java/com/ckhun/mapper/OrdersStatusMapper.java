package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.OrdersStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:39 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface OrdersStatusMapper extends BaseMapper<OrdersStatusMapper> {

    int addOrdersStatus(OrdersStatus ordersStatus);

    OrdersStatus queryOrdersStatusById(String id);
}
