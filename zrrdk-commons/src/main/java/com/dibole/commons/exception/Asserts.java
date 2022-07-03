package com.dibole.commons.exception;

import com.dibole.commons.exceptioncode.IErrorCode;

/**
 * @author Tao
 * @version 1.0.0
 * @className Asserts.java
 * @description 断言处理类，用于抛出api异常
 * @createTime 2020年12月04日 17:19:00
 */
public class Asserts {
    public static void fail(String message) {
        throw new MyException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new MyException(errorCode);
    }
}
