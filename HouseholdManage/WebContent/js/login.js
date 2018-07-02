$(function(){
	var time = 0;
	$("a").click(function(){
		if(time < 3){
			var name = $("input[name='name']").val();
			var password = $("input[name='password']").val();
			
			$.post("loginServlet",{name:name,password:password,ptype:"abc"},
					function(result) {
						if(result=="ok"){
							location="BooksServlet";
						}else{
							time++;
							if($("#loginResult").html()==undefined){
								$("input[name='password']").after("<span id='loginResult'>登录失败</span>");
							}else{
								$("#loginResult").html("登录失败"+time);
							}
							
						}
					});
		}else{
			
		}
	});
});