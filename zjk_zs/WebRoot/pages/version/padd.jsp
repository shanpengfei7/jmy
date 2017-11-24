<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 产品型号申请  &gt 型号管理</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="version-padd.php">
		<input type="hidden" name="pid" value="${product.id }">
		<dl>
			<dt> 型号名称：</dt>
			<dd>
				<input type="text" name="tradename" class="inp_large" value="${product.name }" readonly="readonly" />
			</dd>
		</dl>
		<dl>
			<dt> 名称：</dt>
			<dd>
				<input type="text" name="tradename" class="inp_large" value="${product.tradename }" readonly="readonly" />
			</dd>
		</dl>
		<dl>
			<dt> 属性名称：</dt>
			<dd>
				<input type="text" name="name" class="inp_large" />
			</dd>
		</dl>
		<dl>
			<dt> 属性值：</dt>
			<dd>
				<input type="text" name="value" class="inp_large" />
			</dd>
		</dl>
		<dl>
			<dt> 描述信息：</dt>
			<dd>
				<textarea rows="" cols="" name="description"></textarea>
			</dd>
		</dl>
		
		<div class="form_b">		
			<input type="reset" class="btn_green" id="" value="重置"> <input type="submit" class="btn_blue" id="" value="提 交"> 
			${error } 
		</div>
	   </form>
	</div>
</div>
  </body>
</html>
