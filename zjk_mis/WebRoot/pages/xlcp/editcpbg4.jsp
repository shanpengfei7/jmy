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
                                <td colspan="2" align="center">WCPA躯体症状分类量表</td>
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
                                <td>测试结果</td>
                                <td>原始分</td>
                                <td>因子分</td>
                            </tr>
                            <tr>
                                <td>抑制性躯体症状：</td>
                                <td>${c.yiZhia0 }</td>
                                <td id="yi_zhi">${c.yiZhia }</td>
                            </tr>
                            <tr>
                                <td>激惹性躯体症状：</td>
                                <td>${c.jiReb0 }</td>
                                <td id="ji_re">${c.jiReb }</td>
                            </tr>
                            <tr>
                                <td>生物性躯体症状：</td>
                                <td>${c.shengWuc0 }</td>
                                <td id="sheng_wu">${c.shengWuc }</td>
                            </tr>
                            <tr>
                                <td>想象性躯体症状：</td>
                                <td>${c.xiangXiange0 }</td>
                                <td id="xiang_xiang">${c.xiangXiange }</td>
                            </tr>
                            <tr>
                                <td>认知性躯体症状：</td>
                                <td>${c.renZhid0 }</td>
                                <td id="ren_zhi">${c.renZhid }</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <form action="bggl?m=ebg" method="post">
                <input type="hidden" name="JId" value="${j.id }">
                <input type="hidden" name="id" value="${c.id }">
                <input type="hidden" name="l" value="4">
                <input type="hidden" name="c" value="${cs }">
                <div>
                    <div class="bg_biao_ti">指导意见</div>
                    <div class="bg_nei_rong">主要症状：<textarea name="belong1" rows="" cols="" style="width: 690px;height: 100px;">${c.belong1 }</textarea></div>
                    <div class="bg_nei_rong">次要症状：<textarea name=belong2 rows="" cols="" style="width: 690px;height: 100px;">${c.belong2 }</textarea></div><br>
                    <div class="bg_nei_rong"><textarea name="yiJian1" rows="" cols="" style="width: 690px;height: 100px;">${c.yiJian1 }</textarea></div>
                    <div class="bg_nei_rong"><textarea name="yiJian2" rows="" cols="" style="width: 690px;height: 100px;">${c.yiJian2 }</textarea></div>
                </div>
                <input type="submit" value="保存">
                </form>
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
            data : ['抑制性', '激惹性', '生物性', '想象性', '认知性'],
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
            data:[$("#yi_zhi").text(),$("#ji_re").text(),$("#sheng_wu").text(),$("#xiang_xiang").text(),$("#ren_zhi").text()]
        }
    ]
};
m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
