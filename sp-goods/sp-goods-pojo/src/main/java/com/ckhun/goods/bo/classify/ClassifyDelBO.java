package com.ckhun.goods.bo.classify;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/2/2 14:11
 * @Description
 */
@Data
@ApiModel("分类删除-BO")
public class ClassifyDelBO {

    @ApiModelProperty("分类id")
    private Integer id;

}
