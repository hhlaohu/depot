<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>
    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/depot_area_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label>所属停车场:</label>
                <select class="easyui-combobox" id="id_depot" name=depot_id style="width: 120px;">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${depot_list}" var="item">
                        <option value="${item.depot_id}">${item.depot_name}</option>
                    </c:forEach>
                </select>
            </p>
            <p class="ui-fields">
                <label class="ui-label">区域名称:</label> <input name="depot_area_name"
                                                             class="easyui-box ui-text" style="width: 120px;">
            </p>
            &nbsp;&nbsp;
            <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
            &nbsp;&nbsp;
        </form>
    </div>
    <!--  Search panel end -->

    <!-- DataList  -->
    <form id="listForm" method="post">
        <table id="data-list"></table>
    </form>

    <%--新增停车场区域弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增停车场区域"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 422px; height: 240px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="depot_area_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>所属停车场:</label>
                    <select class="easyui-validatebox" data-options="required:true" id="depot_id" name="depot_id" style="width: 240px;"></select>
                </div>
                <div class="fitem">
                    <label>区域名称:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="depot_area_name" style="width: 240px;"/>
                </div>
                <div class="fitem">
                    <label>总车位数:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="space_amount" style="width: 240px;"/>
                </div>
                <div class="fitem">
                    <label>长租车位数:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="space_long" style="width: 240px;"/>
                </div>
                <div class="fitem">
                    <label>短租车位数:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="space_short" style="width: 240px;"/>
                </div>
                <div id="editPwdbtn" class="dialog-button">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增停车场区域弹窗 end--%>


    <%--新增停车场区域弹窗 start--%>
    <div id="packing-win" class="easyui-dialog" title="新增停车场区域"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 615px; height: 420px;">
        <form id="packingForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" id="depot_area_id" name="depot_area_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>生成规则:</label>
                    <input type="text" name="prefix" placeholder="起始标识"/>-
                    <input type="text" name="begin_no" placeholder="起始数字"/>-
                    <input type="text" name="end_no" placeholder="结束数字"/>
                </div>
                <div class="fitem">
                    <label>排除含:</label> <input type="text" name="exclude_no" placeholder="数字以|分隔"/>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-generate_packing">生成</a>
                </div>
            </div>
        </form>
        <!-- DataList  -->
        <form id="listForm_packing" method="post">
            <table id="data-list-packing"></table>
        </form>

    </div>
    <%--新增停车场区域弹窗 end--%>
</div>
</body>
</html>
