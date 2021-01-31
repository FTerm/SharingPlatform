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
public class GoodsUpdateCountBO {

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品数量")
    private Long count;

}
