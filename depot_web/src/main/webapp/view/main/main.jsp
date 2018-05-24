<%@ page language="java" import="java.net.URLDecoder" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>${project_name}</title>
    <%@include file="/view/resource.jsp" %>
    <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
    <script type="text/javascript" src="${msUrl}/js/ux/main/main.js"></script>
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
            width: 700px;
            height: 210px;
            text-align: center;
            margin: 10px;
            float: left;
            border: 1px solid #0081c2
        }

        .div_right .panel-content {
            text-align: left;
            padding: 10px;
            line-height: 22px;
            color: #000;
            font-size: 16px;
        }

        .div_right .panel-header {
            border-bottom: 1px solid #0081c2;
            background-color: #ffffff;
            text-align: left;
            padding-left: 10px;
            line-height: 22px;
            color: #0081c2;
        }

        /* 		.contentNavi{background-color:#2C8AE6} */
    </style>
</head>
<body class="easyui-layout">

<div class="ui-header"
     data-options="region:'north',split:true,border:false"
     style="height: 40px; overflow: hidden;">
    <h1>${project_name}</h1>
    <div class="ui-login">
        <div class="ui-login-info">
            欢迎 <span class="orange">${user.usr_name}</span> 第[<span
                class="orange">${user.loginCount}</span>]次登录系统
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="modify-pwd-btn"
                                                    href="javascript:void(0);">修改密码</a> | <a class="logout-btn"
                                                                                             href="${msUrl}/logout.shtml">退出</a>
        </div>
    </div>
</div>
<!-- 树形菜单 -->
<div data-options="region:'west',split:false,title:''"
     style="width: 200px;">
    <!-- 	    <div class="sidebar-title">
        <h1>菜单</h1>
    </div> -->
    <div id="tree-box" class="easyui-accordion"
         data-options="fit:true,border:false">
        <c:forEach var="item" items="${menuList}">
            <div title="${item.text}">
                <c:forEach var="node" items="${item.children}">
                    <ul class="sub-menu">
                        <li><a class="menu-item" href="${msUrl}${node.url}">${node.text}</a></li>
                    </ul>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>
<div data-options="region:'south',split:true,border:false"
     style="height: 30px; overflow: hidden;">
    <div class="panel-header" style="border: none; text-align: center;">
        Version&copy;1.0.5:CopyRight&copy;2017特速集团版权所有.官方网址:<a
            href='http://www.sztesu.com'>http://www.sztesu.com</a>&nbsp;
    </div>
</div>
<!-- 中间内容页面 -->
<div data-options="region:'center'">
    <div class="easyui-tabs" id="tab-box"
         data-options="fit:true,border:false">
        <div class="contentNavi" title="欢迎"
             style="padding: 20px; overflow: hidden;">
            <img src="images/glbj.png"
                 style="width: 100%; height: 100%; position: absolute; z-index: -999;">
            <div class="div_right">

                <div class="panel-header">
                    <span>个人信息</span>
                </div>
                <div class="panel-content">
                    <p>您好，${user.usr_name}</p>
                    <p>所属角色:${user_role}</p>
                    <p>上次登录时间:${user.loginTime}</p>
                    <p>上次登录IP:${user.login_ip}</p>
                </div>
            </div>

        </div>
    </div>


</div>
<!--  modify password start -->
<div id="modify-pwd-win" class="easyui-dialog" buttons="#editPwdbtn"
     title="修改用户密码"
     data-options="closed:true,iconCls:'icon-save',modal:true"
     style="width: 350px; height: 200px;">
    <form id="pwdForm" action="modifyPwd.do" class="ui-form" method="post">
        <input class="hidden" name="id">
        <input class="hidden"
               name="usr_name">
        <div class="ui-edit">
            <div class="fitem">
                <label>旧密码:</label>
                <input id="oldPwd" name="oldPwd"
                       type="password" class="easyui-validatebox"
                       data-options="required:true"/>
            </div>
            <div class="fitem">
                <label>新密码:</label>
                <input id="newPwd" name="newPwd"
                       type="password" class="easyui-validatebox"
                       data-options="required:true"/>
            </div>
            <div class="fitem">
                <label>重复密码:</label>
                <input id="rpwd" name="rpwd" type="password"
                       class="easyui-validatebox" required="required"
                       validType="equals['#newPwd']"/>
            </div>
        </div>
    </form>
    <div id="editPwdbtn" class="dialog-button">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           id="btn-pwd-submit">确定</a> <a href="javascript:void(0)"
                                         class="easyui-linkbutton" id="btn-pwd-close">取消</a>
    </div>
</div>
<!-- modify password end  -->
</body>
</html>