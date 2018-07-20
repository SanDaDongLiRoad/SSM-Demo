<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!-- 模态框（Modal） -->
<div class="modal fade" id="user-batch-add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <%--模态框（Modal）标题--%>
                <h4 class="modal-title" id="myModalLabel">批量添加用户</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form id="batch-add-user-form" name="batch-add-user-form" role="form" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="userListFile">用户Excel表格</label>
                                <input type="file" id="userListFile" name="userListFile">
                                <p class="help-block">上传指定格式的用户Excel表格.</p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id = "batch-add-user-btn" class="btn btn-primary">确认上传</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

