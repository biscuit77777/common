package com.biscuit.common.util;

import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.BiscuitException;

import java.util.Collection;
import java.util.Map;

/**
 * 自定义断言工具类
 *
 * @author biscuit
 */
public abstract class AssertUtil {

    /**
     * 基础断言，入参非 true 则抛出异常，终端程序执行
     *
     * @param expression 条件
     * @param message    错误信息
     */
    public static void assertion(boolean expression, String message) {
        if (!expression) {
            throw new BiscuitException(ResultEnum.ASSERT_ERROR.getCode(), message);
        }
    }

    /**
     * 快捷断言，对象为空
     */
    public static void isNull(Object obj, String message) {
        assertion(JudgmentUtil.isNull(obj), message);
    }

    /**
     * 快捷断言，对象全部为空
     */
    public static void isNull(String message, Object... objs) {
        assertion(JudgmentUtil.isNull(objs), message);
    }

    /**
     * 快捷断言，对象非空
     */
    public static void isNotNull(Object obj, String message) {
        assertion(JudgmentUtil.isNotNull(obj), message);
    }

    /**
     * 快捷断言，对象全部非空
     */
    public static void isNotNull(String message, Object... objs) {
        assertion(JudgmentUtil.isNotNull(objs), message);
    }

    /**
     * 快捷断言，集合为空
     */
    public static void isEmpty(Collection<?> collection, String message) {
        assertion(JudgmentUtil.isEmpty(collection), message);
    }

    /**
     * 快捷断言，集合全部为空
     */
    public static void isEmpty(String message, Collection<?>... collections) {
        assertion(JudgmentUtil.isEmpty(collections), message);
    }

    /**
     * 快捷断言，集合非空
     */
    public static void isNotEmpty(Collection<?> collection, String message) {
        assertion(JudgmentUtil.isNotEmpty(collection), message);
    }

    /**
     * 快捷断言，集合全部非空
     */
    public static void isNotEmpty(String message, Collection<?>... collections) {
        assertion(JudgmentUtil.isNotEmpty(collections), message);
    }

    /**
     * 快捷断言，集合为空
     */
    public static void isEmpty(Map<?, ?> collection, String message) {
        assertion(JudgmentUtil.isEmpty(collection), message);
    }

    /**
     * 快捷断言，集合全部为空
     */
    public static void isEmpty(String message, Map<?, ?>... collections) {
        assertion(JudgmentUtil.isEmpty(collections), message);
    }

    /**
     * 快捷断言，集合非空
     */
    public static void isNotEmpty(Map<?, ?> collection, String message) {
        assertion(JudgmentUtil.isNotEmpty(collection), message);
    }

    /**
     * 快捷断言，集合全部非空
     */
    public static void isNotEmpty(String message, Map<?, ?> collections) {
        assertion(JudgmentUtil.isNotEmpty(collections), message);
    }

}
