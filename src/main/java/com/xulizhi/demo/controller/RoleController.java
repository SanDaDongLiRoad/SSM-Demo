package com.xulizhi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.xulizhi.demo.domain.Role;
import com.xulizhi.demo.dto.RoleDTO;
import com.xulizhi.demo.service.RoleMenuService;
import com.xulizhi.demo.service.RoleService;
import com.xulizhi.demo.utils.DTOConverUtils;
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

@Controller
@RequestMapping("role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 分页查询角色列表
     * @param pageNo
     * @param name
     * @return
     */
    @RequestMapping(value="queryRoleListByPageNo",method= RequestMethod.GET)
    public ModelAndView queryRoleListByPageNo(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(value="roleName",required = false) String name){

        logger.info("pageNo:{},name:{}",pageNo,name);

        ModelAndView modelAndView = new ModelAndView();
        DataGridResult result = new DataGridResult();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(name);
        roleDTO.setPageNo(pageNo);
        try{
            result = roleService.queryRoleListByCondition(roleDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("role/role-index");
        modelAndView.addObject("result", result);
        //返回请求表单数据
        modelAndView.addObject("roleName", name);
        logger.info("result:{}",result);
        return modelAndView;
    }

    /**
     * 保存角色信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="saveRole",method = RequestMethod.POST)
    public ReturnInfo saveUser(@RequestBody RoleDTO roleDTO){
        ReturnInfo returnInfo = new ReturnInfo();
        try {
            roleService.saveRole(roleDTO);
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
     * 删除角色
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="deleteRoleById",method=RequestMethod.GET)
    public ReturnInfo deleteRoleById(@RequestParam String id){

        logger.info("id:{}",id);
        ReturnInfo returnInfo = new ReturnInfo();

        try {
            roleService.deleteRoleById(id);
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
     * 修改角色信息
     * @param roleDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value="updateRole",method=RequestMethod.POST)
    public ReturnInfo updateUser(@RequestBody RoleDTO roleDTO){

        logger.info("roleDTO:{}", JSONObject.toJSONString(roleDTO));

        ReturnInfo returnInfo = new ReturnInfo();
        try{
            roleService.updateRole(roleDTO);
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
     * 根据ID查询角色信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryRoleById",method = RequestMethod.GET)
    public String queryRoleById(@RequestParam String id){

        logger.info("id:{}",id);

        ReturnInfo tReturnInfo = new ReturnInfo();

        try{
            Role role = roleService.queryRoleById(id);
            RoleDTO roleDTO = DTOConverUtils.roleConverDTO(role);
            List<String> menuIds = roleMenuService.queryMenuIdsByRoleId(id);
            roleDTO.setMenuIdList(menuIds);
            tReturnInfo.setData(JSONObject.toJSONString(roleDTO));
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
     * 查询角色列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="queryRoleList",method= RequestMethod.GET)
    public List<Role> queryRoleList(){

        List<Role> roleList = new ArrayList<Role>();
        try{
            roleList = roleService.queryRoleList();
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("roleList:{}", JSONObject.toJSONString(roleList));
        return roleList;
    }
}
