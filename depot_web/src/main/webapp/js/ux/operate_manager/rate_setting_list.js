$package('YiYa.Rate_setting');
YiYa.Rate_setting = function () {

    var _box = null;
    var _this = {
        updateAction: 'save.do',
        listForm: $("#listForm"),
        LongRateForm: function () {
            return $("#LongRateForm");
        },
        editWin: function () {
            return $("#long_win");
        },
        shortWin: function () {
            return $("#short_win");
        },
        shortDetailWin: function () {
            return $("#short_detail_win");
        },

        save: function () {
            if (_this.LongRateForm().form('validate')) {
                _this.LongRateForm().attr('action', _this.updateAction);
                YiYa.saveForm(_this.LongRateForm(), function (data) {
                    // 关闭弹窗
                    _this.editWin().dialog('close');
                    // 刷新表格
                    _box = new YDataGrid(_this.config);
                    _box.init();
                });
            }
        },
        initForm: function () {
            // 关闭弹窗
            _this.editWin().find("#btn-close").click(function () {
                _this.editWin().dialog('close');
            });
            // 保存
            _this.editWin().find("#btn-submit").click(function () {
                _this.save();
            });

        },

        // 长租费率管理
        LongRateForm: function (depot_area_id) {
            // $("#packing-win").window("open");
            // $("#checkLogComment2_usrinf_id").attr("value", usrinf_id);
            // 设置区域ID

            // 加载车位表数据
            $('#data_list_long')
                .datagrid(
                    {
                        width: 740,
                        height: 280,
                        striped: true,
                        idField: "long_rate_id",
                        pagination: false,
                        singleSelect: true,// 仅支持单选
                        url: '/depot_background/operate/rate_setting/getLongRateList.do',
                        queryParams: {
                            'depot_area_id': depot_area_id
                        },
                        columns: [[
                            {
                                field: 'long_rate_id',
                                title: 'ID',
                                align: 'center',
                                width: 50
                            },
                            {
                                field: 'long_rate_name',
                                title: '长租费率名称',
                                align: 'center',
                                width: 100
                            },
                            {
                                field: 'depot_area_id',
                                title: '区域ID',
                                align: 'center',
                                width: 100,
                                hidden: true
                            },
                            {
                                field: 'vehicle_type_name',
                                title: '车位类型',
                                align: 'center',
                                width: 150,
                            },
                            {
                                field: 'long_rate_type',
                                title: '长租类型',
                                align: 'center',
                                width: 150,
                                formatter: function (value, row,
                                                     index) {
                                    if (value == 0) {
                                        return "半月卡";
                                    } else if (value == 1) {
                                        return "月卡";
                                    } else if (value == 2) {
                                        return "季卡";
                                    } else if (value == 3) {
                                        return "半年卡";
                                    } else if (value == 4) {
                                        return "年卡"
                                    }
                                }
                            },
                            {
                                field: 'long_rate_price',
                                title: '价格(元)',
                                align: 'center',
                                width: 150,
                            },
                            {
                                field: 'state',
                                title: '操作',
                                align: 'center',
                                width: 120,
                                formatter: function (value, row,
                                                     index) {
                                    var html = "";
                                    html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_delete_long' onclick='delete_long("
                                        + row.long_rate_id
                                        + ")'>删除</a>";
                                    return html;
                                }
                            },]],

                    });

        },

        // 临时费率管理
        ShortRateForm: function (depot_area_id) {
            // 加载车位表数据
            $('#data_list_short')
                .datagrid(
                    {
                        width: 840,
                        height: 280,
                        striped: true,
                        idField: "short_rate_id",
                        pagination: false,
                        singleSelect: true,// 仅支持单选
                        url: '/depot_background/operate/rate_setting/getShortRateList.do',
                        queryParams: {
                            'depot_area_id': depot_area_id
                        },
                        columns: [[
                            {
                                field: 'short_rate_id',
                                title: 'ID',
                                align: 'center',
                                width: 30
                            },
                            {
                                field: 'short_rate_name',
                                title: '临停费率名称',
                                align: 'left',
                                width: 100
                            },
                            {
                                field: 'depot_area_id',
                                title: '区域ID',
                                align: 'center',
                                width: 100,
                                hidden: true
                            },
                            {
                                field: 'vehicle_type_name',
                                title: '车位类型',
                                align: 'center',
                                width: 80,
                            },
                            {
                                field: 'free_time',
                                title: '免费时长',
                                align: 'center',
                                width: 80,
                            },
                            {
                                field: 'high_charge_day',
                                title: '当天最高金额',
                                align: 'center',
                                width: 100,
                            },
                            {
                                field: 'is_free_in_out',
                                title: '达到最高金额免费出入',
                                align: 'center',
                                width: 150,
                                formatter: function (value, row,
                                                     index) {
                                    if (value == 1) {
                                        return "是";
                                    } else {
                                        return "否";
                                    }
                                }
                            },
                            {
                                field: 'date_type',
                                title: '日期类型',
                                align: 'center',
                                width: 80,
                                formatter: function (value, row,
                                                     index) {
                                    if (value == 0) {
                                        return "工作日";
                                    } else if (value == 1) {
                                        return "非工作日";
                                    }
                                }
                            },
                            {
                                field: 'state',
                                title: '状态',
                                align: 'center',
                                width: 60,
                                formatter: function (value, row,
                                                     index) {
                                    if (value == 0) {
                                        return "停用";
                                    } else if (value == 1) {
                                        return "启用";
                                    }
                                }
                            },
                            {
                                field: 'operation',
                                title: '操作',
                                align: 'center',
                                width: 120,
                                formatter: function (value, row,
                                                     index) {
                                    var html = "";
                                    if (row.state == 0) {
                                        html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_open_short' onclick='update_short_state("
                                            + row.short_rate_id + ",1"
                                            + ")'>启用</a>";
                                    } else {
                                        html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_stop_short' onclick='update_short_state("
                                            + row.short_rate_id + ",0"
                                            + ")'>停用</a>";
                                    }
                                    html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_check_short' onclick='check_short("
                                        + row.short_rate_id
                                        + ")'>查看</a>";
                                    return html;
                                }
                            },]],

                    });

        },


        config: {
            dataGrid: {
                title: '',
                striped: true,
                url: 'dataList.do?menuBtnId=91',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[{
                    field: 'depot_area_id',
                    title: '序号',
                    width: 60,
                    sortable: false,
                    align: 'center',
                    checkbox: true
                }, {
                    field: 'depot_area_name',
                    title: '区域名称',
                    width: 100,
                    sortable: false,
                    align: 'center'
                }, {
                    field: 'depot_name',
                    title: '所属停车场',
                    width: 120,
                    sortable: false,
                    align: 'center'
                }, {
                    field: 'space_amount',
                    title: '车位数',
                    width: 100,
                    sortable: false,
                    align: 'center'
                }, {
                    field: 'space_short',
                    title: '是否临停',
                    width: 100,
                    sortable: false,
                    align: 'center',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "否";
                        } else {
                            return "是"
                        }
                    }
                }, {
                    field: 'create_time',
                    title: '创建时间',
                    width: 200,
                    sortable: false,
                    align: 'center'
                },]],
                toolbar: [
                    {
                        id: 'btnlongedit',
                        text: '长租费率设置',
                        btnType: 'add',
                        handler: function () {
                            var selected = _box.utils.getCheckedRows();
                            $("#LongRateForm")[0].reset();
                            if (_box.utils.checkSelectOne(selected)) {
                                $('#depot_name')
                                    .val(selected[0].depot_name);
                                $('#depot_area_name').val(
                                    selected[0].depot_area_name);
                                $('#LongRateForm').find("#depot_area_id")
                                    .val(selected[0].depot_area_id);
                                _this
                                    .LongRateForm(selected[0].depot_area_id);
                                _this.editWin().window('open');
                            }
                        }
                    },
                    {
                        id: 'btnshortedit',
                        text: '短租费率设置',
                        btnType: 'edit',
                        handler: function () {
                            var selected = _box.utils.getCheckedRows();
                            $("#ShortRateForm")[0].reset();
                            if (_box.utils.checkSelectOne(selected)) {
                                $('#ShortRateForm').find('#depot_name')
                                    .val(selected[0].depot_name);
                                $('#ShortRateForm')
                                    .find('#depot_area_name')
                                    .val(selected[0].depot_area_name);
                                $('#ShortRateForm').find("#depot_area_id")
                                    .val(selected[0].depot_area_id);
                                _this
                                    .ShortRateForm(selected[0].depot_area_id);
                                _this.shortWin().window('open');
                            }
                        }
                    }],
                onLoadSuccess: function (data) {
                    if (data.total > 0 && data.rows.length == 0) {
                        var param = $("#searchForm").serializeObject();

                        // 设置页数
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
            _box = new YDataGrid(_this.config);
            _box.init();
        },

    };
    return _this;
}();

$(function () {
    YiYa.Rate_setting.init();
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

    var url = '/depot_background/operate/rate_setting/getDepotList.do';
    $('#depot_id')
        .combobox(
            {
                url: url,
                valueField: 'depot_id',
                textField: 'depot_name',
                editable: false,
                onSelect: function (rec) {
                    $('#depot_area_id').combobox('clear');
                    var url = '/depot_background/operate/rate_setting/getDepotAreaList.do?depot_id='
                        + rec.depot_id;
                    $('#depot_area_id').combobox({
                        url: url,
                        valueField: 'depot_area_id',
                        textField: 'depot_area_name',
                        editable: false
                    });
                }
            });

    var url = '/depot_background/depot/vehicle/dataList_combobox.do';
    $('#LongRateForm').find('#vehicle_type_id').combobox({
        url: url,
        valueField: 'vehicle_type_id',
        textField: 'vehicle_type_name',
        editable: false
    });
    $('#ShortRateForm').find('#vehicle_type_id').combobox({
        url: url,
        valueField: 'vehicle_type_id',
        textField: 'vehicle_type_name',
        editable: false
    });
});

// 修改临租费率状态
function update_short_state(short_rate_id, state) {
    console.log("修改临租费率状态");
    $.ajax({
        type: "POST",
        url: "/depot_background/operate/rate_setting/updateShortState.do",
        data: {
            short_rate_id: short_rate_id, state: state
        },
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            console.log("修改临租费率状态成功");
            // 重新加载车位信息
            var param = $("#ShortRateForm").serializeObject();
            $("#data_list_short").datagrid('reload', param);
        }
    });
}
// 删除长租费率
function delete_long(long_rate_id) {
    $.messager.confirm('确认', '确定要删除该记录?', function (r) {
        if (r) {
            console.log("删除长租费率");
            $.ajax({
                type: "POST",
                url: "/depot_background/operate/rate_setting/deleteLong.do",
                data: {
                    long_rate_id: long_rate_id
                },
                async: false,
                error: function () {
                    alert('Connection error');
                },
                success: function (data) {
                    console.log("删除成功");
                    // 重新加载车位信息
                    var param = $("#LongRateForm").serializeObject();
                    $("#data_list_long").datagrid('reload', param);
                }
            });
        }
    });
}
// 增加长租费率
function add_long() {
    /*return $(this).form('validate');*/
    // 区域ID
    $
        .ajax({
            type: "POST",
            url: "/depot_background/operate/rate_setting/saveLong.do",
            data: $('#LongRateForm').serialize(),
            async: false,
            error: function () {
                alert('Connection error');
            },
            success: function (data) {
                if (data.success) {
                    console.log("增加成功");
                    // 重新加载费率信息
                    var param = $("#LongRateForm").serializeObject();
                    $("#data_list_long").datagrid('reload', param);
                } else {
                    $.messager
                        .confirm(
                            '提示框',
                            '一个区域里，同一个车位类型的同一长租类型只能有一条,你确定要覆盖吗?',
                            function (data) {
                                if (data) {
                                    $
                                        .ajax({
                                            type: "POST",
                                            url: "/depot_background/operate/rate_setting/updateLong.do",
                                            data: $(
                                                '#LongRateForm')
                                                .serialize(),
                                            async: false,
                                            error: function () {
                                                alert('Connection error');
                                            },
                                            success: function (data) {
                                                console
                                                    .log("增加成功");
                                                // 重新加载费率信息
                                                var param = $(
                                                    "#LongRateForm")
                                                    .serializeObject();
                                                $(
                                                    "#data_list_long")
                                                    .datagrid(
                                                        'reload',
                                                        param);
                                            }
                                        });
                                }
                            })
                }
            }
        });
}
function add_time() {
    $('#short_time_div').append(
        "<hr style='margin-bottom:10px;margin-top:10px;border-width: 1px;'/>" +
        "<div class='fitem'>" +
        "<table><tr><td><label>时间段:</label></td><td>" +
        "<input type='text' id='time_begin1' name='time_begin1' style='width: 25px;'/> " +
        "<label style='width: 5px;'>:</label> " +
        "<input type='text' id='time_begin2' name='time_begin2' style='width: 25px;'/> " +
        "<label style='width: 12px; margin-left: 5px; margin-right: 5px'>到</label> " +
        "<input type='text' id='time_end1' name='time_end1' style='width: 25px;'/> " +
        "<label style='width: 5px;'>:</label> " +
        "<input type='text' id='time_end2' name='time_end2' style='width: 25px;'/></td><td width='120'>" +
        "<label style='width: 120px;'>最高金额:</label></td><td>" +
        "<input type='text' name='high_charge' style='width: 50px;'/> " +
        "<label style='width: 112px;'>元(如果为0则不限额)</label></td></tr><tr><td>" +
        "<label>首付金额/时长:</label></td><td><input type='text' name='first_pay_charge' style='width: 50px;'/> " +
        "<label style='width: 15px;'>元/</label> <input type='text' name='first_pay_time' style='width: 50px;'/> " +
        "<label style='width: 30px;'>分钟</label></td><td><label style='width: 120px;'>基础费率金额/时长:</label></td><td>" +
        "<input type='text' name='basic_pay_charge' style='width: 50px;'/> " +
        "<label style='width: 15px;'>元/</label> " +
        "<input type='text' name='basic_pay_time' style='width: 50px;'/> " +
        "<label style='width: 30px;'>分钟</label></td></tr></table></div>"
    );
}
// 增加临租费率
function add_short() {
    /*return $(this).form('validate');*/
    // 区域ID
    $
        .ajax({
            type: "POST",
            url: "/depot_background/operate/rate_setting/saveShort.do",
            data: $('#ShortRateForm').serialize(),
            async: false,
            error: function () {
                alert('Connection error');
            },
            success: function (data) {
                if (data.success) {
                    console.log("增加成功");
                    // 重新加载费率信息
                    var param = $("#ShortRateForm").serializeObject();
                    $("#data_list_short").datagrid('reload', param);
                } else {
                    $.messager
                        .confirm(
                            '提示框',
                            '一个区域里，同一个车位类型的同一日期类型只能有一条,你确定要覆盖吗?',
                            function (data) {
                                if (data) {
                                    $
                                        .ajax({
                                            type: "POST",
                                            url: "/depot_background/operate/rate_setting/updateShort.do",
                                            data: $(
                                                '#ShortRateForm')
                                                .serialize(),
                                            async: false,
                                            error: function () {
                                                alert('Connection error');
                                            },
                                            success: function (data) {
                                                console
                                                    .log("增加成功");
                                                // 重新加载费率信息
                                                var param = $(
                                                    "#ShortRateForm")
                                                    .serializeObject();
                                                $(
                                                    "#data_list_short")
                                                    .datagrid(
                                                        'reload',
                                                        param);
                                            }
                                        });
                                }
                            })
                }
            }
        });
}
function check_short(short_rate_id) {
    ShortRateDetialForm(short_rate_id);
    $("#short_detail_win").window('open');
}

//临时费率时间段列表
function ShortRateDetialForm(short_rate_id) {
    // 加载临时费率时间段表数据
    $('#data_list_short_detail')
        .datagrid(
            {
                width: 920,
                height: 280,
                striped: true,
                idField: "short_duration_id",
                pagination: false,
                singleSelect: true,// 仅支持单选
                url: '/depot_background/operate/rate_setting/getShortRateDurationList.do',
                queryParams: {
                    'short_rate_id': short_rate_id
                },
                columns: [[
                    {
                        field: 'short_duration_id',
                        title: 'ID',
                        align: 'center',
                        width: 50
                    },
                    {
                        field: 'time_begin',
                        title: '开始时间',
                        align: 'center',
                        width: 150
                    },
                    {
                        field: 'short_rate_id',
                        title: '短租费率',
                        align: 'center',
                        width: 100,
                        hidden: true
                    },
                    {
                        field: 'time_end',
                        title: '结束时间',
                        align: 'center',
                        width: 150
                    },
                    {
                        field: 'high_charge',
                        title: '最高金额',
                        align: 'center',
                        width: 100,
                    },
                    {
                        field: 'first_pay_charge',
                        title: '首付金额',
                        align: 'center',
                        width: 100,
                    },
                    {
                        field: 'first_pay_time',
                        title: '首付时长（分钟）',
                        align: 'center',
                        width: 100,
                    },
                    {
                        field: 'basic_pay_charge',
                        title: '基础费率金额',
                        align: 'center',
                        width: 100,
                    },
                    {
                        field: 'basic_pay_time',
                        title: '基础费率时长（分钟）',
                        align: 'center',
                        width: 150,
                    },
                ]],

            });

}
