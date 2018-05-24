$package('YiYa.CouponTemplate');
YiYa.CouponTemplate = function() {

	var _box = null;
	var _this = {
		updateAction : '/depot_background/operate/coupon_template/save.do',
		listForm : $("#listForm"),
		editForm : function() {
			return $("#editForm");
		},
		editWin : function() {
			return $("#edit-win");
		},

		save : function() {
			if (_this.editForm().form('validate')) {
				_this.editForm().attr('action', _this.updateAction);
				YiYa.saveForm(_this.editForm(), function(data) {
					//关闭弹窗
					_this.editWin().dialog('close');
					//刷新表格
					$("#data-list").datagrid('reload',
							$("#searchForm").serializeObject());
				});
			}
		},
		resize : function() {
			var minHeight = $(window).height()
					- $("#searchPanel").outerHeight() - 60;
			minHeight = minHeight > 200 ? minHeight : 200;
			$("#data-list").datagrid('resize', {
				height : minHeight
			});
		},
		initForm : function() {
			//关闭弹窗
			_this.editWin().find("#btn-close").click(function() {
				_this.editWin().dialog('close');
			});
			//保存
			_this.editWin().find("#btn-submit").click(function() {
				_this.save();
			});
		},
		config : {
			dataGrid : {
				title : '',
				striped : true,
				idField : "coupon_template_id",
				url : 'dataList.do',
				pageSize : 20,
				pageList : [ 20, 30, 50, 100 ],
				queryParams : {},
				columns : [ [ {
					field : 'coupon_template_id',
					title : '序号',
					width : 60,
					sortable : false,
					align : 'center',
					checkbox : true
				}, {
					field : 'template_name',
					title : '模板名称',
					width : 120,
					sortable : false,
					align : 'center'
				}, {
					field : 'template_type',
					title : '模板类型',
					width : 120,
					sortable : false,
					align : 'center',
					formatter : function(value, row, index) {
						if (value == 0) {
							return "小时卷";
						} else if (value == 1) {
							return "现金卷";
						} else if (value == 2) {
							return "折扣卷";
						} else if (value == 3) {
							return "全免卷";
						} 
					}
				}, {
					field : 'coupon_rate',
					title : '优惠率',
					width : 120,
					sortable : false,
					align : 'center'
				}, {
					field : 'remark',
					title : '描述',
					width : 150,
					sortable : false,
					align : 'center'
				}, {
					field : 'create_time',
					title : '创建时间',
					width : 180,
					sortable : false,
					align : 'center'
				}, ] ],
				toolbar : [
						{
							id : 'btnadd',
							text : '新增',
							btnType : 'add',
							handler : function() {
								_this.editForm()[0].reset();
								_this.editWin().window('open');
							}
						},
						{
							id : 'btnedit',
							text : '修改',
							btnType : 'edit',
							handler : function() {
								var selected = _box.utils.getCheckedRows();
								_box.handler.edit();
							}
						},
						{
							id : 'btndelete',
							text : '删除',
							btnType : 'remove'
						},
						],
				onLoadSuccess : function(data) {
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
		init : function() {
			_this.initForm();
			_box = new YDataGrid(_this.config);
			_box.init();
		}
	};
	return _this;
}();

$(function() {
	YiYa.CouponTemplate.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe() {
		var minHeight = $(window).height() - $("#searchPanel").outerHeight()
				- 60;
		minHeight = minHeight > 200 ? minHeight : 200;
		$("#data-list").datagrid('resize', {
			height : minHeight
		});
	}
});

