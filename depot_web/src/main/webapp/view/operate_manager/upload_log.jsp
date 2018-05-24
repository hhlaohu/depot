<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/view/resource.jsp" %>

    <script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
    <script type="text/javascript" src="${msUrl}/js/commons/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${msUrl}/js/ux/operate_manager/white_list.js"></script>
    <meta http-equiv="refresh" content="20" url="${msUrl}/log/upload_log.shtml"/>
</head>

<style type="text/css">
    * {
        margin: 0;
        padding: 0
    }

    ul, ol {
        list-style: none
    }

    img, a {
        border: 0px;
    }

    a {
        outline: none;
    }

    .content_ht1 {
        width: 100%;
        margin: 0px auto;
        height: 100%;
        padding-top: 122px;
    }

    .content_right1 {
        width: 810px;
        margin: auto;
        padding: 70px 77px 49px;
        overflow: hidden;
    }

    .content_right1 div {
        float: left;
        width: 202px;
        margin-right: 102px;
        margin-top: 40px;
    }

    .div_right {
        width: 800px;
        height: 320px;
        text-align: center;
        margin: 10px;
        float: left;
        border: 1px solid #0081c2
    }

    .div_right .panel-content {
        text-align: left;
        padding: 10px;
        line-height: 18px;
        color: #000;
        font-size: 16px;
    }

    .div_right .panel-header {
        border-bottom: 1px solid #0081c2;
        background-color: #ffffff;
        text-align: left;
        padding-left: 10px;
        line-height: 18px;
        color: #0081c2;
    }

    /* 		.contentNavi{background-color:#2C8AE6} */
</style>
<body>
<input id="check_status" type="hidden" value="${check_status}">
<div class="div_right">
    <div class="panel-header">
        <span>实时日志</span>
    </div>
    <div class="panel-content">
        <c:forEach items="${log_info}" var="item">
            <p>${item}</p>
        </c:forEach>
    </div>
</div>

<div class="div_right">
    <div class="panel-header">
        <span>异常日志</span>
    </div>
    <div class="panel-content">
        <c:forEach items="${log_error}" var="item">
            <p>${item}</p>
        </c:forEach>
    </div>
</div>
</body>
</html>
