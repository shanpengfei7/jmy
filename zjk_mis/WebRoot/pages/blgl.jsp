<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>病例管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/table_css.css" rel="stylesheet" type="text/css">

    <link href="css/datePicker.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery.date_input.pack.js"></script>

  <%@include file="/commons/header.jsp" %>
  
  
  <input type="hidden" name="r" id="r" value="${param.r }"/>
	<input type="hidden" name="q" id="q" value="${param.q }"/>
    <input type="hidden" name="n" id="n" value="${param.n }"/>
  
  <div class="all__content">
            <div class="search">
            	
            	
            	<form action="blgl?m=iBlgl" method="post">
	                <label for="ri_qi_1">首诊日期：</label>
	                <input type="text" id="ri_qi_1" name="r" class="date_picker" placeholder="点击选择日期"/>至
	                <input type="text" id="ri_qi_2" name="q" class="date_picker" placeholder="点击选择日期"/>
	
	                <label for="name">姓名：</label>
	                <input type="text" name="n" class="date_picker" id="name" />
	
	                <input type="submit" value="查询" class="button"/>
	            </form>
            </div>
            <table class="table" border="1" cellspacing="0">
                <tr class="tr1">
                    <td></td>
                    <td>用户ID</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>出生日期</td>
                    <td>归档状态</td>
                    <td>归档日期</td>
                    <td>精神科医生</td>
                    <td>测评师</td>
                    <td>联系电话</td>
                    <td>联系地址</td>
                </tr>
                <c:forEach items="${page.list }" var="jc" varStatus="s">
                	<tr class="tr${s.index%2==0?2:3 }">
                    <td><a href="blgl?m=gBlgl&id=${jc.id }">详情</a><span style="margin-left: 5px;"></span>
                    <a href="blgl?m=gjcxm&id=${jc.id }">检测项目</a><span style="margin-left: 5px;"></span>
                    <a href="blgl?m=gzlfa&id=${jc.id }">诊疗方案</a>
                    </td>
                    <td>${jc.yongHuId }</td>
                    <td>${jc.xingMing }</td>
                    <c:if test="${jc.xingBie==1 }">
                    <td>男</td>
                    </c:if>
                    <c:if test="${jc.xingBie==2 }">
                    <td>女</td>
                    </c:if>
                    <td>${jc.chuShengNian }-${jc.chuShengYue }-${jc.chuShengRi }</td>
                    <c:if test="${jc.isGuiDang }"><td>已归档</td></c:if>
                    <c:if test="${!jc.isGuiDang }"><td style="background-color: #FCF54C">未归档</td></c:if>
                    <td>${jc.gdRiQi }</td>
                    <td>${jc.zhuGuanYiShi }</td>
                    <td>${jc.cePingShi }</td>
                    <td>${jc.lianXiDianHua }</td>
                    <td>${jc.lianXiDiZhi }</td>
                    <c:if test="${s.last }">
                    	<input type="hidden" id="pageCount" value="${s.count }">
                    </c:if>
                </tr>
                </c:forEach>
                <tr class="tr4">
                    <td colspan="12">
                       第${page.getpageNow() }页，共${page.getTotalPageNumber() }页（<span id="showPageCount"></span>记录）
                        <a href="javascript:void(0);" onclick="aq('blgl?m=iBlgl&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('blgl?m=iBlgl&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('blgl?m=iBlgl&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('blgl?m=iBlgl&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                    </td>
                </tr>
            </table>
        </div>
 <script type="text/javascript">
        	$(document).ready(function(){
        		setting();
        		$("#ri_qi_1").val($("#r").val());
        		$("#ri_qi_2").val($("#q").val());
        		$("#name").val($("#n").val());
        		
        		$("#showPageCount").text($("#pageCount").val());
        		$("#change_page").change(function(){
        			var href="blgl?m=iBlgl&pn="+$("#change_page").val();
        			aq(href);
        		});
        	});
        </script>
  <%@include file="/commons/tail.jsp" %>
