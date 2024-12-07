package com.biscuit.common.emuns;

import lombok.Getter;

/**
 * @author biscuit
 */
@Getter
public enum ResultEnum {

    OK("200", "成功"),
    FAIL("5000", "失败"),
    NOT_FOUND("4004", "资源不存在"),
    AUTHORIZATION_EXPIRATION("4000", "认证已过期"),
    TOKEN_TAMPER("4001", "认证标识已被篡改"),
    NOT_LOGIN("4002", "未登录"),
    NOT_AUTHORITY("4003", "无权限"),
    ASSERT_ERROR("4005", "断言错误"),
    NULL_ERROR("4006", "空指针异常"),
    ;


    private final String code;
    private final String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
