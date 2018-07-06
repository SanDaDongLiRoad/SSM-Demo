<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head-style.inc" %>
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <h3 class="col-md-5">菜单管理</h3>
                            <form id="query-menu-form" class="bs-example bs-example-form col-md-5" role="form" style="margin: 10px 0 10px 0;" action="${basePath}/menu/queryMenuListByPageNo" method="get">
                                <input id="pageNo" name="pageNo" type="hidden" value="1"/>
                                <div class="input-group">
                                    <input id="menuName" name="menuName" type="text" class="form-control" placeholder="请输入菜单名称" value="${menuName}">
                                    <span id="serach-menu" class="input-group-addon btn">搜索</span>
                                </div>
                            </form>
                            <!-- 按钮触发模态框 -->
                            <button class="btn btn-default col-md-2" data-toggle="modal" data-target="#menu-add" style="margin-top: 10px">
                                添加菜单
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>
                            <!-- 添加用户信息弹出框 -->
                            <%--<jsp:include page="/WEB-INF/jsp/menu/menu-add.jsp"/>--%>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>菜单名称</th>
                            <th>菜单排序</th>
                            <th>父级菜单</th>
                            <th>创建人</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${result.rows}" var="menu">
                            <tr>
                                <td>${menu.name}</td>
                                <td>${menu.orderNo}</td>
                                <td>无</td>
                                <td>${menu.createName}</td>
                                <td>
                                    <fmt:formatDate value="${menu.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <!-- 按钮触发模态框 -->
                                    <button class="btn btn-default btn-xs btn-info" data-toggle="modal" data-target="#menu-edit" onClick="Menu.doInitEditMenuForm('${menu.id}')">修改</button>
                                    <!-- 修改用户信息弹出框 -->
                                    <%--<jsp:include page="/WEB-INF/jsp/menu/menu-edit.jsp"/>--%>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="Menu.doDeleteMenu('${menu.id}')">删除</button>
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
