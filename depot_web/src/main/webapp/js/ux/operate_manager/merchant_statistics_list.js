$package('YiYa.MerchantStatistics');
YiYa.MerchantStatistics = function() {

	var _box = null;
	var _this = {
		updateAction : '/depot_background/operate/merchant_coupon/save.do',
		listForm : $("#listForm"),
		editForm : function() {
			return $("#editForm");
		},
		checkForm : function() {
			return $("#checkForm");
		},
		editWin : function() {
			return $("#edit-win");
		},
		checkWin : function() {
			return $("#check_win");
		},

		save : function() {
			if (_this.editForm().form('validate')) {
				_this.editForm().attr('action', _this.updateAction);
				YiYa.saveForm(_this.editForm(), function(data) {
					// 关闭弹窗
					_this.editWin().dialog('close');
					// 刷新表格
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
			// 关闭弹窗
			_this.editWin().find("#btn-close").click(function() {
				_this.editWin().dialog('close');
			});
			// 保存
			_this.editWin().find("#btn-submit").click(function() {
				_this.save();
			});
		},
		config : {
			dataGrid : {
				title : '',
				striped : true,
				idField : "merchant_coupon_id",
				url : 'dataList.do',
				fitColumns: true,
				singleSelect: true,
				rownumbers: true,
				showFooter: true,
				pageSize : 20,
				pageList : [ 20, 30, 50, 100 ],
				queryParams : {},
				columns : [ [
						{
							field : 'merchant_coupon_id',
							title : '序号',
                            width: 40,
							align : 'center',
						},
						{
							field : 'merchant_name',
							title : '商家名称',
							width : 120,
							sortable : false,
							align : 'center',
						},
						{
							field : 'template_name',
							title : '优惠卷模板',
							width : 120,
							sortable : false,
                            align: 'center'
						},
						{
							field : 'template_type',
							title : '优惠卷类型',
							width : 120,
							sortable : false,
							align: 'center',
							formatter : function(value, row, index) {
								if (value == 0) {
									return "小时卷";
								} else if(value == 1){
									return "现金券";
								} else if(value == 2){
									return "折扣券";
								} else if(value == 3){
									return "全免券";
								}
							}
						},
						{
							field : 'coupon_total',
							title : '总数量',
                            width: 80,
							align : 'center'
						},
						{
							field : 'coupon_used',
							title : '使用数量',
                            width: 80,
							align : 'center',
						},
						
						{
							field : 'deductible',
							title : '折扣合计',
                            width: 100,
							align : 'center',
						}, ] ],
				toolbar : [''],
				onLoadSuccess : function(data) {
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
		init : function() {
			_this.initForm();
			_box = new YDataGrid(_this.config);
			_box.init();
		}
	};
	return _this;
}();

$(function() {
	YiYa.MerchantStatistics.init();
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

