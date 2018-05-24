<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/view/resource.jsp"%>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript"
	src="${msUrl}/js/commons/jquery.blockUI.js"></script>
<script type="text/javascript"
	src="${msUrl}/js/ux/operate_manager/merchant_list.js"></script>
</head>
<body>
	<input id="check_status" type="hidden" value="${check_status}">
	<div class="warp easyui-panel" data-options="border:false">
		<!-- Search panel start -->
		<div id="searchPanel" class="easyui-panel ui-search-panel" title=""
			data-options="striped: true,collapsible:true,iconCls:'icon-search'">
			<form id="searchForm">
				<p class="ui-fields">
					<label class="ui-label">商家名称:</label> <input name="merchant_name"
						class="easyui-box ui-text" style="width: 120px;">
				</p>

				&nbsp;&nbsp; <a href="#" id="btn-search" class="easyui-linkbutton"
					iconCls="icon-search">搜索</a> &nbsp;&nbsp;
			</form>
		</div>
		<!--  Search panel end -->

		<!-- DataList  -->
		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>


		<%--新增优惠卷商家弹窗 start--%>
		<div id="edit-win" class="easyui-dialog" title="新增优惠卷商家"
			buttons="#addFormBtn"
			data-options="closed:true,iconCls:'icon-save',modal:true"
			style="width: 400px; height: 250px;">
			<form id="editForm" class="ui-form" method="post">
				<!-- 隐藏文本框 -->
				<input class="hidden" name="merchant_id">
				<div class="ui-edit">
					<div class="fitem">
						<label>商家名称:</label> <input type="text" name="merchant_name"
							style="width: 230px;" class="easyui-validatebox" data-options="required:true" />
					</div>
					<div class="fitem">
						<label>所属区域:</label> <select class="easyui-combobox"
							id="depot_area_id" name="depot_area_id" style="width: 230px;"
							data-options="required:true">
							<option value="" selected="selected">请选择</option>
                <c:forEach items="${depot_area_list_combobox}" var="item">
                    <option value="${item.key}">${item.value}</option>
                </c:forEach>
						</select>
					</div>
					<div class="fitem">
						<label>商家地址:</label> <input type="text" name="merchant_address"
							style="width: 230px;" class="easyui-validatebox" data-options="required:true" />
					</div>
					<div class="fitem">
						<label>联系人:</label> <input type="text" name="merchant_contact"
							style="width: 230px;" />
					</div>
					<div class="fitem">
						<label>联系电话:</label> <input type="text" name="merchant_tel"
							style="width: 230px;" />
					</div>
					<div class="fitem">
						<label>描述:</label> <input type="text" name="remark"
							style="width: 230px;" />
					</div>

				</div>
				<div id="editPwdbtn" class="dialog-button">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="btn-submit">确定</a>
				</div>
			</form>
		</div>
		<%--新增长租车辆弹窗 end--%>

	</div>
</body>
</html>
