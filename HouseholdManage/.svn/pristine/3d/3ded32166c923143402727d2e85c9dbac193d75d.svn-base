$(function(){
	$("#addT").click(function(){
		var licenceID=$("#licenceID").val();
		var IDCard=$("#IDCard").val();
		var name=$("#name").val();
		var phone=$("#phone").val();
		var trpID=$("#trpID").val();
		var begin= $("input[name='be']").datebox('getValue');
		
		if(licenceID==""||IDCard==""||name==""||phone==""||trpID==""||begin==""||end==""||
			licenceID==null||IDCard==null||name==null||phone==null||trpID==null||begin==null||end==null){
			alert("请完善信息");
		}else{
			$.post("addTenantServletControl",{licenceID:licenceID,IDCard:IDCard,name:name,phone:phone,trpID:trpID,begin:begin,end:end},function(data){
				if(data=="ok"){
					alert("增加成功");
				}else{
					alert("增加失败");
				}
			});
	
		}
	});
});