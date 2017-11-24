<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心理测评登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/xin_li_ce_ping/xuan_ze_bing_ren.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/md5.js"></script>
  <%@include file="/commons/xlcp/header.jsp" %>
  <div class="all__content">
            <div class="br__login">
                <div class="br__box">
                    <div class="br__header">在线测评</div>
                    <div class="br__body">
                        <form action="xzbr?m=ibr" method="post" id="login_form">
                            <br>
                            <label for="yong_hu_id">检测号</label>
                            <input type="text" id="yong_hu_id" name="yong_hu_id" value="${userId }">
                            <br><br>
                            <label for="yong_hu_mi_ma">密码</label>
                            <input type="password" id="yong_hu_mi_ma" name="yong_hu_mi_ma">
                            <br><br>
                            <input type="submit" id="kai_shi_kao_shi" value="开始答题">
                        </form>
                    </div>
                    <div class="br__footer"></div>
                </div>
            </div>
        </div>
<script language="javascript">
    $(document).ready(function(){
    	$("#login_form").submit(function(){
    		document.getElementById("yong_hu_mi_ma").value = hex_md5(document.getElementById("yong_hu_mi_ma").value);
    	});
    });
</script>
  <%@include file="/commons/tail.jsp" %>
