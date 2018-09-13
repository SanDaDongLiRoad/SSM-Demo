package com.xulizhi.demo.common;

/**
 * @author lenovo
 */
public class BaseDto {


    /**
     * 页数
     */
    private Integer pageNo = 1;
    /**
     * 每页的条数
     */
    private Integer size = 10;

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

    @Override
    public String toString() {
        return super.toString() + "BaseDto{" + "pageNo='" + pageNo + '\'' + "size='" + size + '\'' + '}';
    }
}
