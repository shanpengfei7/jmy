<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>病例管理-诊疗方案</title>
    
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
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  <div class="all__content">
            <div style="margin-left: 20px">
                <span class="text_3">首诊信息</span><br>
                <label for="yong_hu_id">用户ID：</label>
                <input type="text" name="yong_hu_id" id="yong_hu_id" value="${j.yongHuId }" readonly="readonly" />
                <label for="ri_qi"  class="text_6">首诊日期：</label>
                <input type="datetime-local " name="ri_qi" id="ri_qi" value="${j.riQi }" readonly="readonly" />
                <label for="men_zhen_hao" class="text_6"> 门诊号：</label>
                <input type="text" name="men_zhen_hao" id="men_zhen_hao" value="${j.menZhenHao }" readonly="readonly" />
                <label for="bing_an_hao" class="text_6">病案号：</label>
                <input type="text" name="bing_an_hao" id="bing_an_hao" value="${j.bingAnHao }" readonly="readonly" />
                <br /><br />
                <label for="zhu_guan_yi_shi"> 主管医师：</label>
                <input type="text" name="zhu_guan_yi_shi" id="zhu_guan_yi_shi" value="${j.zhuGuanYiShi }" readonly="readonly" />
                <label for="suo_shu_ke_shi" class="text_6">所属科室：</label>
                <input type="text" name="suo_shu_ke_shi" id="suo_shu_ke_shi" value="${j.suoShuKeShi }" readonly="readonly" />
                <label for="zhuan_ke_yi_sheng" class="text_6">专科医生：</label>
                <input type="text" name="zhuan_ke_yi_sheng" id="zhuan_ke_yi_sheng" value="${j.zhuanKeYiSheng }" readonly="readonly" />
                <br/> <br/>
                <label for="xing_ming">姓名：</label>
                <input type="text" name="xing_ming" id="xing_ming" value="${j.xingMing }" readonly="readonly" />
                <label for="xing_bie" class="text_6">性别：</label>
                <input type="text" name="xing_bie" id="xing_bie" value='<c:if test="${j.xingBie==1 }">男</c:if><c:if test="${j.xingBie==2 }">女</c:if>' readonly="readonly" />
                <!-- <label for="nian_ling">年龄：</label>
                <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <label for="nian" class="text_6">出生日期：</label>
                <!-- <input type="number" min="0" max="150" name="nian_ling" id="nian_ling" readonly="readonly" /> -->
                <input type="number" value="${j.chuShengNian }" min="0" max="3000" name="nian" id="nian" style="width: 50px;" readonly="readonly" />年
                <input type="number" value="${j.chuShengYue }" min="0" max="12" name="yue" id="yue" style="width: 50px;" readonly="readonly" />月
                <input type="number" value="${j.chuShengRi }" min="0" max="31" name="ri" id="ri" style="width: 50px;" readonly="readonly" />日
                <br/><br/>
                <label for="min_zu">民族：</label>
                <input type="text" name="min_zu" id="min_zu" value="${j.minZu }" readonly="readonly" /><span>族</span>
                <label for="hun_yin_zhuang_kuang" class="text_6">婚姻状况：</label>
                <input type="text" name="hun_yin_zhuang_kuang" id="hun_yin_zhuang_kuang" value="${j.hunYinZhuangKuang }" readonly="readonly" />
                <label for="shen_gao" class="text_6">身高：</label>
                <input type="number" value="${j.shenGao }" min="0" max="150" id="shen_gao" name="shen_gao" readonly="readonly" /><span>cm</span>
                <label for="ti_zhong" class="text_6">体重：</label>
                <input type="number" value="${j.tiZhong }" min="0" max="250" name="ti_zhong" id="ti_zhong" readonly="readonly" /><span>kg</span>
                <br /><br />
                <label for="chu_sheng_di">出生地：</label>
                <input type="text" value="${j.chuShengDi }" name="chu_sheng_di" id="chu_sheng_di" readonly="readonly" />
                <br/><br/>
                <label for="zhi_ye">职业：</label>
                <input type="text" name="zhi_ye" id="zhi_ye" value="${j.zhiYe }" readonly="readonly" />
                <label for="wen_hua_cheng_du" class="text_6">文化程度：</label>
                <input type="text" name="wen_hua_cheng_du" id="wen_hua_cheng_du" value="${j.wenHuaChengDu }" readonly="readonly" />
                <label for="jia_li_pai_hang_1" class="text_6">家里排行：</label>
                <input type="number" min="0" max="250" name="jia_li_pai_hang_1" id="jia_li_pai_hang_1" value="${j.paiHang1 }" readonly="readonly" />
                /
               <input type="number" min="0" max="250" name="jia_li_pai_hang_2" id="jia_li_pai_hang_2" value="${j.paiHang2 }" readonly="readonly" />
                <br/><br/>
                <label for="lian_xi_dian_hua">联系电话：</label><input type="text" name="lian_xi_dian_hua" value="${j.lianXiDianHua }" id="lian_xi_dian_hua" readonly="readonly" />
                <label for="jiang_ji_zhuang_kuang" class="text_6">经济状况：</label>
                <c:if test="${j.jingJiZhuangKuang==1 }">
                	<input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="良好" readonly="readonly" />
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==2 }">
                	<input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="一般" readonly="readonly" />
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==3 }">
                	<input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="较差" readonly="readonly" />
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==4 }">
                	<input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="很差" readonly="readonly" />
                </c:if> 
        		<br><br>
                <label for="lian_xi_di_zhi">联系地址：</label><input type="text" name="lian_xi_di_zhi" value="${j.lianXiDiZhi }" id="lian_xi_di_zhi" readonly="readonly" />
        		
        </div>
        <c:forEach items="${zs }" var="z" varStatus="s">
        <c:if test="${s.last }">
        	<input type="hidden" id="last_row" value="${s.count }">
        </c:if>
        <div class="all__content">
            	心理测评结果：<br>
            	<label>诊疗次数</label><input type="text" name="ci_shu" id="ci_shu" value="${z.ciShu }">
        		<label>诊疗日期</label><input type="text" name="ri_qi" id="ci_shu" value="${z.riQi }">
            	<table style="margin-left: 10px;">
	            	<tr>
		            	<td><label>脑电</label></td>
		            	<td><input type="button" value="脑电结果" id="nao_dian_btn${s.index }"><br></td>
	            		<td style="width: 50px;"></td>
	            		<td><label>CCBT</label></td>
	            		<td><input type="button" value="CCBT结果" id="ccbt_btn${s.index }"><br></td>
		            	<td style="width: 50px;"></td>
	            		<td><label>脑认知</label></td>
	            		<td><input type="button" value="脑认知结果" id="nao_ren_zhi_btn${s.index }"><br></td>
	            	</tr>
	            	<tr>
	            		<td><label>心理测评</label></td>
	            		<td><a href="xzbr?m=ibg&id=${z.jiChuXinXiId }" target="_back"><input id="xlcp_btn${s.index }" type="button" value="心理测评结果"></a><br></td>
		            	<td></td>
	            		<td><label>鹰演</label></td>
	            		<td><input type="button" value="鹰演结果" id="ying_yan_btn${s.index }"><br></td>
		            	<td></td>
	            		<td><label>HRV</label></td>
	            		<td><input type="button" value="HRV结果" id="hrv_btn${s.index }"><br></td>
	            	</tr>
            	</table>
        </div>
            <div class="all__content">
           <label> 心身诊断：</label><s id="xszd${s.index }"> </s>
        	<input type="hidden" value="${z.xinShenZhenDuan }" id="xinShenZhenDuan${s.index }">
        	
        </div>
            <div class="all__content">
           <label> 治疗建议：</label>

