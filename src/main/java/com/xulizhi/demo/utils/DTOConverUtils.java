package com.xulizhi.demo.utils;

import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.dto.MenuDTO;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

public class DTOConverUtils {

    public static MenuDTO menuConverDTO(Menu menu){

        MenuDTO menuDTO = new MenuDTO();

        if(StringUtils.isNotEmpty(menu.getId())){
            menuDTO.setId(menu.getId());
        }
        if(StringUtils.isNotEmpty(menu.getName())){
            menuDTO.setName(menu.getName());
        }
        if(StringUtils.isNotEmpty(menu.getIcon())){
            menuDTO.setIcon(menu.getIcon());
        }
        if(StringUtils.isNotEmpty(menu.getUrl())){
            menuDTO.setUrl(menu.getUrl());
        }
        if(StringUtils.isNotEmpty(menu.getParentId())){
            menuDTO.setParentId(menu.getParentId());
        }
        if(StringUtils.isNotEmpty(menu.getCreaterName())){
            menuDTO.setCreaterName(menu.getCreaterName());
        }
        if(!Objects.equals(null,menu.getCreateDate())){
            menuDTO.setCreateDate(menu.getCreateDate());
        }
        if(StringUtils.isNotEmpty(menu.getModifyName())){
            menuDTO.setModifyName(menu.getModifyName());
        }
        if(!Objects.equals(null,menu.getModifyDate())){
            menuDTO.setModifyDate(menu.getModifyDate());
        }

        return menuDTO;
    }
}
