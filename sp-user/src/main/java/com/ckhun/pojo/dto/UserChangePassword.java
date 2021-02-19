package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 19:12 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class UserChangePassword implements Serializable {

    private static final Long SerialVersionUID = 36L;

    private String username;

    private String password;

    private String changePassword;
}
