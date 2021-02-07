package com.ckhun.state;

import com.ckhun.OrderState;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.vo.OrderListVo;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.service.OrdersService;
import com.ckhun.service.impl.OrdersServiceImpl;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:49 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class PayState extends OrderState {

    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已支付，无法关闭");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已支付，无法再次确认");
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已支付，请勿重复支付");
    }

    @Override
    @Transactional
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        R<?> r = this.updateDTO(orderId, orderStatusEnum);
        if (r.isSuccess()) {
            return new R<>("订单状态已经设置为完成状态");
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(400, "订单完成失败，请稍后再试");
        }

    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已支付，无法退款");
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已支付，正常订单");
    }

    private R<?> updateDTO(String orderId, OrderStatusEnum orderStatusEnum) {
        OrdersUpdateStatusDTO ordersUpdateStatusDTO = new OrdersUpdateStatusDTO();
        ordersUpdateStatusDTO.setStatus(orderStatusEnum.getStatus());
        ordersUpdateStatusDTO.setOrderId(orderId);
        ordersUpdateStatusDTO.setCloseTime(TimeUtil.getCreateTime());
        OrdersService ordersService = new OrdersServiceImpl();
        return ordersService.updateOrderStatus(ordersUpdateStatusDTO);
    }
}
