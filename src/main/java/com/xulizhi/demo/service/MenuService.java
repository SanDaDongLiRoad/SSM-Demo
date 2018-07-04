package com.xulizhi.demo.service;

import com.xulizhi.demo.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    /**
     * 查询菜单列表
     * @param menuDTO
     * @return
     */
    List<MenuDTO> queryMenuListByCondition(MenuDTO menuDTO);
}
