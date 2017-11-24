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
                                <td colspan="2" align="center">简明精神病量表</td>
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
                                <td>因子</td>
                                <td>分数</td>
                            </tr>
                            <tr>
                                <td>总分</td>
                                <td>${c.sum }</td>
                            </tr>
                            <tr>
                                <td>焦虑忧郁</td>
                                <td id="jiao_lv">${c.jiaoLvYouLv }</td>
                            </tr>
                            <tr>
                                <td>缺乏活力</td>
                                <td id="que_fa">${c.queFaHuoLi }</td>
                            </tr>
                            <tr>
                                <td>思维障碍</td>
                                <td id="si_wei">${c.siWeiZhangAi }</td>
                            </tr>
                            <tr>
                                <td>激活性</td>
                                <td id="ji_huo">${c.jiHuoXing }</td>
                            </tr>
                            <tr>
                                <td>敌对猜疑</td>
                                <td id="di_dui">${c.diDuiCaiYi }</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div>
                </div>
            </div><div style="margin: 10px 200px;"><a href="xzbr?m=ibg&id=${j.id }"><input type="button" value="返回考试或查看报告"></a></div>
        </div>
 <script type="text/javascript" src="js/echarts.min.js"></script>
 <script type="text/javascript">
 		var m = echarts.init(document.getElementById("aa"));

	option = {
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
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
            data : ['焦虑忧郁', '缺乏活力', '思维障碍', '激活性', '敌对猜疑'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'直接访问',
            type:'bar',
            barWidth: '60%',
            data:[$("#jiao_lv").text(),$("#que_fa").text(),$("#si_wei").text(),$("#ji_huo").text(),$("#di_dui").text()]
        }
    ]
};
m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
