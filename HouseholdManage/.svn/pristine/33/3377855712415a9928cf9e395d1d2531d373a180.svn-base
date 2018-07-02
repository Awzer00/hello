$(function(){
	$("#apply").click(function(){
		var idcard=$("#idcard").val();
		var name=$("#name").val();
		var natives=$("#natives").val();
		var address=$("#address").val();
		if(idcard==null||idcard==""||name==null||name==""||natives==null||natives==""||address==null||address==""){
			alert("请完善信息");
		}else{
			$.post("applyTrpServletControl",{idcard:idcard,name:name,natives:natives,address:address},function(data){
				if(data=="ok"){
					alert("申请成功,请等待处理!");
				}else if(data=="yes"){
					alert("申请成功,请等待处理");
				}else if(data=="error"){
					alert("申请失败,请重新申请")
				}else if(data=="hadTrp"){
					alert("已有暂住证,请去挂失");
				}else{
					alert("没有数据,请先在总表中注册");
				}
			});
			
		}
	});
	
	
	$("#showTrp").click(function(){
		
		var trpid=$("#trpid").val();
		if(trpid==null || trpid==""){
			alert("请完善信息");
		}else{
			$.post("checkHadTrpID",{trpid:trpid},function(data){
				if(data=="noID"){
					alert("没有此用户");
				}else{
					$.getJSON("showTrpByTrpidServlet",{trpid:trpid},function(data){
						$("#trpid").focus(function(){
							$("#trpInfo").remove();
						});
						
						var trp="<ul id='trpInfo'>";
						trp+="<label>暂住证号:</label>"+data.trpid;
						trp+="<br/>";
						trp+="<label>身份证号:</label>"+data.idcard;	
						trp+="<br/>";
						trp+="<label>姓名:</label>"+data.name;
						trp+="<br/>";		
						trp+="<label>籍贯:</label>"+data.natives;
						trp+="<br/>";
						trp+="<label>暂住地址:</label>"+data.address;
						trp+="<br/>";
						trp+="<label>开始日期:</label>"+data.beginDate;
						trp+="<br/>";
						trp+="<label>结束日期:</label>"+data.endDate;
						trp+="<br/><br/>";
						trp+="<a id='confirmDele' href='#'>确认删除</a>";
						trp+="</ul>";
						
						$("#cancel").after(trp);
						
						$("a[id='confirmDele']").click(deleT)
						
					});
				}
			});
		}
		
		function deleT(){
			if(confirm("确认删除吗?")){
				$.post("removeTrpServletControl",{trpid:trpid},function(data){
					if(data=="ok"){
						alert("删除成功");
					}else{
						alert("删除失败");
					}
				});
			}
		}

	});
	
	
	
});