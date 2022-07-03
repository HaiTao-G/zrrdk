package com.dibole.commons.exceptioncode;

/**
 * @author Tao
 * @version 1.0.0
 * @className ParamCode.java
 * @description TODO
 * @createTime 2020年12月04日 17:11:00
 */
public enum ParamCode implements IErrorCode{

    /* 参数错误：2000～2999 */
    PARAM_NOT_VALID(2001, "参数无效"),
    PARAM_IS_BLANK(2002, "参数为空"),
    PARAM_TYPE_ERROR(2003, "参数类型错误"),
    PARAM_NOT_COMPLETE(2004, "参数缺失"),
    INVALIDIMAGE_CATEGORG(2005,"上传文件类型不匹配！！！");


    private Integer code;
    private String message;

    ParamCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
