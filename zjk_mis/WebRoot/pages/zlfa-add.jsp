<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>诊疗方案添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/cepingshi/ji_chu_xin_xi_tian_jia.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/cepingshi/jian_ce_xiang_mu_tian_jia.js"></script>
    <link href="css/modal.css" rel="stylesheet" type="text/css" />
    <link href="css/cepingshi/shou_zhen_xin_xi.css" rel="stylesheet" type="text/css" />
	
  <%@include file="/commons/header.jsp" %>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="js/zlfa.js"></script>
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  <div class="all__content">
            <div style="margin-left: 20px">
                <label class="text_3">首诊信息</label><br>
                <label for="yong_hu_id">用户ID：</label>
                <input type="text"  name="yong_hu_id" id="yong_hu_id" value="" readonly="readonly" />
                <input type="button" value="选择基础信息" id="ji_chu_xin_xi_btn" onclick="fadeIn();">
                <label for="ri_qi" class="text_1">首诊日期：</label>
                <input type="datetime-local " name="ri_qi" id="ri_qi" value="" readonly="readonly" class="text_5"/>
                <label for="men_zhen_hao" class="text_1"> 门诊号：</label>
                <input type="text" name="men_zhen_hao" id="men_zhen_hao" value="" readonly="readonly" class="text_5"/>
                <label for="bing_an_hao" class="text_1">病案号：</label>
                <input type="text" name="bing_an_hao" id="bing_an_hao" value="" readonly="readonly" class="text_5"/>
                <br /><br />
                <label for="zhu_guan_yi_shi"> 主管医师：</label>
                <input type="text" name="zhu_guan_yi_shi" id="zhu_guan_yi_shi" value="" readonly="readonly" />
                <label for="suo_shu_ke_shi" class="text_1">所属科室：</label>
                <input type="text" name="suo_shu_ke_shi" id="suo_shu_ke_shi" value="" readonly="readonly" />
                <label for="zhuan_ke_yi_sheng" class="text_1">专科医生：</label>
                <input type="text" name="zhuan_ke_yi_sheng" id="zhuan_ke_yi_sheng" value="" readonly="readonly" />
                <br/> <br/>
                <label for="xing_ming">姓名：</label>
                <input type="text" name="xing_ming" id="xing_ming" readonly="readonly" />
                <label for="xing_bie" class="text_1">性别：</label>
                <input type="text" name="xing_bie" id="xing_bie" value="" readonly="readonly" />
                <!-- <label for="nian_ling">年龄：</label>
                <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <label for="nian" class="text_1">出生日期：</label>
                <!-- <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <input type="number" min="0" max="3000" name="nian" id="nian" style="width: 50px;" readonly="readonly" />年
                <input type="number" min="0" max="12" name="yue" id="yue" style="width: 50px;" readonly="readonly" />月
                <input type="number" min="0" max="31" name="ri" id="ri" style="width: 50px;" readonly="readonly" />日
                <br/><br/>
                <label for="min_zu">民族：</label>
                <input type="text" name="min_zu" id="min_zu" value="" readonly="readonly" /><span>族</span>
                <label for="hun_yin_zhuang_kuang" class="text_1">婚姻状况：</label>
                <input type="text" name="hun_yin_zhuang_kuang" id="hun_yin_zhuang_kuang" value="" readonly="readonly" />
                <label for="shen_gao" class="text_1">身高：</label>
                <input type="number" min="0" max="150" id="shen_gao" name="shen_gao" readonly="readonly" /><span>cm</span>
                <label for="ti_zhong" class="text_1">体重：</label>
                <input type="number" min="0" max="250" name="ti_zhong" id="ti_zhong" readonly="readonly" /><span>kg</span>
                <br /><br />
                <label for="chu_sheng_di">出生地：</label>
                <input type="text" name="chu_sheng_di" id="chu_sheng_di" readonly="readonly" />
                <br/><br/>
                <label for="zhi_ye">职业：</label>
                <input type="text" name="zhi_ye" id="zhi_ye" value="" readonly="readonly" />
                <label for="wen_hua_cheng_du" class="text_1">文化程度：</label>
                <input type="text" name="wen_hua_cheng_du" id="wen_hua_cheng_du" value="" readonly="readonly" />
                <label for="jia_li_pai_hang_1" class="text_1">家里排行：</label>
                <input type="number" min="0" max="250" name="jia_li_pai_hang_1" id="jia_li_pai_hang_1" value="" readonly="readonly" />
                /
               <input type="number" min="0" max="250" name="jia_li_pai_hang_2" id="jia_li_pai_hang_2" value="" readonly="readonly" />
                <br/><br/>
                <label for="lian_xi_dian_hua">联系电话：</label><input type="text" name="lian_xi_dian_hua" id="lian_xi_dian_hua" readonly="readonly" />
                <label for="jiang_ji_zhuang_kuang"class="text_1">经济状况：</label>
                <input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="" readonly="readonly" />
                <br/><br/>
                <label for="lian_xi_di_zhi">联系地址：</label><input type="text" name="lian_xi_di_zhi" id="lian_xi_di_zhi" readonly="readonly" />
        		<br><br>
  <form action="zlfa?m=szlfa" method="post" id="zlfa_add_form">
  				<input type="hidden" value="${token }" name="token">
        		<input type="hidden" name="ci_shu" id="ci_shu">
        		<input type="hidden" name="ci_shu_j" id="ci_shu_j">
        		<input type="hidden" name="ji_chu_xin_xi_id" id="ji_chu_xin_xi_id">
        </div>
        <div class="all__content">
            	心理测评结果：<br>
            	<table style="margin-left: 10px;">
            		<tr>
	            		<td><label>心理测评</label></td>
	            		<td><input id="xlcp_btn" type="button" value="心理测评结果"><br></td>
		            	<td></td>
	            		<td><label>脑电</label></td>
		            	<td><input type="button" value="脑电结果" id="nao_dian_btn"><br></td>
	            		<td style="width: 50px;"></td>
	            		<td><label>HRV</label></td>
	            		<td><input type="button" value="HRV结果" id="hrv_btn"><br></td>
	            	</tr>
	            	<tr>
	            		<td><label>鹰演</label></td>
	            		<td><input type="button" value="鹰演结果" id="ying_yan_btn"><br></td>
		            	<td></td>
	            		<td><label>CCBT</label></td>
	            		<td><input type="button" value="CCBT结果" id="ccbt_btn"><br></td>
		            	<td style="width: 50px;"></td>
	            		<td><label>脑认知</label></td>
	            		<td><input type="button" value="脑认知结果" id="nao_ren_zhi_btn"><br></td>
	            	</tr>
            	</table>
        </div>
        <br/>
            <div class="all__content">
           <label class="text_4"> 心身诊断：</label><br>
		<input type="checkbox" id="zwsjgnwl" name="xszd" value="植物神经功能紊乱">
		<label for="zwsjgnwl">植物神经功能紊乱</label>
		<input type="checkbox" id="sjsr" name="xszd" value="神经衰弱">
		<label for="sjsr">神经衰弱</label>
		<input type="checkbox" id="smza" name="xszd" value="睡眠障碍">
		<label for="smza">睡眠障碍</label>
		<input type="checkbox" id="qthza" name="xszd" value="躯体化障碍">
		<label for="qthza">躯体化障碍</label>
		<input type="checkbox" id="qtxsza" name="xszd" value="躯体形式障碍">
		<label for="qtxsza">躯体形式障碍</label>
		<input type="checkbox" id="jlzt" name="xszd" value="焦虑状态">
		<label for="jlzt">焦虑状态</label>
		<input type="checkbox" id="jlz" name="xszd" value="焦虑症">
		<label for="jlz">焦虑症</label>
		<input type="checkbox" id="yyzt" name="xszd" value="抑郁状态">
		<label for="yyzt">抑郁状态</label>
		<input type="checkbox" id="yyz" name="xszd" value="抑郁症">
		<label for="yyz">抑郁症</label><br>
		<input type="checkbox" id="qpzt" name="xszd" value="强迫状态">
		<label for="qpzt">强迫状态</label>
		<input type="checkbox" id="qpz" name="xszd" value="强迫症">
		<label for="qpz">强迫症</label>
		<input type="checkbox" id="ybz" name="xszd" value="疑病症">
		<label for="ybz">疑病症</label>
		<input type="checkbox" id="wxzt" name="xszd" value="妄想状态">
		<label for="wxzt">妄想状态</label>
		<input type="checkbox" id="swza" name="xszd" value="思维障碍">
		<label for="swza">思维障碍</label>
		<input type="checkbox" id="hjzt" name="xszd" value="幻觉状态">
		<label for="hjzt">幻觉状态</label>
		<input type="checkbox" id="sxqgza" name="xszd" value="双相情感障碍">
		<label for="sxqgza">双相情感障碍</label>
		<input type="checkbox" id="zkz" name="xszd" value="躁狂症">
		<label for="zkz">躁狂症</label>
		<input type="checkbox" id="jsflz" name="xszd" value="精神分裂症">
		<label for="jsflz">精神分裂症</label>
		<input type="checkbox" id="syza" name="xszd" value="适用障碍">
		<label for="syza">适用障碍</label>
        </div>
        <br/>
            <div class="all__content">
           <label class="text_4"> 治疗建议：</label>

