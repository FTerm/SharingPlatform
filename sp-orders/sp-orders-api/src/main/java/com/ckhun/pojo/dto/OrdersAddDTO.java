package com.ckhun.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 21:22 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel(value = "订单DTO", description = "创建订单的数据结构")
public class OrdersAddDTO implements Serializable {

    private static final long serialVersionUID = 11L;

    private String orderName;

    private Integer paymentType;

    private String promotionId;

    private String skuId;

    private String productCode;

    private Integer userId;
}
