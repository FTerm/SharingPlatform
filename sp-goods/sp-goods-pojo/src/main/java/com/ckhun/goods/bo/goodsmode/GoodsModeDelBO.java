package com.ckhun.goods.bo.goodsmode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/2/1 13:15
 * @Description
 */
@Data
@ApiModel("商品模式删除")
public class GoodsModeDelBO {
    @ApiModelProperty("模式id")
    private Integer id;

    @ApiModelProperty("商品编码")
    private String goodsCode;
}
