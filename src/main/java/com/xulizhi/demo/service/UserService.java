package com.xulizhi.demo.service;

import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.utils.DataGridResult;

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
     * 根据条件查询客户信息列表
     * @param userDTO
     * @return
     * @throws Exception
     */
    DataGridResult queryListByCondition(UserDTO userDTO) throws Exception;

    /**
     * 查询客户信息列表
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    DataGridResult queryUserList(Integer page, Integer rows) throws Exception;

    /**
     * 保存用户
     * @param userDTO
     * @throws Exception
     */
    void saveUser(UserDTO userDTO)throws Exception;

    /**
     * 根据用户Id删除用户
     * @param id
     * @throws Exception
     */
    void deleteUserById(String id) throws Exception;

    /**
     * 修改用户信息
     * @param userDTO
     * @throws Exception
     */
    void updateUser(UserDTO userDTO) throws Exception;
}
