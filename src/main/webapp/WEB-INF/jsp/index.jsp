<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head-style.inc" %>
</head>
<body>
    <!-- 顶栏 -->
    <jsp:include page="common/top.jsp"/>
    <!-- 中间主体 -->
    <div class="container" id="content">
        <div class="row">
            <!-- 菜单栏 -->
            <jsp:include page="common/left-menu.jsp"/>
            <div class="col-md-10"></div>
        </div>
    </div>
    <!-- 底栏 -->
    <jsp:include page="common/bottom.jsp"/>
</body>
</html>
