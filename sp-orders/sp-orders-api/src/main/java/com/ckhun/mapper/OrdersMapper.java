package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.Orders;
import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:38 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    int addOrdersDetails(OrdersDetails ordersDetails);
}
