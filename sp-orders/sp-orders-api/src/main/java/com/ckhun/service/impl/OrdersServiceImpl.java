package com.ckhun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.handler.StateHandler;
import com.ckhun.mapper.OrdersDetailsMapper;
import com.ckhun.mapper.OrdersMapper;
import com.ckhun.mapper.OrdersStatusMapper;
import com.ckhun.pojo.dto.OrdersAddDTO;
import com.ckhun.pojo.dto.OrdersCloseDTO;
import com.ckhun.pojo.dto.OrdersUpdateDTO;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.entity.Orders;
import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import com.ckhun.pojo.vo.OrderListVo;
import com.ckhun.pojo.vo.OrdersAddVo;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    // TODO 待处理返回类型
    @Override
    @Transactional
    public R<?> createOrder(OrdersAddDTO ordersAddDTO) {
        Orders orders = new Orders();
        R<OrdersAddVo> r = new R<>();
        OrdersAddVo ordersAddVo = new OrdersAddVo();

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
            // TODO 判断该sku是否可以租
            Goods data = goodsR.getData();
            ordersDetails.setUnit(data.getUnit());
            // 缺商品单价
        }

        if (ordersAddDTO.getPromotionId() != null) {
            // 预留有活动优惠的订单信息
        }

        ordersStatus.setOrderId(randomOrderId);
        ordersStatus.setOrderStatus(OrderStatusEnum.ORDER_IS_NOT_PAY.getStatus());


        try {
            boolean save = this.save(orders);
            int addOrdersDetails = ordersDetailsMapper.addOrdersDetails(ordersDetails);
            int addOrdersStatus = ordersStatusMapper.addOrdersStatus(ordersStatus);
            if (save && addOrdersStatus == 1 && addOrdersDetails == 1) {
                BeanUtils.copyProperties(orders, ordersAddVo);
                ordersAddVo.setStatus(ordersStatus);
                r.setData(ordersAddVo);
                return r;
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return r.fail(ErrorEnum.CREATE_EOR, null);
            }
        } catch (Exception exception) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return r.fail(ErrorEnum.CREATE_EOR, null);
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
        ordersVo.setOrdersDetails(ordersDetails);
        ordersVo.setStatus(ordersStatus);
        return ordersVo;
    }


    @Deprecated
    @Override
    public Boolean updateOrder(OrdersUpdateDTO ordersUpdateDTO) {
        return null;
    }

    @Override
    public List<OrderListVo> getAllOrder() {
        return this.baseMapper.getOrdersList();
    }

    @Override
    public PageResult selectOrderByPage(PageRequest pageRequest) {
        return pageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 请使用 @updateOrderStatus代替这个业务逻辑
     * @param ordersCloseDTO
     * @return
     */
    @Deprecated
    @Override
    public Boolean closeOrder(OrdersCloseDTO ordersCloseDTO) {
        return null;
    }

    @Override
    @Transactional
    public R<?> delOrderByUser(String orderId, Integer userId) {
        QueryWrapper<Orders> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("order_id", orderId);
        objectQueryWrapper.eq("user_id", userId);
        Orders order = this.getOne(objectQueryWrapper);
        if (order != null) {
            OrdersVo ordersVo = this.queryById(orderId);
            Integer orderStatus = ordersVo.getStatus().getOrderStatus();
            if (orderStatus.equals(OrderStatusEnum.ORDER_IS_CLOSE.getStatus())
                    || orderStatus.equals(OrderStatusEnum.ORDER_IS_FINISH.getStatus())) {
                boolean remove = this.remove(objectQueryWrapper);
                if (remove) return new R<>(ErrorEnum.DELETE_SUCCESS.getErrMsg());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } else {
                return new R<>().fail(ErrorEnum.DELETE_EOR, null);
            }
        }
        return new R<>().fail(ErrorEnum.DELETE_EOR, null);
    }

    @Override
    @Transactional
    public R<?> updateOrderStatus(OrdersUpdateStatusDTO ordersUpdateStatusDTO) {

        // TODO 参数验证
        OrdersStatus ordersStatus = new OrdersStatus();
        StateHandler stateHandler = new StateHandler();
        BeanUtils.copyProperties(ordersUpdateStatusDTO, ordersStatus);
        // 状态值处理 只能按照固定的状态来更新
        // 比如已关闭的订单不能支付
        /*
         * 订单的类型有三种： 先租后买, 以租代售, 共享租赁
         * 1. 关闭订单无法再次修改状态
         * 2. 已经删除订单无法恢复， 删除订单应该用order_type处理，此处的枚举值不应该使用
         * 3. 枚举类不能更新到比当前值更小的值
         * 4. 特殊情况待支付的订单可以关闭，若该订单是正常且正在使用的话 不支持关闭和删除订单
         * 5. 异常订单可以进行处理状态为:  删除、关闭、已完成、已退款
         * 6. 共享租赁的话订单存在状态为:  关闭、待支付、已完成、异常订单
         * 7. 先租后买的话订单存在状态为:  关闭、待支付、已支付、已完成、异常订单
         * 8. 以租代售的话订单存在状态为:  关闭、待支付、已支付、已完成、异常订单
         *
         * 订单模式的修改 不支持
         */
        OrdersVo ordersVo = this.queryById(ordersUpdateStatusDTO.getOrderId());
        if (ordersVo == null) return new R<>().fail(ErrorEnum.FAIL, null);
        Integer orderStatus = ordersVo.getStatus().getOrderStatus();
        String nameForValue = OrderStatusEnum.getNameForValue(orderStatus);
        OrderStatusEnum orderStatusEnum = OrderStatusEnum.valueOf(nameForValue);
        OrderStatusEnum currentStatus = OrderStatusEnum.valueOf(OrderStatusEnum.getNameForValue(ordersUpdateStatusDTO.getStatus()));
        R<?> action = stateHandler.action(ordersVo.getOrderId(), orderStatusEnum, currentStatus);
        if (!action.isSuccess()) {
            return action;
        }
        boolean res = ordersStatusMapper.updateOrdersStatus(ordersStatus);
        if (res) {
            return new R<>(ErrorEnum.UPDATE_SUCCESS.getErrMsg());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
    }

    @Override
    public List<OrderListVo> getOrderByUser(Integer userId) {
        return this.baseMapper.getOrdersByUser(userId);
    }

    private String getRandomOrderId(String s) {
        return new Sha1Hash(System.currentTimeMillis() + ""+ s + "sha1Encode").toString();
    }
    private String getRandomTransactionsId(String s) {
        return new Sha512Hash(System.currentTimeMillis() + ""+ s + "sha1Encode").toString();
    }

    private PageInfo<OrderListVo> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<OrderListVo> ordersList = this.baseMapper.getOrdersList();
        return new PageInfo<OrderListVo>(ordersList);
    }
}
