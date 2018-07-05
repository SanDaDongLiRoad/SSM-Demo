package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.domain.UserExample;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.mapper.UserMapper;
import com.xulizhi.demo.service.UserService;
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
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public DataGridResult queryUserListByCondition(UserDTO userDTO) throws Exception {

        logger.info("userDTO:{}",JSONObject.toJSONString(userDTO));

        //查询客户列表
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(userDTO.getName())){
            criteria.andNameEqualTo(userDTO.getName());
        }
        //分页处理
        PageHelper.startPage(userDTO.getPageNo(), userDTO.getSize());
        List<User> list = userMapper.selectByExample(example);
        //创建一个返回值对象
        DataGridResult result = new DataGridResult();
        result.setRows(list);
        result.setCurrentPageNo(userDTO.getPageNo());
        result.setSize(userDTO.getSize());
        //取记录总条数
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        result.setTotal(pageInfo.getTotal());

        logger.info("result:{}",JSONObject.toJSONString(result));
        return result;
    }


    @Override
    public void saveUser(UserDTO userDTO) throws Exception {
        logger.info("userDTO:{}",JSONObject.toJSONString(userDTO));
        User user = DTOConverUtils.DTOConverUser(userDTO);
        user.setId(UUIDUtils.uuid());
        userMapper.insertSelective(user);
    }

    @Override
    public User queryUserById(String id) throws Exception {

        logger.info("id{}",id);

        if(Objects.equals(id,null)){
            throw new Exception("user id is null !");
        }
        User user = userMapper.selectByPrimaryKey(id);

        logger.info("user{}",JSONObject.toJSONString(user));

        return user;
    }

    @Override
    public DataGridResult queryUserList(Integer page, Integer rows) throws Exception {
        //查询客户列表
        UserExample example = new UserExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<User> list = userMapper.selectByExample(example);
        //创建一个返回值对象
        DataGridResult result = new DataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public void deleteUserById(String id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(UserDTO userDTO) throws Exception {

        logger.info("userDTO{}",userDTO);
        User editUser = queryUserById(userDTO.getId());
        editUser.setName(userDTO.getName());
        editUser.setPassword(userDTO.getPassword());
        editUser.setModifyId("2d707b974930489b94c5a4cc1af5e1d3");
        editUser.setModifyName("xulizhi");
        userMapper.updateByPrimaryKey(editUser);
    }
}
