package com.ckhun.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 13:38 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class EquityInfoVo implements Serializable {

    private static final Long SerialVersionUID = 25L;

    private Integer id;
    private String equityId;
    private String name;
    private String description;
    private Integer frequencyFlag;
    private Integer continuous;
    private Integer status;   // 1 正常卡   0 暂定售卖
    private Integer price;
    private Integer discountFlag;
    private Integer discount;
    private Long discountStartTime;
    private Integer discountContinuousTime;
    private Integer newFlag;
    private Integer newContinuousTime;
    private Integer recommend;
    @Deprecated
    private String specialProduct;
}
