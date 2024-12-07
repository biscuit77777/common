package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 通用List集合响应参数
 * @author biscuit
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RList<T extends BaseAMO> extends BaseAMO {

    /**
     * 数据集合
     */
    private List<T> list;

}
