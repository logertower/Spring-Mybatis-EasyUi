<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/easyui/extBrowser.js" charset="utf-8"></script>

<!-- 引入my97日期时间控件 -->
<%-- <script type="text/javascript" src="${ctx}/jsAndCssForBack/jslib/My97DatePicker4.8b3/My97DatePicker/WdatePicker.js" charset="utf-8"></script> --%>

<!-- 引入kindEditor插件 -->
<%-- <link rel="stylesheet" href="${ctx}/js/easyui/kindeditor-4.1.7/themes/default/default.css">
<script type="text/javascript" src="${ctx}/js/easyui/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script> --%>

<!-- 引入jQuery -->
<script src="${ctx}/js/easyui/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/easyui/jquery.md5.js"></script>

<!-- 引入Highcharts -->
<script src="${ctx}/js/easyui/Highcharts-3.0.1/js/highcharts.js" type="text/javascript" charset="utf-8"></script>

<!-- 引入bootstrap样式 -->
<link href="${ctx}/js/easyui/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- <script charset="utf-8" src="${ctx}/jsAndCssForBack/jslib/bootstrap-2.3.1/js/bootstrap.min.js" charset="utf-8"></script> -->

<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${ctx}/js/easyui/jquery-easyui-1.3.3/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css">
<%-- <link id="easyuiTheme" rel="stylesheet" href="${ctx}/js/easyui/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" type="text/css"> --%>
<link rel="stylesheet" href="${ctx}/js/easyui/jquery-easyui-1.3.3/themes/icon.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 修复EasyUI1.3.3中layout组件的BUG -->
<script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.3.3/plugins/jquery.layout.js" charset="utf-8"></script>

<!-- 引入EasyUI Portal插件 -->
<link rel="stylesheet" href="${ctx}/js/easyui/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="${ctx}/js/easyui/extEasyUI.js" charset="utf-8"></script>

<!-- 扩展EasyUI Icon -->
<link rel="stylesheet" href="${ctx}/css/extEasyUIIcon.css" type="text/css">

<link rel="stylesheet" href="${ctx}/css/demo.css" type="text/css">

<!-- 扩展jQuery -->
<script type="text/javascript" src="${ctx}/js/easyui/extJquery.js" charset="utf-8"></script>


<!-- 自定义js -->
<script type="text/javascript" src="${ctx}/js/common/utils.js" charset="utf-8"></script>


<!-- 自定义css -->
