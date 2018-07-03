package com.xulizhi.demo.common;

public class BaseDTO {

    private Integer pageNo = 1;//页数

    private Integer size = 10;//每页的条数

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
