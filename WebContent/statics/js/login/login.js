/**
 * Created by bdqn on 2016/5/3.
 */
// 登录的方法
function login() {
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	$.ajax({
		"url" : contextPath +"/LoginServlet",
		"type" : "post",
		"data" : {
			"loginName" : loginName,
			"password" : password
		},
		"dataType" : "json",
		"success":function(data){
			if(data.result=="success"){
				window.location.href='index.jsp';
			}else{
				alert("用户名或密码错误");
				window.location.href='login.jsp';
			}
		}

	});
}