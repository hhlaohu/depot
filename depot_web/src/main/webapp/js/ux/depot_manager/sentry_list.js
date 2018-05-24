$package('YiYa.Sentry');
YiYa.Sentry = function () {

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
                idField: "sentry_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'sentry_id', title: '序号', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'sentry_name', title: '岗亭名称', width: 180, sortable: false, align: 'left'},
                    {field: 'property_name', title: '所属物业公司', width: 180, sortable: false, align: 'left'},
                    {
                        field: 'unattended', title: '状态', width: 100, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value == 0 ? "有人" : "无人";
                        }
                    }, {
                        field: 'operation',
                        title: '操作',
                        align: 'center',
                        width: 120,
                        formatter: function (value, row, index) {
                            var html = " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_delete_packing' onclick='get_access_list(" + row.sentry_id + ")'>道口</a>";
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
    YiYa.Sentry.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }
});

//获取当前岗亭道口列表
function get_access_list(sentry_id) {
    //区域车位管理
    $("#div_add_sentry_access").window("open");
    $("input[name='sentry_id']").val(sentry_id);
    //初始化停车场combobox
    $('#depot').combobox({
        url: "/depot_background/depot/depot/combobox.do",
        valueField: 'key',
        textField: 'value',
        editable: false,
        onSelect: function (rec) {
            $('#depot_area').combobox('clear');
            var url = '/depot_background/depot/depot_area/combobox.do?depot_id=' + rec.key;
            $('#depot_area').combobox('reload', url);
        }
    });
    $('#depot_area').combobox({
        url: "/depot_background/depot/depot_area/combobox.do",
        valueField: 'key',
        textField: 'value',
        editable: false,
        onSelect: function (rec) {
            $('#access').combobox('clear');
            var url = '/depot_background/depot/access/combobox.do?depot_area_id=' + rec.key;
            $('#access').combobox('reload', url);
        }
    });


    $('#access').combobox({
        url: "/depot_background/depot/access/combobox.do",
        valueField: 'key',
        textField: 'value',
        editable: false,
    });


    //加载车位表数据
    $('#data-list_sentry_access').datagrid({
        width: 680,
        height: 330,
        striped: true,
        idField: "sentry_access_id",
        pagination: false,
        singleSelect: true,//仅支持单选
        url: '/depot_background/depot/access/dataList_sentry.do',
        queryParams: {
            'sentry_id': sentry_id
        },
        columns: [[
            {field: 'sentry_access_id', title: '序号', width: 60, sortable: false, align: 'center'},
            {field: 'access_name', title: '道口名称', width: 80, sortable: false, align: 'left'},
            {
                field: 'access_type', title: '出/入', width: 50, sortable: false, align: 'center',
                formatter: function (value) {
                    return value == 0 ? "入口" : "出口";
                }
            },
            {
                field: 'access_property', title: '道口属性', width: 80, sortable: false, align: 'center',
                formatter: function (value) {
                    return value == 0 ? "停车场" : "区域";
                }
            },
            {
                field: 'access_level', title: '主次级别', width: 80, sortable: false, align: 'center',
                formatter: function (value) {
                    return value == 0 ? "主道口" : "次道口";
                }
            },
            {field: 'depot_area_name', title: '区域名称', width: 120, sortable: false, align: 'left'},
            {field: 'depot_name', title: '所属停车场', width: 120, sortable: false, align: 'left'},
            {
                field: 'operation', title: '操作', width: 60, sortable: false, align: 'center',
                formatter: function (value, row, index) {
                    return " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_getEquipment' onclick='delete_sentry_access(" + row.sentry_access_id + ")'>删除</a>";
                }
            }
        ]]

    });
}

//删除关联
function delete_sentry_access(sentry_access_id) {
    YiYa.deleteForm("/depot_background/depot/sentry_access/delete.do", {sentry_access_id: sentry_access_id}, function () {
        var param = {
            sentry_id: $("input[name='sentry_id']").val()
        };
        $("#data-list_sentry_access").datagrid('reload', param);

    })
}

function add_sentry_access() {
    YiYa.saveForm($("#addForm_sentry_access"), function (data) {
        var param = {
            sentry_id: $("input[name='sentry_id']").val()
        };
        $("#data-list_sentry_access").datagrid('reload', param);
    });

}