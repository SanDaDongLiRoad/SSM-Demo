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
                    menuElement+="<li><a href=\""+menu.url+"\">"+menu.name+"<span class=\""+menu.icon+"\"/></a></li>";
                }
                navElement.append(menuElement);
            }
        });
    }
};

$(function() {
    Menu.doQuery();
});