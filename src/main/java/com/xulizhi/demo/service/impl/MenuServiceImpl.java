package com.xulizhi.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xulizhi.demo.domain.Menu;
import com.xulizhi.demo.domain.MenuExample;
import com.xulizhi.demo.dto.MenuDTO;
import com.xulizhi.demo.mapper.MenuMapper;
import com.xulizhi.demo.service.MenuService;
import com.xulizhi.demo.utils.DTOConverUtils;
import com.xulizhi.demo.utils.DataGridResult;
import com.xulizhi.demo.utils.TreeBuilder;
import com.xulizhi.demo.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

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
    public String queryMenuTreeList(MenuDTO menuDTO) throws Exception {
        logger.info("menuDTO{}",menuDTO);
        List<TreeBuilder.Node> nodeList = new ArrayList<TreeBuilder.Node>();
        List<MenuDTO> menuDTOList = queryMenuListByCondition(menuDTO);
        for(int i=0;i<menuDTOList.size();i++){
            TreeBuilder.Node node = new TreeBuilder.Node();
            node.setId(menuDTOList.get(i).getId());
            node.setParentId(menuDTOList.get(i).getParentId());
            node.setText(menuDTOList.get(i).getName());
            nodeList.add(node);
        }
        List<TreeBuilder.Node> nodes = new TreeBuilder().buildTree(nodeList);
        logger.info("nodes{}",nodes);
        return JSONObject.toJSONString(nodes);
    }
}
