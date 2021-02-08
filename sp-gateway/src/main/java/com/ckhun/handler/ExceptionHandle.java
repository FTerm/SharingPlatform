package com.ckhun.handler;

import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : Kunhong Chan
 * @date : Created in 16:13 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@ControllerAdvice
@Component
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public R<?> handleEX(ValidationException exception) {
        Map<String, String> data = new HashMap<>();
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                data.put(item.getPropertyPath().toString().substring(item.getPropertyPath().toString().lastIndexOf(".") + 1), item.getMessage());
            }
        }
        return new R<>().fail(ErrorEnum.VALIDATION_EOR, data);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public R<?> httpEx(HttpMessageNotReadableException exception) {
        return new R<>().fail(ErrorEnum.VALIDATION_EOR, null);
    }
}
