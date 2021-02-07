package com.ckhun.state;

import com.ckhun.OrderState;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:51 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class ErrorState extends OrderState {
    @Override
    public R<?> close(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }

    @Override
    public R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }

    @Override
    public R<?> pay(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }

    @Override
    public R<?> finish(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }

    @Override
    public R<?> refund(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }

    @Override
    public R<?> error(String orderId, OrderStatusEnum orderStatusEnum) {
        return new R<>().fail(400, "异常订单，请联系客服处理");
    }
}
