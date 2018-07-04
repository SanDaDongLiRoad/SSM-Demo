package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.service.UserService;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
    @RequestMapping(value="queryListByPageNo",method=RequestMethod.GET)
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

        logger.info("result:{}",result);
        return modelAndView;
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
            tReturnInfo.setData(JSONObject.toJSONString(user));
            tReturnInfo.setFlag("true");
            tReturnInfo.setMes("deal ok");
        }catch(Exception e){
            e.printStackTrace();
            tReturnInfo.setData("");
            tReturnInfo.setFlag("false");
            tReturnInfo.setMes(e.getMessage());
            return JSONObject.toJSONString(tReturnInfo);
        }

        return JSONObject.toJSONString(tReturnInfo);
    }

    /**
     * 根据条件查询客户信息列表
     * @return
     */
    @RequestMapping(value="queryListByCondition",method = RequestMethod.POST)
    public ModelAndView queryListByCondition(@RequestBody UserDTO userDTO){

        logger.info("userDTO:{}",JSONObject.toJSONString(userDTO));

        ModelAndView modelAndView = new ModelAndView();

        DataGridResult result = new DataGridResult();
        try{
            result = userService.queryUserListByCondition(userDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("user/user-index");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    /**
     * 分页查询客户信息列表
     * @return
     */
    @RequestMapping(value="queryList")
    public ModelAndView queryList(@RequestParam(value="page",defaultValue = "1") Integer page,@RequestParam(value="rows",defaultValue = "10") Integer rows){

        logger.info("page:{},rows{}",page,rows);

        ModelAndView modelAndView = new ModelAndView();
        DataGridResult result = new DataGridResult();
        try{
             result = userService.queryUserList(page,rows);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("user/user-index");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    /**
     * 根据用户名查询客户信息
     * @return
     */
    @RequestMapping(value="queryByName",method = RequestMethod.POST)
    public ModelAndView queryByName(@RequestParam(value="userName")String name){

        logger.info("name:{}",name);

        ModelAndView modelAndView = new ModelAndView();

        DataGridResult result = new DataGridResult();
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        try{
            result = userService.queryUserListByCondition(userDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("user/user-index");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    /**
     * 跳转添加客户页面
     * @return
     */
    @RequestMapping(value="toAddPage",method = RequestMethod.GET)
    public ModelAndView toAddUserPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/add-user");

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
        returnInfo.setData("");
        returnInfo.setFlag("true");
        returnInfo.setMes("保存成功!");
        returnInfo.setCode("2000");
        try {
            userService.saveUser(userDTO);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("true");
            returnInfo.setMes("保存失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method=RequestMethod.GET)
    public ReturnInfo deleteUserById(@RequestParam String id){
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setData("");
        returnInfo.setFlag("true");
        returnInfo.setMes("删除成功!");
        returnInfo.setCode("2000");
        try {
            userService.deleteUserById(id);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("true");
            returnInfo.setMes("删除失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }

    @ResponseBody
    @RequestMapping(value="updateUser",method=RequestMethod.POST)
    public ReturnInfo updateUser(@RequestBody UserDTO userDTO){

        logger.info("userDTO:{}",JSONObject.toJSONString(userDTO));

        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setMes("修改成功!");

        try{
            userService.updateUser(userDTO);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("修改失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }
}
