package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/1/31 0:02
 * @Description
 */
@Data
@TableName("g_goods_item")
@ApiModel(description = "商品item",value = "商品item")
public class GoodsItem implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("goods_code")
    @ApiModelProperty("商品编码")
    private String goodsCode;

    @TableField("sku")
    @ApiModelProperty("商品唯一标识码")
    private String sku;

    @TableField("longitude")
    @ApiModelProperty("精度")
    private Long longitude;

    @TableField("latitude")
    @ApiModelProperty("纬度")
    private Long latitude;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Long createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Long updateTime;


}
