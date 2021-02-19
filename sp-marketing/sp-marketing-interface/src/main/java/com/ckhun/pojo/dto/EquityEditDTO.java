package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 13:49 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class EquityEditDTO implements Serializable {

    private static final Long SerialVersionUID = 24L;

    private String equityId;
    private Integer status;
    private Integer discountFlag;
    private EquityDiscount equityDiscount;
}
