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
    public static boolean isMeasure(BigDecimal number) {
        return Objects.nonNull(number) && number.compareTo(BigDecimal.ZERO) > 0;
    }

}
