$package('YiYa.LongPay');
YiYa.LongPay = function () {

    var _box = null;
    var _this = {
        updateAction: '/depot_background/depot/vehicle/save.do',
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
                    $("#data-list").datagrid('reload', $("#searchForm").serializeObject());
                });
            }
        },
        resize: function () {
            var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
            minHeight = minHeight > 200 ? minHeight : 200;
            $("#data-list").datagrid('resize', {height: minHeight});
        }
        ,
        initForm: function () {
            //关闭弹窗
            _this.editWin().find("#btn-close").click(function () {
                _this.editWin().dialog('close');
            });
            //保存
            _this.editWin().find("#btn-submit").click(function () {
                _this.save();
            });
        }
        ,
        config: {
            dataGrid: {
                title: '',
                striped: true,
                idField: "long_pay_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'long_pay_id', title: '序号', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'license_plate', title: '车牌号码', width: 180, sortable: false, align: 'left'},
                    {field: 'owner_name', title: '用户姓名', width: 200, sortable: false, align: 'center'},
                    {field: 'owner_tel', title: '联系电话', width: 120, sortable: false, align: 'center'},
                    {field: 'depot_area_name', title: '所属区域', width: 100, sortable: false, align: 'center'},
                    {field: 'carport', title: '车位', width: 100, sortable: false, align: 'center'},
                    {field: 'vehicle_type_name', title: '车位类型', width: 200, sortable: false, align: 'center'},
                    {field: 'cut_off_time', title: '缴费截止', width: 200, sortable: false, align: 'center'},
                    {field: 'operation', title: '操作', width: 200, sortable: false, align: 'center'}
                ]],
                toolbar: [
                    {
                        id: 'btnadd', text: '新增', btnType: 'add', handler: function () {
                        _this.editForm()[0].reset();
                        _this.editWin().window('open');
                    }
                    },
                    {
                        id: 'btnedit', text: '修改', btnType: 'edit', handler: function () {
                        var selected = _box.utils.getCheckedRows();
                        _box.handler.edit();
                    }
                    },
                    {id: 'btndelete', text: '删除', btnType: 'remove'}
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

$(function () {
    YiYa.LongPay.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }
});