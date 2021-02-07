package com.ckhun.pojo.vo;

import com.ckhun.pojo.entity.OrdersDetails;
import com.ckhun.pojo.entity.OrdersStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 17:38 2021/2/7
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel("获取订单列表或者单条记录的VO")
public class OrderListVo implements Serializable {

    private static final long SerialVersionUID = 18L;

    private String orderId;

    private String orderName;

    private Long orderPrice;

    private Long actualPrice;

    private Integer paymentType;

    private Integer orderType;

    private String promotionId;

    private String vendorId;

    private String transactionsId;

    private Integer orderFlag;

    private Long userId;

    private Long createTime;

    private String billingModel;

    private String image;

    private String skuId;

    private String productCode;

    private Integer orderStatus;

    private String paymentId;

    private Long payTime;

    private Long closeTime;

    private Long updateTime;
}
