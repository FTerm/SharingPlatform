package com.ckhun.event;

import com.ckhun.OrderState;
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
        return null;
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return null;
    }
}
