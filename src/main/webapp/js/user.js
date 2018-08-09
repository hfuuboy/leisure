$(function() {

	/**
	 * 新增
	 */
	$("#submitBtn").click(function() {

		var user = {
			name : $("#name").val(),
			password : $("#password").val(),
			email : $("#email").val(),
			phone : $("#phone").val(),
			sex : $("input[type='radio']:checked").val()
		}
		console.log(user);
		var params = $("#userForm").serialize();
		// var params = $("#userForm").serializeArray(); //转化为json对象
		$.ajax({
			type : "POST",
			dataType : "json",
			url : ctx + "/user/saveUser",
			data : user,
			success : function(data) {
				if (data.status == 'OK') {
					window.location.href = ctx + "/user/toUserList"
				}
			}
		});
	});

	$("#updateFormBtn").click(function() {
		var params = $("#updateForm").serializeArray(); // 转化为json对象
		// alert(JSON.stringify(params)); //转化为json字符串
		$.ajax({
			type : "POST",
			// contentType: 'application/json',
			dataType : "json",
			data : params,
			url : ctx + "/user/updateUser",
			success : function() {
				window.location.href = ctx + "/user/toUserList"
			}
		});

	});

	$("#userForm #name").blur(function() {
		var name = $("#userForm #name").val();
		$.ajax({
			type : "POST",
			dataType : "json",
			cache : false,
			data : {
				name : name
			},
			url : ctx + "/user/checkName",
			success : function(data) {
				if(data.status=="error"){
					$("#remind").css("color","red").html("抱歉！用户名已经存在！");
				}else{
					$("#remind").css("color","green").html("恭喜！用户名可以用！");
				}
			}
		});
	});

});
