<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/property_company_list.js"></script>
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
                <label class="ui-label">物业公司:</label>
                <input name="property_name" class="easyui-box ui-text" style="width: 120px;">
            </p>

            <p class="ui-fields">
                <label>状态:</label>
                <select class="easyui-combobox" id="id_check_status" name="check_status" style="width: 120px;">
                    <option value="">请选择</option>
                    <option value="0">禁用</option>
                    <option value="1">可用</option>
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


    <%--新增物业公司弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增物业公司"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 500px; height: 340px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="property_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>物业公司名称:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="property_name" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>所属集团:</label> <input type="text" name="membership_group" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>组织机构代码:</label> <input type="text" name="institution_code" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>法人姓名:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="corporation" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>成立时间:</label>
                    <input id="founding_time" class="easyui-datetimebox" type="text"
                           name="founding_time" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>联系电话:</label> <input type="text" class="easyui-validatebox" data-options="required:true" validType='mobile' name="tel" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>所属城市:</label>
                    <select class="easyui-validatebox" data-options="required:true" id="province" name="province" style="width: 80px;"></select>
                    <select  class="easyui-validatebox" data-options="required:true" id="city" name="city" style="width: 80px;"></select>
                    <select  class="easyui-validatebox" data-options="required:true" id="area" name="area_id" style="width: 80px;"></select>
                </div>
                <div class="fitem">
                    <label>通讯地址:</label> <input type="text" class="easyui-validatebox" data-options="required:true" name="address" style="width: 248px;"/>
                </div>
                <div class="fitem">
                    <label>状态:</label>
                    <select id="combobox_state" class="easyui-combobox" name="state"
                            />
                    <option value="0">禁用</option>
                    <option value="1">可用</option>
                    </select>
                </div>
                <div id="editPwdbtn" class="dialog-button">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增物业公司弹窗 end--%>
</div>
</body>
</html>
