package com.biscuit.common.result.e;

import com.biscuit.common.base.BaseAMO;

import java.time.LocalDateTime;

/**
 * 通用创建/修改时间响应参数
 * @author biscuit
 */
public abstract class RETime extends BaseAMO {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

}
