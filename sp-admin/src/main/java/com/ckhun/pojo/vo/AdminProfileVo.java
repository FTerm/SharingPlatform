package com.ckhun.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:48 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Data
public class AdminProfileVo implements Serializable {

    private static final long SerialVersionUID = 20L;

    private Integer id;
    private String userName;
    private Long createTime;
    private Long updateTime;
    private String loginIp;
    private String lastLoginTime;
}
