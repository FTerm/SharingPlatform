package com.ckhun.goods.dto.goodsitem;

import com.ckhun.goods.bo.goodsitem.GoodsItemAddBO;
import com.ckhun.goods.bo.goodsitem.GoodsItemListBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/31 0:50
 * @Description
 */
@Data
@ApiModel("商品项DTO")
public class GoodsItemAddListDTO implements Serializable {
    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品项")
    private List<GoodsItemAddBO> goodsItemAddBOList;
}
