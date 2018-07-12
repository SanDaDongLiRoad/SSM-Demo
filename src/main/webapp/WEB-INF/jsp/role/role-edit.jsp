<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!-- 模态框（Modal） -->
<div id="role-edit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
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
                        <form id="edit-role-form" class="form-horizontal" role="form" method="post">
                            <input type="hidden" id = "id" name="id" value="${role.id}"/>
                            <div class="form-group">
                                <label for="roleName" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" id="roleName" name="roleName" class="form-control" placeholder="请输入角色名称" value="${role.name}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="remark" class="col-sm-2 control-label">备&nbsp;&nbsp;&nbsp;&nbsp;注</label>
                                <div class="col-sm-10">
                                    <input type="text" id="remark" name="remark" class="form-control" placeholder="备注" value="${role.remark}"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id = "edit-role-btn" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
