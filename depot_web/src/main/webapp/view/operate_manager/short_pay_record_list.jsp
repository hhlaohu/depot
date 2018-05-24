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
            src="${msUrl}/js/ux/operate_manager/short_pay_record_list.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/common/area.js"></script>

    <style>
        .tab_record {
            border-collapse: collapse;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        .tab_record td {
            width: 100px;
            height: 30px;
            text-align: center;
            border: 1px solid black;
        }

        .car_in_pic {
            width: 280px;
            height: 280px;
        }

        .car_in_pic_td {
            vertical-align: text-top;
        }

        .div_left {
            width: 480px;
            height: 480px;
            float: left;
        }

        .div_right {
            width: 480px;
            height: 480px;
        }

        .real {
            outline: none;
            border: 0px;
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
                <label class="ui-label">车牌号码:</label> <input name="license_plate"
                                                             class="easyui-box ui-text" style="width: 120px;">
            </p>

            &nbsp;&nbsp; <a href="#" id="btn-search" class="easyui-linkbutton"
                            iconCls="icon-search">查询</a> &nbsp;&nbsp;
        </form>
    </div>
    <table>
        <tr>
            <td>
                <!-- DataList  -->
                <form id="listForm" method="post">
                    <table id="data-list" style="width: 920px;"></table>
                </form>
            </td>
            <td class="car_in_pic_td">
                <div>
                    <!--  Search panel end -->
                    <label>入场照片:</label>
                    <div class="jqzoom">
                        <img src="../../images/miss.png" class="car_in_pic" id="bigImg"/>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <%--临停缴费弹窗 start--%>
    <div id="edit-win" class="easyui-dialog" title="临停缴费"
         buttons="#addFormBtn"
         data-options="closed:true,iconCls:'icon-save',modal:true"
         style="width: 1000px; height: 580px;">
        <form id="editForm" class="ui-form" method="post">
            <table>
                <tr>
                    <td>
                        <div class="div_left">
                            <!--   隐藏文本框 -->
                            <input class="hidden" name="onhand_vehicle_id">
                            <input type="hidden" name="need_pay">
                            <input type="hidden" name="merchant_coupon_id">
                            <label class="ui-label">车辆信息:</label>
                            <table class="tab_record">
                                <tr>
                                    <td>车型:</td>
                                    <td id="vehicle_type_name"></td>
                                    <td>入场时间:</td>
                                    <td id="entry_time" style="width: 150px;"></td>
                                </tr>
                                <tr>
                                    <td>入场口:</td>
                                    <td id="access_name"></td>
                                    <td>出场时间:</td>
                                    <td id="exit_time" style="width: 150px;"></td>
                                </tr>
                                <tr>
                                    <td>停车时长:</td>
                                    <td id="stay_time"></td>
                                </tr>
                            </table>
                            <label class="ui-label">费用信息:</label>
                            <table class="tab_record">
                                <tr>
                                    <td>应收费用:</td>
                                    <td id="real_charges" style="width: 100px;">
                                    </td>
                                    <td>优惠：</td>
                                    <td id="discount" style="width: 150px;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>移动支付：</td>
                                    <td id="mobile_payment" style="width: 100px;">0.00元</td>
                                    <td>收费状态</td>
                                    <td id="is_payment" style="width: 150px;">未缴</td>
                                </tr>
                                <tr>
                                    <td>还需支付：</td>
                                    <td id="need_pay" style="width: 100px;">
                                    </td>
                                </tr>
                            </table>
                            <label class="ui-label">费用明细:</label>
                            <form id="detailForm" method="post">
                                <table id="detail_list"></table>
                            </form>
                        </div>
                    </td>
                    <td>
                        <%--右侧优惠劵布局--%>
                        <div id="MerchantDiv" class="div_right">
                            <label class="ui-label">优惠券</label>
                            <div class="fitem" style="margin-top: 10px">
                                <a href="javascript:void(0)" class="easyui-linkbutton"
                                   id="btn_add_time" onclick="cancel_all()">取消所有</a>
                                <select class="easyui-combobox" id="merchant_name" name="merchant_name"
                                        style="width: 120px; margin-left: 300px;"></select>
                            </div>
                            <form id="couponForm" method="post">
                                <table id="merchantCouponList"></table>
                            </form>
                        </div>
                    </td>
                </tr>
            </table>

            <div class="dialog-button">
                <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-close">取消</a>
            </div>
        </form>
    </div>
</div>
</div>
<%--新增停车场弹窗 end--%>
</div>
</body>
</html>
