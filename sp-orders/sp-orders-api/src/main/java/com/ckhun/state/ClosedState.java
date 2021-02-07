package com.ckhun.state;

import com.ckhun.OrderState;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:48 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class ClosedState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单处于关闭状态，无需再次关闭");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单处于关闭状态，无法确认");
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单处于关闭状态，无法支付");

    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单处于关闭状态，无法完成");

    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单处于关闭状态，没有退款选项");
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单已关闭，正常订单");
    }
}
