package com.biscuit.common.param;

import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通用id集合请求参数
 * @author biscuit
 */
@Getter
@Setter
public class PIdList extends BaseAMO {

    /**
     * 数据集合
     */
    private List<Long> list;

}
