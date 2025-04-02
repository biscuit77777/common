package com.biscuit.common.exception;

import com.biscuit.common.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常类型
 * @author biscuit
 */
@Getter
@Setter
public class BiscuitException extends RuntimeException {

    private String code;
    private String desc;

    public BiscuitException() {
        this(ResultEnum.UNKNOWN_ERROR);
    }

    public BiscuitException(ResultEnum result) {
        this(result.getCode(), result.getMessage());
    }

    public BiscuitException(String code, String message) {
        super(message);
        this.code = code;
        this.desc = message;
    }

}
