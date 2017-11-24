<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>脑电报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <%@include file="/commons/xlcp/header.jsp" %>
    <c:if test="${!empty h.pic1 }">
    	<div style="float: left;">
    		<a href="ndbg?m=ipic&id=${h.jiChuXinXiId }&cs=${h.ciShu }&pic=1" target="_blank">
    			<img src="img/naodian/${h.pic1 }" style="width: 400px;height: 200px;" />
    		</a>
    	</div>
    </c:if>
    <c:if test="${!empty h.pic2 }">
    	<div style="float: left;">
    		<a href="ndbg?m=ipic&id=${h.jiChuXinXiId }&cs=${h.ciShu }&pic=2" target="_blank">
    			<img src="img/naodian/${h.pic2 }" style="width: 400px;height: 200px;" />
    		</a>
    	</div>
    </c:if>
    <c:if test="${!empty h.pic3 }">
    	<div style="float: left;">
    		<a href="ndbg?m=ipic&id=${h.jiChuXinXiId }&cs=${h.ciShu }&pic=3" target="_blank">
    			<img src="img/naodian/${h.pic3 }" style="width: 400px;height: 200px;" />
    		</a>
    	</div>
    </c:if>
    <c:if test="${!empty h.pic4 }">
    	<div style="float: left;">
    		<a href="ndbg?m=ipic&id=${h.jiChuXinXiId }&cs=${h.ciShu }&pic=4" target="_blank">
    			<img src="img/naodian/${h.pic4 }" style="width: 400px;height: 200px;" />
    		</a>
    	</div>
    </c:if>
    <c:if test="${!empty h.pic5 }">
    	<div style="float: left;">
    		<a href="ndbg?m=ipic&id=${h.jiChuXinXiId }&cs=${h.ciShu }&pic=5" target="_blank">
    			<img src="img/naodian/${h.pic5 }" style="width: 400px;height: 200px;" />
    		</a>
    	</div>
    </c:if>
  <c:if test="${empty h.pic1 }">
  	  最多可选择5个,多选无效！
    <form action="ndbg?m=sbg" method="post" enctype="multipart/form-data">
    	<input type="hidden" value="${jid }" name="jid" />
    	<input type="hidden" value="${cs }" name="cishu" />
    	<input type="file" multiple="multiple" name="pic" /> 
    	<input type="submit" value="提交" onclick="upload();">
    </form>
  </c:if>
  	<c:if test="${!empty h.pic1 }">
  	<a href="pages/baogao/ndbgEdit.jsp?id=${h.id }&cs=${h.ciShu }&jid=${h.jiChuXinXiId }">重新上传</a>
  </c:if>
   <%@include file="/commons/tail.jsp" %>
