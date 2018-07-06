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
    }
};

$(function() {
    Menu.init();
});