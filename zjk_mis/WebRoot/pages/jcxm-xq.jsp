<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>检测项目详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/cepingshi/ji_chu_xin_xi_tian_jia.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/cepingshi/jian_ce_xiang_mu_tian_jia.js"></script>
    <link href="css/modal.css" rel="stylesheet" type="text/css" />
    <link href="css/cepingshi/shou_zhen_xin_xi.css" rel="stylesheet" type="text/css" />
    <link href="css/table_css.css" rel="stylesheet" type="text/css">

    <link href="css/datePicker.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery.date_input.pack.js"></script>

  <%@include file="/commons/header.jsp" %>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="js/jcxm-xe.js"></script>
  <script type="text/javascript" src="js/jcxm.js"></script>
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  <div class="all__content">
            <div style="margin-left: 20px">
                <label class=text_3>首诊信息</label><br>
                <label for="yong_hu_id">用户ID：</label>
                <input type="text" name="yong_hu_id" id="yong_hu_id" value="${j.yongHuId }" readonly="readonly" />
                <label for="ri_qi" class="text_1">首诊日期：</label>
                <input type="datetime-local " name="ri_qi" id="ri_qi" value="${j.riQi }" readonly="readonly" />
                <label for="men_zhen_hao" class="text_1"> 门诊号：</label>
                <input type="text" name="men_zhen_hao" id="men_zhen_hao" value="${j.menZhenHao }" readonly="readonly" />
                <label for="bing_an_hao" class="text_1">病案号：</label>
                <input type="text" name="bing_an_hao" id="bing_an_hao" value="${j.bingAnHao }" readonly="readonly" />
                <br /><br />
                <label for="zhu_guan_yi_shi"> 主管医师：</label>
                <input type="text" name="zhu_guan_yi_shi" id="zhu_guan_yi_shi" value="${j.zhuGuanYiShi }" readonly="readonly" />
                <label for="suo_shu_ke_shi" class="text_1">所属科室：</label>
                <input type="text" name="suo_shu_ke_shi" id="suo_shu_ke_shi" value="${j.suoShuKeShi }" readonly="readonly" />
                <label for="zhuan_ke_yi_sheng" class="text_1">专科医生：</label>
                <input type="text" name="zhuan_ke_yi_sheng" id="zhuan_ke_yi_sheng" value="${j.zhuanKeYiSheng }" readonly="readonly" />
                <br/> <br/>
                <label for="xing_ming">姓名：</label>
                <input type="text" name="xing_ming" id="xing_ming" value="${j.xingMing }" readonly="readonly" />
                <label for="xing_bie" class="text_1">性别：</label>
                <input type="text" name="xing_bie" id="xing_bie" value='<c:if test="${j.xingBie==1 }">男</c:if><c:if test="${j.xingBie==2 }">女</c:if>' readonly="readonly" />
                <!-- <label for="nian_ling">年龄：</label>
                <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <label for="nian" class="text_1">出生日期：</label>
                <!-- <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <input type="number" value="${j.chuShengNian }" min="0" max="3000" name="nian" id="nian" style="width: 50px;" readonly="readonly" />年
                <input type="number" value="${j.chuShengYue }" min="0" max="12" name="yue" id="yue" style="width: 50px;" readonly="readonly" />月
                <input type="number" value="${j.chuShengRi }" min="0" max="31" name="ri" id="ri" style="width: 50px;" readonly="readonly" />日
                <br/><br/>
                <label for="min_zu">民族：</label>
                <input type="text" name="min_zu" id="min_zu" value="${j.minZu }" readonly="readonly" /><span>族</span>
                <label for="hun_yin_zhuang_kuang" class="text_1">婚姻状况：</label>
                <input type="text" name="hun_yin_zhuang_kuang" id="hun_yin_zhuang_kuang" value="${j.hunYinZhuangKuang }" readonly="readonly" />
                <label for="shen_gao" class="text_1">身高：</label>
                <input type="number" value="${j.shenGao }" min="0" max="150" id="shen_gao" name="shen_gao" readonly="readonly" /><span>cm</span>
                <label for="ti_zhong" class="text_1">体重：</label>
                <input type="number" value="${j.tiZhong }" min="0" max="250" name="ti_zhong" id="ti_zhong" readonly="readonly" /><span>kg</span>
                <br /><br />
                <label for="chu_sheng_di">出生地：</label>
                <input type="text" value="${j.chuShengDi }" name="chu_sheng_di" id="chu_sheng_di" readonly="readonly" />
                <br/><br/>
                <label for="zhi_ye">职业：</label>
                <input type="text" name="zhi_ye" id="zhi_ye" value="${j.zhiYe }" readonly="readonly" />
                <label for="wen_hua_cheng_du" class="text_1">文化程度：</label>
                <input type="text" name="wen_hua_cheng_du" id="wen_hua_cheng_du" value="${j.wenHuaChengDu }" readonly="readonly" />
                <label for="jia_li_pai_hang_1" class="text_1">家里排行：</label>
                <input type="number" min="0" max="250" name="jia_li_pai_hang_1" id="jia_li_pai_hang_1" value="${j.paiHang1 }" readonly="readonly" />
                /
               <input type="number" min="0" max="250" name="jia_li_pai_hang_2" id="jia_li_pai_hang_2" value="${j.paiHang2 }" readonly="readonly" />
                <br/><br/>
                <label for="jiang_ji_zhuang_kuang">经济状况：</label>
                <input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="${j.jingJiZhuangKuang }" readonly="readonly" />
                <label for="lian_xi_dian_hua">联系电话：</label><input type="text" name="lian_xi_dian_hua" value="${j.lianXiDianHua }" id="lian_xi_dian_hua" readonly="readonly" />
                <br/><br/>
                <label for="lian_xi_di_zhi">联系地址：</label><input type="text" name="lian_xi_di_zhi" value="${j.lianXiDiZhi }" id="lian_xi_di_zhi" readonly="readonly" />
        
		        <br><br>
		        <label>检测次数:</label><input type="text" name="ci_shu" id="ci_shu" value="${jc.ciShu }">
        		<label class="text_1">检测日期:</label><input type="text" name="ri_qi" id="ci_shu" value="${jc.riQi }">
        		<input type="hidden" name="ji_chu_xin_xi_id" id="ji_chu_xin_xi_id" value="${j.id }">
				</div>
        <div class="all__content">
            	<label class="text_3">检测项目</label><br><br>
            <label for="nao_dian" class="text_2">检测项目：</label>
             <c:if test="${jc.naoDian }">
             	<input type="checkbox" checked="checked" id="nao_dian" value="脑电" name="jian_ce_xiang_mu">
             </c:if>
             <c:if test="${!jc.naoDian }">
             	<input type="checkbox" id="nao_dian" value="脑电" name="jian_ce_xiang_mu">
             </c:if>
            <label for="nao_dian">脑电</label>
            <c:if test="${jc.ccbt }">
            	<input type="checkbox" checked="checked" id="ccbt" value="CCBT" name="jian_ce_xiang_mu">
            </c:if>
            <c:if test="${!jc.ccbt }">
            	<input type="checkbox" id="ccbt" value="CCBT" name="jian_ce_xiang_mu">
            </c:if>
            <label for="ccbt">CCBT</label>
            <c:if test="${jc.naoRenZhi }">
            	<input type="checkbox" checked="checked" id="nao_ren_zhi" value="脑认知" name="jian_ce_xiang_mu">
            </c:if>
            <c:if test="${!jc.naoRenZhi }">
            	<input type="checkbox" id="nao_ren_zhi" value="脑认知" name="jian_ce_xiang_mu">
            </c:if>
            <label for="nao_ren_zhi">脑认知</label>
            <c:if test="${jc.xinLiCePing }">
            	<input type="checkbox" checked="checked" id="xin_li_ce_ping" value="心理测评" name="jian_ce_xiang_mu">
            </c:if>
            <c:if test="${!jc.xinLiCePing }">
            	<input type="checkbox" id="xin_li_ce_ping" value="心理测评" name="jian_ce_xiang_mu">
            </c:if>
            <label for="xin_li_ce_ping">心理测评</label>
            <c:if test="${jc.yingYan }">
            	<input type="checkbox" checked="checked" id="ying_yan" value="鹰演" name="jian_ce_xiang_mu">
            </c:if>
            <c:if test="${!jc.yingYan }">
            	<input type="checkbox" id="ying_yan" value="鹰演" name="jian_ce_xiang_mu">
            </c:if>
            <label for="ying_yan">鹰演</label>
            <c:if test="${jc.hrv }">
            	<input type="checkbox" checked="checked" id="hrv" value="HRV" name="jian_ce_xiang_mu">
            </c:if>
            <c:if test="${!jc.hrv }">
            	<input type="checkbox" id="hrv" value="HRV" name="jian_ce_xiang_mu">
            </c:if>
            <label for="hrv">HRV</label><br>
            <div class="all__content">
	            <label class="text_4">心理测评项目：</label>
	            <c:forEach items="${lbs }" var="lb" varStatus="s">
	            	<input type="hidden" id="lb${s.index }" value="${lb }">
	            	<c:if test="${s.last }">
	            		<input type="hidden" id="xlcp_count" value="${s.count }">
	            	</c:if>
	            </c:forEach>
	            
	            
	            <input type="hidden" id="xin_li_ce_ping_xiang_mu" value="${z.xinLiCePingXiangMu }">
	            <input type="checkbox" id="ti_zhi_fen_xi" name="xing_li_ce_ping_xiang_mu" value="体质分析量表">
	            <label for="ti_zhi_fen_xi">体质分析量表</label>
	            <input type="checkbox" id="hm" name="xing_li_ce_ping_xiang_mu" value="汉密顿焦虑量表">
	            <label for="hm">汉密顿焦虑量表</label>
	            <input type="checkbox" id="yy" name="xing_li_ce_ping_xiang_mu" value="汉密顿抑郁量表">
	            <label for="yy">汉密顿抑郁量表</label>
	            <input type="checkbox" id="wcpa" name="xing_li_ce_ping_xiang_mu" value="WCPA躯体症状分类量表">
	            <label for="wcpa">WCPA躯体症状分类量表</label>
	            <input type="checkbox" id="zz" name="xing_li_ce_ping_xiang_mu" value="90项症状清单">
	            <label for="zz">90项症状清单</label>
	            <input type="checkbox" id="ask" name="xing_li_ce_ping_xiang_mu" value="艾森克个性测验">
	            <label for="ask">艾森克个性测验</label>
	            <input type="checkbox" id="js" name="xing_li_ce_ping_xiang_mu" value="简明精神病量表">
	            <label for="js">简明精神病量表</label>
	            <input type="checkbox" id="zk" name="xing_li_ce_ping_xiang_mu" value="躁狂量表">
	            <label for="zk">躁狂量表</label>
	            <input type="checkbox" id="cd" name="xing_li_ce_ping_xiang_mu" value="痴呆简易筛查量表">
	            <label for="cd">痴呆简易筛查量表</label>
	            <input type="checkbox" id="cgc" name="xing_li_ce_ping_xiang_mu" value="长谷川痴呆量表">
	            <label for="cgc">长谷川痴呆量表</label>
	            <input type="checkbox" id="yinx" name="xing_li_ce_ping_xiang_mu" value="阴性症状量表">
	            <label for="yinx">阴性症状量表</label>
	            <input type="checkbox" id="yangx" name="xing_li_ce_ping_xiang_mu" value="阳性症状量表">
	            <label for="yangx">阳性症状量表</label>
	            <input type="checkbox" id="qp" name="xing_li_ce_ping_xiang_mu" value="强迫量表">
	            <label for="qp">强迫量表</label>
	            <input type="checkbox" id="yyzsc" name="xing_li_ce_ping_xiang_mu" value="抑郁症筛查量表">
	            <label for="yyzsc">抑郁症筛查量表</label>
	            <input type="checkbox" id="gfxjl" name="xing_li_ce_ping_xiang_mu" value="广泛性焦虑量表">
	            <label for="gfxjl">广泛性焦虑量表</label>
            </div>
            <br><br>

        </div>
        <script type="text/javascript">$(document).ready(function(){
	setting();
});</script>
  <%@include file="/commons/tail.jsp" %>
