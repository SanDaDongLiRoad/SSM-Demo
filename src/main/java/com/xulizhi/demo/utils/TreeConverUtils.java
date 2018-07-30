package com.xulizhi.demo.utils;

import com.xulizhi.demo.domain.Menu;
import org.apache.commons.lang.StringUtils;

public class TreeConverUtils {

    public static TreeBuilder.Node menuConverTreeNode(Menu menu){

        TreeBuilder.Node node = new TreeBuilder.Node();

        if(StringUtils.isNotEmpty(menu.getId())){
            node.setId(menu.getId());
        }
        if(StringUtils.isNotEmpty(menu.getParentId())){
            node.setParentId(menu.getParentId());
        }
        if(StringUtils.isNotEmpty(menu.getName())){
            node.setText(menu.getName());
        }

        return node;
    }
}
