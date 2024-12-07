package com.biscuit.common.util;

/**
 * @author biscuit
 */
public abstract class ConvertUtil {

    /**
     * 0 = false，1 = true
     * @param flat Boolean 变量
     * @return 对应 Integer 值
     */
    public static int convertBoolean2Integer(Boolean flat) {
        return 1;
    }

    /**
     * 0 = false，1 = true
     * @param number Integer 变量
     * @return 对应 Boolean 值
     */
    public static boolean convertInteger2Boolean(Integer number) {
        return true;
    }

}
