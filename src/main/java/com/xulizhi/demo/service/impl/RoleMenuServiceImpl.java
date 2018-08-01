package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.RoleMenu;
import com.xulizhi.demo.domain.RoleMenuExample;
import com.xulizhi.demo.mapper.RoleMenuMapper;
import com.xulizhi.demo.service.RoleMenuService;
import com.xulizhi.demo.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    private static final Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    @Override
    public void saveRoleMenuRelation(RoleMenu roleMenu) throws Exception {
        logger.info("roleMenu:{}", JSONObject.toJSONString(roleMenu));
        roleMenu.setId(UUIDUtils.uuid());
        roleMenuMapper.insertSelective(roleMenu);
    }

    @Override
    public void deleteRoleMenuRelationByRoleId(String roleId) throws Exception {
        logger.info("roleId:{}",roleId );
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        roleMenuMapper.deleteByExample(example);
    }

    @Override
    public void deleteRoleMenuRelationByRoleIdAndMenuIds(String roleId, List<String> menuIds) throws Exception {
        logger.info("roleId:{},menuIds:{}",roleId,JSONObject.toJSONString(menuIds));
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        criteria.andMenuIdIn(menuIds);
        roleMenuMapper.deleteByExample(example);
    }

    @Override
    public List<String> queryMenuIdsByRoleId(String roleId) throws Exception {
        logger.info("roleId:{}",roleId );
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<RoleMenu> roleMenuList = roleMenuMapper.selectByExample(example);
        List<String> menuIds = new ArrayList<String>();
        for(int i=0;i<roleMenuList.size();i++){
            menuIds.add(roleMenuList.get(i).getMenuId());
        }

        return menuIds;
    }
}
