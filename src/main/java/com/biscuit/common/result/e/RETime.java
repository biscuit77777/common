package com.biscuit.common.result.e;

import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 通用创建/修改时间响应参数
 * @author biscuit
 */
@Getter
@Setter
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
