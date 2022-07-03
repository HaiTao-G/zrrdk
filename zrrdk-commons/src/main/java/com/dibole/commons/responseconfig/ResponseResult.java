package com.dibole.commons.responseconfig;

import java.lang.annotation.*;

/**
 * @author Tao
 * @version 1.0.0
 * @className ResponseResult.java
 * @description 标识统一接口返回值注解
 * @createTime 2020年12月07日 17:06:00
 */
//运行时有效
@Retention(RetentionPolicy.RUNTIME)
//描述注解的使用范围
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
