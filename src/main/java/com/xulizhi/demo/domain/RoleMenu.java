package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

/**
 * @author lenovo
 */
public class RoleMenu extends BaseDomain{

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

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
