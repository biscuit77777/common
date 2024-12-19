package com.biscuit.common.enums;

import lombok.Getter;

/**
 * Boolean 对应 Integer 枚举
 * @author biscuit
 */
@Getter
public enum BooleanEnum {

    TRUE(1),
    FALSE(0);

    private final Integer value;

    BooleanEnum(Integer value) {
        this.value = value;
    }

}
