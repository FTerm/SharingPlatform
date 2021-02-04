package com.ckhun.goods.dto.goodsitem;

import com.ckhun.goods.bo.goodsitem.GoodsItemUpdateBO;
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
@ApiModel("商品项更新DTO")
public class GoodsItemUpdateDTO extends GoodsItemUpdateBO implements Serializable {
}
