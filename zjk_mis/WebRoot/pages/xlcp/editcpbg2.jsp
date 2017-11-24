<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心理测评报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  <%@include file="/commons/xlcp/header.jsp" %>
  <link href="css/xin_li_ce_ping/ce_ping_bao_gao.css" rel="stylesheet" type="text/css">
  
  <div class="all__content">
            <div class="bg__con">
                <div class="bg_title"><h1>检测报告</h1></div>
                <div>
                    <div class="bg_biao_ti">基础信息</div>
                    <div class="bg_nei_rong">
                        <table width="700" border="1" cellspacing="0">
                            <tr>
                                <td colspan="2" align="center">汉密顿焦虑量表</td>
                                <td colspan="2">测评日期：${c.riQi }</td>
                            </tr>
                            <tr>
                                <td>用户ID：${j.yongHuId }</td>
                                <td>姓名：${j.xingMing }</td>
                                <td>出生日期： ${j.chuShengNian }-${j.chuShengYue }-${j.chuShengRi }</td>
                                <td>性别：<c:if test="${j.xingBie==1 }">男</c:if><c:if test="${j.xingBie==2 }">女</c:if> </td>
                                
                            </tr>
                        </table>
                    </div>
                </div>
                <div>
                    <div class="bg_biao_ti">测评报告</div>
                    <div class="bg_nei_rong">
                        <div id="aa" style="width: 600px;height:300px;"></div>
                        <table width="700" border="1" cellspacing="0">
                            <tr>
                                <td>总分</td>
                                <td id="zong_fen">${c.result }</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <form action="bggl?m=ebg" method="post">
                <input type="hidden" name="JId" value="${j.id }">
                <input type="hidden" name="id" value="${c.id }">
                <input type="hidden" name="l" value="2">
                <input type="hidden" name="c" value="${cs }">
                <div>
                    <div class="bg_biao_ti">指导意见</div>
                    <div class="bg_nei_rong"><textarea name="yiJian" style="width: 690px;height: 200px;">${c.yiJian }</textarea></div>
                </div>
                <input type="submit" value="保存">
                </form>
            </div><div style="margin: 10px 200px;"><a href="xzbr?m=ibg&id=${j.id }"><input type="button" value="返回考试或查看报告"></a></div>
        </div>
 <script type="text/javascript" src="js/echarts.min.js"></script>
 <script type="text/javascript">
 		var m = echarts.init(document.getElementById("aa"));

	option = {
    tooltip: {
        formatter: "{a} <br/>{b} : {c}%"
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            detail: {formatter:'{value}'},
            data: [{value: $("#zong_fen").text()}]
        }
    ]
};
m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
