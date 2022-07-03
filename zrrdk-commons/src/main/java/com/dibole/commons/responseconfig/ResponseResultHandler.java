package com.dibole.commons.responseconfig;

import com.dibole.commons.api.CommonResult;
import com.dibole.commons.exception.MyException;
import com.dibole.commons.exceptioncode.IErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Tao
 * @version 1.0.0
 * @className ResponseResultHandler.java
 * @description 重写返回体
 * @createTime 2020年12月07日 17:16:00
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice {

    //标记名称
    public static final String RESPONSE_RESULT_ANN = "RESPOMSE-RESULT-ANN";

    /**
     * 是否请求 包含了 注解标记，没有直接返回，不需要重写返回体
     *  判断是否要执行beforeBodyWrite方法，true为执行，false不执行
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();
        //判断请求 是否含有包装标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResult ==null ? false : true;
    }

    /**
     * 对response处理的执行方法
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("进入返回体 重写格式 处理中。。。");
        if (body instanceof IErrorCode){
            log.info("返回值异常做包装处理中。。。");
            IErrorCode errorCode = (IErrorCode) body;
            return CommonResult.failed(errorCode);
        }
        if (body instanceof MyException){
            MyException e = (MyException) body;
            if (e.getErrorCode() != null) {
                return CommonResult.failed(e.getErrorCode());
            }
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(body);
    }
}
