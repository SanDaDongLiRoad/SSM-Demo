<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Title</title>
    <link href="${basePath}/static/css/default-style.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${basePath}/static/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${basePath}/static/plugins/jquery-serialize-json/jquery.serializejson.js" ></script>
</head>
<body>
    <div id="user" name="user">
        <div id="user-query" name="user-query" class="content">
            <form action="${basePath}/user/queryUserList" id="user-query-form" name="user-query-form" class="form-inline" method="post" style="margin:10px;" target="userList">
                <div class="form-group">
                    <label for="name" class="control-label">用户名<font color="red">*</font></label>
                    <input type="text" id="name" class="form-control input-sm" name="name" maxlength="16"/>
                </div>

                <div class="form-group" style="margin-left: 20px;">
                    <input id="queryBtn" type="button" class="btn btn-info input-sm" value="查 询"/>
                    <input type="reset" class="btn btn-info input-sm" value="重 置"/>
                </div>
            </form>
        </div>
    </div>
    <div id="user-list" name="user-list" class="content">
        <table  id="user-list-table" class="table table-striped">
            <thead>
                <tr>
                    <th>用户名</th>
                    <th>创建人名称</th>
                    <th>创建时间</th>
                    <th>修改人名称</th>
                    <th>修改时间</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.createrName}</td>
                        <td>${user.createDate}</td>
                        <td>${user.modifyName}</td>
                        <td>${user.modifyDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="${basePath}/static/js/user/user.js"></script>
</body>
</html>
