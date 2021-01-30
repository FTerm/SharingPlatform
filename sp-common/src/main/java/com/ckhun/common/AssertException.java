package com.ckhun.common;

import com.ckhun.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 断言
 * date：2021年1月30日15:31:10
 * author: One
 * version: 1.0
 */
public class AssertException {

    /**
     * 若 o == null 抛出异常
     *
     * @param o
     * @param message
     */
    public static void isNotNull(Object o, Integer code, String message) {
        if (o == null) {
            throw new ServiceException(code,message);
        }
    }

    /**
     * 若 o != null 抛出异常
     * @param o
     * @param code
     * @param message
     */
    public static void isNull(Object o, Integer code, String message) {
        if (o != null) {
            throw new ServiceException(code,message);
        }
    }

    /**
     * 如果 o == false 则抛出异常
     * @param o
     * @param message
     */
    public static void isTrue(Boolean o, Integer code,String message) {
        if (!o) {
            throw new ServiceException(code,message);
        }
    }

    /**
     * 若 字符串为空 则抛出异常
     * @param o
     * @param message
     */
    public static void isNotBlank(String o,Integer code,String message) {
        if (StringUtils.isBlank(o)) {
            throw new ServiceException(code,message);
        }
    }

    /**
     * 判断 validated
     * @param bindingResult
     */
    public static void isValidated(Integer code,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> str = new ArrayList<String>();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                String msg = fieldError.getDefaultMessage();
                str.add(msg);
            }
            throw new ServiceException(code,str.get(0));
        }
    }

}
