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
            src="${msUrl}/js/ux/operate_manager/rate_setting_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label>所属停车场:</label> <select class="easyui-combobox" id="depot_id"
                                              name="depot_id" style="width: 120px;"></select>
            </p>
            <p class="ui-fields">
                <label>区域名称:</label> <select class="easyui-combobox"
                                             id="depot_area_id" name="depot_area_id" style="width: 120px;"></select>
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

    <%--长租费率设置 start--%>
    <div id="long_win" class="easyui-dialog" title="长租费率设置"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 800px; height: 450px;">
        <form id="LongRateForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="long_rate_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>所属停车场:</label>
                    <input type="text" id="depot_name" class="easyui-validatebox" required="true" disabled="disabled"
                           name="depot_name"/>
                    <label>区域名称:</label>
                    <input type="text" class="easyui-validatebox" required="true" id="depot_area_name"
                           disabled="disabled" name="depot_area_name"/>
                </div>
                <input class="hidden" type="text" name="depot_area_id"
                       id="depot_area_id">
                <div class="fitem">
                    <label>车位类型:</label>
                    <select class="easyui-combobox" id="vehicle_type_id" name="vehicle_type_id"
                            data-options="required:true,width:150"></select>
                    <label>长租类型:</label>
                    <select id="long_rate_type" class="easyui-combobox" name="long_rate_type"
                            data-options="required:true,width:150">
                        <option value="0">半月卡</option>
                        <option value="1">月卡</option>
                        <option value="2">季卡</option>
                        <option value="3">半年卡</option>
                        <option value="4">年卡</option>
                    </select>
                </div>
                <div class="fitem">
                    <label>费率名称:</label> <input type="text" class="easyui-validatebox" required="true"
                                                name="long_rate_name"/>
                    <label>价格:</label> <input type="text" class="easyui-validatebox" required="true"
                                              name="long_rate_price"/> <a
                        style="margin-left: 50px" href="javascript:void(0)"
                        class="easyui-linkbutton" id="btn_add_long" onclick="add_long()">增加费率</a>
                </div>

            </div>
        </form>
        <%--长租费率列表 start--%>
        <form id="listForm_long" method="post">
            <table id="data_list_long"></table>
        </form>
        <%--长租费率列表 end--%>
    </div>
    <%--长租费率设置 end--%>

    <%--临时费率设置 start--%>
    <div id="short_win" class="easyui-dialog" title="临租费率设置"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 900px; height: 550px;">
        <form id="ShortRateForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="short_rate_id" id="short_rate_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>所属停车场:</label>
                    <input type="text" class="easyui-validatebox" id="depot_name" disabled="disabled"
                           name="depot_name"/>
                    <label>区域名称:</label>
                    <input type="text" class="easyui-validatebox" id="depot_area_name" disabled="disabled"
                           name="depot_area_name"/>
                </div>
                <input class="hidden" type="text" name="depot_area_id" id="depot_area_id">
                <div class="fitem">
                    <label>车位类型:</label>
                    <select class="easyui-combobox" id="vehicle_type_id" name="vehicle_type_id" required="true"
                            style="width: 150px;"></select>
                    <label>日期类型:</label>
                    <select class="easyui-combobox" name="date_type" data-options="required:true,width:150">
                        <option value="0">工作日</option>
                        <option value="1">非工作日</option>
                    </select>
                    <a style="margin-left: 50px" href="javascript:void(0)" class="easyui-linkbutton" id="btn_add_short"
                       onclick="add_short()">增加费率</a>
                </div>
                <div class="fitem">
                    <label>费率名称:</label>
                    <input type="text" class="easyui-validatebox" required="true" name="short_rate_name"/>
                    <label>免费时长:</label>
                    <input type="text" class="easyui-validatebox" required="true" name="free_time"/>
                    <a style="margin-left: 50px" href="javascript:void(0)" class="easyui-linkbutton"
                       id="btn_add_time" onclick="add_time()">增加时段</a>
                </div>
                <div class="fitem">
                    <label>当天最高金额:</label>
                    <input type="text" class="easyui-validatebox" required="true" name="high_charge_day"/>
                    <label>元（0为不限额）</label>
                    <input type="checkbox" name="is_free_in_out" value="1"/>
                    <label style="width: 200px;text-align: left;">达到最高金额后可以自由出入</label>
                </div>
                <div class="fitem">
                </div>
                <div id="short_time_div" class="ui-edit">
                    <hr style='margin-bottom:10px;margin-top:10px;border-width: 1px;'/>
                    <div class="fitem">
                        <table>
                            <tr>
                                <td>
                                    <label>时间段:</label>
                                </td>
                                <td>
                                    <input type="text" id="time_begin1" name="time_begin1" style="width: 25px;"/>
                                    <label style="width: 5px;">:</label>
                                    <input type="text" id="time_begin2" name="time_begin2" style="width: 25px;"/>
                                    <label style="width: 12px; margin-left: 5px; margin-right: 5px">到</label>
                                    <input type="text" id="time_end1" name="time_end1" style="width: 25px;"/>
                                    <label style="width: 5px;">:</label>
                                    <input type="text" id="time_end2" name="time_end2" style="width: 25px;"/>
                                </td>
                                <td width="120">
                                    <label style="width: 120px;">最高金额:</label>
                                </td>
                                <td>
                                    <input type="text" name="high_charge" style="width: 50px;"/>
                                    <label style="width: 120px;">元(如果为0则不限额)</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>首付金额/时长:</label>
                                </td>
                                <td>
                                    <input type="text" name="first_pay_charge" style="width: 50px;"/>
                                    <label style="width: 15px;">元/</label>
                                    <input type="text" name="first_pay_time" style="width: 50px;"/>
                                    <label style="width: 30px;">分钟</label>
                                </td>
                                <td>
                                    <label style="width: 112px;">基础费率金额/时长:</label>
                                </td>
                                <td>
                                    <input type="text" name="basic_pay_charge" style="width: 50px;"/>
                                    <label style="width: 15px;">元/</label>
                                    <input type="text" name="basic_pay_time" style="width: 50px;"/>
                                    <label style="width: 30px;">分钟</label>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </form>
        <%--临租费率列表 start--%>
        <form id="listForm_short" method="post" style="margin-left: 15px;">
            <table id="data_list_short"></table>
        </form>
        <%--临租费率列表 end--%>
    </div>
    <%--临租费率设置 end--%>

    <%--临租费率时间段 start--%>
    <div id="short_detail_win" class="easyui-dialog" title="临租费率时间段列表"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true,width:950,height:320">
        <%--临租费率时间段列表 start--%>
        <form id="listForm_short_detail" method="post">
            <table id="data_list_short_detail"></table>
        </form>
        <%--临租费率时间段列表 end--%>
    </div>
    <%--临租费率时间段end--%>
</div>

</body>
</html>
