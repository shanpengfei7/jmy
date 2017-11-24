//function change_code(){
//	$("#vcode").attr("src",verifyUrl+'#'+Math.random());
//	return false;
//}
//登录验证  1为空   2为错误

$(function(){
	
	var $msg = $('.msg');	
	var username=$("input[name='username']");
	var password = $("input[name='password']");
	var verify = $("input[name='verify']");
	$("#login").submit(function(){
		
		if($.trim(username.val())==''){
			$msg.html("<span class='error'>用户名不能为空</span>");
			username.focus();
			return false;
		}else if($.trim(password.val())=='') {			
			$msg.html("<span class='error'>密码不能为空</span>");
			password.focus();
			return false;
		}else if($.trim(verify.val())==''){
			$msg.html("<span class='error'>验证码不能为空</span>");
			verify.focus();
			return false;
		}else{
			$msg.html(' ');
			return true;
		}
		
		return false;
	});



	//验证用户名
	$("input[name='username']").blur(function(){
		if($.trim(username.val())==''){
			$msg.html("<span class='error'>用户名不能为空</span>");
			username.focus();
			return ;
		}else {			
			$msg.html("");
		}
		
	});
	//验证密码
	$("input[name='password']").blur(function(){
		var username=$("input[name='username']");
		if($.trim(password.val())==''){
			$msg.html("<span class='error'>密码不能为空</span>");
			//password.focus();
			return ;
		}else {			
			$msg.html("");
		}
		
	});

//	$("input[name='code']").focus(function(){
//        change_code();
//    });

});


//==============================后台==============================
function change_code(){    
   var imgSrc = $("#verify");    
   var src = imgSrc.attr("src");    
   imgSrc.attr("src",chgUrl(src));    
}    
//时间戳    
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳    
function chgUrl(url){    
   var timestamp = (new Date()).valueOf();    
   urlurl = url.substring(0,17);    
   if((url.indexOf("&")>=0)){    
       urlurl = url + "×tamp=" + timestamp;    
   }else{    
       urlurl = url + "?timestamp=" + timestamp;    
   }    
   return urlurl;    
}    


