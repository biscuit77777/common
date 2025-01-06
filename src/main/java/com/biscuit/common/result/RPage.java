package com.biscuit.common.result;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.biscuit.common.base.BaseAMO;
import com.biscuit.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * 通用分页响应参数
 * @author biscuit
 */
@Getter
@Setter
public class RPage<T extends BaseAMO> extends RList<T> {

    /**
     * 当前页码
     */
    private Long current;

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

    public <V> void assign(Page<V> page) {
        this.current = page.getCurrent();
        this.size = page.getSize();
        this.pages = page.getPages();
        this.total = page.getTotal();
    }

}
