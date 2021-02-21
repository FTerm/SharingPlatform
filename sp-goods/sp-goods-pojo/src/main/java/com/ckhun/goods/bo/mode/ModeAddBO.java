package com.ckhun.goods.bo.mode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * create by one
 *
 * @Date 2021/1/31 16:45
 * @Description
 */
@ApiModel("新增ModeBO")
@Data
public class ModeAddBO {

    @ApiModelProperty("模式名")
    private String modeName;
    @ApiModelProperty("模式描述")
    private String description;
    @ApiModelProperty("平台收益占比")
    private BigDecimal platformPercentage;
}