<div class="all__content">
           <label class="text_4">药物治疗：</label> <br>
		<label class="text_4">甲药</label>
		<select id="yao_wu">
			<option value="请选择">请选择</option>
			<option value="西酞普兰">西酞普兰</option>
			<option value="艾司西酞普兰">艾司西酞普兰</option>
			<option value="盐酸氟西汀">盐酸氟西汀</option>
			<option value="盐酸帕罗西汀">盐酸帕罗西汀</option>
			<option value="舍曲林">舍曲林</option>
			<option value="盐酸度洛西汀肠溶片">盐酸度洛西汀肠溶片</option>
			<option value="文拉法辛">文拉法辛</option>
			<option value="氟哌噻吨美利曲辛">氟哌噻吨美利曲辛</option>
			<option value="地西泮">地西泮</option>
			<option value="氯硝西泮">氯硝西泮</option>
			<option value="艾司唑仑">艾司唑仑</option>
			<option value="酒石酸唑吡坦">酒石酸唑吡坦</option>
			<option value="右佐匹克隆">右佐匹克隆</option>
			<option value="补肾益脑丸">补肾益脑丸</option>
			<option value="百乐眠胶囊">百乐眠胶囊</option>
			<option value="心脑舒口服液">心脑舒口服液</option>
			<option value="舒肝解郁胶囊">舒肝解郁胶囊</option>
			<option value="舒肝颗粒">舒肝颗粒</option>
			<option value="乌灵胶囊">乌灵胶囊</option>
			<option value="安神补脑颗粒">安神补脑颗粒 </option>
			<option value="新乐康片">新乐康片</option>
			<option value="利培酮">利培酮</option>
			<option value="富马酸喹硫平">富马酸喹硫平</option>
			<option value="奥氮平">奥氮平</option>
			<option value="氟哌啶醇">氟哌啶醇</option>
			<option value="丙戊酸钠缓释片">丙戊酸钠缓释片</option>
			<option value="丙戊酸镁">丙戊酸镁</option>
			<option value="碳酸锂">碳酸锂</option>
		</select>
		
		<select id="gui_ge"></select>&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="yong_liang">用量</label>
		<select name="yong_liang" id="yong_liang"></select>&nbsp;&nbsp;&nbsp;&nbsp;
		<label>用法</label>
		<input type="checkbox" id="one" name="one">
		<label for="one">1/日</label>
		<input type="checkbox" id="two" name="two">
		<label for="two">2/日</label>
		<input type="checkbox" id="three" name="three">
		<label for="three">3/日</label>
		<input type="checkbox" id="four" name="four">
		<label for="four">4/日</label>
		<input type="checkbox" id="bys" name="bys">
		<label for="bys">必要时</label>
		<input type="checkbox" id="df" name="df">
		<label for="df">顿服</label>&nbsp;&nbsp;
		<label for="qi_ta_yong_fa">其它用法</label>
		<input type="text" id="qi_ta_yong_fa" name="qi_ta_yong_fa" value=" ">
		<input type="button" value="添加" id="yao_wu_add_btn">

        <table class="table" border="1" cellspacing="0">
                    <tr class="tr1">
                        <td>药名</td>
                        <td>规格</td>
                        <td>用量</td>
                        <td>用法</td>
                        <td>编辑</td>
                    </tr>
                    <tr class="tr4" id="yao_wu_add">
                        <td colspan="5"></td>
                    </tr>
                </table>
                
	    		<input type="hidden" name="yao_wu_zhi_liao" id="yao_wu_zhi_liao">
				
                <br><br>
        <div style="clear: both;"></div>
    </div>
    
    
 <br/> 
