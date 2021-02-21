package com.ckhun.goods.dto.goodsarea;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/2/20 18:58
 * @Description
 */
@Data
@ApiModel("商品区域查询DTO")
public class GoodsAreaAddDTO implements Serializable {

    @ApiModelProperty("经度")
    private String longitude;   //经度

    @ApiModelProperty("纬度")
    private String latitude;    //纬度

    @ApiModelProperty("类型")
    private String type;   //类型
}
