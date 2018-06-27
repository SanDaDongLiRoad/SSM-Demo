Menu = {

    doQuery : function(){
        var params = {
            'parentId': ''
        };
        $.ajax({
            url : getLocalhostPath()+"/menu/queryList",
            type : "POST",
            data : JSON.stringify(params),
            contentType : "application/json",
            dataType : "json",
            success : function (data) {
                var navElement = $('#nav');
                var menuElement = "";
                for(var i=0;i<data.length;i++){
                    var menu = data[i];
                    menuElement+="<li><a href=\""+menu.url+"\">"+menu.name+"<span class=\""+menu.icon+"\"/></a></li>"
                }
                menuElement+="<li><a href=\"/admin/passwordRest\">修改密码<sapn class=\"glyphicon glyphicon-pencil pull-right\"/></a></li><li><a href=\"/logout\">退出系统<sapn class=\"glyphicon glyphicon-log-out pull-right\" /></a></li>";
                navElement.append(menuElement);
            }
        });
    }
};

$(function() {
    Menu.doQuery();
});