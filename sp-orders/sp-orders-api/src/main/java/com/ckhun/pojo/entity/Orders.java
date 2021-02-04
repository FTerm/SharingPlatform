package com.ckhun.pojo.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:30 2021/1/31
 * @description :
 * @since : 1.0.0
 */

@Data
@TableName("c_orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 11L;

    @TableField("order_id")
    private String orderId;
    @TableField("order_name")
    private String orderName;
    @TableField("order_price")
    private Long orderPrice;
    @TableField("actual_price")
    private Long actualPrice;

    /**
     * 支付类型定义
     */
    @TableField("payment_type")
    private Integer paymentType;

    /**
     * 订单租赁模式定义
     */
    @TableField("order_type")
    private Integer orderType;

    @TableField("promotion_id")
    private String promotionId;
    @TableField("vendor_id")
    private String vendorId;
    @TableField("transactions_id")
    private String transactionsId;

    /**
     * 逻辑删除
     * 1 -> 正常
     * 0 -> 删除
     */
    @TableField("order_flag")
    private Integer orderFlag;
    @TableField("user_id")
    private Long userId;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(exist = false)
    private List<OrdersDetails> ordersDetails;

    /**
     * 详细的订单状态查看OrderStatus实体类的描述
     */
    @TableField(exist = false)
    private Integer status;




}
