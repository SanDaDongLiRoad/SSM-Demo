package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

public class Role extends BaseDomain{

    private String name;//角色名称

    private String remark;//备注

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
