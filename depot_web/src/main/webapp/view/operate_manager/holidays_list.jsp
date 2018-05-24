<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript"
            src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript"
            src="${msUrl}/js/ux/operate_manager/holidays_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
    </div>

    <!-- DataList  -->
    <form id="listForm" method="post">
        <table id="data-list"></table>
    </form>


    <%--新增节假日弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增节假日" buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true" style="width: 400px; height: 250px;">
        <form id="editForm" class="ui-form" method="post"> <!-- 隐藏文本框 --> <input class="hidden" name="holidays_id">
            <div class="ui-edit">
                <div class="fitem"><label>节假日名称:</label>
                    <input type="text" name="holidays_name" id="holidays_name"
                           style="width: 230px;" class="easyui-validatebox"
                           data-options="required:true"/></div>
                <div class="fitem"><label>开始时间:</label>
                    <input id="begin_time" name="begin_time" type="text" class="easyui-datebox" style="width: 248px;"
                           required="required"/>
                </div>
                <div class="fitem"><label>结束时间:</label>
                    <input id="end_time" name="end_time" type="text" class="easyui-datebox" style="width: 248px;"
                           required="required"/>
                </div>
                <div class="fitem"><label>类型:</label>
                    <input type="radio" name="holidays_type" value="0">工作日</input>
                    <input type="radio" name="holidays_type" value="1">非工作日</input>
                </div>
            </div>
            <div id="editPwdbtn" class="dialog-button"><a href="javascript:void(0)" class="easyui-linkbutton"
                                                          id="btn-submit">确定</a></div>
        </form>
    </div>
    <%--新增长租车辆弹窗 end--%>

</div>
</body>
</html>
