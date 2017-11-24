<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基础信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  <%@include file="/commons/header.jsp" %>
  <input type="hidden" id="nav" value="基础信息">
  
    <input type="hidden" name="r" id="r" value="${param.r }"/>
	<input type="hidden" name="q" id="q" value="${param.q }"/>
    <input type="hidden" name="n" id="n" value="${param.n }"/>

  <div class="all__content">
            <div class="search">
            <form action="jcxx?m=iJcxx" method="post">
                <label for="ri_qi_1">首诊日期：</label>
                <input type="text" id="ri_qi_1" name="r" class="date_picker" placeholder="点击选择日期"/>至
                <input type="text" id="ri_qi_2" name="q" class="date_picker" placeholder="点击选择日期"/>

                <label for="name">姓名：</label>
                <input type="text" name="n" class="date_picker" id="name" />

                <input type="submit" value="查询" class="button"/>
            
                <a href="jcxx?m=iJcxxAdd"><input type="button" value="添加患者" class="button"/></a>
                <a href="jcxx?m=iHtbrAdd"><input type="button" value="既往患者" class="button"/></a>
            </form>
            </div>
            <table class="table" border="1" cellspacing="0">
                <tr class="tr1">
                    <td></td>
                    <td>用户ID</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>精神科医生</td>
                    <td>测评师</td>
                    <td>专科医生</td>
                    <td>首诊日期</td>
                    <td>联系电话</td>
                    <td>联系地址</td>
                </tr>
                <c:forEach items="${page.list }" var="jc" varStatus="s">
                	<tr class="tr${s.index%2==0?2:3 }">
                    <td><a href="jcxx?m=gJcxx&id=${jc.id }&z=b">编辑</a><span style="margin-left: 10px;"></span><a href="jcxx?m=gJcxx&id=${jc.id }&z=x">详情</a></td>
                    <td>${jc.yongHuId }</td>
                    <td>${jc.xingMing }</td>
                    <c:if test="${jc.xingBie==1 }">
                    <td>男</td>
                    </c:if>
                    <c:if test="${jc.xingBie==2 }">
                    <td>女</td>
                    </c:if>
                    <td>${jc.chuShengNian }-${jc.chuShengYue }-${jc.chuShengRi }</td>
                    <td>${jc.zhuGuanYiShi }</td>
                    <td>${jc.cePingShi }</td>
                    <td>${jc.zhuanKeYiSheng }</td>
                    <td>${jc.riQi }</td>
                    <td>${jc.lianXiDianHua }</td>
                    <td>${jc.lianXiDiZhi }</td>
                    <c:if test="${s.last }">
                    	<input type="hidden" id="pageCount" value="${s.count }">
                    </c:if>
                </tr>
                </c:forEach>
                <tr class="tr4">
                    <td colspan="11">
                        第${page.getpageNow() }页，共${page.getTotalPageNumber() }页（<span id="showPageCount"></span>记录）
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iJcxx&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iJcxx&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iJcxx&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iJcxx&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                    </td>
                </tr>
            </table>
        </div>
        <script type="text/javascript">
        	$(document).ready(function(){
        		$("#ri_qi_1").val($("#r").val());
        		$("#ri_qi_2").val($("#q").val());
        		$("#name").val($("#n").val());
        		
        		$("#showPageCount").text($("#pageCount").val());
        		$("#change_page").change(function(){
        			var href="jcxx?m=iJcxx&pn="+$("#change_page").val();
        			aq(href);
        		});
        	});$(document).ready(function(){
	setting();
});
        </script>
  <%@include file="/commons/tail.jsp" %>
