package com.ckhun.goods.bo.mode;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/1/31 16:45
 * @Description
 */
@ApiModel("新增ModeBO")
@Data
public class ModeAddBO {

    private String modeName;

    private String description;

    private Integer status;
}
