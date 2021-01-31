package com.ckhun.goods.bo.mode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 16:45
 * @Description
 */
@ApiModel("修改ModeBO")
@Data
public class ModeUpdateBO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("模式名")
    private String modeName;

    @ApiModelProperty("秒杀")
    private String description;

    @ApiModelProperty("状态")
    private Integer status;
}
