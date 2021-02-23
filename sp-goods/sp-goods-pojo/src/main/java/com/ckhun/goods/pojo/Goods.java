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
 * @Date 2021/1/30 15:55
 * @Description 商品实体类
 */

@Data
@TableName("g_goods")
@ApiModel(description = "商品实体",value = "商品实体")
public class Goods implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value ="主键id")
    private Integer id;

    @TableField("goods_code")
    @ApiModelProperty(value ="商品编码")
    private String goodsCode;

    @TableField("name")
    @ApiModelProperty(value ="商品名字")
    private String name;

    @TableField("status")
    @ApiModelProperty(value ="商品状态")
    private Integer status;

    @TableField("item_count")
    @ApiModelProperty(value ="商品项数量")
    private Integer itemCount;

    @TableField("unit")
    @ApiModelProperty(value ="商品单位")
    private String unit;

    @TableField("type")
    @ApiModelProperty(value ="商品类型")
    private Integer type;

    @TableField("vendor_code")
    @ApiModelProperty(value ="所属商家")
    private String vendorCode;

    @TableField("create_time")
    @ApiModelProperty(value ="创建时间")
    private long createTime;

    @TableField("update_time")
    @ApiModelProperty(value ="更新时间")
    private long updateTime;

    @TableField("del_flag")
    @ApiModelProperty(value ="是否逻辑删除")
    private Integer delFlag;

    @TableField("price")
    @ApiModelProperty(value = "商品价钱")
    private Long price;

}
