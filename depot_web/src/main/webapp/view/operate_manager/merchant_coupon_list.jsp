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
            src="${msUrl}/js/ux/operate_manager/merchant_coupon_list.js"></script>
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
                            iconCls="icon-search">搜索</a> &nbsp;&nbsp;
        </form>
    </div>
    <!--  Search panel end -->

    <!-- DataList  -->
    <form id="listForm" method="post">
        <table id="data-list"></table>
    </form>


    <%--新增优惠卷弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增优惠卷"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 400px; height: 250px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <div class="ui-edit">
                <div class="fitem">
                    <label>优惠券名称:</label> <input type="text" name="coupon_name"
                                                 style="width: 230px;" class="easyui-validatebox"
                                                 data-options="required:true"/>
                </div>
                <div class="fitem">
                    <label>商家:</label> <select class="easyui-combobox"
                                               id="merchant_id" name="merchant_id" style="width: 230px;"
                                               data-options="required:true">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${merchant_list_combobox}" var="item">
                        <option value="${item.key}">${item.value}</option>
                    </c:forEach>
                </select>
                </div>
                <div class="fitem">
                    <label>优惠券模板:</label> <select class="easyui-combobox"
                                                  id="coupon_template_id" name="coupon_template_id"
                                                  style="width: 230px;" data-options="required:true">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${coupon_template_combobox}" var="item">
                        <option value="${item.key}">${item.value}</option>
                    </c:forEach>
                </select>
                </div>
                <div class="fitem">
                    <label>发放数量:</label>
                    <input type="text" name="coupon_total" style="width: 230px;" class="easyui-numberbox"
                           data-options="min:0,required:true"/>
                </div>
                <div class="fitem">
                    <label>有效期:</label> <input id="validtime_begin"
                                               class="easyui-datebox" type="text" name="validtime_begin"
                                               data-options="required:true"
                                               style="width: 107px;"/> <label style="width: 10px;">~</label> <input
                        id="validtime_end" class="easyui-datebox" type="text" data-options="required:true"
                        name="validtime_end" style="width: 107px;"/>
                </div>

            </div>
            <div id="editPwdbtn" class="dialog-button">
                <a href="javascript:void(0)" class="easyui-linkbutton"
                   id="btn-submit">确定</a>
            </div>
        </form>
    </div>
    <%--新增优惠卷弹窗 end--%>

    <%--查看优惠卷弹窗 start--%>
    <div id="check_win" class="easyui-dialog" title="查看优惠卷"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 450px; height: 200px;">
        <form id="checkForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <table class="show_table">
                <tr>
                    <td width="100px">优惠券名称:</td>
                    <td><label id="coupon_name" name="coupon_name" style="width: 280px;"></label></td>
                </tr>
                <tr>
                    <td>商家:</td>
                    <td><label id="merchant_name" name="merchant_name" style="width: 280px;"></label></td>
                </tr>
                <tr>
                    <td>优惠券模板:</td>
                    <td><label id="template_name" name="template_name" style="width: 280px;"></label></td>
                </tr>
                <tr>
                    <td>发放数量:</td>
                    <td><label name="coupon_total" id="coupon_total" style="width: 280px;"></label></td>
                </tr>
                <tr>
                    <td>有效期:</td>
                    <td><label id="validtime" name="validtime_begin" style="width: 280px;"></label></td>
                </tr>
            </table>
        </form>
    </div>
    <%--新增优惠卷弹窗 end--%>

</div>
</body>
</html>
