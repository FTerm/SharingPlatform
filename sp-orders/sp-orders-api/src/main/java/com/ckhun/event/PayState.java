package com.ckhun.event;

import com.ckhun.OrderState;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:49 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class PayState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已完成，无法关闭");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已完成，无法关闭");
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已完成，无法关闭");
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已完成，无法关闭");
    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已完成，无法关闭");
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已支付，正常订单");
    }
}
