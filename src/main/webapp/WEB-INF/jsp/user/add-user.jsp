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
                            <h1 style="text-align: center;">添加用户信息</h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form id="add-user-form" class="form-horizontal" role="form" action="#" method="post">
                            <div class="form-group">
                                <label for="userName" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入用户名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">密 码</label>
                                <div class="col-sm-10">
                                    <input type="text" id="password" name="password" class="form-control" placeholder="请输入密码"/>
                                </div>
                            </div>
                            <div class="form-group" style="text-align: center">
                                <button id = "btn-save-user" class="btn btn-default" type="button">提交</button>
                                <button class="btn btn-default" type="reset">重置</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 底栏 -->
    <jsp:include page="/WEB-INF/jsp/common/bottom.jsp"/>
</body>
</html>
