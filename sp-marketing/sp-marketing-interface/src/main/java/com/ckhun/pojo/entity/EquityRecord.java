package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:43 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
@TableName("m_equity_record")
public class EquityRecord implements Serializable {

    private static final Long SerialVersionUID = 21L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("coupon_id")
    private String couponId;
    @TableField("equity_id")
    private String equityId;
    @TableField("user_id")
    private Integer userId;
    @TableField("equity_type")
    private Integer equityType;
    @TableField("start_time")
    private Long startTime;
    @TableField("continuous")
    private Integer continuous;
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    private Long createTime;
}
