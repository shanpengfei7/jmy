<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
	 <link href="css/insert.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 产品下线  &gt 产品下线</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="product-add.php">
		<input type="hidden" name="id" value="${id }">
		<dl>
			<dt> 产品宣传类信息：</dt>
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
<textarea rows="" cols="" id="info" style="display: none">${product.information }</textarea>
<script type="text/javascript">
	var ue1 = UE.getEditor('information', {
		initialContent:document.getElementById("info").value
	});
</script>
  </body>
</html>
