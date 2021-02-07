package com.ckhun.service;


import com.ckhun.pojo.dto.OrdersAddDTO;
import com.ckhun.pojo.dto.OrdersCloseDTO;
import com.ckhun.pojo.dto.OrdersUpdateDTO;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.vo.OrderListVo;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:42 2021/1/31
 * @description :
 * @since : 1.0.0
 */
public interface OrdersService {

    /**
     * 创建订单
     * @param ordersAddDTO
     * @return
     */
    R<?> createOrder(OrdersAddDTO ordersAddDTO);

    /**
     * 通过order id查询订单信息
     * @param orderId
     * @return
     */
    OrdersVo queryById(String orderId);

    /**
     * 更新订单信息
     * @param ordersUpdateDTO
     * @return
     */
    @Deprecated
    Boolean updateOrder(OrdersUpdateDTO ordersUpdateDTO);

    /**
     * 获取全部订单信息
     * @return
     */
    List<OrderListVo> getAllOrder();

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult selectOrderByPage(PageRequest pageRequest);

    /**
     * 用户关闭订单
     * @param ordersCloseDTO
     * @return
     */
    @Deprecated
    Boolean closeOrder(OrdersCloseDTO ordersCloseDTO);

    /**
     * 更新订单状态
     * @param ordersUpdateStatusDTO
     * @return
     */
    R<?> updateOrderStatus(OrdersUpdateStatusDTO ordersUpdateStatusDTO);

    /**
     * 用户删除订单
     * @param orderId
     * @param userId
     * @return
     */
    R<?> delOrderByUser(String orderId, Integer userId);


    /**
     * 根据user_id查询用户全部订单
     * @param userId
     * @return
     */
    List<OrderListVo> getOrderByUser(Integer userId);

}
