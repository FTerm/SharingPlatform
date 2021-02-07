package com.ckhun.event;

import com.ckhun.OrderState;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:47 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class ConfirmedState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>("订单已关闭");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已确认，请勿重复确认");

    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单未支付，无法完成");

    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已确认，无需退款，可以直接选择关闭");

    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(ErrorEnum.UPDATE_EOR, "订单已确认，正常订单");

    }
}
