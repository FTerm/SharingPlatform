package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:27 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class EquityAddDTO implements Serializable {

    private static final Long SerialVersionUID = 21L;

    private String name;
    private String description;
    private Integer frequencyFlag;
    private Integer continuous;
    private Integer status;
    private Integer price;
    private Integer recommend;
    private Integer discountFlag;
    private EquityDiscount equityDiscount;
    private Integer newFlag;
    private Integer newContinuousTime;
    @Deprecated
    private String specialProduct;
}
