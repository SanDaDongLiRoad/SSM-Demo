Top = {

    // 定义模块初始化方法
    init: function() {
        Top.bindEvent();
    },

    // 定义事件绑定
    bindEvent : function() {

    },

    //初始化顶部菜单列表（公共）
    doInitTopMenuList : function(){
        var params = {
            'userId': ''
        };
        $.ajax({
            url : getLocalhostPath()+"/user/queryTopMenuListByCondition",
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
};

$(function() {
    Top.init();
});