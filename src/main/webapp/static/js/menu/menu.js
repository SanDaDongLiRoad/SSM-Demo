Menu = {

    // 定义模块初始化方法
    init: function() {
        Menu.bindEvent();
        Menu.doInitMenuList();
    },

    // 定义事件绑定
    bindEvent : function() {
        //条件查询用户
        $("#query-menu-form #serach-menu").on("click", Menu.doQueryByCondition);

        //添加菜单
        $("#menu-add #save-menu-btn").on("click",Menu.doSaveMenu);

        //修改用户信息
        $("#menu-edit #edit-menu-btn").on("click",Menu.doEditMenu);
    },

    //初始化菜单列表（公共）
    doInitMenuList : function(){
            var params = {
                'parentId': ''
            };
            $.ajax({
                url : getLocalhostPath()+"/menu/queryMenuListByCondition",
                type : "POST",
                data : JSON.stringify(params),
                contentType : "application/json",
                dataType : "json",
                success : function (data) {
                    var navElement = $('#nav');
                    var menuElement = "";
                    for(var i=0;i<data.length;i++){
                        var menu = data[i];
                        menuElement+="<li><a href=\""+menu.url+"\">"+menu.name+"<span class=\""+menu.icon+"\"/></a></li>";
                    }
                    navElement.append(menuElement);
                }
            });
        },


    //根据条件查询客户
    doQueryByCondition : function(pageNo){
        if(isPositiveInteger(pageNo)){
            $("#query-menu-form #pageNo").val(pageNo);
        }else{
            $("#query-menu-form #pageNo").val(1);
        }
        // 表单提交
        $('#query-menu-form').submit();
    },
    //保存用户
    doSaveMenu : function(){
        var params = {
            'name': $("#add-menu-form #menuName").val(),
            'icon' : $("#add-menu-form #icon").val(),
            'url' : $("#add-menu-form #url").val(),
            'parentId' : $("#add-menu-form #parentId").val(),
            'orderNo' : $("#add-menu-form #orderNo").val()
        };
        $.ajax({
            url : getLocalhostPath()+"/menu/saveMenu",
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
                    $('#menu-add').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        Menu.doQueryByCondition();//页面刷新
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

    //删除菜单
    doDeleteMenu : function(id) {
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
                        url : getLocalhostPath()+"/menu/deleteMenuById?id="+id,
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
                                $('#menu-add').modal('hide');
                                setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                                    Menu.doQueryByCondition();//页面刷新
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
    //初始化编辑客户表单数据
    doInitEditMenuForm : function(id){
        $.ajax({
            url : getLocalhostPath()+"/menu/queryMenuById?id="+id,
            type : "GET",
            dataType : "json",
            success : function (data) {
                var result = JSON.parse(data.data);
                if(data.flag == 'true'){
                    $("#edit-menu-form #id").val(result.id);
                    $("#edit-menu-form #menuName").val(result.name);
                    $("#edit-menu-form #icon").val(result.icon);
                    $("#edit-menu-form #url").val(result.url);
                    $("#edit-menu-form #parentId").val(result.parentId);
                    $("#edit-menu-form #orderNo").val(result.orderNo);
                }
            }
        });
    },

    //修改菜单信息
    doEditMenu : function(){
        var params = {
            'id': $("#edit-menu-form #id").val(),
            'name': $("#edit-menu-form #menuName").val(),
            'icon' : $("#edit-menu-form #icon").val(),
            'url' : $("#edit-menu-form #url").val(),
            'parentId' : $("#edit-menu-form #parentId").val(),
            'orderNo' : $("#edit-menu-form #orderNo").val()
        };
        $.ajax({
            url : getLocalhostPath()+"/menu/updateMenu",
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
                    $('#menu-edit').modal('hide');

                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        Menu.doQueryByCondition();//页面刷新
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
    }
};

$(function() {
    Menu.init();
});