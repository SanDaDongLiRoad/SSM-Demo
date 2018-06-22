package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.UserDTO;

import java.util.List;

public interface UserService {

    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     * @throws Exception
     */
    User queryUserById(String id) throws Exception;

    /**
     * 查询客户信息列表
     * @param userDTO
     * @return
     * @throws Exception
     */
    List<User> queryUserList(UserDTO userDTO) throws Exception;
}
