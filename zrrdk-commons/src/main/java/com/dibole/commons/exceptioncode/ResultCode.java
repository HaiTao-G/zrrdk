package com.dibole.commons.exceptioncode;
/**
 * @className ResultCode.java
 * @description 接口相关错误码
 * @author Tao
 * @createTime 2020年12月04日 17:11:00
 * @version 1.0.0
 */
public enum ResultCode implements IErrorCode{

    SUCCESS(200, "操作成功！！！"),
    FAILED(500, "服务器错误，请联系管理员！！！"),
    NOT_FOUND(404, "请求内容不存在"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
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
