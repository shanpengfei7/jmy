<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>企业信息初始化</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
	   <link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/calendar.config.js"></script>
  </head>
  
  <body>
    <div class="main">
   <!--  <div class="pos">当前位置 | 企业管理 &gt 企业添加</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="enterprise-add.php">
		<input type="hidden" name="id" value="${enterprise.id }">
		<input type="hidden" name="isconnect" value="${isconnect }">
		<input type="hidden" name="operate" value="${operate }">
		<dl>
			<dt> 企业名称：</dt>
			<dd>
				<input type="text" name="company" class="inp_large" value="${enterprise.company }" />
			</dd>
		</dl>
		<dl>
			<dt> 企业地址：</dt>
			<dd>
				<input type="text" name="address" class="inp_large" value="${enterprise.address }" />
			</dd>
		</dl>
		
		<dl>
			<dt> 法人姓名：</dt>
			<dd>
				<input type="text" name="name" class="inp_large" value="${enterprise.name }" />
			</dd>
		</dl>
		<dl>
			<dt> 法人电话：</dt>
			<dd>
				<input type="text" name="phonenumber" class="inp_large" value="${enterprise.phonenumber }" />
				<textarea rows="" cols="" id="info" style="display: none">${enterprise.information }</textarea>
			</dd>
		</dl>
		<dl>
			<input type="hidden" value="${enterprise.role }" id="role" name="role" />
			<dt> 企业类型：</dt>
			<dd>
				<input type="checkbox" id="role1" />厂家 
				<input type="checkbox" id="role2" />代理商
				<input type="checkbox" id="role4" />经销商
			</dd>
		</dl>
		<dl>
			<dt> 企业信息：</dt>
			<dd>
				<script id="information" name="information" type="text/plain" style="width:1024px;height:100px;"></script>
			</dd>
		</dl>
		
		<div class="form_b">		
			<input type="reset" class="btn_green" id="" value="重置"> <input type="submit" class="btn_blue" id="" value="提 交"> 
			${error } 
		</div>
	   </form>
	</div>
</div>
<script type="text/javascript">
	var ue1 = UE.getEditor('information', {
		initialContent:document.getElementById("info").value
	});
	var role = $("#role").val();
	if(role == 1) {
		$("#role1").attr("checked", "checked");
	} else if(role == 2) {
		$("#role2").attr("checked", "checked");
	} else if(role == 3) {
		$("#role1").attr("checked", "checked");
		$("#role2").attr("checked", "checked");
	} else if(role == 4) {
		$("#role4").attr("checked", "checked");
	} else if(role == 5) {
		$("#role1").attr("checked", "checked");
		$("#role4").attr("checked", "checked");
	} else if(role == 6) {
		$("#role2").attr("checked", "checked");
		$("#role4").attr("checked", "checked");
	} else if(role == 7) {
		$("#role1").attr("checked", "checked");
		$("#role2").attr("checked", "checked");
		$("#role4").attr("checked", "checked");
	}
	$("#form_do").submit(function(){
		var role = 0;
		if($("#role1").attr("checked") == "checked" && $("#role2").attr("checked") == "checked" && $("#role4").attr("checked") == "checked"){
			role = 7;
		}else if($("#role1").attr("checked") == "checked" && $("#role2").attr("checked") == "checked"){
			role = 3;
		}else if($("#role1").attr("checked") == "checked" && $("#role4").attr("checked") == "checked"){
			role = 5;
		}else if($("#role2").attr("checked") == "checked" && $("#role4").attr("checked") == "checked"){
			role = 6;
		}else if($("#role1").attr("checked") == "checked"){
			role = 1;
		}else if($("#role2").attr("checked") == "checked"){
			role = 2;
		}else if($("#role4").attr("checked") == "checked"){
			role = 4;
		}
		if(role == 0) {
			alert("请选择企业类型！");
			return false;
		}
		$("#role").val(role);
	});
</script>
  </body>
</html>

