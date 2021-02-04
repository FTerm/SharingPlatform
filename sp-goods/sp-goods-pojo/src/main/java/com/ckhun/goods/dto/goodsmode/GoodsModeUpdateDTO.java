package com.ckhun.goods.dto.goodsmode;

import com.ckhun.goods.bo.goodsmode.GoodsModeUpdateBO;
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
@ApiModel("商品模式更新DTO")
public class GoodsModeUpdateDTO extends GoodsModeUpdateBO implements Serializable {
}
