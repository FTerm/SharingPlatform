package com.ckhun.goods.dto.goods;

import com.ckhun.goods.bo.goods.GoodsListBO;
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
@ApiModel("商品分页DTO")
public class GoodsListDTO extends GoodsListBO implements Serializable {
}
