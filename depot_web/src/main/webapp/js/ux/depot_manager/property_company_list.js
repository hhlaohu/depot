$package('YiYa.Property_company');
YiYa.Property_company = function () {

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
                idField: "property_id",
                url: 'dataList.do',
                pageSize: 20,
                pageList: [20, 30, 50, 100],
                queryParams: {},
                columns: [[
                    {field: 'property_id', title: 'ID', width: 60, sortable: false, align: 'center', checkbox: true},
                    {field: 'property_name', title: '物业公司名称', width: 80, sortable: true, hidden: true},
                    {field: 'membership_group', title: '所属集团', width: 100, sortable: false, align: 'center'},
                    {field: 'institution_code', title: '组织机构代码', width: 120, sortable: false, align: 'center'},
                    {field: 'corporation', title: '法人姓名', width: 100, sortable: false, align: 'center'},
                    {field: 'founding_time', title: '成立时间', width: 160, sortable: false, align: 'center'},
                    {field: 'tel', title: '联系电话', width: 130, sortable: false, align: 'center'},
                    {
                        field: 'area', title: '所在城市', width: 200, sortable: false, align: 'left',
                        formatter: function (value, row, index) {
                            return row.province_name
                                + " " + row.city_name
                                + " " + row.area_name;
                        }
                    },
                    {field: 'address', title: '通讯地址', width: 180, sortable: false, align: 'left'},
                    {
                        field: 'state', title: '状态', width: 100, sortable: false, align: 'center',
                        formatter: function (value) {
                            return value === 1 ? "可用" : "禁用";
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
                        var selected = _box.utils.getCheckedRows();
                        _box.handler.edit();
                        $('#province').combobox('select', selected[0].province_id);
                        $('#city').combobox('select', selected[0].city_id);
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
        }
        ,
        init: function () {
            _this.initForm();
            _box = new YDataGrid(_this.config);
            _box.init();
        }
    };
    return _this;
}();

$(function () {
    //初始化表格
    YiYa.Property_company.init();
    resizeIframe();
    $(window).resize(resizeIframe);
    function resizeIframe() {
        var minHeight = $(window).height() - $("#searchPanel").outerHeight() - 60;
        minHeight = minHeight > 200 ? minHeight : 200;
        $("#data-list").datagrid('resize', {height: minHeight});
    }


});

$(function () {
    $("#combobox_state").combobox({
        editable: false
    });
});