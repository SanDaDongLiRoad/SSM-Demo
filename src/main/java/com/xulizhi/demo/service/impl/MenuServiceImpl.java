package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.domain.MenuExample;
import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.mapper.MenuMapper;
import com.xulizhi.demo.service.MenuService;
import com.xulizhi.demo.utils.DTOConverUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> queryMenuList(MenuDTO menuDTO) {

        logger.info("menuDTO:{}", JSONObject.toJSONString(menuDTO));

        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if(StringUtils.isNotEmpty(menuDTO.getParentId())){
            criteria.andParentIdEqualTo(menuDTO.getParentId());

        }
        List<Menu> menuList = menuMapper.selectByExample(menuExample);

        List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();

        for(int i=0;i<menuList.size();i++){
            MenuDTO converMenuDTO = DTOConverUtils.menuConverDTO(menuList.get(i));
            menuDTOList.add(converMenuDTO);
        }

        return menuDTOList;
    }
}
