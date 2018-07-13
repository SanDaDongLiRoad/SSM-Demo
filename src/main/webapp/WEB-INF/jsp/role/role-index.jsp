<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head-style.inc" %>
    <script type="text/javascript" src="${basePath}/static/plugins/bootstrap-treeview/bootstrap-treeview.js"></script>
    <script type="text/javascript" src="${basePath}/static/js/role/role.js"></script>
    <script type="text/javascript" src="${basePath}/static/js/BootstrapTreeviewUtils.js"></script>
    <script>
        //根据条件查询角色
        function doQueryByCondition(pageNo){
            if(isPositiveInteger(pageNo)){
                $("#query-role-form #pageNo").val(pageNo);
            }else{
                $("#query-role-form #pageNo").val(1);
            }
            // 表单提交
            $('#query-role-form').submit();
        }
    </script>
</head>
<body>
    <!-- 顶栏 -->
    <jsp:include page="/WEB-INF/jsp/common/top.jsp"/>
    <!-- 中间主体 -->
    <div class="container" id="content">
        <div class="row">
            <!-- 菜单栏 -->
            <jsp:include page="/WEB-INF/jsp/common/left-menu.jsp"/>
            <div class="col-md-10">
                <div class="panel panel-default" style="border: 1px solid #35b558;">
                    <div class="panel-heading">
                        <div class="row">
                            <h3 class="col-md-5">角色管理</h3>
                            <form id="query-role-form" class="bs-example bs-example-form col-md-5" role="form" style="margin: 10px 0 10px 0;" action="${basePath}/role/queryRoleListByPageNo" method="get">
                                <input id="pageNo" name="pageNo" type="hidden" value="1"/>
                                <div class="input-group">
                                    <input id="roleName" name="roleName" type="text" class="form-control" placeholder="请输入角色名称" value="${roleName}">
                                    <span id="serach-role" class="input-group-addon btn">搜索</span>
                                </div>
                            </form>
                            <!-- 按钮触发模态框 -->
                            <button class="btn btn-default col-md-2" data-toggle="modal" data-target="#role-add" style="margin-top: 10px" onclick="Role.doInitMenuTreeList();">
                                添加角色
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>
                            <!-- 添加用户信息弹出框 -->
                            <jsp:include page="/WEB-INF/jsp/role/role-add.jsp"/>
                        </div>
                    </div>
                    <table class="table table-bordered table-condensed">
                        <thead>
                            <tr>
                                <th>角色名称</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${result.rows}" var="role">
                                <tr>
                                    <td>${role.name}</td>
                                    <td>${role.createName}</td>
                                    <td>
                                        <fmt:formatDate value="${role.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    </td>
                                    <td>
                                        <!-- 按钮触发模态框 -->
                                        <button class="btn btn-default btn-xs btn-info" data-toggle="modal" data-target="#role-edit" onClick="Role.doInitEditRoleForm('${role.id}')">修改</button>
                                        <!-- 修改用户信息弹出框 -->
                                        <jsp:include page="/WEB-INF/jsp/role/role-edit.jsp"/>
                                        <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="Role.doDeleteRole('${role.id}')">删除</button>
                                        <!--弹出框-->
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 底栏 -->
    <jsp:include page="/WEB-INF/jsp/common/bottom.jsp"/>
</body>
</html>
