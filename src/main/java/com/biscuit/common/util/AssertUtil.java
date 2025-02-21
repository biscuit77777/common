package com.biscuit.common.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.biscuit.common.enums.ResultEnum;
import com.biscuit.common.exception.BiscuitException;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义断言工具类
 * @author biscuit
 */
public abstract class AssertUtil {

    /**
     * 基础断言，入参非 true 则抛出异常，终端程序执行
     * @param expression 条件
     * @param message 错误信息
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
        assertion(Objects.isNull(obj), message);
    }

    /**
     * 快捷断言，对象非空
     */
    public static void isNotNull(Object obj, String message) {
        assertion(Objects.nonNull(obj), message);
    }

    /**
     * 快捷断言，集合为空
     */
    public static void isEmpty(Collection<?> collection, String message) {
        assertion(CollectionUtils.isEmpty(collection), message);
    }

    /**
     * 快捷断言，集合非空
     */
    public static void isNotEmpty(Collection<?> collection, String message) {
        assertion(CollectionUtils.isNotEmpty(collection), message);
    }

    /**
     * 快捷断言，集合为空
     */
    public static void isEmpty(Map<?, ?> collection, String message) {
        assertion(CollectionUtils.isEmpty(collection), message);
    }

    /**
     * 快捷断言，集合非空
     */
    public static void isNotEmpty(Map<?, ?> collection, String message) {
        assertion(CollectionUtils.isNotEmpty(collection), message);
    }

}
