package com.ckhun.utils;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:06 2021/2/6
 * @description :
 * @since : 1.0.0
 */
@Getter
public enum OrderStatusEnum {
    @Deprecated
    ORDER_IS_DEL(0, "订单已删除"),

    ORDER_IS_CLOSE(1, "订单已关闭"),
    ORDER_IS_NOT_PAY(2, "订单待支付"),
    ORDER_IS_PAY(3, "订单已支付"),
    ORDER_IS_FINISH(4, "订单已完成"),
    ORDER_IS_REFUND(5, "订单已退款"),
    ORDER_IS_ERROR(6, "异常订单")
    ;


    private final Integer status;
    private final String statusMsg;

    OrderStatusEnum(Integer status, String statusMsg) {
        this.status = status;
        this.statusMsg = statusMsg;
    }

    /**
     * 根据状态码返回枚举类的名
     * @param status
     * @return
     */
    public static String getNameForValue(Integer status) {
        OrderStatusEnum[] values = OrderStatusEnum.values();
        OrderStatusEnum enumValue = null;

        for (OrderStatusEnum value : values) {
            enumValue = value;

            if (enumValue.getStatus().equals(status)) {
                return value.name();
            }
        }
        return String.valueOf(enumValue);
    }
}
