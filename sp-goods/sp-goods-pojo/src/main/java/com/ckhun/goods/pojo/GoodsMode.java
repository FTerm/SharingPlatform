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
 * @Date 2021/1/31 0:09
 * @Description
 */
@Data
@TableName("g_goods_mode")
@ApiModel(description = "商品模式",value = "商品模式")
public class GoodsMode implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("goods_code")
    @ApiModelProperty("商品编码")
    private String goodsCode;

    @TableField("mode_id")
    @ApiModelProperty("商品模式id")
    private Integer modeId;

    @TableField("price")
    @ApiModelProperty("价钱")
    private Long price;

    @TableField("target")
    @ApiModelProperty("期望价钱")
    private Long target;

    @TableField("target")
    @ApiModelProperty("状态")
    private Integer status;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Long createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Long updateTime;

}