<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head-style.inc" %>
    <script type="text/javascript" src="${basePath}/static/js/user/user.js"></script>
    <script>
        //根据条件查询客户
        function doQueryByCondition(pageNo){
            if(isPositiveInteger(pageNo)){
                $("#query-user-form #pageNo").val(pageNo);
            }else{
                $("#query-user-form #pageNo").val(1);
            }
            // 表单提交
            $('#query-user-form').submit();
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
                            <div class="col-md-4">
                                <h3>用户管理</h3>
                            </div>
                            <div class="col-md-4">
                                <form id="query-user-form" class="bs-example bs-example-form" role="form" style="margin: 10px 0 10px 0;" action="${basePath}/user/queryUserListByPageNo" method="get">
                                    <input id="pageNo" name="pageNo" type="hidden" value="1"/>
                                    <div class="input-group">
                                        <input id="userName" name="userName" type="text" class="form-control" placeholder="请输入姓名" value="${userName}">
                                        <span id="serach-user" class="input-group-addon btn">搜索</span>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-2">
                                <!-- 按钮触发模态框 -->
                                <button id="user-add-modal-btn" class="btn btn-default" data-toggle="modal" data-target="#user-add" style="margin-top: 10px">
                                    添加用户信息
                                    <sapn class="glyphicon glyphicon-plus"/>
                                </button>
                            </div>
                            <!-- 添加用户信息弹出框 -->
                            <jsp:include page="/WEB-INF/jsp/user/user-add.jsp"/>
                            <!-- 按钮触发模态框 -->
                            <div class="col-md-2">
                                <button id="user-batch-add-modal-btn" class="btn btn-default" data-toggle="modal" data-target="#user-batch-add" style="margin-top: 10px">
                                    批量添加用户
                                    <sapn class="glyphicon glyphicon-plus"/>
                                </button>
                            </div>
                            <!-- 批量新增用户弹出框 -->
                            <jsp:include page="/WEB-INF/jsp/user/user-batch-add.jsp"/>
                        </div>
                    </div>
                    <table class="table table-bordered table-condensed">
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
                                    <td>${user.createName}</td>
                                    <td>
                                        <fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    </td>
                                    <td>
                                        <!-- 按钮触发模态框 -->
                                        <button class="btn btn-default btn-xs btn-info" data-toggle="modal" data-target="#user-edit" onClick="User.doInitEditUserForm('${user.id}')">修改</button>
                                        <!-- 修改用户信息弹出框 -->
                                        <jsp:include page="/WEB-INF/jsp/user/user-edit.jsp"/>
                                        <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="User.doDeleteUser('${user.id}')">删除</button>
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
