package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.service.UserService;
import com.xulizhi.demo.utils.DtoConverUtils;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.ReturnInfo;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;


@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 分页查询客户列表
     * @param pageNo
     * @param name
     * @return
     */
    @RequestMapping(value="queryUserListByPageNo",method=RequestMethod.GET)
    public ModelAndView queryUserByPageNo(@RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(value="userName",required = false) String name){

        logger.info("pageNo:{},name:{}",pageNo,name);

        ModelAndView modelAndView = new ModelAndView();
        DataGridResult result = new DataGridResult();
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setPageNo(pageNo);
        try{
            result = userService.queryUserListByCondition(userDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("user/user-index");
        modelAndView.addObject("result", result);
        //返回请求表单数据
        modelAndView.addObject("userName", name);
        logger.info("result:{}",result);
        return modelAndView;
    }

    /**
     * 保存用户信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="saveUser",method = RequestMethod.POST)
    public ReturnInfo saveUser(@RequestBody UserDTO userDTO){
        ReturnInfo returnInfo = new ReturnInfo();
        try {
            userService.saveUser(userDTO);
            returnInfo.setMes("保存成功!");
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("保存失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }

    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam String id){

        logger.info("id:{}",id);

        ReturnInfo tReturnInfo = new ReturnInfo();

        try{
            User user = userService.queryUserById(id);
            UserDTO userDTO = DtoConverUtils.userConverDTO(user);
            tReturnInfo.setData(JSONObject.toJSONString(userDTO));
            tReturnInfo.setMes("deal ok");
        }catch(Exception e){
            e.printStackTrace();
            tReturnInfo.setFlag("false");
            tReturnInfo.setMes("系统异常");
        }
        logger.info("tReturnInfo:{}",tReturnInfo);
        return JSONObject.toJSONString(tReturnInfo);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="deleteUserById",method=RequestMethod.GET)
    public ReturnInfo deleteUserById(@RequestParam String id){

        logger.info("id:{}",id);
        ReturnInfo returnInfo = new ReturnInfo();

        try {
            userService.deleteUserById(id);
            returnInfo.setMes("删除成功!");
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("删除失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }

    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value="updateUser",method=RequestMethod.POST)
    public ReturnInfo updateUser(@RequestBody UserDTO userDTO){

        logger.info("userDTO:{}",JSONObject.toJSONString(userDTO));

        ReturnInfo returnInfo = new ReturnInfo();
        try{
            userService.updateUser(userDTO);
            returnInfo.setMes("修改成功!");
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("修改失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }

    /**
     * 批量上传新增用户Eexcel
     */
    @RequestMapping(value = "/uploadUserListFile", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo uploadUserListFile(@RequestParam("userListFile") MultipartFile userListFile) {
        ReturnInfo returnInfo = new ReturnInfo();
        CommonsMultipartFile commonsMultipartFile= (CommonsMultipartFile)userListFile;
        DiskFileItem diskFileItem = (DiskFileItem)commonsMultipartFile.getFileItem();
        File usersFile = diskFileItem.getStoreLocation();
        try {
            userService.uploadUserListFile(usersFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnInfo;
    }
}
