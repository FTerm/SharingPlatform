package com.ckhun.goods.dto.goods;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/1/31 0:50
 * @Description
 */
@Data
@ApiModel("商品新增DTO")
public class GoodsAddDTO implements Serializable {

    @ApiModelProperty("商品名")
    private String name;

    @ApiModelProperty("商品状态")
    private Integer stauts;

    @ApiModelProperty("商品数量")
    private Long count;

    @ApiModelProperty("商品单位")
    private String unit;

    @ApiModelProperty("商品类型")
    private Integer type;

    @ApiModelProperty("所属商家")
    private String vendorCode;
}
