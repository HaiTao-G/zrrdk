package com.dibole.commons.exceptioncode;

/**
 * @author Tao
 * @version 1.0.0
 * @className IErrorCode.java
 * @description 封装API的错误码
 * @createTime 2020年12月04日 17:08:00
 * 封装api的错误码
 * #1001～1999 区间表示用户错误
 * #2001～2999 区间表示参数错误
 * #3001～3999 区间表示接口异常
 * TODO 将来做统一异常处理的时候，直接自定义IException重写构造方法，方便拓展
 */
public interface IErrorCode {
    Integer getCode();

    String getMessage();
}
