package com.biscuit.common.util;

import com.biscuit.common.base.BaseAMO;
import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.result.R;

/**
 * 返回值工具类
 * @author biscuit
 */
public abstract class RUtil {

    public static <T extends BaseAMO> R<T> ok() {
        return ok(null);
    }

    public static <T extends BaseAMO> R<T> ok(T data) {
        return build(ResultEnum.OK.getCode(), ResultEnum.OK.getMessage(), data);
    }

    public static <T extends BaseAMO> R<T> fail() {
        return fail(ResultEnum.FAIL);
    }

    public static <T extends BaseAMO> R<T> fail(ResultEnum resultEnum) {
        return fail(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static <T extends BaseAMO> R<T> fail(String code, String message) {
        return build(code, message, null);
    }

    private static <T extends BaseAMO> R<T> build(String code, String message, T data) {
        R<T> t = new R<>();
        t.setCode(code);
        t.setData(data);
        t.setMessage(message);
        return t;
    }

}
