package com.dibole.commons.exceptioncode;

/**
 * @author Tao
 * @version 1.0.0
 * @className UserCode.java
 * @description 用户自定义错误码
 * @createTime 2020年12月04日 17:11:00
 */
public enum UserCode implements IErrorCode{
    NOT_EXIST_USER_OR_ERROR_PWD(10000, "该用户不存在或密码错误"),
    NOT_PARAM_USER_OR_ERROR_PWD(10001, "用户名或密码为空"),
    LOGINED_IN(10002, "该用户已登录"),
    NOT_EXIST_BUSINESS(10003, "该商家不存在"),
    SHIRO_ERROR(10004, "登录异常"),
    UNAUTHO_ERROR(10005, "您没有该权限"),
    BIND_PHONE(1006, "请绑定手机号"),
    UPLOAD_ERROR(1007, "上传文件异常"),
    INVALID_CAPTCHA(1008, "无效的验证码"),
    USER_FROZEN(1009, "该用户已被冻结"),
    ILLEGALITY_OPERATION(1010,"用户非法操作");

    private Integer code;
    private String message;

    UserCode(Integer code, String message) {
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
