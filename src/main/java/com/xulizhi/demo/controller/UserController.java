package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.UserDTO;
import com.xulizhi.demo.service.UserService;
import com.xulizhi.demo.utils.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     */
    @RequestMapping(value="queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam String id){

        logger.info("queryUserById param id is: "+ id);

        ReturnInfo tReturnInfo = new ReturnInfo();

        try{
            User user = userService.queryUserById(id);
            tReturnInfo.setData(JSONObject.toJSONString(user));
            tReturnInfo.setFlag("true");
            tReturnInfo.setMes("deal ok");
        }catch(Exception e){
            e.printStackTrace();
            tReturnInfo.setData(null);
            tReturnInfo.setFlag("false");
            tReturnInfo.setMes(e.getMessage());
            return JSONObject.toJSONString(tReturnInfo);
        }

        return JSONObject.toJSONString(tReturnInfo);
    }

    /**
     * 查询客户信息列表
     * @return
     */
    @RequestMapping(value="queryUserList",method = RequestMethod.POST)
    public ModelAndView queryUserList(UserDTO userDTO){

        logger.info("queryUserList param is: "+ JSONObject.toJSONString(userDTO));

        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = new ArrayList<User>();
        try{
            userList = userService.queryUserList(userDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("user-query");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
}
