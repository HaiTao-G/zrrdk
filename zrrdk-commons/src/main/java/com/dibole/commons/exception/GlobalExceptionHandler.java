package com.dibole.commons.exception;

import com.dibole.commons.api.CommonResult;
import com.dibole.commons.exceptioncode.ParamCode;
import com.dibole.commons.exceptioncode.ResultCode;
import com.dibole.commons.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Tao
 * @version 1.0.0
 * @className GlobalExceptionHandler.java
 * @description 全局异常处理
 * @createTime 2020年12月04日 17:20:00
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常拦截
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public CommonResult error(MyException e) {
        log.error(ExceptionUtils.getMessage(e));
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 参数类型错误
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult error(MethodArgumentNotValidException e) {
        log.error(ExceptionUtils.getMessage(e));
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String description = allErrors.stream().map(x -> x.getDefaultMessage()).reduce((x, y) -> x + "," + y).orElseGet(()->ParamCode.PARAM_NOT_VALID.getMessage());
        return CommonResult.validateFailed(description);
    }

    /**
     * 参数缺失
     * @param e
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public CommonResult error(MissingServletRequestParameterException e) {
        return CommonResult.validateFailed("必须的" + e.getParameterType() + "类型参数" + e.getParameterName() + "不存在");
    }


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public CommonResult error(Exception e) {
        log.error(ExceptionUtils.getMessage(e));
        if(e instanceof org.springframework.web.servlet.NoHandlerFoundException){
            return CommonResult.failed(ResultCode.NOT_FOUND);
        }else {
            return CommonResult.failed(ResultCode.FAILED);
        }
    }
}
