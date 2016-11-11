<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
label {
	display: inline;
	margin-bottom: 5px;
}
</style>
<script type="text/javascript" charset="utf-8">
	var loginDialog;
	var sessionInfo_user_loginName = '${user.username}';
	
	//启动dialog
	$(function() {
		if(!sessionInfo_user_loginName) {
			//console.info("true--2");
			loginDialog = $('#loginDialog').show().dialog({
				modal : true,
				closable : false,
				buttons : [ {
					text : '登录',
					handler : function() {
						loginFun();
					}
				} ]
			});
			$('#loginDialog input').keyup(function(event) {
				if (event.keyCode == '13') {
					loginFun();
				}
			});
		}
	});//end of $(function);

	//登陆
	function loginFun() {
		var form = $('#loginForm');//选中的tab里面的form
		var name = $("#name").val();
		var pwd = $.md5($("#pwd").val());
		var params = "name=" + name + "&pwd=" + pwd ;
		if (form.form('validate')) {
			 parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			}); 
			$.post('${pageContext.request.contextPath}/user/login.html',
					params, function(json) {
						if (json.rtCode == 0) {
							
							//1、获取登陆用户的姓名
							var rtData = json.rtData;
							name = rtData.name;
							//2、判断登陆用户是系统管理员，还是普通用户，根据不同的参数加载不同的菜单树
							initMenuTree('sys');
							
							//3、隐藏登陆窗口，在右下角显示欢迎词，在右上角显示注销和用户名
							parent.$.messager.progress("close");//关闭事件处理提示条
							$('#loginDialog').dialog('close');
							$.messager.show({
								title : '系统消息',
								msg : name + '：欢迎登录',
								showType : 'show'
							});
							parent.$(".logout").append("<a>"+name+"</a><span>|</span><a onclick='logoutFun(true);'>注销</a>");

						} else {
							$.messager.alert('错误', json.rtMsg, 'error');
							 parent.$.messager.progress("close");//关闭事件处理提示条
						}
						
					}, "JSON");
		}
	}
</script>
<div id="loginDialog" title="用户登录"
	style="width: 330px; height: 240px; overflow: hidden; display: none;">
	<form method="post" style="margin: 35px 0 0 15px;">
		<table id="loginForm" class="table table-hover table-condensed">
			<tr>
				<th>登录名</th>
				<td>
					<input id="name" name="name" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true" value="">
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td>
					<input id="pwd" name="pwd" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="">
				</td>
			</tr>
		</table>
	</form>
</div>
