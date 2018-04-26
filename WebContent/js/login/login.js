function login(){
	var login_name = $("#login_name").val();
	var pass_word = $("#pass_word").val();
    $.post(
    		"login/loginByNameAndPassword",
    		{
    			loginName:login_name,
    			passWord:pass_word
    		},function(data,status){
    			window.location.href=data.url;
    			alert('提示：' + data.message);

//    			$.messager.alert('提示',data.message);
    		},null)
//     $.ajax({
//    	 url: "login/loginByNameAndPassword",
//    	 type: "POST",
//    	 dataType: "json",
//    	 data: {
// 			loginName:login_name,
//			passWord:pass_word
//		},
//		success: function (data, status) {
//			window.location.href=data.url;
//			$.messager.alert('提示',data.message);
//		},
//		error: function (request, status, errorThrown) {
//		    // 通常 textStatus 和 errorThrown 之中
//		    // 只有一个会包含信息
//		    this; // 调用本次AJAX请求时传递的options参数
//		}
//     })
}