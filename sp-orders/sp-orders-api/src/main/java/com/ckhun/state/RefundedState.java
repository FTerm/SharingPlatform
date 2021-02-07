package com.ckhun.state;

import com.ckhun.OrderState;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:50 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class RefundedState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单退款，无法关闭");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单退款，无法确认");
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单退款，请勿支付");
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        // TODO 退款逻辑
        return new R<>().fail(400, "退款已完成");
    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "已经正在处理退款");
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "订单退款，正常订单");
    }
}
