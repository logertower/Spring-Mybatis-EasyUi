<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#menu-tools a {
	margin: -5.6px;
}
</style>
<script type="text/javascript">
	var layout_west_tree;
	var layout_west_tree_url = '';
	var sessionInfo_user_loginName = '${user.username}';
	

	$(function(){
		if(sessionInfo_user_loginName){
			initMenuTree();
		}
	});
	
	function initMenuTree() {
		layout_west_tree_url = ctx + '/json/menu_sys.json';
		layout_west_tree = $('#layout_west_tree').tree({
			url : layout_west_tree_url,
			parentField : 'pid',
			//lines : true,
			onClick : function(node) {
				if (node.attributes && node.attributes.url) {
					var url;
					if (node.attributes.url.indexOf('/') == 0) {//如果url第一位字符是"/"，那么代表打开的是本地的资源
						url = ctx + node.attributes.url;
						
					} else {/*打开跨域资源*/
						url = node.attributes.url;
					}
					addTab({
						url : url,
						title : node.text,
						iconCls : node.iconCls
					});
				}
			},
			onBeforeLoad : function(node, param) {
				if (layout_west_tree_url) {//只有刷新页面才会执行这个方法
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
				}
			},
			onLoadSuccess : function(node, data) {
				parent.$.messager.progress('close');
			}
		});
	}

	function addTab(params) {
	    console.info(params);
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
			var index = t.tabs('getTabIndex', t.tabs('getSelected'));
			t.tabs('getTab', index).panel('refresh');
			parent.$.messager.progress('close');
		} else {
			t.tabs('add', opts);
		}
	}
	
	//刷新菜单
	function menu_refresh() {
		$('#layout_west_tree').tree('reload');
	}
	
	//展开树
	function menu_next() {
		var node = $('#layout_west_tree').tree('getSelected');
		if (node) {
			$('#layout_west_tree').tree('expandAll', node.target);
		} else {
			$('#layout_west_tree').tree('expandAll');
		}
	}
	
	//合并树
	function menu_previous() {
		var node = $('#layout_west_tree').tree('getSelected');
		if (node) {
			$('#layout_west_tree').tree('collapseAll', node.target);
		} else {
			$('#layout_west_tree').tree('collapseAll');
		}
	}

	<%--打开菜单--%>

	function openCustomerManagerTab(){
		var paramobj = {
			title: "用户信息管理",
			iconCls: "status_online",
			url: ctx + "/layout/tools/customerManager.html"
		}
		addTab(paramobj);
	}

	function openCustomerLevelPointManagerTab(){
		var paramobj = {
			title: "用户等级管理",
			iconCls: "status_online",
			url: ctx + "/layout/tools/customerLevelPointManager.html"
		}
		addTab(paramobj);
	}

	function openCustomerBalanceManagerTab(){
		var paramobj = {
			title: "用户余额管理",
			iconCls: "status_online",
			url: ctx + "/layout/tools/customerBalanceManager.html"
		}
		addTab(paramobj);
	}

	function openMessageManagerTab(){
		var paramobj = {
			title: "短信管理",
			iconCls: "status_online",
			url: ctx + "/layout/tools/customerMessageManager.html"
		}
		addTab(paramobj);
	}

</script>
<div class="easyui-accordion" data-options="fit:true,border:false">
	<div title="系统菜单" style="padding: 5px;" data-options="border:false,isonCls:'anchor',tools :'#menu-tools'">
		<div class="well well-small">
			<ul id="layout_west_tree">
				<li>
					<a href="#" plain="true" iconCls="status_online" title="用户信息管理" onclick="openCustomerManagerTab();">用户信息管理</a>
				</li>
				<li>
					<a href="#" plain="true" iconCls="status_online" title="用户等级管理" onclick="openCustomerLevelPointManagerTab();">用户等级管理</a>
				</li>
				<li>
					<a href="#" plain="true" iconCls="status_online" title="余额管理" onclick="openCustomerBalanceManagerTab();">余额管理</a>
				</li>
				<li>
					<a href="#" plain="true" iconCls="status_online" title="短信管理" onclick="openMessageManagerTab();">短信管理</a>
				</li>
			</ul>
		</div>
	</div>
	
</div>

<!-- 菜单树操作 -->
<div id="menu-tools">
	<a href="#" plain="true" iconCls="database_refresh" title="刷新菜单" onclick="menu_refresh();"></a>
	<a href="#" plain="true" iconCls="resultset_next" title="展开树" onclick="menu_next();"></a>
	<a href="#" plain="true" iconCls="resultset_previous" title="合并树" onclick="menu_previous();"></a>
</div>