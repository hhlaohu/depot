<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/sentry_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label class="ui-label">所属物业公司:</label>
                <select class="easyui-combobox" name=property_id style="width: 120px;">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${property_company_list}" var="item">
                        <option value="${item.key}">${item.value}</option>
                    </c:forEach>
                </select>
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


    <%--新增岗亭弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增岗亭"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 450px; height: 200px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="sentry_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>岗亭名称:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="sentry_name"/>
                </div>
                <div class="fitem">
                    <label>方向:</label>
                    <input type="radio" name="position" value="0" checked/>北
                    <input type="radio" name="position" value="1"/>东北
                    <input type="radio" name="position" value="2"/>东
                    <input type="radio" name="position" value="3"/>东南
                    <input type="radio" name="position" value="4"/>南
                    <input type="radio" name="position" value="5"/>西南
                    <input type="radio" name="position" value="6"/>西
                    <input type="radio" name="position" value="7"/>西北
                </div>
                <div class="fitem">
                    <label>所属公司:</label>
                    <select class="easyui-combobox" name=property_id style="width: 120px;">
                        <c:forEach items="${property_company_list}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="fitem">
                    <label>无人值守:</label>
                    <input type="radio" name="unattended" value="0" checked/>是
                    <input type="radio" name="unattended" value="1"/>否
                </div>
                <div id="editPwdbtn" class="dialog-button">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增岗亭弹窗 end--%>

    <%--道口管理弹窗 start--%>
    <div id="div_add_sentry_access" class="easyui-dialog" title="道口管理"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 700px; height: 400px;">
        <!-- Search panel start -->
        <div id="searchPanel_sentry_access">
            <form id="addForm_sentry_access" action="/depot_background/depot/sentry_access/save.do">
                <input class="hidden" name="sentry_id"/>
                <p class="ui-fields">
                    <label class="ui-label">所属停车场:</label>
                    <select class="easyui-combobox" id="depot" name="depot_id" style="width: 150px;"></select>
                </p>
                <p class="ui-fields">
                    <label class="ui-label">所属区域:</label>
                    <select class="easyui-combobox" id="depot_area" name="depot_area_id" style="width: 120px;"></select>
                </p>
                <p class="ui-fields">
                    <label class="ui-label">道口:</label>
                    <select class="easyui-combobox" id="access" name="access_id" style="width: 80px;"></select>
                </p>
                <a href="#" id="btn_add_sentry_access" class="easyui-linkbutton" iconCls="icon-search"
                   onclick="add_sentry_access()">增加</a>
            </form>
        </div>
        <!--  Search panel end -->

        <!-- DataList  -->
        <form id="listForm_sentry_access" method="post">
            <table id="data-list_sentry_access"></table>
        </form>

    </div>
    <%--道口管理弹窗 end--%>
</div>
</body>
</html>
