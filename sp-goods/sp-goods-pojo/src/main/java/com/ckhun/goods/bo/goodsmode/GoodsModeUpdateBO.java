package com.ckhun.goods.bo.goodsmode;

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
@ApiModel("更新-商品模式")
public class GoodsModeUpdateBO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("价钱")
    private Long price;

    @ApiModelProperty("期望价钱")
    private Long target;

    @ApiModelProperty("状态")
    private Integer status;
}
