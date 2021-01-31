package com.ckhun.goods.handler;

import com.ckhun.exception.ServiceException;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * description: 业务层异常统一处理
 * date：2020/10/28 9:38 上午
 * author: One
 * version: 1.0
 */
@ControllerAdvice
public class ServiceExceptionHandle {

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public R<String> handler(HttpServletResponse response, ServiceException e){
        R<String> result = new R<>();
        String message = e.getMessage();
        result.setData(message);
        result.setErrMsg(message);
        result.setErrCode(ErrorEnum.VALIDATION_EOR.getErrCode());
        return result;
    }
}
