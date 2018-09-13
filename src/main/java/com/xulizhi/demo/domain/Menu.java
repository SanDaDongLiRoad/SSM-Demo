package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

/**
 * @author lenovo
 */
public class Menu extends BaseDomain{

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单的BootStrap图标属性
     */
    private String icon;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 父菜单Id
     */
    private String parentId;

    /**
     * 菜单排序序号
     */
    private Integer orderNo;

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
