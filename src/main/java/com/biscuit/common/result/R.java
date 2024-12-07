package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用响应
 * @author biscuit
 */
@Getter
@Setter
public class R<T extends BaseAMO> extends BaseAMO {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

}
