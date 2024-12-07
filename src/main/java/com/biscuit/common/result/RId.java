package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 通用id响应参数
 * @author biscuit
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RId extends BaseAMO {

    /**
     * id
     */
    private Long id;

}
