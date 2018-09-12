package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.domain.MenuExample;
import com.xulizhi.demo.domain.User;
import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.dto.RoleMenuDTO;
import com.xulizhi.demo.mapper.MenuMapper;
import com.xulizhi.demo.service.MenuService;
import com.xulizhi.demo.service.RoleMenuService;
import com.xulizhi.demo.service.UserService;
import com.xulizhi.demo.utils.DTOConverUtils;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.TreeBuilder;
import com.xulizhi.demo.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private UserService userService;

    @Override
    public List<MenuDTO> queryMenuListByCondition(MenuDTO menuDTO) throws Exception{

        logger.info("menuDTO:{}", JSONObject.toJSONString(menuDTO));

        MenuExample menuExample = new MenuExample();
        menuExample.setOrderByClause("order_no desc");
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if(StringUtils.isNotEmpty(menuDTO.getParentId())){
            criteria.andParentIdEqualTo(menuDTO.getParentId());

        }
        List<Menu> menuList = menuMapper.selectByExample(menuExample);

        List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();

        for(int i=0;i<menuList.size();i++){
            MenuDTO converMenuDTO = DTOConverUtils.menuConverDTO(menuList.get(i));
            menuDTOList.add(converMenuDTO);
        }

        return menuDTOList;
    }

    @Override
    public DataGridResult queryMenuListByPageNo(MenuDTO menuDTO) throws Exception {

        logger.info("menuDTO:{}",JSONObject.toJSONString(menuDTO));

        //查询菜单列表
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if(StringUtils.isNotEmpty(menuDTO.getName())){
            criteria.andNameEqualTo(menuDTO.getName());
        }
        //分页处理
        PageHelper.startPage(menuDTO.getPageNo(), menuDTO.getSize());
        List<Menu> list = menuMapper.selectByExample(menuExample);
        //创建一个返回值对象
        DataGridResult result = new DataGridResult();
        result.setRows(list);
        result.setCurrentPageNo(menuDTO.getPageNo());
        result.setSize(menuDTO.getSize());
        //取记录总条数
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(list);
        result.setTotal(pageInfo.getTotal());

        logger.info("result:{}",JSONObject.toJSONString(result));
        return result;
    }

    @Override
    public void saveMenu(MenuDTO menuDTO) throws Exception {
        logger.info("menuDTO:{}",JSONObject.toJSONString(menuDTO));
        Menu menu = DTOConverUtils.DTOConverMenu(menuDTO);
        menu.setId(UUIDUtils.uuid());
        menuMapper.insertSelective(menu);
    }

    @Override
    public void deleteMenuById(String id) throws Exception {
        logger.info("id{}",id);
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Menu queryMenuById(String id) throws Exception {
        logger.info("id{}",id);

        if(Objects.equals(id,null)){
            throw new Exception("Menu id is null !");
        }
        Menu menu = menuMapper.selectByPrimaryKey(id);

        logger.info("menu{}",JSONObject.toJSONString(menu));

        return menu;
    }

    @Override
    public void updateMenu(MenuDTO menuDTO) throws Exception {
        logger.info("menuDTO{}",menuDTO);
        Menu editMenu = queryMenuById(menuDTO.getId());
        editMenu.setName(menuDTO.getName());
        editMenu.setIcon(menuDTO.getIcon());
        editMenu.setUrl(menuDTO.getUrl());
        editMenu.setParentId(menuDTO.getParentId());
        editMenu.setOrderNo(menuDTO.getOrderNo());
        editMenu.setModifyId("2d707b974930489b94c5a4cc1af5e1d3");
        editMenu.setModifyName("xulizhi");
        menuMapper.updateByPrimaryKey(editMenu);
    }

    @Override
    public String queryMenuTreeList(RoleMenuDTO roleMenuDTO) throws Exception {
        logger.info("roleMenuDTO{}",JSONObject.toJSONString(roleMenuDTO));
        List<TreeBuilder.Node> nodeList = new ArrayList<TreeBuilder.Node>();
        MenuDTO menuDTO = new MenuDTO();
        List<MenuDTO> menuDTOList = queryMenuListByCondition(menuDTO);
        List<String> menuIds = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("checked", true);
        if(StringUtils.isNotEmpty(roleMenuDTO.getRoleId())){
            menuIds = roleMenuService.queryMenuIdsByRoleId(roleMenuDTO.getRoleId());
        }
        for(int i=0;i<menuDTOList.size();i++){
            TreeBuilder.Node node = new TreeBuilder.Node();
            node.setId(menuDTOList.get(i).getId());
            node.setParentId(menuDTOList.get(i).getParentId());
            node.setText(menuDTOList.get(i).getName());
            if(menuIds.contains(node.getId())){
                node.setState(map);
            }
            nodeList.add(node);
        }
        List<TreeBuilder.Node> nodes = new TreeBuilder().buildTree(nodeList);
        logger.info("nodes{}", JSONObject.toJSONString(nodes, SerializerFeature.DisableCircularReferenceDetect));
        return JSONObject.toJSONString(nodes, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public List<Menu> queryTopMenuListByUserId(String userId) throws Exception {
        logger.info("userId{}",userId);
        User user = userService.queryUserById(userId);
        List<String> menuIds = roleMenuService.queryMenuIdsByRoleId(user.getRoleId());
        List<Menu> menuList = new ArrayList<Menu>();
        for(int i=0;i<menuIds.size();i++){
            Menu menu = queryMenuById(menuIds.get(i));
            if(Objects.equals(menu.getParentId(),"0")) {
                menuList.add(menu);
            }
        }
        //对集合元素进行排序
        Collections.sort(menuList, new Comparator<Menu>(){
            /*
             * int compare(Menu m1, Menu m2) 返回一个基本类型的整型，
             * 返回负数表示：m1小于m2，
             * 返回0 表示：m1和m2相等，
             * 返回正数表示：p1大于p2
             */
            @Override
            public int compare(Menu m1, Menu m2) {
                //按照Menu的orderNo进行升序排列
                if(m1.getOrderNo() > m2.getOrderNo()){
                    return 1;
                }
                if(Objects.equals(m1.getOrderNo(),m2.getOrderNo())){
                    return 0;
                }
                return -1;
            }
        });
        return menuList;
    }
}
