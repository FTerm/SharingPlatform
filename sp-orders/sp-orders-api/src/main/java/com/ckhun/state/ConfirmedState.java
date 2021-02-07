package com.ckhun.state;

import com.ckhun.OrderState;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.service.OrdersService;
import com.ckhun.service.impl.OrdersServiceImpl;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:47 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class ConfirmedState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        R<?> r = this.updateDTO(orderId, orderStatusEnum);
        if (r.isSuccess()) {return new R<>("订单已关闭");}
        else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(400, "订单关闭失败，请稍后再试");
        }


    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已确认，请勿重复确认");

    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        // TODO 接入支付系统
        return new R<>().fail(400, "订单暂时不支持支付");
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单未支付，无法完成");

    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已确认，无需退款，可以直接选择关闭");

    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已确认，正常订单");

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
