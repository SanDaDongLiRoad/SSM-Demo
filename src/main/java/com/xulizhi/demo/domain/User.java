package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

/**
 * @author lenovo
 */
public class User extends BaseDomain {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色Id
     */
    private String roleId;

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
