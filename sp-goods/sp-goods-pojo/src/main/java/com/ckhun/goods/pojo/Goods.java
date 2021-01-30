package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/1/30 15:55
 * @Description 商品实体类
 */

@Data
@TableName("g_goods")
public class Goods implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goods_code")
    private String goodsCode;

    @TableField("name")
    private String name;

    @TableField("status")
    private Integer status;

    @TableField("count")
    private Integer count;

    @TableField("unit")
    private String unit;

    @TableField("type")
    private Integer type;

    @TableField("vendor_code")
    private String vendorCode;

    @TableField("create_time")
    private long createTime;

    @TableField("update_time")
    private long updateTime;

    @TableField("del_flag")
    private Integer delFlag;

}
