package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xulizhi.demo.domain.Role;
import com.xulizhi.demo.domain.RoleExample;
import com.xulizhi.demo.dto.RoleDTO;
import com.xulizhi.demo.mapper.RoleMapper;
import com.xulizhi.demo.service.RoleService;
import com.xulizhi.demo.utils.DTOConverUtils;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataGridResult queryRoleListByCondition(RoleDTO roleDTO) throws Exception {
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
    public void saveRole(RoleDTO roleDTO) throws Exception {
        logger.info("roleDTO:{}",JSONObject.toJSONString(roleDTO));
        Role role = DTOConverUtils.DTOConverRole(roleDTO);
        role.setId(UUIDUtils.uuid());
        roleMapper.insertSelective(role);
    }

    @Override
    public void deleteRoleById(String id) throws Exception {
        logger.info("id{}",id);
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRole(RoleDTO roleDTO) throws Exception {
        logger.info("roleDTO{}",roleDTO);
        Role editRole = queryRoleById(roleDTO.getId());
        editRole.setName(roleDTO.getName());
        editRole.setRemark(roleDTO.getRemark());
        editRole.setModifyId("2d707b974930489b94c5a4cc1af5e1d3");
        editRole.setModifyName("xulizhi");
        roleMapper.updateByPrimaryKey(editRole);
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
