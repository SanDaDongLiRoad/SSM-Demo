package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.RoleMenu;

public interface RoleMenuService {

    /**
     * 保存角色权限关系
     * @param roleMenu
     * @throws Exception
     */
    void saveRoleMenuRelation(RoleMenu roleMenu)throws Exception;
}
