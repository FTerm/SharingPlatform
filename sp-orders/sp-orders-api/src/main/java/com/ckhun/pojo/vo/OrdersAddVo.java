package com.ckhun.pojo.vo;

import com.ckhun.pojo.entity.OrdersStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:39 2021/2/7
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel("订单创建VO")
public class OrdersAddVo implements Serializable {

    private static final long serialVersionUID = 11L;

    private String orderId;

    private String orderName;

    private Long orderPrice;

    private Long actualPrice;

    private Integer paymentType;

    private Integer orderType;

    private Long createTime;

    private OrdersStatus status;
}
