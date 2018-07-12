package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

public class User extends BaseDomain {

    private String name;//用户名

    private String password;//密码

    private String roleId;//角色Id

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
