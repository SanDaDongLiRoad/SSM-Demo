User = {

    init: function() {
        User.bindEvent();
    },

    // 定义事件绑定
    bindEvent : function() {

        // 查询按钮事件
        $("#queryBtn").on("click", User.doQuery);
    },


    //保存
    doQuery: function(){

        // 表单提交
        $('#user-query-form').submit();
    }
};

$(function() {
    User.init();
});
