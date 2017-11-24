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
                                <td colspan="2" align="center">90项症状清单</td>
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
                                <td>原始分数</td>
                                <td>平均分</td>
                                <td>参考诊断</td>
                                <td>常模(M±SD)</td>
                            </tr>
                            <tr>
                                <td>总分</td>
                                <td>${c.sum }</td>
                                <td></td>
                                <td></td>
                                <td>129.96±38.76</td>
                            </tr>
                            <tr>
                                <td>总均分</td>
                                <td>${c.ave }</td>
                                <td></td>
                                <td></td>
                                <td>1.44±0.43</td>
                            </tr>
                            <tr>
                                <td>敌对</td>
                                <td>${c.diDui0 }</td>
                                <td id="di_dui">${c.diDui }</td>
                                <td>${c.belongDiDui0 }</td>
                                <td>1.48±0.56</td>
                            </tr>
                            <tr>
                                <td>焦虑</td>
                                <td>${c.jiaoLv0 }</td>
                                <td id="jiao_lv">${c.jiaoLv }</td>
                                <td>${c.belongJiaoLv0 }</td>
                                <td>1.39±0.43</td>
                            </tr>
                            <tr>
                                <td>精神病性</td>
                                <td>${c.jingShenBing0 }</td>
                                <td id="jing_shen">${c.jingShenBing }</td>
                                <td>${c.belongJingShenBing0 }</td>
                                <td>1.29±0.42</td>
                            </tr>
                            <tr>
                                <td>恐怖</td>
                                <td>${c.kongBu0 }</td>
                                <td id="kong_bu">${c.kongBu }</td>
                                <td>${c.belongKongBu0 }</td>
                                <td>1.23±0.41</td>
                            </tr>
                            <tr>
                                <td>偏执</td>
                                <td>${c.pianZhi0 }</td>
                                <td id="pian_zhi">${c.pianZhi }</td>
                                <td>${c.belongPianZhi0 }</td>
                                <td>1.43±0.57</td>
                            </tr>
                            <tr>
                                <td>其他</td>
                                <td>${c.qiTa0 }</td>
                                <td id="qi_ta">${c.qiTa }</td>
                                <td>${c.belongQiTa0 }</td>
                                <td>1.40±0.50</td>
                            </tr>
                            <tr>
                                <td>强迫症状</td>
                                <td>${c.qiangPoZheng0 }</td>
                                <td id="qiang_po">${c.qiangPoZheng }</td>
                                <td>${c.belongQiangPoZheng0 }</td>
                                <td>1.62±0.58</td>
                            </tr>
                            <tr>
                                <td>躯体化</td>
                                <td>${c.quTiHua0 }</td>
                                <td id="qu_ti">${c.quTiHua }</td>
                                <td>${c.belongQuTiHua0 }</td>
                                <td>1.37±0.48</td>
                            </tr>
                            <tr>
                                <td>人际关系</td>
                                <td>${c.renJiGuanXi0 }</td>
                                <td id="ren_ji">${c.renJiGuanXi }</td>
                                <td>${c.belongRenJiGuanXi0 }</td>
                                <td>1.65±0.51</td>
                            </tr>
                            <tr>
                                <td>抑郁</td>
                                <td>${c.yiYu0 }</td>
                                <td id="yi_yu">${c.yiYu }</td>
                                <td>${c.belongYiYu0 }</td>
                                <td>1.50±0.59</td>
                            </tr>
                            
                        </table>
                    </div>
                </div>
                <div>
                    <div class="bg_biao_ti">指导意见</div>
                    <div class="bg_nei_rong">${c.belongQuTiHua }</div><br>
                    <div class="bg_nei_rong">${c.belongQiangPoZheng }</div><br>
                    <div class="bg_nei_rong">${c.belongRenJiGuanXi }</div><br>
                    <div class="bg_nei_rong">${c.belongYiYu }</div><br>
                    <div class="bg_nei_rong">${c.belongJiaoLv }</div><br>
                    <div class="bg_nei_rong">${c.belongDiDui }</div><br>
                    <div class="bg_nei_rong">${c.belongKongBu }</div><br>
                    <div class="bg_nei_rong">${c.belongPianZhi }</div><br>
                    <div class="bg_nei_rong">${c.belongJingShenBing }</div><br>
                    <div class="bg_nei_rong">${c.belongQiTa }</div><br>
                </div>
            </div><div style="margin: 10px 200px;">
            <a href="xzbr?m=ibg&id=${j.id }"><input type="button" value="返回考试或查看报告"></a>
            <a href="bggl?m=iebg&id=${j.id }&c=${c.ciShu }&l=5"><input type="button" value="修改报告"></a>
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
                var res = [{text:'敌对',max:4}, {text:'焦虑',max:4}, {text:'精神病性',max:4},
                            {text:'恐怖',max:4}, {text:'偏执',max:4}, {text:'其它',max:4},
                            {text:'强迫症状',max:4}, {text:'躯体化',max:4}, {text:'人际关系',max:4}, {text:'抑郁',max:4}];
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
                    value:[$("#di_dui").text(), $("#jiao_lv").text(), $("#jing_shen").text(), 
                    		$("#kong_bu").text(), $("#pian_zhi").text(), $("#qi_ta").text(), 
                    		$("#qiang_po").text(), $("#qu_ti").text(), $("#ren_ji").text(),$("#yi_yu").text(), ]
                }
            ]
        }
    ]
};
m.setOption(option);
 </script>
  <%@include file="/commons/tail.jsp" %>
