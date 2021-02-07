package com.ckhun.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:02 2021/2/6
 * @description :
 * @since : 1.0.0
 */
@Data
@Deprecated
@ApiModel(value = "关闭订单DTO", description = "关闭订单的数据结构")
public class OrdersCloseDTO implements Serializable {

    private static final long serialVersionUID = 14L;
}
