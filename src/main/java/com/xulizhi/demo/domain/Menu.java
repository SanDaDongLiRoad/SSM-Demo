package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

public class Menu extends BaseDomain{

    private String name;//菜单名称

    private String icon;//菜单的BootStrap图标属性

    private String url;//菜单地址

    private String parentId;//父菜单Id

    private Integer orderNo;//菜单排序序号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
