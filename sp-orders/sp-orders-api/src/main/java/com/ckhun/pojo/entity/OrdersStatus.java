package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 15:43 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Data
@TableName("c_orders_status")
public class OrdersStatus implements Serializable {

    private static final long serialVersionUID = 13L;
    @TableField("order_id")
    private String orderId;
    /**
     * orderStatus 详细描述
     * 0 -> 已删除
     * 1 -> 已关闭
     * 2 -> 待支付
     * 3 -> 已支付
     * 4 -> 已完成
     * 5 ->
     *
     */
    @TableField("order_status")
    private Integer orderStatus;
    @TableField("payment_id")
    private String paymentId;
    @TableField("pay_time")
    private Long payTime;
    @TableField("close_time")
    private Long closeTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
}
