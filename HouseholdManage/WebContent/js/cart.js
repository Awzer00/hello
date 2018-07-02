$(function(){

	$("input[name='c']").change(function(){
		var c = $(this).val();
		var bookId = $("#id").html();
		$.post("Add2CartServlet",{id:bookId,count:c},function(data){
			alert(data);
		})
		
	});
	
	
	$("input[value='-']").click(function (){
		var n = $(this).next().val();
		n--;
		if(n<=1){
			$(this).next().val(1);
		}else{
			$(this).next().val(n);
			$("input[name='c']").change();
		}
	});
	$("input[value='+']").click(function(){

		var n = $(this).prev().val();
		n++;
		$(this).prev().val(n);

		$("input[name='c']").change();
		if(n>1){
			$(this).prev().prev().val("-");
			$("input[value='-']").click(minusCount);
		}
		
	});
	
	
});