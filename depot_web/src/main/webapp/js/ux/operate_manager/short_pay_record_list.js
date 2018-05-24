$package('YiYa.Short_pay_record');
YiYa.Short_pay_record = function () {

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
            _this.editForm().attr('action', _this.updateAction);
            YiYa.saveForm(_this.editForm(), function (data) {
                console.log(data);
                //关闭弹窗
                _this.editWin().dialog('close');
                //刷新表格
                _box = new YDataGrid(_this.config);
                _box.init();
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
                idField: "onhand_vehicle_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {
                        field: 'onhand_vehicle_id',
                        title: '序号',
                        width: 60,
                        sortable: false,
                        align: 'center'
                    },
                    {
                        field: 'license_plate',
                        title: '车牌号码',
                        width: 120,
                        sortable: false,
                        align: 'left'
                    },
                    {
                        field: 'vehicle_type_name',
                        title: '车型',
                        width: 120,
                        sortable: false,
                        align: 'center'
                    },
                    {
                        field: 'access_name',
                        title: '入道口',
                        width: 100,
                        sortable: false,
                        align: 'center'
                    },
                    {
                        field: 'entry_time',
                        title: '入场时间',
                        width: 150,
                        sortable: false,
                        align: 'center'
                    },
                    {
                        field: 'is_payment',
                        title: '缴费状态',
                        width: 80,
                        sortable: false,
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "未缴";
                            } else if (value == 1) {
                                return "已缴";
                            }
                        }
                    },
                    {
                        field: 'operate',
                        title: '操作',
                        width: 120,
                        align: 'center',
                        formatter: function (value, row, index) {
                            var html = "";
                            if (row.is_payment == 0) {
                                html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_pay_short' onclick='pay_short(\""
                                    + row.onhand_vehicle_id
                                    + "\",\""
                                    + row.vehicle_type_name
                                    + "\",\""
                                    + row.entry_time
                                    + "\",\""
                                    + row.access_name + "\")'>缴费</a>";
                            }
                            return html;
                        }
                    },]],
                toolbar: [''],
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
    YiYa.Short_pay_record.init();
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

    var url = '/depot_background/operate/short_pay_record/getAllMerchantList.do';
    $('#MerchantDiv').find('#merchant_name').combobox({
        url: url,
        valueField: 'merchant_id',
        textField: 'merchant_name',
        editable: false,
        onSelect: function (rec) {
            $('#merchantCouponList').datagrid("reload", {merchant_id: rec.merchant_id})
        }
    });
});

function pay_short(onhand_vehicle_id, vehicle_type_name, entry_time,
                   access_name) {
    var exit_time = CurentTime;
    var stay_time = getDtime(entry_time);
    $('#vehicle_type_name').html(vehicle_type_name);
    $('#access_name').html(access_name);
    $('#entry_time').html(entry_time);
    $('#exit_time').html(exit_time);
    $('#stay_time').html(stay_time);
    //加载费用明细
    DetailListForm(onhand_vehicle_id);
    $("input[name='onhand_vehicle_id']").val(onhand_vehicle_id);
    //加载优惠券列表
    getMerchantCouponList();
    $("#edit-win").window("open");
}
function getDtime(entry_time) {
    var rDate = {};
    var tempStrs = entry_time.split(" ");  //截取时间
    var dateStrs = tempStrs[0].split("-");  // 解析日期部分
    var timeStrs = tempStrs[1].split(":");  // 解析时间部分
    // 获得目标时间对象
    var entryDate = new Date(parseInt(dateStrs[0], 10),
        (parseInt(dateStrs[1], 10) - 1),
        parseInt(dateStrs[2], 10),
        parseInt(timeStrs [0], 10),
        parseInt(timeStrs[1], 10),
        parseInt(timeStrs[2], 10));
    var NowDate = new Date();   // 获取当前时间
    var Dtime = NowDate - entryDate;  // 计算时间差
    // 填充时间差对象
    rDate.days = Math.floor(Dtime / (24 * 3600 * 1000));
    var leave1 = Dtime % (24 * 3600 * 1000);
    rDate.hours = Math.floor(leave1 / (3600 * 1000));
    var leave2 = leave1 % (3600 * 1000);
    rDate.minutes = Math.floor(leave2 / (60 * 1000));
    var leave3 = leave2 % (60 * 1000);
    rDate.seconds = Math.round(leave3 / 1000);
    return rDate.days + "天" + rDate.hours + "小时" + rDate.minutes + "分";
}

