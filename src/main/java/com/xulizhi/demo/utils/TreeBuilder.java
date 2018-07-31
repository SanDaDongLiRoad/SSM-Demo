package com.xulizhi.demo.utils;

import com.xulizhi.demo.constants.EBootStrapTreeViewNodeState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 构造目录JSON树
 * Created by xulizhi on 2018/7/27.
 */
public class TreeBuilder {

    /**
     * 判断是否为根节点
     * @param node
     * @return
     */
    public boolean rootNode(Node node,List<Node> nodeList) {
        boolean isRootNode = true;
        for (Node n : nodeList) {
            if (Objects.equals(node.getParentId(),n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    /**
     * 获取集合中所有的根节点
     * @param nodeList
     * @return
     */
    public List<Node> getRootNodes(List<Node> nodeList) {
        List<Node> rootNodes = new ArrayList<>();
        for (Node n : nodeList) {
            // 判断是否为根节点
            if (rootNode(n,nodeList)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }

    /**
     * 获取父节点下所有的子节点
     * @param node
     * @param nodeList
     * @return
     */
    public List<Node> getChildNodes(Node node,List<Node> nodeList) {
        List<Node> childNodes = new ArrayList<>();
        for (Node n : nodeList) {
            if (Objects.equals(node.getId(),n.getParentId())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }

    /**
     * 递归子节点
     * @param node
     * @param nodeList
     */
    public void buildChildNodes(Node node,List<Node> nodeList) {
        List<Node> children = getChildNodes(node,nodeList);// 获取父节点下所有的子节点
        if (!children.isEmpty()) {
            for (Node child : children) {
                buildChildNodes(child,nodeList);
            }
            node.setNodes(children);
        }
    }

    /**
     * 构建树形结构
     * @param nodeList 所有节点集合
     * @return
     */
    public List<Node> buildTree(List<Node> nodeList) {
        List<Node> treeNodes = new ArrayList<>();
        List<Node> rootNodes = getRootNodes(nodeList);//获取集合中所有的根节点
        for (Node rootNode : rootNodes) {
            // 递归子节点
            buildChildNodes(rootNode,nodeList);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    /**
     * 树节点类
     */
    public static class Node {

        private String id;
        private String parentId;
        private String text;
        private String state = EBootStrapTreeViewNodeState.UnChecked.getValue();//默认未勾选状态
        private List<Node> nodes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public List<Node> getNodes() {
            return nodes;
        }

        public void setNodes(List<Node> nodes) {
            this.nodes = nodes;
        }
    }
}