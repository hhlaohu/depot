$(function () {
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }
});

function update() {
    YiYa.ajaxSubmit($("#paramForm"), function (data) {
        console.log(data);
        if (data.success) {
            YiYa.alert('提示', data.msg, 'success');
        } else {
            YiYa.alert('提示', data.msg, 'error');
        }
    })
}
