package com.ckhun.goods.bo.goodsitem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 15:20
 * @Description
 */
@Data
@ApiModel("商品项更新BO")
public class GoodsItemUpdateBO {

    @ApiModelProperty("商品sku")
    private String sku;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("纬度")
    private String latitude;

    @ApiModelProperty("范围")
    private String scope;

}
