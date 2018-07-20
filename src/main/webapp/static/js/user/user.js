User = {

    // 定义模块初始化方法
    init: function() {
        User.bindEvent();
    },

    // 定义事件绑定
    bindEvent : function() {

        //条件查询用户
        $("#query-user-form #serach-user").on("click", User.doQueryByCondition);

        //添加用户
        $("#user-add #save-user-btn").on("click",User.doSaveUser);

        //修改用户信息
        $("#user-edit #edit-user-btn").on("click",User.doEditUser);

        //查询角色列表
        $("#user-add-modal-btn").on("click", User.doQueryRoleList);

        //查询角色列表
        $("#batch-add-user-btn").on("click", User.doUploadUserListFile);
    },

    //初始化编辑客户表单数据
    doInitEditUserForm : function(id){
        $.ajax({
            url : getLocalhostPath()+"/user/queryUserById?id="+id,
            type : "GET",
            dataType : "json",
            success : function (data) {
                var result = JSON.parse(data.data);
                if(data.flag == 'true'){
                    $("#edit-user-form #userName").val(result.name);
                    $("#edit-user-form #password").val(result.password);
                    $("#edit-user-form #id").val(result.id);
                }
            }
        });
    },

    //根据条件查询客户
    doQueryByCondition : function(pageNo){
        if(isPositiveInteger(pageNo)){
            $("#query-user-form #pageNo").val(pageNo);
        }else{
            $("#query-user-form #pageNo").val(1);
        }
        // 表单提交
        $('#query-user-form').submit();
    },

    //保存用户
    doSaveUser : function(){
        var params = {
            'name': $("#add-user-form #userName").val(),
            'password' : $("#add-user-form #password").val(),
            'roleId':$('#add-user-form #userRole option:selected').val()//选中的值
        };
        $.ajax({
            url : getLocalhostPath()+"/user/saveUser",
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
                    $('#user-add').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        User.doQueryByCondition();//页面刷新
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

    //删除用户
    doDeleteUser : function(id) {
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
                        url : getLocalhostPath()+"/user/deleteUserById?id="+id,
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
                                $('#user-add').modal('hide');
                                setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                                    User.doQueryByCondition();//页面刷新
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

    //修改用户信息
    doEditUser : function(){
        var params = {
            'id': $("#user-edit #id").val(),
            'name':$("#user-edit #userName").val(),
            'password':$("#user-edit #password").val(),
            'roleId':$('#user-edit #userRole option:selected').val()//选中的值
        };
        $.ajax({
            url : getLocalhostPath()+"/user/updateUser",
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
                    $('#user-edit').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        User.doQueryByCondition();//页面刷新
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
    //初始化新增客户时角色列表
    doQueryRoleList : function(){
        $.ajax({
            url : getLocalhostPath()+"/role/queryRoleList",
            type : "GET",
            dataType : "json",
            success : function (data) {
                var selectElement = $('#add-user-form #userRole');
                var optionElement = "";
                for(var i=0;i<data.length;i++){
                    var role = data[i];
                    optionElement+="<option value=\'"+role.id+"\'>"+role.name+"</option>";
                }
                selectElement.append(optionElement);
            }
        });
    },

    //批量添加用户
    doUploadUserListFile : function() {
        var formData = new FormData($("#batch-add-user-form")[0]);
        $.ajax({
            url: getLocalhostPath()+"/user/uploadUserListFile",
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (returndata) {
                alert(returndata);
            },
            error: function (returndata) {
                alert(returndata);
            }
        });
    }
};

$(function() {
    User.init();
});
