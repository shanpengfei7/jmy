<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>操作失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	window.onload = function ()
	{
		var oCountDown = document.getElementById("countdown");
		var aInput = oCountDown.getElementsByTagName("input")[0];
		var timer = null;
		aInput.onclick = function ()
		{
			this.className == "" ? (timer = setInterval(updateTime, 1000), updateTime()) : (clearInterval(timer));
			this.className = this.className == '' ? "cancel" : '';
		};
		function format(a)
		{
			return a.toString().replace(/^(\d)$/,'0$1');
		}
		function updateTime ()
		{
			var aSpan = oCountDown.getElementsByTagName("span");
			var oRemain = aSpan[0].innerHTML.replace(/^0/,'') * 60 + parseInt(aSpan[1].innerHTML.replace(/^0/,''));
			if(oRemain <= 0)
			{
				clearInterval(timer);
				return;
			}
			oRemain--;
			aSpan[0].innerHTML = format(parseInt(oRemain / 60));
			oRemain %= 60;
			aSpan[1].innerHTML = format(parseInt(oRemain));
		}
		// 加上此句即可。
		aInput.click();
		aInput.style.display = "none";
	};
	</script>
  </head>
  
  <body>
   <center>
   		<h1> 操作失败</h1>
   		<div align="center" id="countdown">
	<a href="${nextUrl }"><h4>过<span>00</span><span>03</span>秒自动跳转</h4></a>
	<br>
	<input type="button" value="开始" style="display: none" />
	</div>
   </center>
   <%response.setHeader("refresh", "3;URL=" + request.getAttribute("nextUrl")); %>
  </body>
</html>
