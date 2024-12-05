package com.biscuit.common.emuns;

/**
 * @author biscuit
 */
public enum ResultEnum {

    OK("200", "成功"),
    FAIL("5000", "失败"),
    ;


    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
