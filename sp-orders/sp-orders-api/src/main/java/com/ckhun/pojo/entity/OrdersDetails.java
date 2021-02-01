package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 15:41 2021/1/31
 * @description :
 * @since : 1.0.0
 */

@Data
@TableName("c_orders_details")
public class OrdersDetails implements Serializable {

    private static final long serialVersionUID = 12L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long Id;
    @TableField("order_id")
    private String orderId;
    @TableField("sku_id")
    private String skuId;
    @TableField("price")
    private Long price;
    @TableField("unit")
    private String unit;
    @TableField("billing_model")
    private Integer billingModel;
    /**
     * billingModel 详细描述
     * 1 ->
     * 2 ->
     * 3 ->
     */
    @TableField("image")
    private String image;
    @TableField("location_id")
    private Long locationId;


}
