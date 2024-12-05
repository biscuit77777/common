package com.biscuit.common.param;

import com.biscuit.common.base.BaseAMO;

import java.util.List;

/**
 * 通用id集合请求参数
 * @author biscuit
 */
public class PIdList extends BaseAMO {

    /**
     * 数据集合
     */
    private List<Long> list;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

}
