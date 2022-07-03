package com.dibole.commons.exception;

import com.dibole.commons.exceptioncode.IErrorCode;

/**
 * @author Tao
 * @version 1.0.0
 * @className MyException.java
 * @description 自定义api异常
 * @createTime 2020年12月04日 17:04:00
 */
public class MyException extends RuntimeException{

    private IErrorCode errorCode;

    public MyException(IErrorCode iErrorCode) {
        super(iErrorCode.getMessage());
        this.errorCode = iErrorCode;
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
