package com.biscuit.common.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * 通用分页响应参数
 *
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

    @SuppressWarnings("unchecked")
    public <V> void assign(Page<V> page) {
        this.current = page.getCurrent();
        this.size = page.getSize();
        this.pages = page.getPages() == 0 ? 1 : page.getPages();
        this.total = page.getTotal();
        super.setList((List<T>) page.getRecords());
    }

}
