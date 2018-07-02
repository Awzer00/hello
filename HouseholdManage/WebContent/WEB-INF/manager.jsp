<%@page import="com.project.entity.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/easyui.css">
<link rel="stylesheet" type="text/css" href="./css/icon.css">
<link rel="stylesheet" type="text/css" href="./css/demo.css">
<link rel="stylesheet" type="text/css" href="./css/titleimg.css">
<style type="text/css">
	li a{
		text-decoration: none;
    }
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/role.js"></script>

</head>
<body class="easyui-layout">
<%		
	Role role=(Role) session.getAttribute("role");
	String id="";
	String type="";
	try{
		id=role.getLogId();
		type=role.getRlimit();
	}catch(Exception e){
		response.sendRedirect("login.jsp");
	}
%>

		<div data-options="region:'north',border:false" style="height:130px;background:rgb(57,135,197);padding:10px"><img class="titleimg" alt="" src="./img/bbb.png">
			<div style="padding-top: 90px;padding-left:1050px">
				<span style="color: white;padding-right:10px ">用户编号：<%=id %></span>
				<span style="color: white;padding-right:30px  "><%=type %></span>
				<a href="logoutServlet" style="font-weight: bold; color: white;text-decoration: none;">切换用户</a>
			</div>
		</div>
		<div data-options="region:'west',split:false,title:'导航菜单 '" style="width:202px;">
			<div class="easyui-accordion" style="width:200px;">
			
 				<% if("管理员".equals(type)) {%>
				<div title="权限分配"  style="overflow:auto;padding:10px;">
					<a id="addPower" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-add'">增加用户</a><br/><br/>
					<a id="removePower" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-remove'">移除用户</a><br/><br/>
				</div>
 			 	
				<div title="权限管理"  style="padding:10px;">
					<a id="updateLogPwd" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-save'">修改密码</a><br/><br/>
					<a id="updatePower" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-save'">修改权限</a><br/><br/>
					<a id="showPower" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">查询权限</a><br/><br/>
					<a id="showAllPower" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">查询所有人权限</a>
				</div>
				<% }%>	
				
				 <% 	if("市局用户".equals(type) ||	"分局用户".equals(type) || "地区派出所".equals(type)){%>
				<div title="户口管理"  style="padding:10px;">
					<a id="addData" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-add'">增加新户口</a><br/><br/>
					<a id="removeData" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-remove'">移除户口</a><br/><br/>
					<a id="updateData" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-save'">修改户口信息</a>
				</div>
				<div title="户口查询"  style="padding:10px;">
					<a id="showAlldata" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">查询所有</a><br/><br/>
					<a id="showDataByIDC" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">身份证查询</a><br/><br/>
					<a id="showAllHost" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">查询所有户主</a><br/><br/>
				</div>
				<% }%>
				
				<% 	if("市局用户".equals(type) ||	"分局用户".equals(type) || "地区派出所".equals(type) || "协管员".equals(type)){%>
				<%   if("协管员".equals(type)){%>
					<br/>
					<a id="showDataByIDC" class="easyui-linkbutton" style="width:130px;margin-left:20px;" data-options="iconCls:'icon-search'">身份证查询</a>
					<br/><br/>
				<% }%>
				
				<div title="业务办理"  style="padding:10px;">
					<div class="easyui-panel" style="padding:5px;border:none;">
						<ul class="easyui-tree">
							<li data-options="state:'closed'">
								<span>户主</span>
								<ul>
									<li><a id="showHostByLID">按许可证查询</a></li>
									<li><a id="showHostByIDCard">按身份证查询</a></li>
									<li><a id="updateLidInfoByLID">更改许可证信息</a></li>
									<li><a id="removeLidByLID">撤销房屋租赁许可证</a></li>
								</ul>
							</li>	
						</ul>	
						<!-- <ul class="easyui-tree">
							<li data-options="state:'closed'">
								<span>房客</span>
								<ul>
									<li><a id="addTenant">新增房客</a></li>
									<li><a href="#">删除房客</a></li>
									<li><a href="#">更改房客信息</a></li>
									<li><a href="#">查询所有房客</a></li>
									<li><a href="#">按身可证查询</a></li>
									<li><a href="#">按暂住证查询</a></li>
									<li><a href="#">查询该户暂住人员</a></li>
								</ul>
							</li>	
						</ul> -->
						<ul class="easyui-tree">
							<li data-options="state:'closed'">
								<span>暂住证</span>
								<ul>
									<li><a id="applyTrp">申请暂住证</a></li>
									<% 	if("市局用户".equals(type) ||	"分局用户".equals(type) || "地区派出所".equals(type)){%>
									<li><a id="resolveApplyTrp">处理暂住证</a></li>
									<% }%>
									<li><a id="outTimeApplyTrp">过期申请记录</a></li>
									<li><a id="removeTrp">撤销暂住证</a></li>
									<li><a id="showAllTrp">查看暂住证</a></li>
									<li><a id="searchTrp">挂失暂住证</a></li>
								</ul>
							</li>	
						</ul>
					</div>
				</div>
				<% }%>
			</div>
		</div>	
		<div id="center" data-options="region:'center',title:' '">
			${message }
		</div>
	
</body>
</html>