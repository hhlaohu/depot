<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/depot_list.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/common/area.js"></script>
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


    <%--新增停车场弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增停车场"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 800px; height: 380px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="depot_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>停车场名称:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="depot_name" style="width: 248px;"/>
                    <label>所属城市:</label>
                    <select class="easyui-validatebox" data-options="required:true" id="province" name="province" style="width: 80px;"></select>
                    <select class="easyui-validatebox" data-options="required:true" id="city" name="city" style="width: 80px;"></select>
                    <select class="easyui-validatebox" data-options="required:true" id="area" name="area_id" style="width: 80px;"></select>
                </div>
                <div class="fitem">
                    <label>停车场类型:</label>
                    <select class="easyui-validatebox" data-options="required:true" id="depot_type" name="depot_type_id" style="width: 248px;"></select>
                    <label>通讯地址:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="address" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>停车场编号:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="depot_number" style="width: 248px;"/>
                    <label>备案号:</label>
                    <input type="text" name="registered_no" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>总车位数:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="space_amount" style="width: 248px;"/>
                    <label>长租车位数:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="space_long" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>临停车位数:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="space_short" style="width: 248px;"/>
                    <label>激活码:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="activate_code" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>创建时间:</label>
                    <input id="create_time"  class="easyui-datetimebox" data-options="required:true" type="text" name="create_time"
                           style="width: 248px;">
                    <label>运营时间:</label>
                    <input id="founding_time" class="easyui-datetimebox" data-options="required:true" type="text" name="service_time"
                           style="width: 248px;">
                </div>
                <div class="fitem">
                    <label>停车场描述:</label> <input type="text"  name="description" style="width: 603px;"/>
                </div>
                <div class="fitem">
                    <label>CSID:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" placeholder="管局注册编号" name="CSID" style="width: 248px;"/>
                    <label>TCCID:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" placeholder="接入统一编号" name="TCCID" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>JWDBZ:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" placeholder="0-百度；1-高德；2-其它" name="JWDBZ" style="width: 248px;"/>
                    <label>XKZH:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" placeholder="经营性停车场许可证号" name="XKZH" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>经度(TCCJD):</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="TCCJD" style="width: 248px;"/>
                    <label>纬度(TCCWD):</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="TCCWD" style="width: 248px;"/>
                </div>
                <div id="editPwdbtn" class="dialog-button">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增停车场弹窗 end--%>
</div>
</body>
</html>
