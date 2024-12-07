package com.biscuit.common.emuns;

import lombok.Getter;

/**
 * @author biscuit
 */
@Getter
public enum DeletedEnum {

    /**
     * 已删除
     */
    TRUE(1),

    /**
     * 未删除
     */
    FALSE(0);

    private final int value;

    DeletedEnum(int value) {
        this.value = value;
    }

}
