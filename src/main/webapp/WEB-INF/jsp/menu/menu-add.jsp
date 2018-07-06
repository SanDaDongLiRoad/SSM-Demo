<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!-- 模态框（Modal） -->
<div class="modal fade" id="menu-add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <%--模态框（Modal）标题--%>
                <h4 class="modal-title" id="myModalLabel">菜单信息</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form id="add-menu-form" class="form-horizontal" role="form" method="post">
                            <div class="form-group">
                                <label for="menuName" class="col-sm-2 control-label">菜单名称</label>
                                <div class="col-sm-10">
                                    <input type="text" id="menuName" name="menuName" class="form-control" placeholder="请输入菜单名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="icon" class="col-sm-2 control-label">图标样式</label>
                                <div class="col-sm-10">
                                    <input type="text" id="icon" name="icon" class="form-control" placeholder="请输入菜单图标"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label>
                                <div class="col-sm-10">
                                    <input type="text" id="url" name="url" class="form-control" placeholder="请输入菜单地址"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="parentId" class="col-sm-2 control-label">父级菜单</label>
                                <div class="col-sm-10">
                                    <input type="text" id="parentId" name="parentId" class="form-control" placeholder="请输入父级菜单"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orderNo" class="col-sm-2 control-label">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序</label>
                                <div class="col-sm-10">
                                    <input type="text" id="orderNo" name="orderNo" class="form-control" placeholder="请输入菜单排序"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id = "save-menu-btn" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
