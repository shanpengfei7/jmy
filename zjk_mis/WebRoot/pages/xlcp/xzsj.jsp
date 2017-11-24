<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择试卷或报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/xin_li_ce_ping/xuan_ze_shi_juan.css" rel="stylesheet" type="text/css">
<style type="text/css">
	h3{
		color: red;
	}
</style>
  <%@include file="/commons/xlcp/header.jsp" %>
  <div class="all__content">
            <div class="sj__select">
                <div class="sj__box">
                    <div class="sj__header">选择试卷</div>
                    <div class="br__body">
                    <c:forEach items="${xl }" var="x" varStatus="s">
                    	<div class="sj_row">
                            <div>${s.count }.${x.liangBiao.mingCheng }</div>
                            <div class="sj_desc">
                            	<c:if test="${x.liangBiao.jianJie!=null }">
                            	<h3>简介：</h3>
                            		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            		${x.liangBiao.jianJie }</p>
                            	</c:if>
                            	<c:if test="${x.liangBiao.yaoQiu!=null }">
                            	<h3>要求：</h3>
                            		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            		${x.liangBiao.yaoQiu }</p>
                            	</c:if>
                            	<c:if test="${x.liangBiao.shiJian!=null }">
                            	<h3>时间：</h3>
                            		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            		${x.liangBiao.shiJian }</p>
                            	</c:if>
                            	<c:if test="${x.liangBiao.zhuYiShiXiang!=null }">
                            	<h3>注意事项</h3>
                            		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            		${x.liangBiao.zhuYiShiXiang }</p>
                            	</c:if>
                            	<c:if test="${x.liangBiao.yingYongPingJia!=null }">
                            	<h3>应用评价：</h3>
                            		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            		${x.liangBiao.yingYongPingJia }</p>
                            	</c:if>
                            </div>
                            <c:if test="${!x.isJianCe }">
                            	<div class="sj_btn">
                            		<form action="kaoshi?m=gt" method="post">
                            			<input type="hidden" value="${x.liangBiao.id }" name="t" />
                            			<input type="hidden" value="${cs }" name="c" />
                            			<input type="hidden" value="${jId }" name="j" />
                            			<input type="submit" value="开始答题">
                            		</form>
                            	</div>
                            </c:if>
                            <c:if test="${x.isJianCe }">
                            	<div class="sj_btn"><a href="bggl?m=gbg&j=${jId }&c=${cs }&l=${x.liangBiao.id }"><input type="button" value="查看报告"></a></div>
                            </c:if>
                            <div style="clear: both"></div>
                        </div>
                    </c:forEach>
                    </div>
                    <div class="sj__footer"></div>
                </div>
            </div>
        </div>
  <%@include file="/commons/tail.jsp" %>
