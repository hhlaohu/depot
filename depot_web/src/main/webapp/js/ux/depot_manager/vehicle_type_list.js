$package('YiYa.Vehicle');
YiYa.Vehicle = function () {

    var _box = null;
    var _this = {
        updateAction: 'save.do',
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
                idField: "vehicle_type_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {
                        field: 'vehicle_type_id',
                        title: '序号',
                        width: 60,
                        sortable: false,
                        align: 'center',
                        checkbox: true
                    },
                    {field: 'vehicle_type_name', title: '车型名称', width: 180, sortable: false, align: 'left'},
                    {field: 'update_time', title: '更新时间', width: 160, sortable: false, align: 'center'},
                    {
                        field: 'default_type', title: '默认车型', width: 100, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value == 0 ? "非默认" : "默认";
                        }
                    }, {
                        field: 'operation',
                        title: '操作',
                        align: 'center',
                        width: 120,
                        formatter: function (value, row, index) {
                            var html = "";
                            if (row.default_type == 0) {
                                html += "<a href='javascript:void(0)' class='easyui-linkbutton' id='btn_start_packing' onclick='setDefault(" + row.vehicle_type_id + ")'>设为默认</a>";
                            }
                            return html;
                        }
                    }
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
    YiYa.Vehicle.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }
});

function setDefault(vehicle_type_id) {
    var data = {vehicle_type_id: vehicle_type_id, default_type: 1};
    YiYa.getById("/depot_background/depot/vehicle/save.do", data, function (result) {
        var param = $("#searchForm").serializeObject();

        //设置页数
        var $getPager = $("#data-list").datagrid('getPager');
        var $pagination = $($getPager).pagination("options");
        if ($pagination != undefined) {
            $pagination.pageNumber = 1;
        }
        param.pageFlag = 1;

        $("#data-list").datagrid('reload', param);
    });
}