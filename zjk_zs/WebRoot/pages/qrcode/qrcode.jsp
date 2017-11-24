<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
<link rel='stylesheet' type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/qrcode.min.js"></script>
</script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 二维码管理  &gt 二维码列表 &gt 二维码查看</div> -->
	<input type="hidden" id="qr" value="${param.token }" />
	
	<div id="qrcode"></div>
<script type="text/javascript">
	new QRCode('qrcode', {
		text:'http://192.168.108.201:8080/zs/show.php?token=' + document.getElementById('qr').value,
		width:200,
		height:200,
		colorDark:'#000000',
		colorLight:'#ffffff',
		correctLevel:QRCode.CorrectLevel.M
	});
</script>

  </body>
</html>