function CurentTime() {
    var now = new Date();

    var year = now.getFullYear(); //年
    var month = now.getMonth() + 1; //月
    var day = now.getDate(); //日

    var hh = now.getHours(); //时
    var mm = now.getMinutes(); //分
    var ss = now.getSeconds(); //秒

    var clock = year + "-";

    if (month < 10)
        clock += "0";

    clock += month + "-";

    if (day < 10)
        clock += "0";

    clock += day + " ";

    if (hh < 10)
        clock += "0";

    clock += hh + ":";
    if (mm < 10)
        clock += '0';
    clock += mm + ":";

    if (ss < 10)
        clock += '0';
    clock += ss;
    return (clock);
}

// 费用明细
function DetailListForm(onhand_vehicle_id) {
    $.ajax({
        type: "POST",
        url: "/depot_background/operate/short_pay_record/getShortFeesRecordList.do",
        data: {
            'onhand_vehicle_id': onhand_vehicle_id
        },
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            var stopFees = data.footer[0].stop_fees;
            var amount = stopFees + "元";
            $("#real_charges").html(amount);
            $("#need_pay").html(amount);
            $("input[name='need_pay']").val(stopFees);
        }
    });
    // 加载费用明细数据
    $('#detail_list').datagrid({
        width: 456,
        height: 180,
        striped: true,
        idField: "short_fees_id",
        pagination: false,
        singleSelect: true,// 仅支持单选
        url: "/depot_background/operate/short_pay_record/getShortFeesRecordList.do",
        showFooter: true,
        queryParams: {
            'onhand_vehicle_id': onhand_vehicle_id
        },
        columns: [[{
            field: 'license_plate',
            title: '车牌号',
            align: 'center',
            width: 82
        }, {
            field: 'depot_area_name',
            title: '区域',
            align: 'center',
            width: 145
        }, {
            field: 'stop_time',
            title: '停留时间',
            align: 'center',
            width: 80,
        }, {
            field: 'first_pay_rate',
            title: '费率',
            align: 'center',
            width: 60,
        }, {
            field: 'stop_fees',
            title: '费用',
            align: 'center',
            width: 80,
        },]],

    });

}
// 费用明细
function getMerchantCouponList(merchant_id) {
    // 加载费用明细数据
    $('#merchantCouponList').datagrid({
        width: 456,
        height: 180,
        striped: true,
        idField: "merchant_coupon_id",
        pagination: false,
        singleSelect: true,// 仅支持单选
        url: '/depot_background/operate/merchant_coupon/selectByAvailable.do',
        queryParams: {
            'merchant_id': merchant_id
        },
        columns: [[{
            field: 'merchant_name',
            title: '商家',
            align: 'left',
            width: 120
        }, {
            field: 'template_name',
            title: '优惠券',
            align: 'left',
            width: 145
        }, {
            field: 'operate',
            title: '操作',
            align: 'center',
            width: 80,
            formatter: function (value, row, index) {
                return " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_pay_short' onclick='use_coupon(" + row.merchant_coupon_id + ")'>使用</a>";
            }
        },]],

    });

}


function use_coupon(merchant_coupon_id) {
    $("input[name='merchant_coupon_id']").val(merchant_coupon_id);
    //AJAX获取使用优惠券后的价格
    $.ajax({
        type: "POST",
        url: "/depot_background/operate/short_pay_record/getNeedPayWithMerchantId.do",
        data: {
            'merchant_coupon_id': merchant_coupon_id,
            'onhand_vehicle_id': $("input[name='onhand_vehicle_id']").val()
        },
        async: false,
        error: function () {
            alert('Connection error');
        },
        success: function (data) {
            console.log(data);
            $("#need_pay").html("<font color='#FF0000'>" + data.need_pay + "元</font>");
            $("input[name='need_pay']").val(data.need_pay);
            $("#discount").html(data.template_name);
        }
    });


}
function cancel_all() {
    console.log("取消所有优惠券");
    $("input[name='merchant_coupon_id']").val("");
    $("#discount").html("");
    $("#need_pay").html("<font color='#FF0000'>" + $("#real_charges").html() + "</font>");

}

