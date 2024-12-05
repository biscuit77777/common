package com.biscuit.common.emuns;

/**
 * @author biscuit
 */
public enum DeletedEnum {

    /**
     * 已删除
     */
    TRUE(1),

    /**
     * 未删除
     */
    FALSE(0);

    private Integer value;

    DeletedEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