<div class="all__content">
            心身调节：<br>
		<input type="checkbox" id="zwsjgntj" name="zwsjgntj" value="植物神经功能调节">
		<label for="zwsjgntj">植物神经功能调节</label>
		<input type="number" name="zwsjgntjc" id="zwsjgntjc" min="1" style="width: 50px;">次
		<input type="checkbox" id="ngntj" name="ngntj" value="脑功能调节" class="text_1">
		<label for="ngntj">脑功能调节</label>
		<input type="number" name="ngntjc" id="ngntjc" min="1" style="width: 50px;">次
		<input type="checkbox" id="swfktj" name="swfktj" value="生物反馈调节" class="text_1">
		<label for="swfktj">生物反馈调节</label>
		<input type="number" name="swfktjc" id="swfktjc" min="1" style="width: 50px;">次
		<input type="checkbox" id="jlccjzl" name="jlccjzl" value="经颅磁刺激治疗" class="text_1">
		<label for="jlccjzl">经颅磁刺激治疗</label>
		<input type="number" name="jlccjzlc" id="jlccjzlc" min="1" style="width: 50px;">次
		<input type="checkbox" id="wlzl" name="wlzl" value="物理治疗" class="text_1">
		<label for="wlzl">物理治疗</label>
		<input type="number" name="wlzlc" id="wlzlc" min="1" style="width: 50px;">次
		<br/>
		<input type="checkbox" id="xlzl" name="xlzl" value="心理治疗">
		<label for="xlzl">心理治疗</label>
		<input type="number" name="xlzlc" id="xlzlc" min="1" style="width: 50px;">次
		<input type="checkbox" id="rzxwlf" name="rzxwlf" value="认知行为疗法" class="text_1">
		<label for="rzxwlf">认知行为疗法</label>
		<input type="number" name="rzxwlfc" id="rzxwlfc" min="1" style="width: 50px;">次
		<input type="checkbox" id="spzl" name="spzl" value="沙盘治疗" class="text_1">
		<label for="spzl">沙盘治疗</label>
		<input type="number" name="spzlc" id="spzlc" min="1" style="width: 50px;">次
		<input type="checkbox" id="ttzl" name="ttzl" value="团体治疗" class="text_1">
		<label for="ttzl">团体治疗</label>
		<input type="number" name="ttzlc" id="ttzlc" min="1" style="width: 50px;">次
		
		
        </div>
        </div>
        <br/>
            <div class="all__content">
           &nbsp;&nbsp;<label> 复诊时间：</label><br>
           <label><input type="button" value="归档" id="xxgd"></label>
