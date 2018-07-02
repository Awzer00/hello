<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>西安市公安局</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	 function newRefresh(){
		$("#imageCode").attr("src","imageServlet?"+ Math.random());
	} 
	 function changBack(){
			var i=1;
			$("#leftmove").click(function(){
				i--;
				if(i==0){
					i=5;
				}
				$("#main>#img").removeClass();
				$("#main>#img").addClass("pic"+i);
			});
			$("#rightmove").click(function(){
				i++;
				if(i==6){
					i=1;
				}
				$("#main>#img").removeClass();
				$("#main>#img").addClass("pic"+i);
			});	
		}
	$(function(){
			$("#imageCode").click(newRefresh);
			$("#aCode").click(newRefresh);
			changBack();	
	});
</script>
</head>
<body>
<div id="page">
	<div id="top">
		<img alt="" src="img/logo.png">
	</div>
	<div id="main">			
		<span id="leftmove" title="上一张"><</span>
		<span id="rightmove" title="下一张">></span>
		<div id="img"></div>
		<form action="loginServlet" method="post">
				<div id="divSelect">登录权限
					<select  name="userType">
						<option value="管理员">管理员</option> 
						<option value="市局用户">市局用户</option> 
						<option value="分局用户">分局用户</option> 
						<option value="地区派出所" selected="selected">地区派出所</option> 
						<option value="协管员">协管员</option> 
					</select>
				</div>
			<div>用户名：<input type="text" name="userId" maxlength="20"  placeholder="用户名" /></div>
			<div>密&nbsp;&nbsp;码：<input type="password"  name="userPwd" maxlength="20" placeholder="密码"/></div>
			
			<div class="code">
				验证码：<input type="text" name="randomCode" />&nbsp;
				<img title="点击更换" id="imageCode" src="imageServlet">
				<a href="#" id="aCode">看不清</a>
			</div>
			<div>
				<input type="submit" value="登 录"/>
			</div>
			
			<%
				String message = (String) request.getAttribute("message");
				if (message != null) {
			%>
			<div style="color: red;"><%=message%></div>
			<%
				}
			%>
			
		</form>
	</div>
	<div id="buttom">
		<div>
			<a href="http://www.xa-police.gov.cn/help/help.htm">网站地图</a> ｜
			<a href="http://www.xa-police.gov.cn/index.php?m=content&c=index&a=lists&catid=20">机构概况</a> ｜ 
			<a href="http://www.xa-police.gov.cn/index.php?m=content&c=index&a=lists&catid=119">联系我们</a>
		</div>
		<div>西安市西大街63号&nbsp;&nbsp;邮编：710002&nbsp;&nbsp;邮箱：xian_police@163.com</div>
		<div><img src="img/ga_icon.png">&nbsp;&nbsp;陕公网安备 61010402000130号</div>
	</div>
</div>
</body>
</html>