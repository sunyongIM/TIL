/**
 * 
 */
$(function(){
	$("#login_btn").click(function(){
		var id = $("#id").val();
		var pw = $("#pw").val();
		alert(id+":"+pw);
		
		$.ajax({
			data:{checkId:id, checkPw:pw},
			type:"post",
			dataType:"text",
			url:"http://localhost:9090/test/controller/login",
			async:false,
			success:function(data,textStatus){
				alert(data+"님 login ok: Status "+textStatus);
			},
			error:function(data,textStatus){
//				$("#message").text("error");
				alert("login fail: Status "+textStatus)
			},
			complete:function(data,textStatus){
				
			}
		});
	});
});