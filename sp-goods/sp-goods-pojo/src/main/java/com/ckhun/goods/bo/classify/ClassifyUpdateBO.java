package com.ckhun.goods.bo.classify;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/2/2 14:14
 * @Description
 */
@Data
@ApiModel("分类更新-BO")
public class ClassifyUpdateBO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("分类名")
    private String classifyName;

    @ApiModelProperty("父id  0--一级分类")
    private Integer pid;

    @ApiModelProperty("1-一级分类，2-二级分类(需要写pid)")
    private Integer type;

    @ApiModelProperty("status")
    private Integer status;


}
