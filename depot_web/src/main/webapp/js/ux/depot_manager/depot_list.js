$package('YiYa.Depot');
YiYa.Depot = function () {

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
                idField: "depot_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'depot_id', title: '序号', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'depot_name', title: '停车场名称', width: 180, sortable: false, align: 'left'},
                    {
                        field: 'area', title: '所在城市', width: 200, sortable: false, align: 'center',
                        formatter: function (value, row, index) {
                            return row.province_name
                                + " " + row.city_name
                                + " " + row.area_name;
                        }
                    },
                    {field: 'depot_type_name', title: '停车场类型', width: 120, sortable: false, align: 'center'},
                    {field: 'space_amount', title: '车位数量', width: 100, sortable: false, align: 'center'},
                    {field: 'activate_code', title: '激活码', width: 100, sortable: false, align: 'center'},
                    {field: 'create_time', title: '创建时间', width: 200, sortable: false, align: 'center'},
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
                        $('#province').combobox('select', selected[0].province_id);
                        $('#city').combobox('select', selected[0].city_id);
                        $('#area').combobox('select', selected[0].area_id);
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
    YiYa.Depot.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }
});

$(function () {
    $('#depot_type').combobox({
        url: '/depot_background/depot/depottype/getAll.do',
        valueField: 'depot_type_id',
        textField: 'depot_type_name',
        editable: false
    });
});