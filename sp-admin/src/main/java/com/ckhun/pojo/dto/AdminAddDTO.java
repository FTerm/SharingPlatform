package com.ckhun.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:40 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Data
@ApiModel("添加管理员DTO")
public class AdminAddDTO implements Serializable {

    private static final long SerialVersionUID = 20L;

    private String userName;
    private String password;
}
