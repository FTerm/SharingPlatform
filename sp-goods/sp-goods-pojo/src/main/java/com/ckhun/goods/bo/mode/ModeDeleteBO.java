package com.ckhun.goods.bo.mode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 16:48
 * @Description
 */
@ApiModel("新增ModeBO")
@Data
public class ModeDeleteBO {

    @ApiModelProperty("id")
    private Integer id;
}
