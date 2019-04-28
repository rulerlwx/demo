package com.majiaxueyuan.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lwx on 2019/2/23.
 */
@ControllerAdvice
public class GlobleExceptionApp {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runtimeException(){
        return "出现异常，相当于以前的AOP拦截";
    }
}
