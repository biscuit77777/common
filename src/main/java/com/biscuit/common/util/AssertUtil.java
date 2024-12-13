package com.biscuit.common.util;

import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.BiscuitException;

/**
 * @author biscuit
 */
public abstract class AssertUtil {

    public static void assertion(boolean expression, String message) {
        if (!expression) {
            throw new BiscuitException(ResultEnum.ASSERT_ERROR.getCode(), message);
        }
    }

}
