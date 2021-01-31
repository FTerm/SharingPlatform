package com.ckhun.goods.bo.goodsitem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/31 15:34
 * @Description
 */
@Data
@ApiModel("批量删除")
public class GoodsItemDeleteBO {

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("SKU集合")
    private List<String> skuList;
}
