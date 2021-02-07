package com.ckhun.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 22:55 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel(value = "更新订单DTO", description = "更新订单的请求数据结构")
public class OrdersUpdateStatusDTO implements Serializable {

    private static final long serialVersionUID = 10L;

    @Deprecated
    private String platform;

    private Integer status;

    private String orderId;

    private Integer uerId;

    private Long closeTime;


}
