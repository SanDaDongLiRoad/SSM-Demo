Role = {

    // 定义模块初始化方法
    init: function() {
        Role.bindEvent();
    },

    // 定义事件绑定
    bindEvent : function() {

        //条件查询角色
        $("#query-role-form #serach-role").on("click", Role.doQueryByCondition);

        //添加角色
        $("#role-add #save-role-btn").on("click",Role.doSaveRole);

        //修改角色信息
        $("#role-edit #edit-role-btn").on("click",Role.doEditRole);
    },

    //初始化编辑角色表单数据
    doInitEditRoleForm : function(id){
        Role.doInitMenuTreeList('edit',id);
        $.ajax({
            url : getLocalhostPath()+"/role/queryRoleById?id="+id,
            type : "GET",
            dataType : "json",
            success : function (data) {
                var result = JSON.parse(data.data);
                if(data.flag == 'true'){
                    $("#edit-role-form #roleName").val(result.name);
                    $("#edit-role-form #remark").val(result.remark);
                    $("#edit-role-form #id").val(result.id);
                }
            }
        });
    },

    //根据条件查询角色
    doQueryByCondition : function(pageNo){
        if(isPositiveInteger(pageNo)){
            $("#query-role-form #pageNo").val(pageNo);
        }else{
            $("#query-role-form #pageNo").val(1);
        }
        // 表单提交
        $('#query-role-form').submit();
    },

    //保存角色
    doSaveRole : function(){
        var nodes = $('#add-role-form #treeview-checkable').treeview('getChecked');
        var menuIdList=new Array();
        if(nodes!=undefined){
            for(var i=0;i<nodes.length;i++){
                menuIdList[i] = nodes[i].id;
            }
        }
        var params = {
            'menuIdList':menuIdList,
            'name': $("#add-role-form #roleName").val(),
            'remark' : $("#add-role-form #remark").val()
        };
        $.ajax({
            url : getLocalhostPath()+"/role/saveRole",
            type : "POST",
            data : JSON.stringify(params),
            contentType : "application/json",
            dataType : "json",
            success : function (data) {
                if(data.flag=='true'){
                    swal({
                        title: "保存成功",
                        type :"success",
                        timer: 2000,
                        showConfirmButton: false
                    });
                    $('#role-add').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        Role.doQueryByCondition();//页面刷新
                    },2000);
                }else{
                    swal({
                        title: "保存失败",
                        type :"error",
                        timer: 2000,
                        showConfirmButton: false
                    });
                }
            }
        });
    },

    //删除角色
    doDeleteRole : function(id) {
        swal({
                title: "确定删除吗？",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                closeOnConfirm: true,
                closeOnCancel: true
            },
            function (isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        url : getLocalhostPath()+"/role/deleteRoleById?id="+id,
                        type : "GET",
                        dataType : "json",
                        success : function(data){
                            if(data.flag=='true'){
                                swal({
                                    title: "删除成功",
                                    type :"success",
                                    timer: 2000,
                                    showConfirmButton: false
                                });
                                $('#role-add').modal('hide');
                                setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                                    Role.doQueryByCondition();//页面刷新
                                },2000);
                            }else{
                                swal({
                                    title: "删除失败",
                                    type :"error",
                                    timer: 2000,
                                    showConfirmButton: false
                                });
                            }
                        }
                    });
                }
            });
    },

    //修改角色信息
    doEditRole : function(){
        var nodes = $('#edit-role-form #treeview-checkable').treeview('getChecked');
        var menuIdList=new Array();
        if(nodes!=undefined){
            for(var i=0;i<nodes.length;i++){
                menuIdList[i] = nodes[i].id;
            }
        }
        var params = {
            'menuIdList':menuIdList,
            'id': $("#role-edit #id").val(),
            'name':$("#role-edit #roleName").val(),
            'remark':$("#role-edit #remark").val()
        };
        $.ajax({
            url : getLocalhostPath()+"/role/updateRole",
            type : "POST",
            data : JSON.stringify(params),
            contentType : "application/json",
            dataType : "json",
            success : function (data) {
                if(data.flag=='true'){
                    swal({
                        title: "修改成功",
                        type :"success",
                        timer: 2000,
                        showConfirmButton: false
                    });
                    $('#role-edit').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        Role.doQueryByCondition();//页面刷新
                    },2000);
                }else{
                    swal({
                        title: "修改失败",
                        type :"error",
                        timer: 2000,
                        showConfirmButton: false
                    });
                }
            }
        });
    },

    //初始化树菜单列表
    doInitMenuTreeList : function (type,id) {
        var params = {
            'roleId': id,
        };
        $.ajax({
            url : getLocalhostPath()+"/menu/queryMenuTreeList",
            type : "POST",
            data : JSON.stringify(params),
            contentType : "application/json",
            dataType : "json",
            success : function (data) {
                console.log(data.data);
                initTreeList(data.data,$('#'+type+'-role-form #treeview-checkable'));
            }
        });
    }
};

$(function() {
    Role.init();
});
