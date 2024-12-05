package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;

import java.util.List;

/**
 * 通用List集合响应参数
 * @author biscuit
 */
public class RList<T extends BaseAMO> extends BaseAMO {

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

    public RList() {
    }

    public RList(List<T> list) {
        this.list = list;
    }

}
