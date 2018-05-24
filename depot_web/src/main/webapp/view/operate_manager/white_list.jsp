<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/operate_manager/white_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label class="ui-label">白名单名称:</label>
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


    <%--新增白名单弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增白名单" buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true" style="width: 400px; height: 175px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="white_list_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>所属区域:</label>
                    <select class="easyui-combobox" data-options="required:true" id="depot_area_id" name=depot_area_id style="width: 230px;">
                        <option value="0" selected="selected">所有区域</option>
                        <c:forEach items="${depot_area_combobox}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="fitem">
                    <label>车牌号:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="license_plate" style="width: 230px;"/>
                </div>
                <div class="fitem">
                    <label>车辆说明:</label>
                    <input type="text" name="remark" style="width: 230px;"/>
                </div>
            </div>
            <div id="editPwdbtn" class="dialog-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
            </div>
        </form>
    </div>
    <%--新增白名单弹窗 end--%>
</div>
</body>
</html>
