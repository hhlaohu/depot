$package('YiYa.Holidays');
YiYa.Holidays = function () {

    var _box = null;
    var _this = {
        updateAction: '/depot_background/operate/holidays/save.do',
        listForm: $("#listForm"),
        editForm: function () {
            return $("#editForm");
        },
        editWin: function () {
            return $("#edit-win");
        },

        save: function () {
            if (_this.editForm().form('validate')) {
                _this.editForm().attr('action', _this.updateAction);
                YiYa.saveForm(_this.editForm(), function (data) {
                    //关闭弹窗
                    _this.editWin().dialog('close');
                    //刷新表格
                    $("#data-list").datagrid('reload',
                        $("#searchForm").serializeObject());
                });
            }
        },
        resize: function () {
            var minHeight = $(window).height()
                - $("#searchPanel").outerHeight() - 60;
            minHeight = minHeight > 200 ? minHeight : 200;
            $("#data-list").datagrid('resize', {
                height: minHeight
            });
        },
        initForm: function () {
            //关闭弹窗
            _this.editWin().find("#btn-close").click(function () {
                _this.editWin().dialog('close');
            });
            //保存
            _this.editWin().find("#btn-submit").click(function () {
                _this.save();
            });
        },
        config: {
            dataGrid: {
                title: '',
                striped: true,
                idField: "holidays_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[{
                    field: 'holidays_id',
                    title: '序号',
                    width: 60,
                    sortable: false,
                    align: 'center',
                    checkbox: true
                }, {
                    field: 'holidays_name',
                    title: '名称',
                    width: 120,
                    sortable: false,
                    align: 'center'
                }, {
                    field: 'begin_time',
                    title: '开始时间',
                    width: 180,
                    sortable: false,
                    align: 'center',
                    formatter: function (value) {
                        var crtTime = new Date(value);
                        return dateFtt("yyyy-MM-dd", crtTime);//直接调用公共JS里面的时间类处理的办法
                    }
                }, {
                    field: 'end_time',
                    title: '结束时间',
                    width: 180,
                    sortable: false,
                    align: 'center',
                    formatter: function (value) {
                        var crtTime = new Date(value);
                        return dateFtt("yyyy-MM-dd", crtTime);//直接调用公共JS里面的时间类处理的办法
                    }
                }, {
                    field: 'holidays_type',
                    title: '类型',
                    width: 120,
                    sortable: false,
                    align: 'center',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "工作日";
                        } else if (value == 1) {
                            return "非工作日";
                        }
                    }
                },]],
                toolbar: [
                    {
                        id: 'btnadd',
                        text: '新增',
                        btnType: 'add',
                        handler: function () {
                            _this.editForm()[0].reset();
                            _this.editWin().window('open');
                        }
                    },
                    {
                        id: 'btnedit',
                        text: '修改',
                        btnType: 'edit',
                        handler: function () {
                            var selected = _box.utils.getCheckedRows();
                            _box.handler.edit();
                        }
                    },
                    {
                        id: 'btndelete',
                        text: '删除',
                        btnType: 'remove'
                    },
                ],
                onLoadSuccess: function (data) {
                    if (data.total > 0 && data.rows.length == 0) {
                        var param = $("#searchForm").serializeObject();

                        //设置页数
                        var $getPager = $("#data-list").datagrid('getPager');
                        var $pagination = $($getPager).pagination("options");
                        if ($pagination != undefined) {
                            $pagination.pageNumber = 1;
                        }
                        param.pageFlag = 1;

                        $("#data-list").datagrid('reload', param);
                    }
                }
            }
        },
        init: function () {
            _this.initForm();
            _box = new YDataGrid(_this.config);
            _box.init();
        }
    };
    return _this;
}();

/**************************************时间格式化处理************************************/
function dateFtt(fmt, date) { //author: meizz
    var o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds(),                 //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(function () {
    YiYa.Holidays.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight()
            - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {
            height: minHeight
        });
    }
});

