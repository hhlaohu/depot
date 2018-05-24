$package('YiYa.Access');
YiYa.Access = function () {
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
            //保存
            _this.editWin().find("#btn-submit").click(function () {
                _this.save();
            });
        }
        ,
        config: {
            dataGrid: {
                title: '',
                height: 280,
                striped: true,
                idField: "access_id",
                url: 'dataList.do',
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'access_id', title: '序号', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'access_name', title: '道口名称', width: 180, sortable: false, align: 'left'},
                    {
                        field: 'access_type', title: '出/入', width: 100, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value == 0 ? "入口" : "出口";
                        }
                    },
                    {
                        field: 'access_property', title: '道口属性', width: 100, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value == 0 ? "停车场" : "区域";
                        }
                    },
                    {
                        field: 'access_level', title: '主次级别', width: 120, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value == 0 ? "主道口" : "次道口";
                        }
                    },
                    {field: 'depot_area_name', title: '区域名称', width: 200, sortable: false, align: 'center'},
                    {field: 'depot_name', title: '所属停车场', width: 200, sortable: false, align: 'center'},
                    {
                        field: 'operation', title: '操作', width: 200, sortable: false, align: 'center',
                        formatter: function (value, row, index) {
                            return " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_getEquipment' onclick='getEquipment(" + row.access_id + ")'>查看设备</a>";
                        }
                    },
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
    YiYa.Access.init();
});

$(function () {
    var url = '/depot_background/operate/rate_setting/getDepotAreaList.do';
    $('#depot_area').combobox({
        url: url,
        valueField: 'depot_area_id',
        textField: 'depot_area_name',
        editable: false
    });
});

//获取道口设备信息
function getEquipment(access_id) {
    $("#equipment_access_id").val(access_id);
    //加载车位表数据
    $('#data_list_equipment').datagrid({
        height: 280,
        striped: true,
        idField: "carport_id",
        pagination: false,
        singleSelect: true,//仅支持单选
        url: '/depot_background/depot/equipment/dataList.do',
        queryParams: {
            'access_id': access_id
        },
        columns: [[
            {field: 'equipment_id', title: 'ID', align: 'center', width: 50},
            {field: 'equipment_name', title: '设备名称', align: 'center', width: 100},
            {
                field: 'equipment_type', title: '设备类型', align: 'center', width: 100,
                formatter: function (value) {
                    //设备类型：0，显示屏，1，摄像机,2:闸道
                    switch (value) {
                        case 0:
                            return "显示屏";
                            break;
                        case 1:
                            return "摄像机";
                            break;
                        case 2:
                            return "闸道";
                            break;
                        default:
                            return "-";
                            break;
                    }
                }
            },
            {field: 'equipment_number', title: '设备编号', align: 'center', width: 100},
            {field: 'depot_area_id', title: '类型', align: 'center', width: 100, hidden: true},
            {
                field: 'equipment_ip',
                title: 'IP：端口',
                align: 'left',
                width: 150
            },
            {
                field: 'depot_name',
                title: '硬件地址',
                align: 'left',
                width: 150,
            },
            {
                field: 'state',
                title: '操作',
                align: 'center',
                width: 120,
                formatter: function (value, row, index) {
                    var html = "<a href='javascript:void(0)' class='easyui-linkbutton' id='btn_start_packing' onclick='equipment_update(" + row.equipment_id + ")'>修改</a>"
                        + " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_delete_packing' onclick='equipment_delete(" + row.equipment_id + ")'>删除</a>";
                    return html;
                }
            }
        ]],
        toolbar: [
            {
                id: 'btnadd', text: '新增', btnType: 'add', handler: function () {
                $("#editForm_equipment")[0].reset();
                $("#equipment_access_id").val(access_id);
                $("#edit_win_equipment").window('open');
            }
            }

        ]

    });
}
function equipment_save() {
    $.ajax({
        type: "POST",
        url: "/depot_background/depot/equipment/save.do",
        data: $('#editForm_equipment').serialize(),
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            $("#edit_win_equipment").window('close');
            equipment_reload();
        }
    });
}

//重新加载设备信息
function equipment_reload() {
    var param = {
        access_id: $("#equipment_access_id").val()
    };
    $("#data_list_equipment").datagrid('reload', param);

}


function equipment_update(equipment_id) {
    var data = {equipment_id: equipment_id};
    YiYa.getById("/depot_background/depot/equipment/getId.do", data, function (result) {
        $("#editForm_equipment").form('load', result.data);
        $("#edit_win_equipment").dialog('open');
    });
}

function equipment_delete(equipment_id) {
    $.messager.confirm('确认', '确定要删除该记录?', function (r) {
        if (r) {
            var data = {equipment_id: equipment_id};
            YiYa.deleteForm(
                "/depot_background/depot/equipment/delete.do",
                data,
                function () {
                    $("#edit_win_equipment").window('close');
                    equipment_reload();
                })
        }
    });

}