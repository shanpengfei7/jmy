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
                                <td colspan="2" align="center">艾森克个性测验</td>
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
                                <td>指标</td>
                                <td>原始分</td>
                                <td>标准分</td>
                            </tr>
                            <tr>
                                <td>外倾-内倾型</td>
                                <td>${c.ey }</td>
                                <td id="e">${c.e }</td>
                            </tr>
                            <tr>
                                <td>神经质</td>
                                <td>${c.ny }</td>
                                <td id="n">${c.n }</td>
                            </tr>
                            <tr>
                                <td>精神质</td>
                                <td>${c.py }</td>
                                <td id="p">${c.p }</td>
                            </tr>
                            <tr>
                                <td>掩饰性</td>
                                <td>${c.ly }</td>
                                <td id="l">${c.l }</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div>
                    <div class="bg_biao_ti">指导意见</div>
                    <div class="bg_nei_rong">${c.belongE }</div>
                    <div class="bg_nei_rong">${c.yiJianE }</div><br>
                    <div class="bg_nei_rong">${c.belongN }</div>
                    <div class="bg_nei_rong">${c.yiJianN }</div><br>
                    <div class="bg_nei_rong">${c.belongP }</div>
                    <div class="bg_nei_rong">${c.yiJianP }</div><br>
                    <div class="bg_nei_rong">${c.belongL }</div>
                    <div class="bg_nei_rong">${c.yiJianL }</div><br>
                </div>
            </div><div style="margin: 10px 200px;">
            <a href="xzbr?m=ibg&id=${j.id }"><input type="button" value="返回考试或查看报告"></a>
            <a href="bggl?m=iebg&id=${j.id }&c=${c.ciShu }&l=6"><input type="button" value="修改报告"></a>
            </div>
        </div>
 <script type="text/javascript" src="js/echarts.min.js"></script>
 <script type="text/javascript">
 		var m = echarts.init(document.getElementById("aa"));

option = {
        tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['艾森克个性测验']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['外倾-内倾型','神经质','精神质','掩饰性']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'邮件营销',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[$("#e").text(), $("#n").text(), $("#p").text(), $("#l").text()]
        }
    ]
};

m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
