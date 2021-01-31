package com.ckhun.goods.bo.goodsitem;

import com.ckhun.utils.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 15:50
 * @Description
 */
@Data
@ApiModel("分页筛选BO")
public class GoodsItemListBO extends PageRequest {

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品项唯一编码")
    private String sku;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("纬度")
    private String latitude;

}
