package com.biscuit.common.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 通用判断工具类
 *
 * @author biscuit
 */
public abstract class JudgmentUtil {

    /**
     * 对象为空
     *
     * @param obj 对象
     * @return true 为空 | false 不为空
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 多个对象全部为空
     *
     * @param objs 对象数组
     * @return true 全部为空 | false 非全部为空
     */
    public static boolean isNull(Object... objs) {
        for (Object obj : objs) {
            if (isNull(obj)) continue;
            return false;
        }
        return true;
    }

    /**
     * 对象不为空
     *
     * @param obj 对象
     * @return true 不为空 | false 为空
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 多个对象全部不为空
     *
     * @param objs 对象数组
     * @return true 全部不为空 | false 非全部不为空
     */
    public static boolean isNotNull(Object... objs) {
        for (Object obj : objs) {
            if (isNotNull(obj)) continue;
            return false;
        }
        return true;
    }

    /**
     * 字符串为空
     *
     * @param cs 字符串
     * @return true 为空 | false 不为空
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
     * 字符串全部为空
     *
     * @param css 字符串数组
     * @return true 全部为空 | false 非全部为空
     */
    public static boolean isBlank(CharSequence... css) {
        for (CharSequence cs : css) {
            if (isBlank(cs)) continue;
            return false;
        }
        return true;
    }

    /**
     * 字符串不为空
     *
     * @param cs 字符串
     * @return true 不为空 | false 为空
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 字符串全部不为空
     *
     * @param css 字符串数组
     * @return true 全部不为空 | false 非全部不为空
     */
    public static boolean isNotBlank(CharSequence... css) {
        for (CharSequence cs : css) {
            if (isNotBlank(cs)) continue;
            return false;
        }
        return true;
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
     * 集合为空
     *
     * @param collection 集合
     * @return true 为空 | false 不为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 集合全部为空
     *
     * @param collections 集合数组
     * @return true 全部为空 | false 非全部不为空
     */
    public static boolean isEmpty(Collection<?>... collections) {
        for (Collection<?> collection : collections) {
            if (isEmpty(collection)) continue;
            return false;
        }
        return true;
    }

    /**
     * 集合不为空
     *
     * @param collection 集合
     * @return true 不为空 | false 为空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }


    /**
     * 集合全部不为空
     *
     * @param collections 集合数组
     * @return true 全部不为空 | false 非全部为空
     */
    public static boolean isNotEmpty(Collection<?>... collections) {
        for (Collection<?> collection : collections) {
            if (isNotEmpty(collection)) continue;
            return false;
        }
        return true;
    }

    /**
     * 集合为空
     *
     * @param collection 集合
     * @return true 为空 | false 不为空
     */
    public static boolean isEmpty(Map<?, ?> collection) {
        return collection == null || !collection.isEmpty();
    }

    /**
     * 集合全部为空
     *
     * @param collections 集合数组
     * @return true 全部为空 | false 非全部不为空
     */
    public static boolean isEmpty(Map<?, ?>... collections) {
        for (Map<?, ?> collection : collections) {
            if (isEmpty(collection)) continue;
            return false;
        }
        return true;
    }

    /**
     * 集合不为空
     *
     * @param collection 集合
     * @return true 不为空 | false 为空
     */
    public static boolean isNotEmpty(Map<?, ?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 集合全部不为空
     *
     * @param collections 集合数组
     * @return true 全部不为空 | false 非全部为空
     */
    public static boolean isNotEmpty(Map<?, ?>... collections) {
        for (Map<?, ?> collection : collections) {
            if (isNotEmpty(collection)) continue;
            return false;
        }
        return true;
    }

}