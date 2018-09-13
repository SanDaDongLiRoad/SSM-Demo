package com.xulizhi.demo.utils;

import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.domain.Role;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.MenuDto;
import com.xulizhi.demo.dto.RoleDto;
import com.xulizhi.demo.dto.UserDto;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * @author lenovo
 */
public class DtoConverUtils {

    public static MenuDto menuConverDTO(Menu menu){

        MenuDto menuDTO = new MenuDto();

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

    public static User DTOConverUser(UserDto userDTO){

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
        if(StringUtils.isNotEmpty(userDTO.getRoleId())){
            user.setRoleId(userDTO.getRoleId());
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

    public static UserDto userConverDTO(User user){

        UserDto userDTO = new UserDto();

        if(StringUtils.isNotEmpty(user.getId())){
            userDTO.setId(user.getId());
        }
        if(StringUtils.isNotEmpty(user.getName())){
            userDTO.setName(user.getName());
        }
        if(StringUtils.isNotEmpty(user.getPassword())){
            userDTO.setPassword(user.getPassword());
        }
        if(StringUtils.isNotEmpty(user.getRoleId())){
            userDTO.setRoleId(user.getRoleId());
        }
        if(Objects.equals(user.getDeleted(),null)){
            userDTO.setDeleted(user.getDeleted());
        }
        if(StringUtils.isNotEmpty(user.getCreaterId())){
            userDTO.setCreateId(user.getCreaterId());
        }
        if(StringUtils.isNotEmpty(user.getCreateName())){
            userDTO.setCreateName(userDTO.getCreateName());
        }
        if(!Objects.equals(null,user.getCreateDate())){
            userDTO.setCreateDate(user.getCreateDate());
        }
        if(StringUtils.isNotEmpty(user.getModifyId())){
            userDTO.setModifyId(user.getModifyId());
        }
        if(StringUtils.isNotEmpty(user.getModifyName())){
            userDTO.setModifyName(user.getModifyName());
        }
        if(!Objects.equals(null,user.getModifyDate())){
            userDTO.setModifyDate(user.getModifyDate());
        }
        return userDTO;
    }

    public static Menu DTOConverMenu(MenuDto menuDTO){

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

    public static Role DTOConverRole(RoleDto roleDTO){

        Role role = new Role();

        if(StringUtils.isNotEmpty(roleDTO.getId())){
            role.setId(roleDTO.getId());
        }
        if(StringUtils.isNotEmpty(roleDTO.getName())){
            role.setName(roleDTO.getName());
        }
        if(StringUtils.isNotEmpty(roleDTO.getRemark())){
            role.setRemark(roleDTO.getRemark());
        }
        if(Objects.equals(roleDTO.getDeleted(),null)){
            role.setDeleted(roleDTO.getDeleted());
        }
        if(StringUtils.isNotEmpty(roleDTO.getCreateId())){
            role.setCreaterId(roleDTO.getCreateId());
        }
        if(StringUtils.isNotEmpty(roleDTO.getCreateName())){
            role.setCreateName(roleDTO.getCreateName());
        }
        if(!Objects.equals(null,roleDTO.getCreateDate())){
            role.setCreateDate(roleDTO.getCreateDate());
        }
        if(StringUtils.isNotEmpty(roleDTO.getModifyId())){
            role.setModifyId(roleDTO.getModifyId());
        }
        if(StringUtils.isNotEmpty(roleDTO.getModifyName())){
            role.setModifyName(roleDTO.getModifyName());
        }
        if(!Objects.equals(null,roleDTO.getModifyDate())){
            role.setModifyDate(roleDTO.getModifyDate());
        }
        return role;
    }

    public static RoleDto roleConverDTO(Role role){

        RoleDto roleDTO = new RoleDto();

        if(StringUtils.isNotEmpty(role.getId())){
            roleDTO.setId(role.getId());
        }
        if(StringUtils.isNotEmpty(role.getName())){
            roleDTO.setName(role.getName());
        }
        if(StringUtils.isNotEmpty(role.getRemark())){
            roleDTO.setRemark(role.getRemark());
        }
        if(Objects.equals(role.getDeleted(),null)){
            roleDTO.setDeleted(role.getDeleted());
        }
        if(StringUtils.isNotEmpty(role.getCreaterId())){
            roleDTO.setCreateId(role.getCreaterId());
        }
        if(StringUtils.isNotEmpty(role.getCreateName())){
            roleDTO.setCreateName(role.getCreateName());
        }
        if(!Objects.equals(null,role.getCreateDate())){
            roleDTO.setCreateDate(role.getCreateDate());
        }
        if(StringUtils.isNotEmpty(role.getModifyId())){
            roleDTO.setModifyId(role.getModifyId());
        }
        if(StringUtils.isNotEmpty(role.getModifyName())){
            roleDTO.setModifyName(role.getModifyName());
        }
        if(!Objects.equals(null,role.getModifyDate())){
            roleDTO.setModifyDate(role.getModifyDate());
        }
        return roleDTO;
    }
}
