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
            src="${msUrl}/js/ux/operate_manager/merchant_statistics_list.js"></script>
    <style>
        .show_table td {
            border-color: #ccc;
            border-width: 0 1px 1px 0;
            border-style: dotted;
            height: 24px;
            line-height: 24px;
        }

        .show_table {
            border: 1px solid #ccc;
            width: 400px;
        }
    </style>
</head>

<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label>商家名称:</label> <select class="easyui-combobox"
                                             id="merchant_id" name="merchant_id" style="width: 100px;"
                                             data-options="required:true">
                <option value="" selected="selected">全部</option>
                <c:forEach items="${merchant_list_combobox}" var="item">
                    <option value="${item.key}">${item.value}</option>
                </c:forEach>
            </select>
            </p>
            <p class="ui-fields">
                <label>优惠券类型:</label> <select class="easyui-combobox"
                                              id="template_type" name="template_type" style="width: 100px;"
                                              data-options="required:true">
                <option value="" selected="selected">全部</option>
                <option value="0">小时卷</option>
                <option value="1">现金券</option>
                <option value="2">折扣券</option>
                <option value="3">全免券</option>
            </select>
            </p>
            <p class="ui-fields">
                <label>优惠券状态:</label> <select class="easyui-combobox" id="state"
                                              name="state" style="width: 100px;" data-options="required:true">
                <option value="" selected="selected">全部</option>
                <option value="0">停用</option>
                <option value="1">可用</option>
            </select>
            </p>

            &nbsp;&nbsp; <a href="#" id="btn-search" class="easyui-linkbutton"
                            iconCls="icon-search">统计</a> &nbsp;&nbsp;
        </form>
    </div>
    <!--  Search panel end -->

    <!-- DataList  -->
    <form id="listForm" method="post">
        <table id="data-list"></table>
    </form>

</div>
</body>
</html>
