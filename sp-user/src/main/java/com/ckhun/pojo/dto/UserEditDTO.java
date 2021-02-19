package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:35 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class UserEditDTO implements Serializable {

    private static final Long SerialVersionUID = 33L;

    private String username;

    private String password;

    private Integer gender;

    private String email;

    private String phone;

}
