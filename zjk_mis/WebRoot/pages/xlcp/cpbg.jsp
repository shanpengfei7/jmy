<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测评报告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  <%@include file="/commons/xlcp/header.jsp" %>
  <link href="css/xin_li_ce_ping/ce_ping_bao_gao.css" rel="stylesheet" type="text/css">
  
  <div class="all__content">
            <div class="bg__con">
                <div class="bg_title"><h1>工人医院心理测评报告</h1></div>
                <div>
                    <div class="bg_biao_ti">基础信息</div>
                    <div class="bg_nei_rong">
                        <table width="700" border="1" cellspacing="0">
                            <tr>
                                <td colspan="2" align="center">中医体质分析量表</td>
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
                        <!-- <img src="image/s.png"> -->
                        <div id="aa" style="width: 600px;height:400px;"></div>
                        <table width="700" border="1" cellspacing="0">
                            <tr>
                                <td>平和质</td>
                                <td id="pingHe">${c.pingHe }</td>
                                <td>气虚质</td>
                                <td id="qiXu">${c.qiXu }</td>
                                <td>阳虚质</td>
                                <td id="yangXu">${c.yangXu }</td>
                            </tr>
                            <tr>
                                <td>阴虚质</td>
                                <td id="yinXu">${c.yinXu }</td>
                                <td>痰湿质</td>
                                <td id="tanShi">${c.tanShi }</td>
                                <td>湿热质</td>
                                <td id="shiRe">${c.shiRe }</td>
                            </tr>
                            <tr>
                                <td>淤血质</td>
                                <td id=yuXue>${c.yuXue }</td>
                                <td>气郁质</td>
                                <td id="qiYu">${c.qiYu }</td>
                                <td>特禀质</td>
                                <td id="teBing">${c.teBing }</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div>
                    <div class="bg_biao_ti">指导意见</div>
                    <div class="bg_nei_rong">${c.yiJian }</div>
                </div>
                <div>
                    <div class="bg_biao_ti">建议</div>
                    <div class="bg_nei_rong">${c.jianYi }</div>
                </div>
                <div>
                    <div class="bg_biao_ti">膳食</div>
                    <div class="bg_nei_rong">${c.yaoShan }</div>
                </div>
            </div>
        </div>
 <script type="text/javascript" src="js/echarts.min.js"></script>
 <script type="text/javascript">
 		var m = echarts.init(document.getElementById("aa"));

	option = {
    tooltip: {
        trigger: 'axis'
    },
    radar: [
        {
            indicator: (function (){
                var res = [{text:'平和质',max:100}, {text:'气虚质',max:100}, {text:'阳虚质',max:100},
                            {text:'阴虚质',max:100}, {text:'痰湿质',max:100}, {text:'湿热质',max:100},
                            {text:'淤血质',max:100}, {text:'气郁质',max:100}, {text:'特禀质',max:100}];
                return res;
            })(),
            center: ['60%','50%'],
            radius: 80
        }
    ],
    series: [
        {
            type: 'radar',
            radarIndex: 0,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data: [
                {
                    value:[$("#pingHe").text(), $("#qiXu").text(), $("#yangXu").text(), 
                    		$("#yinXu").text(), $("#tanShi").text(), $("#shire").text(), 
                    		$("#yuXue").text(), $("#qiYu").text(), $("#teBing").text(), ]
                }
            ]
        }
    ]
};
m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
