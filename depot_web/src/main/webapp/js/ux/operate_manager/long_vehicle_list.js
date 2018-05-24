$package('YiYa.LongPay');
YiYa.LongPay = function () {

    var _box = null;
    var _this = {
        updateAction: '/depot_background/operate/long_vehicle/save.do',
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
                idField: "long_vehicle_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {
                        field: 'long_vehicle_id',
                        title: '序号',
                        width: 60,
                        sortable: false,
                        align: 'center',
                        checkbox: true
                    },
                    {field: 'license_plate', title: '车牌号码', width: 120, sortable: false, align: 'left'},
                    {field: 'owner_name', title: '用户姓名', width: 120, sortable: false, align: 'center'},
                    {field: 'owner_tel', title: '联系电话', width: 120, sortable: false, align: 'center'},
                    {field: 'depot_area_name', title: '所属区域', width: 150, sortable: false, align: 'center'},
                    {field: 'carport', title: '车位', width: 100, sortable: false, align: 'center'},
                    {field: 'vehicle_type_name', title: '车位类型', width: 100, sortable: false, align: 'center'},
                    {field: 'cut_off_time', title: '缴费截止', width: 200, sortable: false, align: 'center'}
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
                    {id: 'btndelete', text: '删除', btnType: 'remove'},
                    {
                        id: 'btnpay', text: '缴费', btnType: 'add', handler: function () {
                        var selected = _box.utils.getCheckedRows();
                        if (_box.utils.checkSelectOne(selected)) {
                            $("#addPayForm").form('load', selected[0]);
                            //加载该车型对应的费率
                            // $('#addPayForm_long_rate_id').combobox('clear');
                            $('#addPayForm_long_rate_id').combobox({
                                url: '/depot_background/operate/long_rate/combobox.do?vehicle_type_id=' + selected[0].vehicle_type_id,
                                valueField: 'key',
                                textField: 'value',
                                editable: false,
                                onSelect: function (rec) {
                                    var data = {
                                        long_rate_id: rec.key,
                                        long_vehicle_id: $("#addPay_long_vehicle_id").val()
                                    };
                                    YiYa.getById("/depot_background/operate/long_rate/getId.do", data, function (result) {
                                        console.log(result);
                                        $("#addPay-win").find("input[name='pay_fees']").val(result.data.long_rate_price);
                                        $("#addPay-win").find("input[name='cut_off_time']").val(result.data.cut_off_time);
                                    })
                                }
                            });
                            $("#addPay-win").dialog('open');
                        }

                    }
                    }
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

function btn_long_pay_record_submit() {
    YiYa.saveForm($("#addPayForm"), function () {
        $("#addPay-win").dialog('close');
        $("#data-list").datagrid('reload', $("#searchForm").serializeObject());
    })
}