<div class="all__content">
           <label>药物治疗：</label> <br>

        <table class="table" border="1" cellspacing="0">
                    <tr class="tr1">
                        <td width="180px">药名</td>
                        <td width="180px;">规格</td>
                        <td width="180px;">用量</td>
                        <td width="180px;">用法</td>
                        <td width="180px;">编辑</td>
                    </tr>
                    <c:forEach items="${z.yaoWuZhiLiaos }" var="y" varStatus="vs">
                    	<tr class="tr${vs.index%2==0?2:3 }" id='yao_wu_add${vs.count }'>
	                    	<td width="180px">${y.yaoMing }</td><input type="hidden" id="y_yao_ming${vs.count }" value="${y.yaoMing }">
	                        <td width="180px;">${y.guiGe }</td><input type="hidden" id="y_gui_ge${vs.count }" value="${y.guiGe }">
	                        <td width="180px;">${y.yongLiang }</td><input type="hidden" id="y_yong_liang${vs.count }" value="${y.yongLiang }">
	                        <td width="180px;">${y.yongFa }</td><input type="hidden" id="y_yong_fa${vs.count }" value="${y.yongFa }">
	                        <td><a href='javascript:void(0);' onclick="deleteYao('yao_wu_add${vs.count }','${vs.count }')">删除</a></td>
                        	<c:if test="${vs.last }">
                        		<input type="hidden" id="click_count" value="${vs.count }">
                        	</c:if>
                        </tr>
                    </c:forEach>
                    <tr class="tr4" id="yao_wu_add">
                        <td colspan="5"></td>
                    </tr>
                </table>
                <br>
        <div style="clear: both;"></div>
    </div>
