package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.Orders;
import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import com.ckhun.pojo.vo.OrderListVo;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:38 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    int addOrdersDetails(OrdersDetails ordersDetails);

    @Select("   SELECT\n" +
            "	c_orders.order_id,\n" +
            "	c_orders.order_name,\n" +
            "	c_orders.order_price,\n" +
            "	c_orders.actual_price,\n" +
            "	c_orders.payment_type,\n" +
            "	c_orders.order_type,\n" +
            "	c_orders.promotion_id,\n" +
            "	c_orders.vendor_id,\n" +
            "	c_orders.transactions_id,\n" +
            "	c_orders.order_flag,\n" +
            "	c_orders.user_id,\n" +
            "	c_orders.create_time,\n" +
            "	c_orders_details.billing_model,\n" +
            "	c_orders_details.sku_id,\n" +
            "	c_orders_details.product_code,\n" +
            "	c_orders_details.image,\n" +
            "	c_orders_status.order_status,\n" +
            "	c_orders_status.pay_time,\n" +
            "	c_orders_status.payment_id,\n" +
            "	c_orders_status.close_time,\n" +
            "	c_orders_status.update_time \n" +
            "   FROM\n" +
            "	( `c_orders` LEFT JOIN `c_orders_details` ON c_orders.order_id = c_orders_details.order_id )\n" +
            "	LEFT JOIN `c_orders_status` ON c_orders.order_id = c_orders_status.order_id\n" +
            "	WHERE c_orders.order_flag = 0")
    List<OrderListVo> getOrdersList();

    @Select("   SELECT\n" +
            "	c_orders.order_id,\n" +
            "	c_orders.order_name,\n" +
            "	c_orders.order_price,\n" +
            "	c_orders.actual_price,\n" +
            "	c_orders.payment_type,\n" +
            "	c_orders.order_type,\n" +
            "	c_orders.promotion_id,\n" +
            "	c_orders.vendor_id,\n" +
            "	c_orders.transactions_id,\n" +
            "	c_orders.order_flag,\n" +
            "	c_orders.user_id,\n" +
            "	c_orders.create_time,\n" +
            "	c_orders_details.billing_model,\n" +
            "	c_orders_details.sku_id,\n" +
            "	c_orders_details.product_code,\n" +
            "	c_orders_details.image,\n" +
            "	c_orders_status.order_status,\n" +
            "	c_orders_status.pay_time,\n" +
            "	c_orders_status.payment_id,\n" +
            "	c_orders_status.close_time,\n" +
            "	c_orders_status.update_time \n" +
            "   FROM\n" +
            "	( `c_orders` LEFT JOIN `c_orders_details` ON c_orders.order_id = c_orders_details.order_id )\n" +
            "	LEFT JOIN `c_orders_status` ON c_orders.order_id = c_orders_status.order_id\n" +
            "	WHERE c_orders.order_flag = 0 and c_orders.user_id = #{id}")
    List<OrderListVo> getOrdersByUser(Integer id);
}
