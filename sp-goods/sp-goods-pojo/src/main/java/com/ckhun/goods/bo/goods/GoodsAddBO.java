package com.ckhun.goods.bo.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * create by one
 *
 * @Date 2021/1/31 0:50
 * @Description
 */
@Data
@ApiModel("商品新增BO")
public class GoodsAddBO {

    @ApiModelProperty("商品名")
    private String name;

    @ApiModelProperty("商品状态")
    private Integer stauts;

    @ApiModelProperty("商品数量")
    private Long count;

    @ApiModelProperty("商品单位")
    private String unit;

    @ApiModelProperty("商品类型")
    private Integer type;

    @ApiModelProperty("所属商家")
    private String vendorCode;
}
