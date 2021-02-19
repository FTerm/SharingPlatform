package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:20 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
@TableName("c_user")
public class User implements Serializable {

    private static final Long SerialVersionUID = 30L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("gender")
    private Integer gender;

    @TableField("email")
    private String email;

    @TableField("phone")
    private Integer phone;

    @TableField("status")
    private Integer status;   // 1 / 0

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @TableField("del_flag")
    private Integer delFlag;

}
