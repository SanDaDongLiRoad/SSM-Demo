package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.Role;
import com.xulizhi.demo.dto.RoleDto;
import com.xulizhi.demo.utils.DataGridResult;

import java.util.List;

public interface RoleService {

    /**
     * 根据条件分页查询角色信息列表
     * @param roleDTO
     * @return
     * @throws Exception
     */
    DataGridResult queryRoleListByCondition(RoleDto roleDTO) throws Exception;

    /**
     * 根据ID查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    Role queryRoleById(String id) throws Exception;


    /**
     * 保存角色
     * @param roleDTO
     * @throws Exception
     */
    void saveRole(RoleDto roleDTO)throws Exception;

    /**
     * 根据角色Id删除角色
     * @param id
     * @throws Exception
     */
    void deleteRoleById(String id) throws Exception;

    /**
     * 修改角色信息
     * @param roleDTO
     * @throws Exception
     */
    void updateRole(RoleDto roleDTO) throws Exception;

    /**
     * 查询角色信息列表
     * @return
     * @throws Exception
     */
    List<Role> queryRoleList() throws Exception;
}
