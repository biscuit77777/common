package com.biscuit.common.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.biscuit.common.base.BaseEntity;
import com.biscuit.common.enums.DeletedEnum;

import java.time.LocalDateTime;

/**
 * Wrapper 条件工具类
 * @author biscuit0
 */
public abstract class WrapperUtil<T extends BaseEntity> {

    public static <T extends BaseEntity> LambdaQueryWrapper<T> getQueryWrapper(Class<T> clazz) {
        return Wrappers.lambdaQuery(clazz)
                .eq(BaseEntity::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

    public static <T extends BaseEntity> LambdaUpdateWrapper<T> getUpdateWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz)
                .eq(BaseEntity::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

    public static <T extends BaseEntity> LambdaUpdateWrapper<T> getDeleteWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz)
                .set(BaseEntity::getIsDeleted, DeletedEnum.TRUE.getValue())
                .set(BaseEntity::getDeletedTime, LocalDateTime.now())
                .eq(BaseEntity::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

}
