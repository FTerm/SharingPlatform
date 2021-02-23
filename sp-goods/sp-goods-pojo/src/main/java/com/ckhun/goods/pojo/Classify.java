package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/2/2 13:29
 * @Description
 */
@Data
@TableName("g_classify")
@ApiModel(description = "分类", value = "分类")
public class Classify {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("classify_name")
    @ApiModelProperty("分类名")
    private String classifyName;

    @TableField("pid")
    @ApiModelProperty("父id   0 --一级分类")
    private Integer pid;

    @TableField("status")
    @ApiModelProperty("状态")
    private Integer status;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Long createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Long updateTime;

    @TableField("del_flag")
    @ApiModelProperty("逻辑删除")
    private Integer delFlag;

    @TableField("type")
    @ApiModelProperty("类型")
    private Integer type;

    @TableField("img")
    @ApiModelProperty(value = "类型")
    private String img;


}
