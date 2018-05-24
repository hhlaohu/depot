<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>
    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/depot_manager/access_list.js"></script>
</head>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="warp easyui-panel" data-options="border:false">
    <!-- Search panel start -->
    <div id="searchPanel" class="easyui-panel ui-search-panel" title=""
         data-options="striped: true,collapsible:true,iconCls:'icon-search'">
        <form id="searchForm">
            <p class="ui-fields">
                <label>所属区域:</label>
                <select class="easyui-combobox" id="depot_area_id" name=depot_area_id style="width: 120px;">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${depot_area_list}" var="item">
                        <option value="${item.depot_area_id}">${item.depot_area_name}</option>
                    </c:forEach>
                </select>
            </p>
            <p class="ui-fields">
                <label class="ui-label">道口名称:</label>
                <input name="access_name"
                       class="easyui-box ui-text" style="width: 120px;">
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
    <form id="listForm_equipment" method="post">
        <table id="data_list_equipment"></table>
    </form>


    <%--新增道口弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="新增道口"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 350px; height: 398px;">
        <form id="editForm" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" name="access_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>所属区域:</label>
                    <select class="easyui-validatebox" data-options="required:true" id="depot_area" name="depot_area_id"
                            style="width: 150px;"></select>
                </div>
                <div class="fitem">
                    <label>道口名称:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="access_name"
                           style="width: 150px;"/>
                </div>
                <div class="fitem">
                    <label>主次级别:</label>
                    <input type="radio" name="access_level" id="access_level_1" value="0" checked/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">主道口</label>
                    <input type="radio" name="access_level" id="access_level_2" value="1"/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">次道口</label>
                </div>
                <div class="fitem">
                    <label>道口类型:</label>
                    <input type="radio" name="access_type" id="access_type_1" value="0" checked/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">入口</label>
                    <input type="radio" name="access_type" id="access_type_2" value="1"/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">出口</label>
                </div>
                <div class="fitem">
                    <label>道口属性:</label>
                    <input type="radio" name="access_property" id="access_property_1" value="0" checked/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">停车场</label>
                    <input type="radio" name="access_property" id="access_property_2" value="1"/>
                    <label style="text-align: left;width: 65px;line-height: 27px;">区域</label>
                </div>
                <div class="fitem">
                    <label>管局ID:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="rta_id"
                           style="width: 150px;" placeholder="管局分配的id"/>
                </div>
                <div class="fitem">
                    <label>管局编号:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="JCKBH"
                           style="width: 150px;" placeholder="管局编号从 1 开始顺延"/>
                </div>
                <div class="fitem">
                    <label>经纬度体系:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="JCKJWDBZ"
                           style="width: 150px;" placeholder="0-百度；1-高德；2-其它"/>
                </div>
                <div class="fitem">
                    <label>道口经度:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="JCKJD"
                           style="width: 150px;"/>
                </div>
                <div class="fitem">
                    <label>道口纬度:</label>
                    <input type="text" class="easyui-validatebox" data-options="required:true" name="JCKWD"
                           style="width: 150px;"/>
                </div>

                <div id="editbtn" class="dialog-button"
                     style="align-content: center;text-align: center;background-color: #fff;">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增道口弹窗 end--%>

    <%--新增设备弹窗 start--%>
    <div id="edit_win_equipment" class="easyui-dialog" title="新增道口"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 350px; height: 395px;">
        <form id="editForm_equipment" class="ui-form" method="post">
            <!-- 隐藏文本框 -->
            <input class="hidden" id="equipment_access_id" name="access_id">
            <input class="hidden" id="equipment_id" name="equipment_id">
            <div class="ui-edit">
                <div class="fitem">
                    <label>设备类型:</label>
                    <select class="easyui-combobox" id="equipment_type" name="equipment_type" style="width: 130px;">
                        <option value="0" selected>显示屏</option>
                        <option value="1">摄像机</option>
                        <option value="2">闸道</option>
                    </select>
                </div>
                <div class="fitem">
                    <label>设备名称:</label>
                    <input type="text" name="equipment_name"/>
                </div>
                <div class="fitem">
                    <label>设备编号:</label>
                    <input type="text" name="equipment_number"/>
                </div>
                <div class="fitem">
                    <label>设备IP:</label>
                    <input type="text" name="equipment_ip"/>
                </div>
                <div class="fitem">
                    <label>设备端口:</label>
                    <input type="text" name="equipment_port"/>
                </div>
                <div class="fitem">
                    <label>网关:</label>
                    <input type="text" name="equipment_gateway"/>
                </div>
                <div class="fitem">
                    <label>用户名:</label>
                    <input type="text" name="equipment_usr"/>
                </div>
                <div class="fitem">
                    <label>密码:</label>
                    <input type="text" name="equipment_pwd"/>
                </div>
                <div class="fitem">
                    <label>通道:</label>
                    <input type="text" name="ch_id" value="0"/>
                </div>
                <div class="fitem">
                    <label>持续时间:</label>
                    <input type="text" name="duration" value="1000"/>
                </div>
                <div class="fitem">
                    <label>备注:</label>
                    <textarea name="remark" id="area_remark" cols="20" rows="3"></textarea>
                </div>
                <div class="dialog-button"
                     style="align-content: center;text-align: center;background-color: #fff;">
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_submit_equipment"
                       onclick="equipment_save()">确定</a>
                </div>
            </div>
        </form>
    </div>
    <%--新增设备弹窗 end--%>
</div>
</body>
</html>
