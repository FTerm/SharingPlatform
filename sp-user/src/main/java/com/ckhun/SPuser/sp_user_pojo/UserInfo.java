package com.ckhun.SPuser.sp_user_pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *order: Junsen
 * Time：2021-1-31 00:06:06
 */
@Data
@TableName("c_user")
public class UserInfo {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;

    @TableField("username")
    @ApiModelProperty("用户名")
    private String username;

    @TableField("password")
    @ApiModelProperty("密码")
    private String password;

    @TableId("gender")
    @ApiModelProperty("性别")
    private Integer gender;

    @TableField("birth")
    @ApiModelProperty("生日")
    private String birth;

    @TableField("email")
    @ApiModelProperty("邮箱")
    private String email;

    @TableId("phone")
    @ApiModelProperty("手机号")
    private Integer phone;

    @TableField("status")
    @ApiModelProperty("商品状态")
    private Integer status;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private long createTime;

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private long updateTime;

    @TableField("del_flag")
    @ApiModelProperty("逻辑删除")
    private Integer delFlag;

}


