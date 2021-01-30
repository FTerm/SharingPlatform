package com.ckhun.exception;

/**
 * create by one
 *
 * @Date 2021/1/30 15:28
 * @Description 自定义运行时异常
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException() {
        super();
    }

    public ServiceException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
