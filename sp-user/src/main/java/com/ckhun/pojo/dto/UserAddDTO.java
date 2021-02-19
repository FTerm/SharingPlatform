package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:15 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class UserAddDTO implements Serializable {

    private static final Long SerialVersionUID = 31L;

    private String username;

    private String password;

    private Integer gender;
}