<div class="all__content">
            &nbsp;&nbsp;<label for="nao_dian">检测项目：</label>
            <input type="checkbox" id="nao_dian" value="脑电" name="jian_ce_xiang_mu">
            <label for="nao_dian">脑电</label>
            <input type="checkbox" id="ccbt" value="CCBT" name="jian_ce_xiang_mu">
            <label for="ccbt">CCBT</label>
            <input type="checkbox" id="nao_ren_zhi" value="脑认知" name="jian_ce_xiang_mu">
            <label for="nao_ren_zhi">脑认知</label>
            <input type="checkbox" id="xin_li_ce_ping" value="心理测评" name="jian_ce_xiang_mu">
            <label for="xin_li_ce_ping">心理测评</label>
            <input type="checkbox" id="ying_yan" value="鹰演" name="jian_ce_xiang_mu">
            <label for="ying_yan">鹰演</label>
            <input type="checkbox" id="hrv" value="HRV" name="jian_ce_xiang_mu">
            <label for="hrv">HRV</label><br>
            <div class="all__content">
            &nbsp;&nbsp;<label>心理测评项目：</label>
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
            <br>

</div>
<div class="all__content">
            	&nbsp;&nbsp;<label for="fz_time">复诊时间：</label>
				过<input type="number" min="1" max="100" name="fz_time" id="fz_time" style="width: 50px;">周来复诊
</div>
        </div>
            
            <input type="submit" value="保存" id="save">
          </form>
          <input type="hidden" name="r" id="r" value="${param.r }"/>
		<input type="hidden" name="q" id="q" value="${param.q }"/>
	    <input type="hidden" name="n" id="n" value="${param.n }"/>
	    <input type="hidden" id="f" value="${f }">
             <!--模态对话框-->
            <div id="formTable" class="modal hide">

                <form id="form_zl" action="zlfa?m=iZlfaAdd" method="post">
                    <input type="hidden" value="t" name="f">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">选择基础信息</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut();" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    <div class="search">

		                <label for="name">姓名：</label>
		                <input type="text" name="n" class="date_picker" id="name" />
		
		                <input type="submit" value="查询" class="button" id="search_btn" />
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
                    </tr>
                    <c:forEach items="${page.list }" var="jc" varStatus="s">
	                	<tr class="tr${s.index%2==0?2:3 }">
		                    <td><a href="javascript:x_z(${jc.id })">选择</a></td>
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
		                    <c:if test="${s.last }">
		                    	<input type="hidden" id="pageCount" value="${s.count }">
		                    </c:if>
		                </tr>
	                </c:forEach>
                    <tr class="tr4">
                        <td colspan="11">
                            第${page.getpageNow() }页，共${page.getTotalPageNumber() }页（<span id="showPageCount"></span>记录）
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfaAdd&f=t&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfaAdd&f=t&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfaAdd&f=t&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfaAdd&f=t&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                        </td>
                    </tr>
                </table>
                    </div>
                    <div class="modal-footer">
                        <a  href="javascript:void(0);" onclick="fadeOut();" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </form>
            </div>
            <!--模态对话框结束-->
<script type="text/javascript">
$(document).ready(function(){
	$("#xxgd").click(function(){
		/* window.location.href="zlfa?m=gd&id=" + $("#ji_chu_xin_xi_id").val(); */
		$("#zlfa_add_form").attr("action", "zlfa?m=gd&id=" + $("#ji_chu_xin_xi_id").val());
		$("#zlfa_add_form").submit();
		
	});
});
$(document).ready(function(){
	setting();
});
</script>
  <%@include file="/commons/tail.jsp" %>