<div class="all__content">
            心身调节：<s id="xstj${s.index }"></s>
            <input type="hidden" value="${z.xinShenTiaoJie }" id="xinShenTiaoJie${s.index }">
        </div>
        </div>
            <div class="all__content">
           &nbsp;&nbsp;<label> 复诊时间：</label><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="all__content">
            &nbsp;&nbsp;<label for="nao_dian">检测项目：</label><s id="jcxm${s.index }"></s>
            <input type="hidden" value="${z.jianCeXiangMu }" id="jianCeXiangMu${s.index }">
            <div class="all__content">
            &nbsp;&nbsp;<label>心理测评项目：</label><s id="xlcpxm${s.index }"></s>
           <input type="hidden" value="${z.xinLiCePingXiangMu }" id="xinLiCePingXiangMu${s.index }">
            </div>
            <br>
</div>
<div class="all__content">
            	&nbsp;&nbsp;<label for="fz_time">复诊时间：</label>
				过<input type="number" value="${z.fuZhenShiJian }" min="1" max="100" name="fz_time" id="fz_time" style="width: 50px;">周来复诊
</div>
<div class="all__content">
            	&nbsp;&nbsp;<label for="fz_time">回访：</label><br><br>
				回访状态：<c:if test="${z.huiFangZhuangTai }">已回访<br>
				回访内容：<br><textarea rows="10" cols="100">${z.huiFangNeiRong }</textarea>
				</c:if>
				<c:if test="${!z.huiFangZhuangTai }">未回访<br>
				
				</c:if>
</div>
        </div>
        <br><br><br>
        </c:forEach>
        <script type="text/javascript">
	        		$(document).ready(function(){
	        			var last_row = $("#last_row").val();
	        			
	        			for(var i = 0; i < last_row; i++) {
		        			var xs = $("#xinShenZhenDuan" + i).val().split("|");
		        			for(var x in xs) {
		        				$("#xszd" + i).after("<span style='margin-right: 15px;'>"+xs[x]+"</span>");
		        			}
	        			}
	        			
	        		});
	        		$(document).ready(function(){
	        			var last_row = $("#last_row").val();
		        		for(var i = 0; i < last_row; i++) {
		        			var xxs = $("#xinShenTiaoJie" + i).val().split("|");
		        			for(var xx in xxs) {
		        				$("#xstj" + i).after("<span style='margin-right: 15px;'>"+xxs[xx]+"次</span>");
		        			}
	        			}
        			});
        			$(document).ready(function(){
        				var last_row = $("#last_row").val();
		        		for(var i = 0; i < $("#last_row").val(); i++) {
		        			var xs = $("#jianCeXiangMu" + i).val().split("|");
		        			for(var x in xs) {
		        				if(xs[x] == "脑电") {
					    			$("#nao_dian_btn" + i).css("background-color", "green");
					    		} 
					    		if(xs[x] == "CCBT") {
					    			$("#ccbt_btn" + i).css("background-color", "green");
					    		} 
					    		if(xs[x] == "脑认知") {
					    			$("#nao_ren_zhi_btn" + i).css("background-color", "green");
					    		} 
					    		if(xs[x] == "心理测评") {
					    			$("#xlcp_btn" + i).css("background-color", "green");
					    		} 
					    		if(xs[x] == "鹰演") {
					    			$("#ying_yan_btn" + i).css("background-color", "green");
					    		} 
					    		if(xs[x] == "HRV") {
					    			$("#hrv_btn" + i).css("background-color", "green");
					    		}
		        			
		        				$("#jcxm" + i).after("<span style='margin-right: 15px;'>"+xs[x]+"</span>");
		        			}
	        			}
	        		});
	        		$(document).ready(function(){
        				var last_row = $("#last_row").val();
		        		for(var i = 0; i < $("#last_row").val(); i++) {
		        			var xs = $("#xinLiCePingXiangMu" + i).val().split("|");
		        			for(var x in xs) {
		        				$("#xlcpxm" + i).after("<span style='margin-right: 15px;'>"+xs[x]+"</span>");
		        			}
	        			}
	        		});
$(document).ready(function(){
	setting();
});
    	
        	</script>
  <%@include file="/commons/tail.jsp" %>
