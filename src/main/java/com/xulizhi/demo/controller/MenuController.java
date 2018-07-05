package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    /**
     * 查询菜单列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryMenuListByCondition",method = RequestMethod.POST)
    public List<MenuDTO> queryMenuListByCondition(@RequestBody MenuDTO menuDTO){

        logger.info("menuDTO:{}", JSONObject.toJSONString(menuDTO));

        List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();
        try{
            menuDTOList = menuService.queryMenuListByCondition(menuDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("menuDTOList:{}", JSONObject.toJSONString(menuDTOList));
        return menuDTOList;
    }
}
