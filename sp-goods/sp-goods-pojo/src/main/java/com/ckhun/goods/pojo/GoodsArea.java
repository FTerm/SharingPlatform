package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * create by one
 *
 * @Date 2021/2/8 21:10
 * @Description
 */
@Data
@TableName("g_goods_area")
@ApiModel(description = "商品区域实体",value = "商品区域实体")
public class GoodsArea {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("longitude")
    @ApiModelProperty("经度")
    private String longitude;

    @TableField("latitude")
    @ApiModelProperty("纬度")
    private String latitude;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @TableField("del_flag")
    @ApiModelProperty("是否逻辑删除")
    private Integer delFlag;

    @TableField("scope")
    @ApiModelProperty("范围")
    private String scope;

    @TableField("unit")
    @ApiModelProperty("单位")
    private String unit;

    @TableField("type")
    @ApiModelProperty("机器类型")
    private Integer type;

    @TableField("count")
    @ApiModelProperty("可容纳数量")
    private Integer count;

    @TableField("type")
    @ApiModelProperty("属于商品编码")
    private String goodsCode;
}
