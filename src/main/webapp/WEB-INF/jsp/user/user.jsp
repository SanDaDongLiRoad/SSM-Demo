<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head-style.inc" %>
    <script type="text/javascript" src="${basePath}/static/js/user/user.js"></script>
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
                            <h3 class="col-md-5">用户管理</h3>
                            <form id="query-user-form" class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="${basePath}/user/queryByName" method="post">
                                <div class="input-group">
                                    <input id="userName" name="userName" type="text" class="form-control" placeholder="请输入姓名">
                                    <span id="serach-user" class="input-group-addon btn">搜索</span>
                                </div>
                            </form>
                            <!-- 按钮触发模态框 -->
                            <button class="btn btn-default col-md-2" data-toggle="modal" data-target="#user-add" style="margin-top: 20px">
                                添加用户信息
                                <sapn class="glyphicon glyphicon-plus"/>
                            </button>
                            <!-- 添加用户信息弹出框 -->
                            <jsp:include page="/WEB-INF/jsp/user/user-add.jsp"/>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>用户编号</th>
                                <th>用户名</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${result.rows}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.createrName}</td>
                                    <td>${user.createDate}</td>
                                   <%-- <td><fmt:formatDate value="${user.createDate}" dateStyle="medium"/></td>--%>
                                    <td>
                                        <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editStudent?id=${user.id}'">修改</button>
                                        <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeStudent?id=${user.id}'">删除</button>
                                        <!--弹出框-->
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- 底栏 -->
    <jsp:include page="/WEB-INF/jsp/common/bottom.jsp"/>
</body>
</html>
