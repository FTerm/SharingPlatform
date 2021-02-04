package com.ckhun.goods.dto.goodsmode;

import com.ckhun.goods.bo.goodsmode.GoodsModeDelBO;
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
@ApiModel("商品模式删除DTO")
public class GoodsModeDelDTO extends GoodsModeDelBO implements Serializable {
}
