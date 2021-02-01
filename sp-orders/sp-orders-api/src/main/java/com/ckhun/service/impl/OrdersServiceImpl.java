package com.ckhun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.mapper.OrdersMapper;
import com.ckhun.pojo.dto.OrdersAddDTO;
import com.ckhun.pojo.dto.OrdersUpdateDTO;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.entity.Orders;
import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.TimeUtil;
import com.ckhun.utils.TrueOrFalseEnum;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:42 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {


    @Override
    @Transactional
    public String createOrder(OrdersAddDTO ordersAddDTO) {
        Orders orders = new Orders();

        OrdersDetails ordersDetails = new OrdersDetails();

        OrdersStatus ordersStatus = new OrdersStatus();

        BeanUtils.copyProperties(ordersAddDTO, orders);
        orders.setOrderFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        String randomOrderId = getRandomOrderId(orders.getOrderName());
        String randomTransactionsId = getRandomTransactionsId(orders.getOrderName());
        Long time = TimeUtil.getCreateTime();
        orders.setCreateTime(time);
        orders.setTransactionsId(randomTransactionsId);
        // 用商品拿价格

        if (ordersAddDTO.getPromotionId() == null) {
            // 预留有活动优惠的订单信息
        }

        ordersStatus.setOrderId(randomOrderId);
        ordersStatus.setOrderStatus(0);
        ordersStatus.setCreateTime(time);

        boolean save = this.save(orders);
//        boolean save1 = this.save(ordersDetails);
        System.out.println(orders);
        return randomOrderId;
    }

    @Override
    public OrdersVo queryById(String orderId) {
        return null;
    }

    @Override
    public Boolean updateOrder(OrdersUpdateDTO ordersUpdateDTO) {
        return null;
    }

    @Override
    public List<OrdersVo> getAllOrder() {
        return null;
    }

    @Override
    public PageResult selectOrderByPage(PageRequest pageRequest) {
        return null;
    }

    @Override
    public Boolean updateOrderStatus(OrdersUpdateStatusDTO ordersUpdateStatusDTO) {
        return null;
    }

    @Override
    public List<OrdersVo> getOrderByUser(String userId) {
        return null;
    }

    private String getRandomOrderId(String s) {
        return new Sha1Hash(System.currentTimeMillis() + ""+ s + "sha1Encode").toString();
    }
    private String getRandomTransactionsId(String s) {
        return new Sha512Hash(System.currentTimeMillis() + ""+ s + "sha1Encode").toString();
    }
}
