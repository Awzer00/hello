<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updatePowerServletControl" method="post">
		   
        <label>请输入登录号:</label>   
        <input type="text" name="logID"/> <br/>  

        <label>权限设置:</label>   
        <select  name="power">
			<option value="管理员">管理员</option> 
			<option value="市局用户">市局用户</option> 
			<option value="分局用户">分局用户</option> 
			<option value="地区派出所" selected="selected">地区派出所</option> 
			<option value="协管员">协管员</option> 
		</select><br/>
 
        <input type="submit" value="确定" />
	    <a id="cancel" href="rolePriorityServlet">取消</a>
	  
	</form>
</body>
</html>