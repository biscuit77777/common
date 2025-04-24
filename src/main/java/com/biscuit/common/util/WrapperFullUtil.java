package com.biscuit.common.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.biscuit.common.base.BaseEntityFull;
import com.biscuit.common.enums.DeletedEnum;

import java.time.LocalDateTime;

/**
 * Wrapper 条件工具类
 *
 * @author biscuit
 */
public abstract class WrapperFullUtil<T extends BaseEntityFull> {

    public static <T extends BaseEntityFull> LambdaQueryWrapper<T> getQueryWrapper(Class<T> clazz) {
        return Wrappers.lambdaQuery(clazz)
                .eq(BaseEntityFull::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

    public static <T extends BaseEntityFull> LambdaUpdateWrapper<T> getUpdateWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz)
                .eq(BaseEntityFull::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

    public static <T extends BaseEntityFull> LambdaUpdateWrapper<T> getDeleteWrapper(Class<T> clazz) {
        return Wrappers.lambdaUpdate(clazz)
                .set(BaseEntityFull::getIsDeleted, DeletedEnum.TRUE.getValue())
                .set(BaseEntityFull::getDeletedTime, LocalDateTime.now())
                .eq(BaseEntityFull::getIsDeleted, DeletedEnum.FALSE.getValue());
    }

}
