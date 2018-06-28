User = {

    // 定义模块初始化方法
    init: function() {
        User.bindEvent();
    },

    // 定义事件绑定
    bindEvent : function() {

        // 查询按钮事件
        $("#queryBtn").on("click", User.doQuery);

        $("#serach-user").on("click", User.doQueryByCondition);

        //添加用户
        $("#btn-save-user").on("click",User.doSaveUser);
    },

    //根据条件查询客户
    doQueryByCondition : function () {
        // 表单提交
        $('#query-user-form').submit();
    },

    //保存用户
    doSaveUser : function(){
        var params = {
            'name': $("#add-user-form #userName").val(),
            'password' : $("#password").val()
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
                    console.log(isConfirm);
                    $.ajax({
                        url : getLocalhostPath()+"/user/deleteById?id="+id,
                        type : "GET",
                        dataType : "json",
                        success : function (data) {
                            if(data.flag=='true'){
                                console.log(data.flag);
                                swal({
                                    title: "删除成功",
                                    type :"success",
                                    timer: 4000,
                                    showConfirmButton: false
                                });
                                $('#user-add').modal('hide');
                                console.log('end');
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
    }
};

$(function() {
    User.init();
});
