package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    /**
     * 保存角色权限关系
     * @param roleMenu
     * @throws Exception
     */
    void saveRoleMenuRelation(RoleMenu roleMenu)throws Exception;

    /**
     * 删除角色权限关系
     * @param roleId
     * @throws Exception
     */
    void deleteRoleMenuRelation(String roleId) throws Exception;
}
