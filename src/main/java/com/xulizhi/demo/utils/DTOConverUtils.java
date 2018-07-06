package com.xulizhi.demo.utils;

import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.dto.UserDTO;
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
        if(StringUtils.isNotEmpty(menu.getCreateName())){
            menuDTO.setCreateName(menu.getCreateName());
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

    public static User DTOConverUser(UserDTO userDTO){

        User user = new User();

        if(StringUtils.isNotEmpty(userDTO.getId())){
            user.setId(userDTO.getId());
        }
        if(StringUtils.isNotEmpty(userDTO.getName())){
            user.setName(userDTO.getName());
        }
        if(StringUtils.isNotEmpty(userDTO.getPassword())){
            user.setPassword(userDTO.getPassword());
        }
        if(Objects.equals(userDTO.getDeleted(),null)){
            user.setDeleted(userDTO.getDeleted());
        }
        if(StringUtils.isNotEmpty(userDTO.getCreateId())){
            user.setCreaterId(userDTO.getCreateId());
        }
        if(StringUtils.isNotEmpty(userDTO.getCreateName())){
            user.setCreateName(userDTO.getCreateName());
        }
        if(!Objects.equals(null,userDTO.getCreateDate())){
            user.setCreateDate(userDTO.getCreateDate());
        }
        if(StringUtils.isNotEmpty(userDTO.getModifyId())){
            user.setModifyId(userDTO.getModifyId());
        }
        if(StringUtils.isNotEmpty(userDTO.getModifyName())){
            user.setModifyName(userDTO.getModifyName());
        }
        if(!Objects.equals(null,userDTO.getModifyDate())){
            user.setModifyDate(userDTO.getModifyDate());
        }
        return user;
    }

    public static Menu DTOConverMenu(MenuDTO menuDTO){

        Menu menu = new Menu();

        if(StringUtils.isNotEmpty(menuDTO.getId())){
            menu.setId(menuDTO.getId());
        }
        if(StringUtils.isNotEmpty(menuDTO.getName())){
            menu.setName(menuDTO.getName());
        }
        if(StringUtils.isNotEmpty(menuDTO.getIcon())){
            menu.setIcon(menuDTO.getIcon());
        }
        if(StringUtils.isNotEmpty(menuDTO.getUrl())){
            menu.setUrl(menuDTO.getUrl());
        }
        if(StringUtils.isNotEmpty(menuDTO.getParentId())){
            menu.setParentId(menuDTO.getParentId());
        }
        if(!Objects.equals(null,menuDTO.getOrderNo())){
            menu.setOrderNo(menuDTO.getOrderNo());
        }
        if(Objects.equals(menuDTO.getDeleted(),null)){
            menu.setDeleted(menuDTO.getDeleted());
        }
        if(StringUtils.isNotEmpty(menuDTO.getCreateId())){
            menu.setCreaterId(menuDTO.getCreateId());
        }
        if(StringUtils.isNotEmpty(menuDTO.getCreateName())){
            menu.setCreateName(menuDTO.getCreateName());
        }
        if(!Objects.equals(null,menuDTO.getCreateDate())){
            menu.setCreateDate(menuDTO.getCreateDate());
        }
        if(StringUtils.isNotEmpty(menuDTO.getModifyId())){
            menu.setModifyId(menuDTO.getModifyId());
        }
        if(StringUtils.isNotEmpty(menuDTO.getModifyName())){
            menu.setModifyName(menuDTO.getModifyName());
        }
        if(!Objects.equals(null,menuDTO.getModifyDate())){
            menu.setModifyDate(menuDTO.getModifyDate());
        }
        return menu;
    }
}
