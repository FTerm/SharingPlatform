package com.ckhun.goods.bo.goodsitem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/31 14:43
 * @Description
 */
@Data
@ApiModel("批量增加")
public class GoodsItemAddListBO {
    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品项")
    private List<GoodsItemAddBO> goodsItemAddBOList;
}
