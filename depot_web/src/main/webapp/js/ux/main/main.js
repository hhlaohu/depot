$package('YiYa.main');

YiYa.main = function () {
    return {
        treeSelect: function () {
            var _this = $(this);
            var title = _this.text();
            var url = _this.attr('href');
            // 查找所有的已经选中的元素
            $("a").removeClass("menu-item-selected");
            _this.addClass("menu-item-selected");
            YiYa.main.addTab(title, url);
            $("#checkDialog").dialog('close');
            return false;
        },
        treeInit: function () {
            var $items = $('#tree-box').find(".menu-item");
            $items.bind('click', this.treeSelect);
        },
        addTab: function (_title, _url) {
            var boxId = '#tab-box';
            if ($(boxId).tabs('exists', _title)) {
                var tab = $(boxId).tabs('getTab', _title);
                var index = $(boxId).tabs('getTabIndex', tab);
                $(boxId).tabs('select', index);
                if (tab && tab.find('iframe').length > 0) {
                    var _refresh_ifram = tab.find('iframe')[0];
                    _refresh_ifram.contentWindow.location.href = _url;
                }
            } else {
                var _content = "<iframe scrolling='auto' frameborder='0' src='" + _url + "' style='width:100%; height:100%'></iframe>";
                $(boxId).tabs('add', {
                    title: _title,
                    content: _content,
                    closable: true
                });

            }
        },
        menuHover: function () {
            //菜单鼠标进入效果
//			$('.menu-item').hover(
//				function () {
//					$(this).stop().animate({ paddingLeft: "35px" }, 200,function(){
//						$(this).addClass("orange");
//					});
//				}, 
//				function () {
//					$(this).stop().animate({ paddingLeft: "25px" },function(){
//						$(this).removeClass("orange");
//					});
//				}
//			);
        },
        modifyPwd: function () {
            var pwdForm = $("#pwdForm");
            if (pwdForm.form('validate')) {
                var parentId = $('#search_parentId').val();
                $("#edit_parentId").val(parentId)
                YiYa.saveForm(pwdForm, function (data) {
                    $('#modify-pwd-win').dialog('close');
                    pwdForm.resetForm();
                });
            }
        },
        init: function () {
            this.treeInit();
            this.menuHover();

            //修改密码绑定事件
            $('.modify-pwd-btn').click(function () {
                $('#modify-pwd-win').dialog('open');
            });
            $('#btn-pwd-close').click(function () {
                $('#modify-pwd-win').dialog('close');
            });
            //修改密码确认
            $('#btn-pwd-submit').click(function () {

                var oldPwd = $('#oldPwd').val();
                var newPwd = $('#newPwd').val();
                var rpwd = $('#rpwd').val();
                if (newPwd != rpwd) {
                    YiYa.alert("提示", "新密码和重复密码不匹配", "info");
                    $('#newPwd').val("");
                    $('#rpwd').val("");
                    return;
                }

                YiYa.ajaxJson('modifyPwd.do', 'oldPwd=' + oldPwd + '&newPwd=' + newPwd, function (data) {
                    if (data.success) {
                        YiYa.alert("提示", "修改密码成功", "info");
                        $('#modify-pwd-win').dialog('close');
                    } else {
                        YiYa.alert("提示", "修改密码失败，原因：" + data.msg, "info");
                    }
                });

            });
        }
    };
}();


$(function () {
    YiYa.main.init();
    //默认隐藏左边菜单导航
//	$(".layout-button-left").live("click",function(){ 
//    }); 
//    $(".layout-button-left").click();

});		