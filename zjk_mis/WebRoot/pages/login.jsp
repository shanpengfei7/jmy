<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    <link rel="icon" href="W-MIS.ico" type="image/x-icon" />   
    <link rel="shortcut icon" href="W-MIS.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/login.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
<div class="up">
    <div class="login">
        <table class="table" border="0" cellspacing="0">
            <tr>
                <td class="td4" colspan="3">
                    <h1>欢迎登录W-MIS系统</h1>
                </td>
            </tr>
            <tr class="tr1">
                <td class="td2">
					<form action="login?m=lgn" method="post" class="back" id="login_form">
						<label>用户名：</label>
						<br/>
						<input type="text" class="text" value="" name="number" placeholder="请输入用户名"/>
						<br/>
						<label>密码：</label>
						<br/>
						<input type="password" class="text" value=""  id="password" placeholder="请输入密码"/>
						<input type="hidden" name="password" id="passwords"/>
						<br/> <br/>                    
                        <input type="submit" value="登录" class="button">
                    </form>
                    <c:if test="${!empty error }">
	                    	<span style="color: red;">${error }</span>
					</c:if>
                </td>
                <td class="td3">
                    <img src="image/login.jpg" style="margin-left: 15px"/>
                    <br/>
                    <img src="image/login.jpg" width="50px" height="55px" style="margin-left:-30px"/>
                    <br/>
                    <img src="image/login.jpg" width="30px" height="33px" style="margin-left: -70px">
                </td>
            </tr>
			
        </table>
    </div>
</div>
<div class="down"></div>
<style>
.footer{
	position: fixed !important;
	bottom: 30px;
	_position: absolute;
	_top: expression_r(eval_r(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight));
    text-align: center;
    font-size: 12px;
    color:white;
}
</style>
<div class="footer" id="footer_footer">
 <p>Copyrights  &copy; 2016-2018 All Rights Reserved. 河北张家口医院 版权所有 如有转载或引用本站文章涉及版权问题，请与我们联系 <br/>
      医院地址:河北省张家口市纬一路A110号      邮编:760000      冀ICP备 05004666   E-Mail:w-mis@163.com </p>
</div>
<script type="text/javascript">
	$("#footer_footer").css("left", $(window).width()/2-350);
</script>
<script language="javascript">
    $(document).ready(function(){
    	$("#login_form").submit(function(){
    		document.getElementById("passwords").value = hex_md5(document.getElementById("password").value);
    	});
    });
    $(document).ready(function(){
    	$("body").css("height", $(window).height());
    });
</script>
</body>
</html>