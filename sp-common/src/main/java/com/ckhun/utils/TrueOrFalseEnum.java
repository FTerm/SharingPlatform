package com.ckhun.utils;

import lombok.Data;
import lombok.Getter;

/**
 * create by one
 *
 * @Date 2021/1/31 1:15
 * @Description
 */
@Getter
public enum  TrueOrFalseEnum {
    FALSE_STAUTS(0,Boolean.FALSE),
    TRUE_STAUTS(1,Boolean.TRUE);

    private final Integer status;
    private final Boolean flag;

    TrueOrFalseEnum(Integer status, Boolean flag) {
        this.status = status;
        this.flag = flag;
    }
}
