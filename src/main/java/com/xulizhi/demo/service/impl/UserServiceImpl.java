package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.domain.UserExample;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.mapper.UserMapper;
import com.xulizhi.demo.service.UserService;
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
    public User queryUserById(String id) throws Exception {

        logger.info("queryUserById param id is: "+ id);

        if(Objects.equals(id,null)){
            throw new Exception("user id is null !");
        }
        User user = userMapper.selectByPrimaryKey(id);

        logger.info("queryUserById result is: "+ user.toString());

        return user;
    }

    @Override
    public List<User> queryUserList(UserDTO userDTO) throws Exception {

        logger.info("queryUserList param is: "+ JSONObject.toJSONString(userDTO));

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(StringUtils.isNotEmpty(userDTO.getName())){
            criteria.andNameEqualTo(userDTO.getName());

        }
        List<User> userList = userMapper.selectByExample(userExample);

        return userList;
    }
}
