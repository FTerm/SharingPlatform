package com.ckhun.goods.dto.goodsitem;

import com.ckhun.goods.bo.goodsitem.GoodsItemListBO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/1/31 0:50
 * @Description
 */
@Data
@ApiModel("商品项分DTO")
public class GoodsItemListDTO extends GoodsItemListBO implements Serializable {
}
