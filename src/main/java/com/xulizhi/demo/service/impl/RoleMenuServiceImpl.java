package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.RoleMenu;
import com.xulizhi.demo.mapper.RoleMenuMapper;
import com.xulizhi.demo.service.RoleMenuService;
import com.xulizhi.demo.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
