<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--shiro标签--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!-- 顶栏 -->
<div class="container" id="top">
    <div class="row">
        <div class="col-md-12">
            <div class="navbar navbar-default" role="navigation" style="border: 1px solid #35b558;">
                <div class="container-fluid">
                    <!--加入导航条标题-->
                    <div class="navbar-header">
                        <a href="##" class="navbar-brand"><b>管理系统</b></a>
                    </div>
                    <div style="margin-left: 170px;">
                        <ul id="top-menu-list" class="nav navbar-nav"></ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" style="margin: 8px;">
                                    <%--登录用户名--%>
                                    <span class="glyphicon glyphicon-user"><%--<shiro:principal/>--%>Admin</span>
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                    <li role="presentation">
                                        <a role="menuitem" tabindex="-1" href="#">
                                            <span class="glyphicon glyphicon-cog pull-right"></span>
                                            修改个人信息
                                        </a>
                                    </li>
                                    <!-分割线--->
                                    <li role="presentation" class="divider"></li>
                                    <li role="presentation">
                                        <a role="menuitem" tabindex="-1" href="/logout">
                                            <span class="glyphicon glyphicon-off pull-right"></span>
                                            注销
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>