/**
 * JS数据绑定，加载TreeView,初始化Tree
 * @param data
 * @param treeElement
 */
function initTreeList(data,treeElement){
    var $checkableTree =treeElement
        .treeview({
            data: data, //数据
            showCheckbox: true,
            multiSelect : true,
            levels: 0,
            onNodeChecked: function(event, node) { //选中节点
                var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                if (selectNodes) { //子节点不为空，则选中所有子节点
                    treeElement.treeview('checkNode', [selectNodes, { silent: true }]);
                }
                var parentNode = treeElement.treeview("getNode", node.parentId);
                setParentNodeCheck(node,treeElement);
            },
            onNodeUnchecked: function(event, node) { //取消选中节点
                var selectNodes = getChildNodeIdArr(node); //获取所有子节点
                if (selectNodes) { //子节点不为空，则取消选中所有子节点
                    treeElement.treeview('uncheckNode', [selectNodes, { silent: true }]);
                }
                setParentNodeUnCheck(node,treeElement);
            }
        });
}

//判断该父节点的子节点是否全部已取消，如果全部取消则取消选中该父节点（迭代到该节点没有父节点或者该节点父节点的所有子节点没有全部被取消为止）
function setParentNodeUnCheck(node,treeElement) {
    var parentNode = treeElement.treeview("getNode", node.parentId);

    if (parentNode.nodes) {
        var checkedCount = 0;
        for (x in parentNode.nodes) {
            if (!parentNode.nodes[x].state.checked) {
                checkedCount ++;
            } else {
                break;
            }
        }
        if (checkedCount === parentNode.nodes.length) {
            treeElement.treeview("uncheckNode", parentNode.nodeId);
            setParentNodeUnCheck(parentNode,treeElement);
        }
    }
}

//选中所有子节点时，选中父节点
function setParentNodeCheck(node,treeElement) {
    var parentNode = treeElement.treeview("getNode", node.parentId);
    if (parentNode.nodes) {
        var checkedCount = 0;
        for (x in parentNode.nodes) {
            if (parentNode.nodes[x].state.checked) {
                checkedCount ++;
            } else {
                break;
            }
        }
        if (checkedCount === parentNode.nodes.length) {
            treeElement.treeview("checkNode", parentNode.nodeId);
            setParentNodeCheck(parentNode,treeElement);
        }
    }
}

//获取所有子节点
function getChildNodeIdArr(node) {
    var ts = [];
    if (node.nodes) {
        for (x in node.nodes) {
            ts.push(node.nodes[x].nodeId);
            if (node.nodes[x].nodes) {
                var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                for (j in getNodeDieDai) {
                    ts.push(getNodeDieDai[j]);
                }
            }
        }
    } else {
        ts.push(node.nodeId);
    }
    return ts;
}