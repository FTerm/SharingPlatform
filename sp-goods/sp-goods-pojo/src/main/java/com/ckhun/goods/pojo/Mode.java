package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * create by one
 *
 * @Date 2021/1/31 0:13
 * @Description
 */
@Data
@TableName("g_goods_mode")
@ApiModel(description = "商品模式",value = "商品模式")
public class Mode implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("mode_name")
    @ApiModelProperty("模式名称")
    private String modeName;


    @TableField("description")
    @ApiModelProperty("模式描述")
    private String description;

    @TableField("platform_percentage")
    @ApiModelProperty("平台收益百分比")
    private BigDecimal platformPercentage;

    @TableField("target")
    @ApiModelProperty("状态")
    private Integer status;

    @TableField("del_flag")
    @ApiModelProperty("是否逻辑删除")
    private Integer delFlag;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Long createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Long updateTime;

}
