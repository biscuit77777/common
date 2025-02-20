package com.biscuit.common.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

/**
 * 通用判断工具类
 *
 * @author biscuit
 */
public abstract class JudgmentUtil {

    /**
     * 字符串是否为空
     *
     * @param cs 字符串
     * @return true 空 | false 非空
     */
    public static boolean isBlank(CharSequence cs) {
        if (cs != null) {
            int length = cs.length();

            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 字符串是否不为空
     *
     * @param cs 字符串
     * @return true 非空 | false 空
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 数值是否合法（不为空且大于零）
     *
     * @param number 数值
     * @return true 合法 | 非发
     */
    public static boolean isLegalNumber(Number number) {
        if (Objects.isNull(number)) return false;
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).compareTo(BigDecimal.ZERO) > 0;
        }
        return number.doubleValue() > 0;
    }

    /**
     * 是否为空集合
     *
     * @param collection 集合
     * @return true 空 | false 非空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || !collection.isEmpty();
    }

    /**
     * 是否为非空集合
     *
     * @param collection 集合
     * @return true 非空 | false 空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}