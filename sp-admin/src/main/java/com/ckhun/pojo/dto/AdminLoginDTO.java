package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:43 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Data
public class AdminLoginDTO implements Serializable {

    private static final long SerialVersionUID = 20L;

    private String userName;
    private String password;
}
