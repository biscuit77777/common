package com.biscuit.common.exception;

import com.biscuit.common.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录异常
 * @author biscuit
 */
@Getter
@Setter
public class LoginException extends RuntimeException {

    private String code;
    private String desc;

    public LoginException() {
        this(ResultEnum.NOT_LOGIN);
    }

    public LoginException(ResultEnum result) {
        this(result.getCode(), result.getMessage());
    }

    public LoginException(String code, String message) {
        super(message);
        this.code = code;
        this.desc = message;
    }

}
