package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

/**
 * @author lenovo
 */
public class Role extends BaseDomain{

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
