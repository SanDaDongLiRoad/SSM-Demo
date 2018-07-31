package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

public class RoleMenu extends BaseDomain{

    private String roleId;//角色ID

    private String menuId;//菜单ID

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
