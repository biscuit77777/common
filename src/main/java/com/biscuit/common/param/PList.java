package com.biscuit.common.param;

import com.biscuit.common.base.BaseAMO;

import java.util.List;

/**
 * 通用集合请求参数
 * @author biscuit
 */
public class PList<T extends BaseAMO> extends BaseAMO {

    /**
     * 数据集合
     */
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
