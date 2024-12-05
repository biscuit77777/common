package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;


/**
 * 通用分页响应参数
 * @author biscuit
 */
public class RPage<T extends BaseAMO> extends RList<T> {

    /**
     * 当前页码
     */
    private Long page;

    /**
     * 每页条数
     */
    private Long size;

    /**
     * 总页码
     */
    private Long pages;

    /**
     * 数据总条数
     */
    private Long total;

    public void assign() {
    }

}
