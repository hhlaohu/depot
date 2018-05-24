<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/operate_manager/parameter_setting.js"></script>

    <style>
        .tab_record td {
            width: 250px;
            height: 30px;
            text-align: left;
            border: 1px solid #cccccc;
        }

        .tab_record {
            border: 1px solid #cccccc;
        }

        .div_warp {
            padding-top: 30px;
            width: 550px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="warp easyui-panel" data-options="border:false">
    <div class="div_warp">
        <p style="text-align: center; font-size: 20px;">运营参数设置</p>
        <form id="paramForm" style="padding-top: 40px;margin-left: 20px;"
              action="/depot_background/operate/parameter_setting/save.do">
            <table class="tab_record">
                <tr>
                    <td>每天最高收费跨界点：</td>
                    <td>
                        <input type="radio" name="toll_point" value="0" <c:if
                                test="${parameter_setting.toll_point == 0}"> checked="checked"</c:if>>入场时间</input>
                        <input type="radio" name="toll_point" value="1" <c:if
                                test="${parameter_setting.toll_point == 1}"> checked="checked"</c:if>>0点</input>
                    </td>
                </tr>
                <tr>
                    <td>超过每天最高收费后，是否允许免费进出：</td>
                    <td>
                        <input type="radio" name="highcharge_free" value="0"<c:if
                                test="${parameter_setting.highcharge_free ==0}"> checked="checked"</c:if>>不允许</input>
                        <input type="radio" name="highcharge_free" value="1"<c:if
                                test="${parameter_setting.highcharge_free ==1}"> checked="checked"</c:if>>允许</input>
                    </td>
                </tr>
                <tr>
                    <td>缴费后最长滞留时间：</td>
                    <td>
                        <input type="text" name="time" style="width: 100px;" value="1"/>
                        <label>分钟</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-submit" onclick="update()">保存</a>
                    </td>
                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>
