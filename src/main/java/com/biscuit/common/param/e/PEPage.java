package com.biscuit.common.param.e;

import com.biscuit.common.base.BaseAMO;

/**
 * 通用分页参数
 * @author biscuit
 */
public abstract class PEPage extends BaseAMO {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public void check() {
        this.pageNo = this.pageNo != null && this.pageNo > 0 ? this.pageNo : 1;
        this.pageSize = this.pageSize != null && this.pageSize > 0 ? this.pageSize : 10;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
