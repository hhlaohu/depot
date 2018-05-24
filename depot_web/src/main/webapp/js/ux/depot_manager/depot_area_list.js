$package('YiYa.Depot_area');
YiYa.Depot_area = function () {

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

            //生成车位列表
            $("#packing-win").find("#btn-generate_packing").click(function () {
                console.log("生成车位列表");
                //区域ID
                var depot_area_id = $("#depot_area_id").val();
                $.ajax({
                    type: "POST",
                    url: "generate_packing.do",
                    data: $('#packingForm').serialize(),
                    async: false,
                    error: function () {
                        alert('Connection error');
                    },
                    success: function (data) {
                        console.log("生成成功");
                        //重新加载车位信息
                        var param = $("#packingForm").serializeObject();
                        $("#data-list-packing").datagrid('reload', param);
                    }
                });
            });
        },

        //区域车位管理
        packingForm: function (depot_area_id, depot_area_name, depot_name) {
            $("#packing-win").window("open");
            $("#packing-win").find("#depot_area_id").val(depot_area_id);
            //加载车位表数据
            $('#data-list-packing').datagrid({
                width: 600,
                height: 280,
                striped: true,
                idField: "carport_id",
                pagination: false,
                singleSelect: true,//仅支持单选
                url: '/depot_background/depot/carport/dataList.do',
                queryParams: {
                    'depot_area_id': depot_area_id
                },
                columns: [[
                    {field: 'carport_id', title: 'ID', align: 'center', width: 50},
                    {field: 'carport_name', title: '车位编号', align: 'center', width: 100},
                    {field: 'depot_area_id', title: '区域ID', align: 'center', width: 100, hidden: true},
                    {
                        field: 'depot_area_name',
                        title: '区域名称',
                        align: 'center',
                        width: 150,
                        formatter: function () {
                            return depot_area_name;
                        }
                    },
                    {
                        field: 'depot_name',
                        title: '所属停车场',
                        align: 'center',
                        width: 150,
                        formatter: function () {
                            return depot_name;
                        }
                    },
                    {
                        field: 'state',
                        title: '状态',
                        align: 'center',
                        width: 120,
                        formatter: function (value, row, index) {
                            var html = "";
                            if (value == 0) {
                                html += "<a href='javascript:void(0)' class='easyui-linkbutton' id='btn_start_packing' onclick='startPacking(" + row.carport_id + ")'>启用</a>";
                            } else {
                                html += "<a href='javascript:void(0)' class='easyui-linkbutton' id='btn_stop_packing' onclick='stopPacking(" + row.carport_id + ")'>禁用</a>";
                            }
                            html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_delete_packing' onclick='deletePacking(" + row.carport_id + ")'>删除</a>";
                            return html;
                        }
                    },
                ]],

            });

        },

        config: {
            dataGrid: {
                title: '',
                striped: true,
                idField: "depot_area_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'depot_area_id', title: '序号', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'depot_area_name', title: '区域名称', width: 100, sortable: false, align: 'center'},
                    {field: 'depot_name', title: '所属停车场', width: 120, sortable: false, align: 'center'},
                    {field: 'space_amount', title: '车位数', width: 100, sortable: false, align: 'center'},
                    {
                        field: 'space_short', title: '是否临停', width: 100, sortable: false, align: 'center',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "否";
                            } else {
                                return "是"
                            }
                        }
                    },
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
                        $('#depot_id').combobox('select', selected[0].depot_id);
                    }
                    },
                    {
                        id: 'btnpacking', text: '车位', btnType: 'edit', handler: function () {
                        $("#packingForm")[0].reset();
                        var selected = _box.utils.getCheckedRows();
                        if (_box.utils.checkSelectOne(selected)) {
                            _this.packingForm(selected[0].depot_area_id, selected[0].depot_area_name, selected[0].depot_name);
                            $("#packing-win").window('open');
                        }
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
    YiYa.Depot_area.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }

    var url = '/depot_background/operate/rate_setting/getDepotList.do';
    $('#depot_id').combobox({
        url: url,
        valueField: 'depot_id',
        textField: 'depot_name',
        editable: false
    });
});


//禁用
function stopPacking(carport_id) {
    console.log("禁用车位");
    $.ajax({
        type: "POST",
        url: "/depot_background/depot/carport/stopPacking.do",
        data: {carport_id: carport_id},
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            console.log("禁用成功");
            //重新加载车位信息
            var param = $("#packingForm").serializeObject();
            $("#data-list-packing").datagrid('reload', param);
        }
    });
}
//启用
function startPacking(carport_id) {
    console.log("启用车位" + carport_id);
    $.ajax({
        type: "POST",
        url: "/depot_background/depot/carport/startPacking.do",
        data: {carport_id: carport_id},
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            console.log("启用成功");
            //重新加载车位信息
            var param = $("#packingForm").serializeObject();
            $("#data-list-packing").datagrid('reload', param);
        }
    });
}
//删除
function deletePacking(carport_id) {
    console.log("删除车位");
    $.ajax({
        type: "POST",
        url: "/depot_background/depot/carport/deletePacking.do",
        data: {carport_id: carport_id},
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            console.log("删除成功");
            //重新加载车位信息
            var param = $("#packingForm").serializeObject();
            $("#data-list-packing").datagrid('reload', param);
        }
    });
}