<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!-- 模态框（Modal） -->
<div id="user-edit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <%--模态框（Modal）标题--%>
                <h4 class="modal-title" id="myModalLabel">用户信息</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form id="edit-user-form" class="form-horizontal" role="form" method="post">
                            <input type="hidden" id = "id" name="id" value="${user.id}"/>
                            <div class="form-group">
                                <label for="userName" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入用户名" value="${user.name}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                                <div class="col-sm-10">
                                    <input type="text" id="password" name="password" class="form-control" placeholder="请输入密码" value="${user.password}"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id = "edit-user-btn" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
