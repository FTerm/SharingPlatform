package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:21 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
@TableName("m_equity_info")
public class EquityInfo implements Serializable {

    private static final Long SerialVersionUID = 20L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("equity_id")
    private String equityId;
    @TableField("name")
    private String name;
    @TableField("description")
    private String description;
    @TableField("frequency_flag")
    private Integer frequencyFlag;
    @TableField("continuous")
    private Integer continuous;
    @TableField("del_flag")
    private Integer delFlag;
    @TableField("status")
    private Integer status;   // 1 正常卡   0 暂定售卖
    @TableField("price")
    private Integer price;
    @TableField("discount_flag")
    private Integer discountFlag;
    @TableField("discount")
    private Integer discount;
    @TableField("discount_start_time")
    private Long discountStartTime;
    @TableField("discount_continuous_time")
    private Integer discountContinuousTime;
    @TableField("new_flag")
    private Integer newFlag;
    @TableField("new_continuous_time")
    private Integer newContinuousTime;
    @TableField("recommend")
    private Integer recommend;
    @Deprecated
    @TableField("special_product")
    private String specialProduct;
}
