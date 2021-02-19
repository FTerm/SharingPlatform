package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:30 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class EquityDiscount implements Serializable {

    private static final Long SerialVersionUID = 22L;

    private Integer discount;
    private Long discountStartTime;
    private Integer discountContinuousTime;
}
