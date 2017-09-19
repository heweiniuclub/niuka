package com.niuka.common.model;

import java.io.Serializable;

/**
 * 分页基类
 *
 * @author hewei
 */
public class PaginationSupport implements Serializable {
    private static final long serialVersionUID = 2234283310680151858L;

    /** 默认显示页码数 */
    public static final int DEFAULT_OFFSET_SIZE = 3;

    /** 默认每页行数 */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /** 显示页码数 */
    private int offsetSize = DEFAULT_OFFSET_SIZE;

    /** 每页行数 */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /** 当前页码 */
    private int pageNo = 1;

    /** 记录总数 */
    private long rowCount;

    public PaginationSupport() {}

    public PaginationSupport(int pageNo, int pageSize) {
        this.pageNo   = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    public int getOffsetSize() {
        return offsetSize;
    }

    public void setOffsetSize(int offsetSize) {
        this.offsetSize = offsetSize;
    }

    /**
     * 获取总页数
     */
    public long getPageCount() {
        if (rowCount % pageSize == 0) {
            return rowCount / pageSize;
        } else {
            return (rowCount / pageSize) + 1;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
