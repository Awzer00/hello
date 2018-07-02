$(function(){
	
	$("#showHostByLicenceID").click(function(){
		var licenceID=$("#licenceID").val();
		if(licenceID==null||licenceID==""){
			alert("请输入租赁证号码!")
		}else{
			$.getJSON("showHostByLIDServletControl?licenceID="+licenceID,function(data){
				if(data=="noID"){
					alert("没有此租赁证");
				}else{
					var host="<ul>";
					host+="<li>";
					host+=data.licenceId;
					host+="</li>";
					host+="<li>";
					host+=data.idcard;
					host+="</li>";
					host+="<li>";
					host+=data.name;
					host+="</li>";	
					host+="<li>";
					host+=data.address;
					host+="</li>";
					host+="<li>";
					host+=data.beginDate;
					host+="</li>";
					host+="<li>";
					host+=data.endDate;
					host+="</li>";
					host+="</ul>";
					
					$("#cancel").after(host);
				}
			});
		}
	});
	
	$("#showHostByLicenceid").click(function(){
		var licenceID=$("#licenceID").val();
		if(licenceID==null||licenceID==""){
			alert("请输入租赁证号码!")
		}else{
			$.getJSON("showHostByLIDServletControl?licenceID="+licenceID,function(data){
				if(data=="noID"){
					alert("没有此租赁证");
				}else{
					$("div[id='updateMess']").css("display","block");
					$("#ID").val(data.id);
					$("#LIDC").val(data.licenceID);
					$("#NAME").val(data.name);
					$("#IDC").val(data.idcard);
					$("#ADDR").val(data.address);
					$("#BEGIN").val(data.beginDate);
					$("#END").val(data.endDate);
				}
			});
		}
	});
	
	$("#comm").click(function(){
		var id=$("#ID").val();
		var licenceID=$("#LIDC").val();
		var name=$("#NAME").val();
		var idcard=$("#IDC").val();
		var address=$("#ADDR").val();
		var begin=$("#BEGIN").val();
		var end=$("#END").val();
		if(id==null||id==""||licenceID==null||licenceID==""||name==null||name==""||
			idcard==null||idcard==""||address==null||address==""||begin==null||begin==""||end==null||end==""){
			alert("请完善信息");
		}else{
			$.post("updateLidInfoByLIDServletControl",{id:id,licenceID:licenceID,name:name,idcard:idcard,address:address,begin:begin,end:end},function(data){
				if(data=="ok"){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
					
			});
		}
	});
	
	
	$("#showHostByIDC").click(function(){
		var IDCard=$("#IDCard").val();
		if(IDCard==null||IDCard==""){
			alert("请输入身份证号码!")
		}else{
			$.getJSON("showHostByIDCardServletControl?IDCard="+IDCard,function(data){
				if(data=="noID"){
					alert("没有此身份证");
				}else{
					var host="<ul>";
					host+="<li>";
					host+=data.licenceId;
					host+="</li>";
					host+="<li>";
					host+=data.idcard;
					host+="</li>";
					host+="<li>";
					host+=data.name;
					host+="</li>";	
					host+="<li>";
					host+=data.address;
					host+="</li>";
					host+="<li>";
					host+=data.beginDate;
					host+="</li>";
					host+="<li>";
					host+=data.endDate;
					host+="</li>";
					host+="</ul>";
					
					$("#cancel").after(host);
				}
			});
		}
	});
	
	
	$("#deleteHostByLicenceid").click(function(){
		var licenceID=$("#licenceID").val();
		if(licenceID==null||licenceID==""){
			alert("请输入租赁证号码!");
		}else{
			$.post("removeLidByLIDServletControl",{licenceID:licenceID},function(data){
				if(data=="empty"){
					alert("请输入租赁证号码");
				}else if(data=="ok"){
					alert("删除成功");
					$("#licenceID").val("");
				}else{
					alert("删除失败");
				}
			});
		}
	});
});