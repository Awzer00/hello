$(function(){
	//增加权限
	$(function(){
		$("input[id='addRole']").click(function(){
			var name=document.getElementById("name").value;
			var logid=document.getElementById("logID").value;
			var logPwd=document.getElementById("logPwd").value;
			var userType=document.getElementById("userType").value;
			$.post("addRoleServletControl",{name:name,logid:logid,logPwd:logPwd,userType:userType},function(data){
				if(data=="hadID"){
					$("span[id='mess']").html("账户已存在请重新输入").css("color","red");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='mess']").html("");
					});
				}else if(data=="ok"){
					$("span[id='mess']").html("注册成功").css("color","green");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='mess']").html("");
					});
				}else if(data=='error'){
					$("span[id='mess']").html("注册失败").css("color","red");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='mess']").html("");
					});
				}else{
					$("span[id='mess']").html("不能为空").css("color","red");
				}
			});
		});
	 });
	
	
	//删除某人权限
	$("a[id='deleRole']").click(function(){
		var logID=$("#logID").val();
		if(logID==null || logID==""){
			alert("请输入登录号");
		}else{
			$.post("removeRoleServletControl",{logID,logID},function(data){
				if(data=="ok"){
					$("input[id='logID']").after("<span id='deleR' style='color:green;'>删除成功</span>");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='deleR']").remove();
					});
				}else if(data=="error"){
					$("input[id='logID']").after("<span id='deleR' style='color:red;'>删除失败</span>");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='deleR']").remove();
					});
				}else if(data=="noID"){
					$("input[id='logID']").after("<span id='deleR' style='color:red;'>此用户不存在</span>");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='deleR']").remove();
					});
				}else{
					$("input[id='logID']").after("<span id='deleR' style='color:red;'>请输入登录号</span>");
					$("input[id='logID']").bind("focus",function(){
						$("span[id='deleR']").remove();
					});
				}
			});
		}
	});
	
	
	//修改密码
	$("input[id='updatePwd']").click(function(){
		var logID=$("#logID").val();
		var logPwd1=$("#logPwd1").val();
		var logPwd2=$("#logPwd2").val();
		if(logPwd1!=logPwd2){
			alert("两次输入密码不同!!");
		}else{
			$.post("updateLogPwdServletControl",{logID:logID,logPwd:logPwd1},function(data){
				if(data=="noID"){
					alert("用户不存在");
				}else if(data=="ok"){
					alert("修改成功,下次登录请使用新密码");
				}else{
					alert("修改失败");
				}
			});
		}
	})
	
	
	//修改权限
	$("input[id='updatePower']").click(function(){
		var logID=$("#logID").val();
		var power=$("select[name='power']").val();
		$.post("updatePowerServletControl",{logID:logID,power:power},function(data){
			if(data=="noID"){
				alert("用户不存在");
			}else if(data=="ok"){
				alert("修改成功,下次登录请使用新权限");
			}else{
				alert("修改失败");
			}
		});
	});
	
	
	//查询某人权限
	$("input[id='showPower']").click(function(){
		$("table[id='sr']").remove();
		var logID=$("input[id='logID']").val();
		$.getJSON("showPowerServletControl",{logID:logID},function(data){
			if(data=="noID"){
				$("a[id='cancel']").after("<span id='mess' style='color:red;'>用户不存在</span>");
				$("input[id='logID']").bind("focus",function(){
					$("span[id='mess']").remove();
				});
			}else if(data=="error"){
				$("a[id='cancel']").after("<span id='mess' style='color:red;'>查无信息</span>");
				$("input[id='logID']").bind("focus",function(){
					$("span[id='mess']").remove();
				});
			}else{
				var role="";
				role+="<table id='sr'cellpadding='3'>";
				role+="<tr>";
				role+="<td>";
				role+="姓名";
				role+="</td>";
				role+="<td>";
				role+="登录号"
				role+="</td>";	
				role+="<td>";
				role+="权限"
				role+="</td>";	
				role+="</tr>";
				role+="<tr>";
				role+="<td>";
				role+=data.roleName;
				role+="</td>";
				role+="<td>";
				role+=data.logId;
				role+="</td>";	
				role+="<td>";
				role+=data.rlimit;
				role+="</td>";	
				role+="</tr>";
				role+="</table>";
				
				$("a[id='cancel']").after(role);
			}
		});
	});
	
});