package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xulizhi.demo.domain.Role;
import com.xulizhi.demo.domain.RoleExample;
import com.xulizhi.demo.domain.RoleMenu;
import com.xulizhi.demo.dto.RoleDto;
import com.xulizhi.demo.mapper.RoleMapper;
import com.xulizhi.demo.service.RoleMenuService;
import com.xulizhi.demo.service.RoleService;
import com.xulizhi.demo.utils.DtoConverUtils;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public DataGridResult queryRoleListByCondition(RoleDto roleDTO) throws Exception {
        logger.info("roleDTO:{}", JSONObject.toJSONString(roleDTO));

        //查询客户角色列表
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(roleDTO.getName())){
            criteria.andNameEqualTo(roleDTO.getName());
        }
        //分页处理
        PageHelper.startPage(roleDTO.getPageNo(), roleDTO.getSize());
        List<Role> list = roleMapper.selectByExample(example);
        //创建一个返回值对象
        DataGridResult result = new DataGridResult();
        result.setRows(list);
        result.setCurrentPageNo(roleDTO.getPageNo());
        result.setSize(roleDTO.getSize());
        //取记录总条数
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        result.setTotal(pageInfo.getTotal());

        logger.info("result:{}",JSONObject.toJSONString(result));
        return result;
    }

    @Override
    public Role queryRoleById(String id) throws Exception {

        logger.info("id{}",id);

        if(Objects.equals(id,null)){
            throw new Exception("role id is null !");
        }
        Role role = roleMapper.selectByPrimaryKey(id);

        logger.info("role{}",JSONObject.toJSONString(role));

        return role;
    }

    @Override
    public void saveRole(RoleDto roleDTO) throws Exception {
        logger.info("roleDTO:{}",JSONObject.toJSONString(roleDTO));
        Role role = DtoConverUtils.DTOConverRole(roleDTO);
        role.setId(UUIDUtils.uuid());
        //保存角色
        roleMapper.insertSelective(role);
        //保存角色权限关系
        for(int i=0;i<roleDTO.getMenuIdList().size();i++){
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(UUIDUtils.uuid());
            roleMenu.setRoleId(role.getId());
            roleMenu.setMenuId(roleDTO.getMenuIdList().get(i));
            roleMenuService.saveRoleMenuRelation(roleMenu);
        }
    }

    @Override
    public void deleteRoleById(String id) throws Exception {
        logger.info("id{}",id);
        //删除角色
        roleMapper.deleteByPrimaryKey(id);
        //删除角色权限关系
        roleMenuService.deleteRoleMenuRelationByRoleId(id);
    }

    @Override
    public void updateRole(RoleDto roleDTO) throws Exception {
        logger.info("roleDTO{}",JSONObject.toJSONString(roleDTO));
        Role editRole = queryRoleById(roleDTO.getId());
        editRole.setName(roleDTO.getName());
        editRole.setRemark(roleDTO.getRemark());
        editRole.setModifyId("2d707b974930489b94c5a4cc1af5e1d3");
        editRole.setModifyName("xulizhi");
        roleMapper.updateByPrimaryKey(editRole);
        //更新角色权限关系表
        List<String> newMenuIds = new ArrayList<String>();
        for(int i=0;i<roleDTO.getMenuIdList().size();i++){
            newMenuIds.add(roleDTO.getMenuIdList().get(i));
        }
        List<String> oldMenuIds = roleMenuService.queryMenuIdsByRoleId(roleDTO.getId());
        newMenuIds.removeAll(oldMenuIds);//角色新增的权限集合
        oldMenuIds.removeAll(roleDTO.getMenuIdList());//角色删除的权限集合
        for(int i=0;i<newMenuIds.size();i++) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(newMenuIds.get(i));
            roleMenu.setRoleId(roleDTO.getId());
            roleMenuService.saveRoleMenuRelation(roleMenu);
        }
        if(!oldMenuIds.isEmpty()) {
            roleMenuService.deleteRoleMenuRelationByRoleIdAndMenuIds(roleDTO.getId(), oldMenuIds);
        }
    }

    @Override
    public List<Role> queryRoleList() throws Exception {
        //查询客户角色列表
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        List<Role> roleList = roleMapper.selectByExample(example);
        logger.info("roleList:{}",JSONObject.toJSONString(roleList));
        return roleList;
    }
}
