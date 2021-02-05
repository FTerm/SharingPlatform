package com.ckhun.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ckhun.pojo.entity.OrdersDetails;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 20:39 2021/1/31
 * @description :
 * @since : 1.0.0
 */

@Data
@ApiModel("订单VO")
public class OrdersVo implements Serializable {

    private static final long serialVersionUID = 11L;

    private String orderId;

    private String orderName;

    private Long orderPrice;

    private Long actualPrice;

    private Integer paymentType;

    private String skuId;

    private String productCode;

    private String locationId;

    private Integer orderType;

    private String promotionId;

    private String vendorId;

    private String transactionsId;

    private Integer orderFlag;

    private Long userId;

    private Long createTime;

    private List<OrdersDetails> ordersDetails;

    private Integer status;

    private String paymentId;

    private Long payTime;
}
