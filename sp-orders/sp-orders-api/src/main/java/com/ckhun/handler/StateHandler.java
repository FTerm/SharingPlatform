package com.ckhun.handler;

import com.ckhun.OrderState;
import com.ckhun.event.*;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:57 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public class StateHandler {

    private Map<Enum<OrderStatusEnum>, OrderState> stateMap = new ConcurrentHashMap<>();

    public StateHandler() {
        stateMap.put(OrderStatusEnum.ORDER_IS_CLOSE, new ClosedState());
        stateMap.put(OrderStatusEnum.ORDER_IS_NOT_PAY, new ConfirmedState());
        stateMap.put(OrderStatusEnum.ORDER_IS_PAY, new PayState());
        stateMap.put(OrderStatusEnum.ORDER_IS_FINISH, new FinishedState());
        stateMap.put(OrderStatusEnum.ORDER_IS_REFUND, new RefundedState());
        stateMap.put(OrderStatusEnum.ORDER_IS_ERROR, new ErrorState());
    }

    public R<?> action(String orderId, OrderStatusEnum orderStatusEnum, OrderStatusEnum currentStatus) {
        OrderState orderState = stateMap.get(orderStatusEnum);
        switch (currentStatus) {
            case ORDER_IS_CLOSE:
                return orderState.close(orderId, currentStatus);
            case ORDER_IS_NOT_PAY:
                return orderState.confirm(orderId, currentStatus);
            case ORDER_IS_PAY:
                return orderState.pay(orderId, currentStatus);
            case ORDER_IS_FINISH:
                return orderState.finish(orderId, currentStatus);
            case ORDER_IS_REFUND:
                return orderState.refund(orderId, currentStatus);
            default:
                return orderState.error(orderId, currentStatus);
        }
    }

}
