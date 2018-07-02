<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">   
	    <div>   
	        <label >姓名:</label>   
	        <input  type="text" name="name" id="name"/>   
	    </div>   
	    <div>   
	        <label >登录号:</label>   
	        <input  type="text" name="logID" id="logID" onblur="checkLogid" />  
	    </div>  
	    <div>   
	        <label >密码:</label>   
	        <input  type="text" name="logPwd" id="logPwd"/>   
	    </div>  
	    <div>   
	        <label >登录权限:</label>   
	        <select  name="userType" id="userType">
				<option value="管理员">管理员</option> 
				<option value="市局用户">市局用户</option> 
				<option value="分局用户">分局用户</option> 
				<option value="地区派出所" selected="selected">地区派出所</option> 
				<option value="协管员">协管员</option> 
			</select>
	    </div>   
	    <div>
	    	<span id="mess"></span>
	    </div> 
	    <div>   
	        <input type="submit" value="申请" />
		    <a id="cancel" href="rolePriorityServlet">取消</a>
	    </div> 
   </form>  
   
   <script type="text/javascript">
		function checkLogid(){
			var logid=document.getElementById("logID").value;
			if(logid==""){
				$("input[id='logID']").after("&nbsp;<span id='empty' style='color:red;'>注册名不可为空</span>");
				$("input[id='logID']").bind("focus",function(){
					$("span[id='empty']").remove();
				});
			}else{
				$.post("ckeckHadLodid",{logid:logid},function(data){
					if(data=="ok"){
						$("input[id='logID']").after("&nbsp;<span id='ok' style='color:green;'>注册名可用</span>");
						$("input[id='logID']").bind("focus",function(){
							$("span[id='ok']").remove();
						});
					}else{
						$("input[id='logID']").after("&nbsp;<span id='error' style='color:red'>注册名已存在</span>");
						$("input[id='logID']").bind("focus",function(){
							$("input[id='logID']").val("");
							$("span[id='error']").remove();
						});
					}
				});
			}
		}
		
		$(function(){
			$("form").submit(function(){
				var name=document.getElementById("name").value;
				var logid=document.getElementById("logID").value;
				var logPwd=document.getElementById("logPwd").value;
				var userType=document.getElementById("userType").value;
				$.post("addRoleServletControl",{name:name,logid:logid,logPwd:logPwd,userType:userType},function(data){
					if(data=="hadID"){
						$("span[id='mess']").val("账户已存在请重新输入");
					}else if(data=="ok"){
						$("span[id='mess']").val("注册成功");
					}else{
						$("span[id='mess']").val("注册失败");
					}
				});
			});
		});
  </script>
</body>
</html>