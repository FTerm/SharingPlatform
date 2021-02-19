package com.ckhun.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:53 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Data
public class UserVo implements Serializable {

    private static final Long SerialVersionUID = 34L;

    private String username;

    private Integer gender;

    private String email;

    private String phone;

    private Integer status;

    private Long createTime;

    private Long updateTime;

}
