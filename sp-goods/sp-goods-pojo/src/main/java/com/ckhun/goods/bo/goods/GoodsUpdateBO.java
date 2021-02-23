package com.ckhun.goods.bo.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 12:21
 * @Description
 */
@Data
@ApiModel("商品更新BO")
public class GoodsUpdateBO {

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "商品状态 0-新增未运营，1-正常, -1-删除")
    private Integer stauts;

    @ApiModelProperty(value = "商品单位")
    private String unit;

    @ApiModelProperty(value = "商品类型")
    private Integer type;

    @ApiModelProperty(value = "所属商家")
    private String vendorCode;

    @ApiModelProperty(value = "商品价钱")
    private Long price;



}
