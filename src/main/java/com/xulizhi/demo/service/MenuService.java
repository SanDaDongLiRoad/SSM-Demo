package com.xulizhi.demo.service;

import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.utils.DataGridResult;

import java.util.List;

public interface MenuService {

    /**
     * 查询菜单列表
     * @param menuDTO
     * @return
     */
    List<MenuDTO> queryMenuListByCondition(MenuDTO menuDTO) throws Exception;

    DataGridResult queryMenuListByPageNo(MenuDTO menuDTO) throws Exception;
}
