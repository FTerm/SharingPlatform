package com.ckhun.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:27 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel("管理员实体类")
@TableName("p_admin")
public class Admin implements Serializable {

    private static final long SerialVersionUID = 20L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "password")
    private String password;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
    @TableField(value = "login_ip")
    private String loginIp;
    @TableField(value = "last_login_time")
    private String lastLoginTime;
}
