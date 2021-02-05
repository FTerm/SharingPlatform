package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.OrdersDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:39 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface OrdersDetailsMapper extends BaseMapper<OrdersDetailsMapper> {

    int addOrdersDetails(OrdersDetails ordersDetails);

    OrdersDetails queryDetailsById(String id);
}
