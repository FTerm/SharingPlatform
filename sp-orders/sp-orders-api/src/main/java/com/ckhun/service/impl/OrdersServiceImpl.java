package com.ckhun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.goods.service.ModeService;
import com.ckhun.mapper.OrdersDetailsMapper;
import com.ckhun.mapper.OrdersMapper;
import com.ckhun.mapper.OrdersStatusMapper;
import com.ckhun.pojo.dto.OrdersAddDTO;
import com.ckhun.pojo.dto.OrdersUpdateDTO;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.entity.Orders;
import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.*;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:42 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersDetailsMapper ordersDetailsMapper;

    @Autowired
    private OrdersStatusMapper ordersStatusMapper;

    @Autowired
    private GoodsService goodsService;

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
        orders.setTransactionsId(randomTransactionsId);
        // 用商品拿价格
        R<Goods> goodsR = goodsService.goodsByCode(ordersAddDTO.getProductCode());
        if (goodsR.getErrCode() == ErrorEnum.SUCCESS.getErrCode()) {
            Goods data = goodsR.getData();
            ordersDetails.setUnit(data.getUnit());
            // 缺商品单价
        }

        if (ordersAddDTO.getPromotionId() != null) {
            // 预留有活动优惠的订单信息
        }

        ordersStatus.setOrderId(randomOrderId);
        ordersStatus.setOrderStatus(0);


        try {
            boolean save = this.save(orders);
            int addOrdersDetails = ordersDetailsMapper.addOrdersDetails(ordersDetails);
            int addOrdersStatus = ordersStatusMapper.addOrdersStatus(ordersStatus);
            if (save && addOrdersStatus == 1 && addOrdersDetails == 1) {
                return randomOrderId;
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return "rollback";
            }
        } catch (Exception exception) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "rollback";
        }

    }

    @Override
    public OrdersVo queryById(String orderId) {
        OrdersVo ordersVo = new OrdersVo();
        QueryWrapper<Orders> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("order_id", orderId);
        Orders orders = this.getOne(objectQueryWrapper);
        BeanUtils.copyProperties(orders, ordersVo);
        OrdersDetails ordersDetails = ordersDetailsMapper.queryDetailsById(orderId);
        OrdersStatus ordersStatus = ordersStatusMapper.queryOrdersStatusById(orderId);
        BeanUtils.copyProperties(ordersDetails, ordersVo);
        BeanUtils.copyProperties(ordersStatus, ordersVo);
        ordersVo.setStatus(ordersStatus.getOrderStatus());
        return ordersVo;
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
