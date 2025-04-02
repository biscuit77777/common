package com.biscuit.common.enums;

import lombok.Getter;

/**
 * @author biscuit
 */
@Getter
public enum ResultEnum {

    OK("200", "成功"),
    AUTHORIZATION_EXPIRATION("4000", "认证已过期"),
    TOKEN_TAMPER_ERROR("4001", "认证标识已被篡改异常"),
    NOT_LOGIN_ERROR("4002", "未登录异常"),
    NOT_AUTHORITY_ERROR("4003", "无权限异常"),
    NOT_FOUND_ERROR("4004", "资源不存在异常"),
    ASSERT_ERROR("4005", "断言异常"),
    NULL_ERROR("4006", "空指针异常"),
    PARAM_VERIFY_ERROR("4007", "参数校验异常"),
    UNKNOWN_ERROR("5000", "未知异常"),
    ;


    private final String code;
    private final String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}