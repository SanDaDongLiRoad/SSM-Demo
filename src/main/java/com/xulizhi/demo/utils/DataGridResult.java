package com.xulizhi.demo.utils;

import java.util.List;

public class DataGridResult {

    private long currentPageNo;//当前页数
    private long size;//每页显示记录数
    private long total;//总记录数
    private List<?> rows;//总记录数据集合

    public long getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(long currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
