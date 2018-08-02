Top = {

    // 定义模块初始化方法
    init: function() {
        Top.bindEvent();
        Top.doInitTopMenuList('c6a31def16e642c59481a5b5a91cfb8d');
    },

    // 定义事件绑定
    bindEvent : function() {

    },

    //初始化顶部菜单列表（公共）
    doInitTopMenuList : function(userId){
        $.ajax({
            url : getLocalhostPath()+"/menu/queryTopMenuListByUserId?userId="+userId,
            type : "GET",
            dataType : "json",
            success : function (data) {
                var result = JSON.parse(data.data);
                var navElement = $('#top-menu-list');
                var menuElement = "";
                for(var i=0;i<result.length;i++){
                    var menu = result[i];
                    menuElement+="<li><a href=\""+menu.url+"\">"+menu.name+"</a></li>";
                }
                navElement.append(menuElement);
            }
        });
    },
};

$(function() {
    Top.init();
});