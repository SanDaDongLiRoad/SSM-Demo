package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.dto.MenuDto;
import com.xulizhi.demo.dto.RoleMenuDto;
import com.xulizhi.demo.utils.DataGridResult;

import java.util.List;

/**
 * @author lenovo
 */
public interface MenuService {

    /**
     * 查询菜单列表
     * @param menuDTO
     * @return
     */
    List<MenuDto> queryMenuListByCondition(MenuDto menuDTO) throws Exception;

    /**
     * 分页查询客户列表
     * @param menuDTO
     * @return
     * @throws Exception
     */
    DataGridResult queryMenuListByPageNo(MenuDto menuDTO) throws Exception;

    /**
     * 保存菜单信息
     * @param menuDTO
     * @throws Exception
     */
    void saveMenu(MenuDto menuDTO)throws Exception;

    /**
     * 根据用户Id删除菜单
     * @param id
     * @throws Exception
     */
    void deleteMenuById(String id) throws Exception;

    /**
     * 根据ID查询菜单信息
     * @param id
     * @return
     * @throws Exception
     */
    Menu queryMenuById(String id) throws Exception;

    /**
     * 修改菜单信息
     * @param menuDTO
     * @throws Exception
     */
    void updateMenu(MenuDto menuDTO) throws Exception;

    /**
     * 查询菜单树结构JSON串
     * @param roleMenuDTO
     * @return
     * @throws Exception
     */
    String queryMenuTreeList(RoleMenuDto roleMenuDTO) throws Exception;

    /**
     * 根据用户ID一级菜单
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Menu> queryTopMenuListByUserId(String roleId) throws Exception;
}
