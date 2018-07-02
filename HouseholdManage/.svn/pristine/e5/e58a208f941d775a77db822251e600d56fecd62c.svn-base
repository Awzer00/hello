$(function(){
	
	//新增新户口
	$("input[id='addData']").click(function(){
		$("div[id='mess']").remove();
		var IDCard=$("#IDCard").val();
		var name=$("#name").val();
		var sex=$("#sex1:checked").val()=="男"?$("#sex1").val():$("#sex2").val();
		var natives=$("#natives").val();
		var nation=$("#nation").val();
		var trpid=$("#trpid").val();
		if(IDCard==null ||name==null || natives==null || nation==null || trpid==null || IDCard==""||name==""||natives==""||nation==""||trpid==""){
			$("input").bind("focus",function(){
				$("div[id='mess']").remove();
			});
			$("#handle").before("<div id='mess' style='color:red'>请完善信息</div>");
		
		}else{
			$.post("addDataServletControl",{IDCard:IDCard,name:name,sex:sex,natives:natives,nation:nation,trpid:trpid},function(data){
				if(data=="ok"){
					alert("增加成功");
				}else{
					$("#cancel").after("<div id='mess' style='color:red'>增加失败</div>");
					$("input").bind("focus",function(){
						$("div[id='mess']").remove();
					});
				}
			});
		}
	});
	
	
	//移除户口
	$("input[id='removeData']").click(function(){
		var IDCard=$("#IDCard").val();
		if(IDCard==null || IDCard==""){
			alert("请输入身份证号码");
		}else{
			if(confirm("确认删除:"+IDCard+"吗？")){
				$.post("removeDataServletControl",{IDCard:IDCard},function(data){
					if(data=="empty"){
						alert("请输入身份证号码");
					}else if(data=="ok"){
						$("#cancel").after("<div id='mess' style='color:green'>删除成功</div>");
						$("#IDCard").bind("focus",function(){
							$("div[id='mess']").remove();
						});
					}else if(data=="noIDCard"){
						alert("查无此人");
					}else{
						$("#cancel").after("<div id='mess' style='color:red'>删除失败</div>");
						$("#IDCard").bind("focus",function(){
							$("div[id='mess']").remove();
						});
					}
				});
			}
			
		}
	});
	
	
	//根据身份证查找信息
	$("#showDataById").click(function(){
		var IDCard=$("#IDCard").val();
		if(IDCard!="" && IDCard!=null){
			$.post("ckeckHadIDCard",{IDCard:IDCard},function(data){
				if(data=="error"){
					$("input[id='IDCard']").after("&nbsp;<span id='i' style='color:red;'>身份证号码不存在</span>");
					$("input[id='IDCard']").bind("focus",function(){
						$("span[id='i']").remove();
					});
				}else{
					$.getJSON("showDataByIDCardServletControl",{IDCard:IDCard},function(data){
						var d="<ul style='margin-left:100px;	padding:10px;'>";

						d+="<label>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>"+data.id;
						d+="<br/>";
						d+="<label>身份证号:</label>"+data.idcard;
						d+="<br/>";
						d+="<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>"+data.name;
						d+="<br/>";
						d+="<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>"+data.sex;
						d+="<br/>";
						d+="<label>籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯:</label>"+data.natives;
						d+="<br/>";
						d+="<label>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:</label>"+data.nation;
						d+="<br/>";
						d+="<label>暂住证号:</label>"+data.trpid;
						d+="<br/>";
						d+="</ul>";
						
						$("#handle").after(d);
			      });
				}	
			
		    });
		}
	});	
	
	
	
});	
