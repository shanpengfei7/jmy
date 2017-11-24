<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="common/css/layui.css" media="all">
	<script type="text/javascript" src="common/layui.js"></script>  
	<script type="text/javascript" src="common/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="common/js/jquery.form.js"></script>
  </head>
  
  <body>
  <div class="main">
  <div class="list">  
  ${error }
    
	  <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input name="name" value="${name }" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	     <label class="layui-form-label">手机</label>
	    <div class="layui-input-block">
	      <input name="phone" value="${phone }" lay-verify="title" autocomplete="off" placeholder="请输入手机" class="layui-input" type="text">
	    </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
	    <div class="layui-input-block">
	      <input name="email" value="${email }" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input" type="text">
	    </div>
      </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">地址</label>
	    <div class="layui-input-block">
	      <input name="address" value="${address }" lay-verify="title" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">帐号</label>
	    <div class="layui-input-block">
	      <input name="username" value="${username }" lay-verify="title" autocomplete="off" placeholder="请输入帐号" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-block">
	      <input name="password1" value="${password1 }" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">确认密码</label>
	    <div class="layui-input-block">
	      <input name="password2" value="${password2 }" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
	    </div>
	  </div>
	  <form class="layui-form" id="subfun" action="user/pic.jmy" method="post" enctype="multipart/form-data">
	  <div class="layui-form-item">
	    <label class="layui-form-label">证件照片</label>
	    <div class="layui-input-block">
	      	<input id="mypic" name="pic" class="layui-upload-file" type="file" lay-title="添加证件的图片">
	    	<img id="LAY_demo_upload" src="common/images/blank.jpg" width="200" height="200">
	    	<input type="hidden" name="picName" id="picName">
	    </div>
	  </div>
	  </form>
	  <div class="layui-form-item">
	    <label class="layui-form-label">验证码</label>
	    <div class="layui-input-block">
	      <input name="verify" value="" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">验证码</label>
	    <div class="layui-input-block">
	      <img src="user/verify.jmy" align="absmiddle" id="verify" onclick="change_code();"/>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	   <a href="javascript:sub();" class="layui-btn">立即提交</a>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
  
  </div>
  </div>
<script type="text/javascript">

	$(function() {
  		$("#mypic").change(function(){
  			$("#subfun").ajaxSubmit(function(message) {
				$("#LAY_demo_upload").attr('src',message); 
				$("#picName").val(message);
	  		});
		});
	});
	</script>
	<script type="text/javascript">
	function sub() {	
		var name = $('input[name="name"]').val();
		var phone = $('input[name="phone"]').val();
		var email = $('input[name="email"]').val();
		var address = $('input[name="address"]').val();
		var username = $('input[name="username"]').val();
		var password1 = $('input[name="password1"]').val();
		var password2 = $('input[name="password2"]').val();
		var verify = $('input[name="verify"]').val();
		var picName = $('input[name="picName"]').val();
		
		$.post("user/register.jmy", 
		
			{"name":name,"phone":phone,"email":email,"address":address,"picName":picName,
			"username":username,"password1":password1,"password2":password2,"verify":verify}, 
			
			function (data) {
				if(data==1) {
					alert("注册成功！")
					location.href="user/login.jsp";
				} else {
					alert(data);
				}
			}
		);
	}
 </script>
  <script type="text/javascript">
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
  </script>
  </body>
</html>
