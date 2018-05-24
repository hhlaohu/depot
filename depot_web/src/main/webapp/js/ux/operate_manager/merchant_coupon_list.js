$package('YiYa.MerchantCoupon');
YiYa.MerchantCoupon = function() {

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
				pageSize : 20,
				pageList : [ 20, 30, 50, 100 ],
				queryParams : {},
				columns : [ [
						{
							field : 'merchant_coupon_id',
							title : '序号',
                            width: 40,
							sortable : false,
							align : 'center',
						},
						{
							field : 'coupon_name',
							title : '优惠券名称',
							width : 120,
							sortable : false,
                            align: 'left'
						},
						{
							field : 'merchant_name',
							title : '商家名称',
							width : 120,
							sortable : false,
							align : 'center',
						},
						{
							field : 'coupon_total',
							title : '总数量',
                            width: 80,
							sortable : false,
							align : 'center'
						},
						{
							field : 'coupon_unused',
							title : '剩余数量',
                            width: 80,
							sortable : false,
							align : 'center',
							formatter : function(value, row, index) {
								return row.coupon_total - row.coupon_used;
							}
						},
						{
							field : 'template_name',
							title : '优惠模板',
							width : 120,
							sortable : false,
                            align: 'left'
						},
						{
							field : 'validtime',
							title : '有效期',
							width : 300,
							sortable : false,
							align : 'center'
						},
						{
							field : 'state',
							title : '状态',
                            width: 60,
							sortable : false,
							align : 'center',
							formatter : function(value, row, index) {
								if (value == 0) {
									return "停用";
								} else {
									return "使用中";
								}
							}
						},
						{
							field : 'create_time',
							title : '创建时间',
							width : 150,
							sortable : false,
							align : 'center'
						},
						{
							field : 'operate',
							title : '操作',
                            width: 100,
							align : 'center',
							formatter : function(value, row, index) {
								var html = "";
								html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_pay_short' onclick='check(\""
									+ row.coupon_name
									+ "\",\""
									+ row.merchant_name
									+ "\",\""
									+ row.template_name
									+ "\",\""
									+ row.coupon_total
									+ "\",\""
									+ row.validtime + "\")'>查看</a>";
								if (row.state == 0) {
									html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_pay_short' onclick='updateState(\""
										+ row.state
										+ "\",\""
										+ row.merchant_coupon_id + "\")'>启用</a>";
								} else {
									html += " <a href='javascript:void(0)' class='easyui-linkbutton' id='btn_pay_short' onclick='updateState(\""
										+ row.state
										+ "\",\""
										+ row.merchant_coupon_id + "\")'>停用</a>";
								}
								return html;
							}
						}, ] ],
				toolbar : [ {
					id : 'btnadd',
					text : '增加优惠卷',
					btnType : 'add',
					handler : function() {
						_this.editForm()[0].reset();
						_this.editWin().window('open');
					}
				}, ],
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
	YiYa.MerchantCoupon.init();
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

function check(coupon_name,merchant_name,template_name,coupon_total,validtime){
	$("#checkForm").find('#coupon_name').html(coupon_name);
	$("#checkForm").find('#merchant_name').html(merchant_name);
	$("#checkForm").find('#template_name').html(template_name);
	$("#checkForm").find('#coupon_total').html(coupon_total);
	$("#checkForm").find('#validtime').html(validtime);
	$("#check_win").window('open');
}
function updateState(state,merchant_coupon_id){
	 $.ajax({
	        type: "POST",
	        url: "/depot_background/operate/merchant_coupon/updateState.do",
	        data: {
	        	state: state, merchant_coupon_id: merchant_coupon_id
	        },
	        async: false,
	        error: function () {
	            alert('Connection error');
	        },
	        success: function (data) {
	        	if(data.success){
	        		// 重新加载车位信息
	        		var param = $("#listForm").serializeObject();
	        		$("#data-list").datagrid('reload', param);
	        	}else {
	        		 $.messager
                     .alert("提示","优惠卷过期或者剩余数量为0!");
	        	}
	        }
	    });
}
