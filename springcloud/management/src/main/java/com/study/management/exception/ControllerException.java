package com.study.management.exception;


import com.alibaba.fastjson.JSON;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 描述:
 *
 * @Author;wangkaitong
 * @Date;2019/7/10
 * @Version;1.0
 * @Senice;1.0
 */
@Component
@ControllerAdvice
public class ControllerException {


    private static final Logger log= LoggerFactory.getLogger(ControllerException.class);
    /**
     * 全局异常  Exception 处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleException(Exception e){

        if(e instanceof BindException){
            BindException exception = (BindException) e;
            Result failure = Result.resultFail(ResultStatus.PARAM_ERROR);
            List<ObjectError> allErrors = exception.getAllErrors();
            failure.setMessage(exception.getMessage());
            String message =  allErrors.stream().map(objectError -> {
                return objectError.getDefaultMessage();
            }).collect(Collectors.joining(","));
            String.join(",",message);
            log.error("参数校验出错：{}",message);
            return  failure;
        }
        log.error("发现未知异常，异常信息为:{}",e);

        Result result = Result.resultFail(ResultStatus.SYSTEM_ERROR);
        result.setMessage(e.getMessage());
        return result;
    }

    /**
     * 运行时异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleException(RuntimeException e){
        log.error("发现未知异常，异常信息为:{}",e);
        Result result = Result.resultFail(ResultStatus.SYSTEM_ERROR);
        result.setMessage(e.getMessage());
        return result;
    }


    /**
     *
     * 参数为空校验
     * @param e
     * @param
     * @return
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMissingServletRequestParameterException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        Result failure = Result.resultFail(ResultStatus.PARAM_ERROR);
        String message =  allErrors.stream().map(objectError -> {
            return objectError.getDefaultMessage();
        }).collect(Collectors.joining(","));
        failure.setMessage(message);
        log.error("参数校验出错：{}",message);
        return  failure;
    }
}
