package com.ckhun.goods.bo.goods;

import com.ckhun.utils.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 13:05
 * @Description
 */
@Data
@ApiModel("商品分页筛选BO")
public class GoodsListBO extends PageRequest {

    @ApiModelProperty("商品名-模糊查询")
    private String name;

    @ApiModelProperty("商品状态-筛选条件")
    private Integer stauts;

    @ApiModelProperty("商品类型")
    private Integer type;

    @ApiModelProperty("所属商家--模糊查询")
    private String vendorCode;

    @ApiModelProperty("开始时间")
    private Long startTime;

    @ApiModelProperty("结束时间")
    private Long endTime;

}
