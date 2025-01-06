package com.biscuit.common.util;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 数值工具类
 * @author biscuit
 */
public abstract class NumberUtil {

    /**
     * 判断数值是否标准，不为空并且大于0
     */
    public static boolean isMeasure(Integer number) {
        return Objects.nonNull(number) && number > 0;
    }

    /**
     * 判断数值是否标准，不为空并且大于0
     */
    public static boolean isMeasure(Float number) {
        return Objects.nonNull(number) && number > 0;
    }

    /**
     * 判断数值是否标准，不为空并且大于0
     */
    public static boolean isMeasure(Double number) {
        return Objects.nonNull(number) && number > 0;
    }

    /**
     * 判断数值是否标准，不为空并且大于0
     */
    public static boolean isMeasure(Long number) {
        return Objects.nonNull(number) && number > 0;
    }

    /**
     * 判断数值是否标准，不为空并且大于0
     */
    public static boolean isMeasure(BigDecimal number) {
        return Objects.nonNull(number) && number.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * 数值补零并转换为字符串
     * @param digit 位数
     * @param number 数值
     */
    public static String repairZeroToString(Integer digit, Integer number) {
        return repairZeroToString(digit, Long.parseLong(number.toString()));
    }

    /**
     * 数值补零并转换为字符串
     * @param digit 位数
     * @param number 数值
     */
    public static String repairZeroToString(Integer digit, Long number) {
        AssertUtil.assertion(digit >= number.toString().length(), "数值位数大于补零总位数");
        StringBuilder repair = new StringBuilder();
        for (int i = 0; i < digit - number.toString().length(); i++) {
            repair.append("0");
        }
        return repair.toString() + number;
    }

}
