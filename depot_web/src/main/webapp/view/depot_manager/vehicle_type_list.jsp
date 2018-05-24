<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>
    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/vehicle_type_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label class="ui-label">停车场名称:</label>
                <input name="depot_name" class="easyui-box ui-text" style="width: 120px;">
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


    <div id="edit-win" class="easyui-dialog" title="新增停车场"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 350px; height: 150px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="vehicle_type_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>车型名称:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="vehicle_type_name"/>
                </div>
                <div class="fitem">
                    <label>是否默认:</label>
                    <input type="radio" name="default_type" value="1"/>是
                    <input type="radio" name="default_type" value="0" checked/>否
                </div>
                <div id="editPwdbtn" class="dialog-button">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增停车场弹窗 end--%>
</div>

</body>
</html>
