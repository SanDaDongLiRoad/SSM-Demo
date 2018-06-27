package com.xulizhi.demo.common;

public class BaseDTO {

    private Integer page = 1;//页数

    private Integer rows = 10;//每页的条数

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
