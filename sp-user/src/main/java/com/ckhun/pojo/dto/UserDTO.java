package com.ckhun.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:39 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class UserDTO implements Serializable {

    private static final Long SerialVersionUID = 35L;

    private String username;

    private String password;
}
