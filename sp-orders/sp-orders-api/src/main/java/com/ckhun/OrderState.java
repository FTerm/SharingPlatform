package com.ckhun;

import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.OrderStatusEnum;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:41 2021/2/7
 * @description :
 * @since : 1.0.0
 */
public abstract class OrderState {

    public abstract R<?> close(String orderId, OrderStatusEnum orderStatusEnum);

    public abstract R<?> confirm(String orderId, OrderStatusEnum orderStatusEnum);

    public abstract R<?> pay(String orderId, OrderStatusEnum orderStatusEnum);

    public abstract R<?> finish(String orderId, OrderStatusEnum orderStatusEnum);

    public abstract R<?> refund(String orderId, OrderStatusEnum orderStatusEnum);

    public abstract R<?> error(String orderId, OrderStatusEnum orderStatusEnum);
}
