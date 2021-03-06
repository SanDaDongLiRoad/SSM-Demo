package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.dto.MenuDto;
import com.xulizhi.demo.dto.RoleMenuDto;
import com.xulizhi.demo.service.MenuService;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 */
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
    public List<MenuDto> queryMenuListByCondition(@RequestBody MenuDto menuDTO){

        logger.info("menuDTO:{}", JSONObject.toJSONString(menuDTO));

        List<MenuDto> menuDTOList = new ArrayList<MenuDto>();
        try{
            menuDTOList = menuService.queryMenuListByCondition(menuDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("menuDTOList:{}", JSONObject.toJSONString(menuDTOList));
        return menuDTOList;
    }

    /**
     * 分页查询客户列表
     * @param pageNo
     * @param name
     * @return
     */
    @RequestMapping(value="queryMenuListByPageNo",method=RequestMethod.GET)
    public ModelAndView queryMenuListByPageNo(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(value="menuName",required = false) String name){

        logger.info("pageNo:{},name:{}",pageNo,name);

        ModelAndView modelAndView = new ModelAndView();
        DataGridResult result = new DataGridResult();
        MenuDto menuDTO = new MenuDto();
        menuDTO.setName(name);
        menuDTO.setPageNo(pageNo);
        try{
            result = menuService.queryMenuListByPageNo(menuDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("menu/menu-index");
        modelAndView.addObject("result", result);
        //返回请求表单数据
        modelAndView.addObject("menuName", name);
        logger.info("result:{}",result);
        return modelAndView;
    }

    /**
     * 保存菜单信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="saveMenu",method = RequestMethod.POST)
    public ReturnInfo saveMenu(@RequestBody MenuDto menuDTO){
        ReturnInfo returnInfo = new ReturnInfo();
        try {
            menuService.saveMenu(menuDTO);
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
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="deleteMenuById",method=RequestMethod.GET)
    public ReturnInfo deleteMenuById(@RequestParam String id){

        logger.info("id:{}",id);
        ReturnInfo returnInfo = new ReturnInfo();

        try {
            menuService.deleteMenuById(id);
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
     * 根据ID查询菜单信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryMenuById",method = RequestMethod.GET)
    public String queryMenuById(@RequestParam String id){

        logger.info("id:{}",id);

        ReturnInfo tReturnInfo = new ReturnInfo();

        try{
            Menu menu = menuService.queryMenuById(id);
            tReturnInfo.setData(JSONObject.toJSONString(menu));
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
     * 修改菜单信息
     * @param menuDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value="updateMenu",method=RequestMethod.POST)
    public ReturnInfo updateMenu(@RequestBody MenuDto menuDTO){

        logger.info("menuDTO:{}",JSONObject.toJSONString(menuDTO));

        ReturnInfo returnInfo = new ReturnInfo();
        try{
            menuService.updateMenu(menuDTO);
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
     * 查询菜单树结构JSON串
     * @param roleMenuDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryMenuTreeList",method=RequestMethod.POST)
    public ReturnInfo queryMenuTreeList(@RequestBody RoleMenuDto roleMenuDTO){

        logger.info("menuDTO:{}",JSONObject.toJSONString(roleMenuDTO));

        ReturnInfo returnInfo = new ReturnInfo();
        try{
            String menuTreeJsonStr = menuService.queryMenuTreeList(roleMenuDTO);
            returnInfo.setData(menuTreeJsonStr);
            returnInfo.setMes("查询成功!");
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("查询失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }


    @ResponseBody
    @RequestMapping(value="queryTopMenuListByUserId",method=RequestMethod.GET)
    public ReturnInfo queryTopMenuListByUserId(@RequestParam String userId){

        logger.info("userId:{}",userId);

        ReturnInfo returnInfo = new ReturnInfo();
        try{
            List<Menu> menuList = menuService.queryTopMenuListByUserId(userId);
            returnInfo.setMes("查询成功!");
            returnInfo.setData(JSONObject.toJSONString(menuList));
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setFlag("false");
            returnInfo.setMes("查询失败!");
            returnInfo.setCode("2001");
        }
        return returnInfo;
    }
}
