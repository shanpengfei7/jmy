<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>后台管理中心</title>
	<link rel='stylesheet' type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>

	<script type="text/javascript" src="js/qrcode.min.js"></script>
  </head>
  
  <body>
    <style type="text/css">
	html{_overflow-y:scroll}
</style>
<div style="min-width:780px">

<div class="column">
	<dl class="dbox winbg1" id="item3">
	    <dt class="lside">
	        <div class="l">我的个人信息</div>
	    </dt>
	    <dd>
			<div class="content">
				您好，欢迎使用本系统<br/>
				<div class="clear"></div>
				<c:if test="${!empty logininformation.lasttime}">
				上次登录时间：<date:date value ="${logininformation.lasttime} "/><br/>
				</c:if>
				<c:if test="${!empty logininformation.lastip }">
				上次登录IP：${logininformation.lastip } <br/>
				</c:if>
			</div>
	    </dd>
	</dl>
	<dl class="dbox winbg2" id="item3">
	    <dt class="lside">
	        <div class="l">用码信息</div>
	    </dt>
	    <dd>
			<div class="content">				
				企业量：${statistical.enterprisecount }<br/>
				扫码总次数：${statistical.scannumber } <br/>
				总产码量：${statistical.qrcodecount } <br/>
				已用码量：${statistical.usecount } <br/>
				未用码量：${statistical.unusecount } <br/>
			</div>
	    </dd>
	</dl>
	<c:if test="${!empty enterprise.code }">
		<dl class="dbox winbg3" id="item1">
		    <dt class="lside"><span class="l">企业码:${enterprise.code }</span></dt>
		    <dd>
		        <input type="hidden" id="qr" value="${enterprise.code }" />
	   			<div id="qrcode"></div>
		    </dd>
		</dl>
	</c:if>
	<dl class="dbox winbg5" id="item1">
	    <dt class="lside"><span class="l">金蚂蚁开发团队</span></dt>
	    <dd>
	        <div class="content">
			版权所有：<a href="{:go_link('http://www.zjk-net.com/')}" target="_blank">张家口金蚂蚁科技</a><br />
			官方网站：<a href="http://www.zjk-net.com" target="_blank">http://www.zjk-net.com</a><br />
			</div>
	    </dd>
	</dl>

</div>


</div>
<script type="text/javascript">
	new QRCode('qrcode', {
		text:document.getElementById('qr').value,
		width:200,
		height:200,
		colorDark:'#000000',
		colorLight:'#ffffff',
		correctLevel:QRCode.CorrectLevel.M
	});
</script>
  </body>
</html>
