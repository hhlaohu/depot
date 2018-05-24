<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/operate_manager/long_vehicle_list.js"></script>
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


    <%--新增长租车辆弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增长租车辆"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 400px; height: 250px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="long_vehicle_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>车辆牌照:</label>
                    <input type="text"  name="license_plate" style="width: 230px;"
                           class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>用户姓名:</label>
                    <input type="text" name="owner_name" style="width: 230px;" class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>联系电话:</label>
                    <input type="text" name="owner_tel" style="width: 230px;" class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>所属区域:</label>
                    <select class="easyui-combobox" id="depot_area_id" name="depot_area_id"
                            style="width: 230px;" data-options="required:true">
                        <option value="" selected="selected">请选择</option>
                        <c:forEach items="${depot_area_list_combobox}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="fitem">
                    <label>车位:</label>
                    <input type="text" name="carport" style="width: 230px;" class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>车位类型:</label>
                    <select class="easyui-combobox" id="vehicle_type_id" name="vehicle_type_id"
                            style="width: 230px;" data-options="required:true">
                        <option value="" selected="selected">请选择</option>
                        <c:forEach items="${vehicle_type_list_combobox}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div id="editPwdbtn" class="dialog-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
            </div>
        </form>
    </div>
    <%--新增长租车辆弹窗 end--%>


    <%--长租车缴费 start--%>
    <div id="addPay-win" class="easyui-dialog" title="长租车缴费"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 400px; height: 250px;">
        <form id="addPayForm" class="ui-form" method="post" action="/depot_background/operate/long_pay_record/save.do">
            <!-- 隐藏文本框 -->
            <input class="hidden" id="addPay_long_vehicle_id" name="long_vehicle_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>车辆牌照:</label>
                    <input type="text" id="license_plate" name="license_plate"
                           style="width: 230px;background-color: #CCCCCC;"
                           data-options="required:true" disabled="disabled"/>
                </div>
                <div class="fitem">
                    <label>车位类型:</label>
                    <select class="easyui-combobox" id="addPay_vehicle_type_id" name="vehicle_type_id"
                            style="width: 230px;background-color: #CCCCCC;" disabled="disabled">
                        <option value="" selected="selected">请选择</option>
                        <c:forEach items="${vehicle_type_list_combobox}" var="item">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="fitem">
                    <label>长租费率:</label>
                    <select class="easyui-combobox" id="addPayForm_long_rate_id" name="long_rate_id"
                            style="width: 230px;">
                    </select>
                </div>
                <div class="fitem">
                    <label>缴费金额:</label>
                    <input type="text" name="pay_fees" style="width: 230px;" data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>截止日期:</label>
                    <input type="text" name="cut_off_time" style="width: 230px;" data-options="required:true"/>
                </div>

            </div>
            <div class="dialog-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" id="addPay_submit"
                   onclick="btn_long_pay_record_submit()">确定</a>
            </div>
        </form>
    </div>
    <%--长租车缴费 end--%>
</div>
</body>
</html>
