package com.biscuit.common.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.biscuit.common.base.BaseEntitySimple;
import com.biscuit.common.enums.DeletedEnum;

import java.time.LocalDateTime;

/**
 * Wrapper 条件工具类
 *
 * @author biscuit
 */
public abstract class WrapperSimpleUtil<T extends BaseEntitySimple> {

    public static <T extends BaseEntitySimple> LambdaQueryWrapper<T> getQueryWrapper(Class<T> clazz) {
        return Wrappers.lambdaQuery(clazz);
    }

    public static <T extends BaseEntitySimple> LambdaUpdateWrapper<T> getUpdateWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz);
    }

    public static <T extends BaseEntitySimple> LambdaUpdateWrapper<T> getDeleteWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz);
    }

}
