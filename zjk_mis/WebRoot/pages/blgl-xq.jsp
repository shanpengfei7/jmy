<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基础信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/cepingshi/ji_chu_xin_xi_tian_jia.css" rel="stylesheet" type="text/css">
	
  <%@include file="/commons/header.jsp" %>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="js/cepingshi/ji_chu_xin_xi.js"></script>
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  <div class="all__content">
            <div style="margin-left: 20px">
            	<label for="yong_hu_id">用户ID：</label>
                <input type="text" name="yong_hu_id" id="yong_hu_id" value="${j.yongHuId }" readonly="readonly" />
                <label for="ri_qi" class="text_6">首诊日期：</label>
                <input type="datetime-local " name="ri_qi" id="ri_qi" value="${j.riQi }" readonly="readonly" />
                <label for="men_zhen_hao" class="text_6"> 门诊号：</label>
                <input type="text" name="men_zhen_hao" id="men_zhen_hao" value="${j.menZhenHao }" readonly="readonly" />
                <label for="bing_an_hao" class="text_6">病案号：</label>
                <input type="text" name="bing_an_hao" id="bing_an_hao" value="${j.bingAnHao }" readonly="readonly" />
                <br /><br />
                <label for="zhu_guan_yi_shi"> 主管医师：</label>
                <select name="zhu_guan_yi_shi" id="zhu_guan_yi_shi">
                		<option>${j.zhuGuanYiShi }</option>
                </select>
                <label for="suo_shu_ke_shi" class="text_6">所属科室：</label>
                <select name="suo_shu_ke_shi" id="suo_shu_ke_shi">
                		<option>${j.suoShuKeShi }</option>
                </select>
                <label for="zhuan_ke_yi_sheng" class="text_6">专科医生：</label>
                <select name="zhuan_ke_yi_sheng" id="zhuan_ke_yi_sheng">
                    <option>${j.zhuanKeYiSheng }</option>
                </select>
                
                <br/> <br/>
                <label for="xing_ming">姓名：</label>
                <input type="text" name="xing_ming" id="xing_ming" value="${j.xingMing }"  readonly="readonly">
                <label for="nan" class="text_6">性别：</label>
                <c:if test="${j.xingBie == 1 }">
                <input type="radio" id="nan" name="xing_bie" value="男" checked="checked"><label for="nan">男</label>
                <input type="radio" id="nv" name="xing_bie" value="女"><label for="nv">女</label>
                </c:if>
                <c:if test="${j.xingBie == 2 }">
                <input type="radio" id="nan" name="xing_bie" value="男"><label for="nan">男</label>
                <input type="radio" id="nv" name="xing_bie" value="女" checked="checked"><label for="nv">女</label>
                </c:if>
                <label for="nian" class="text_6">出生日期：</label>
                <input type="number" min="0" max="3000" name="nian" id="nian" style="width: 50px;" value="${j.chuShengNian }" />年
                <input type="number" min="0" max="12" name="yue" id="yue" style="width: 50px;" value="${j.chuShengYue }" />月
                <input type="number" min="0" max="31" name="ri" id="ri" style="width: 50px;" value="${j.chuShengRi }" />日
                <br><br>
                <label for="min_zu">民族：</label>
                <input type="text" name="min_zu" id="min_zu" value="${j.minZu }" /><span>族</span>
                <label for="hun_yin_zhuang_kuang" class="text_6">婚姻状况：</label>
                <select name="hun_yin_zhuang_kuang" id="hun_yin_zhuang_kuang">
                    <option>${j.hunYinZhuangKuang }</option>
                </select>
                <label for="shen_gao" class="text_6">身高：</label>
                <input type="number" min="0" max="350" id="shen_gao" name="shen_gao" value="${j.shenGao }" /><span>cm</span>
                <label for="ti_zhong" class="text_6">体重：</label>
                <input type="number" min="0" max="350" name="ti_zhong" id="ti_zhong" value="${j.tiZhong }"/><span>kg</span>
                <br /><br />
                <label for="chu_sheng_di">出生地：</label>
                <input type="text" name="chu_sheng_di" id="chu_sheng_di" value="${j.chuShengDi }">
                <br/><br/>
                <label for="zhi_ye">职业：</label>
                <select name="zhi_ye" id="zhi_ye">
                    <option>${j.zhiYe }</option>
                </select>
                <label for="wen_hua_cheng_du" class="text_6">文化程度：</label>
                <select name="wen_hua_cheng_du" id="wen_hua_cheng_du">
                    <option>${j.wenHuaChengDu }</option>
                </select>
                <label for="jia_li_pai_hang_1" class="text_6">家里排行：</label>
                <select name="jia_li_pai_hang_1" id="jia_li_pai_hang_1">
                    <option>${j.paiHang1 }</option>
                </select>
                /
                <select name="jia_li_pai_hang_2" id="jia_li_pai_hang_2">
                    <option>${j.paiHang2 }</option>
                </select>
                <br/><br/>
                <label for="liang_hao">经济状况：</label>
                <c:if test="${j.jingJiZhuangKuang==1 }">
                	<input type="radio" checked="checked" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==2 }">
                	<input type="radio" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                    <input type="radio" checked="checked" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==3 }">
                	<input type="radio" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                    <input type="radio" checked="checked" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==4 }">
                	<input type="radio" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                    <input type="radio" checked="checked" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                </c:if>
                <c:if test="${j.jingJiZhuangKuang==null }">
                	<input type="radio" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                    <input type="radio" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                </c:if>
                      
                <label for="lian_xi_dian_hua">联系电话：</label><input value="${j.lianXiDianHua }" type="text" name="lian_xi_dian_hua" id="lian_xi_dian_hua"/>
                <br/><br/>
                <label for="lian_xi_di_zhi">联系地址：</label><input value="${j.lianXiDiZhi }" type="text" name="lian_xi_di_zhi" id="lian_xi_di_zhi" class="jianju"/>
                <br/><br/><hr><br>
                <label for="ji_bing_wen_ti">就诊原因：</label>
                      <input type="hidden" value="${j.jiuZhenYuanYin }" id="jiu_zhen_yuan_yin">
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="疾病问题" id="ji_bing_wen_ti"/><label for="ji_bing_wen_ti" class="text_7">疾病问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="睡眠问题" id="shui_mian_wen_ti"/><label for="shui_mian_wen_ti" class="text_7">睡眠问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="情绪问题" id="qing_xu_wen_ti"/><label for="qing_xu_wen_ti" class="text_7">情绪问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="认知问题" id="ren_zhi_wen_ti"/><label for="ren_zhi_wen_ti" class="text_7">认知问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="记忆问题" id="ji_yi_wen_ti"/><label for="ji_yi_wen_ti" class="text_7">记忆问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="注意力问题" id="zhu_yi_li_wen_ti"/><label for="zhu_yi_li_wen_ti" class="text_7">注意力问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="人际关系" id="ren_ji_wen_ti"/><label for="ren_ji_wen_ti" class="text_7">人际关系</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="婚恋情感" id="hun_lian_qing_gan"/><label for="hun_lian_qing_gan" class="text_7">婚恋情感</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="工作问题" id="gong_zuo_wen_ti"/><label for="gong_zuo_wen_ti" class="text_7">工作问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="学习问题" id="xue_xi_wen_ti"/><label for="xue_xi_wen_ti" class="text_7">学习问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="个性问题" id="ge_xing_wen_ti"/><label for="ge_xing_wen_ti" class="text_7">个性问题</label>
                      <br><br>
                      <label for="jiu_zhen_yuan_yin_qi_ta">其它:</label><input type="text" name="jiu_zhen_yuan_yin" id="jiu_zhen_yuan_yin_qi_ta" class="jianju">
                <br/><br/>
                <label for="liang_hao"> 睡眠：</label>
                <input type="hidden" value="${j.shuiMian }" id="shui_mian">
                <input type="checkbox" name="shuimian" value="良好" id="shui_mian_liang_hao"/><label for="shui_mian_liang_hao" class="text_7">良好</label>
                <input type="checkbox" name="shuimian" value="一般" id="shui_mian_yi_ban"/><label for="shui_mian_yi_ban">一般</label>
                <input type="checkbox" name="shuimian" value="欠佳" id="shui_mian_qian_jia"/><label for="shui_mian_qian_jia" class="text_7">欠佳</label>
                <input type="checkbox" name="shuimian" value="入睡困难" id="ru_shui_kun_nan"/><label for="ru_shui_kun_nan"> 入睡困难</label>
                <input type="checkbox" name="shuimian" value="早醒" id="shui_mian_zao_xing"/><label for="shui_mian_zao_xing"> 早醒</label>
                <input type="checkbox" name="shuimian" value="睡眠深度不足" id="shui_mian_shen_du_bu_zu"/><label for="shui_mian_shen_du_bu_zu"> 睡眠深度不足</label>
                <input type="checkbox" name="shuimian" value="嗜睡" id="shui_mian_shi_shui"/><label for="shui_mian_shi_shui"> 嗜睡</label>
                <input type="checkbox" name="shuimian" value="醒后无力" id="xing_hou_wu_li"/><label for="xing_hou_wu_li"> 醒后无力</label>
                <br/><br/>
                <label for="shi_yu_liang_hao"> 食欲：</label>
                <c:if test="${j.shiYu==1 }">
                	<input type="radio" checked="checked" name="shiyu" value="良好" id="shi_yu_liang_hao"/><label for="shi_yu_liang_hao"> 良好</label>
	                <input type="radio" name="shiyu" value="一般" id="shi_yu_yi_ban"/><label for="shi_yu_yi_ban"> 一般</label>
	                <input type="radio" name="shiyu" value="欠佳" id="shi_yu_qian_jia"/><label for="shi_yu_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.shiYu==2 }">
                	<input type="radio" checked="checked" name="shiyu" value="良好" id="shi_yu_liang_hao"/><label for="shi_yu_liang_hao"> 良好</label>
	                <input type="radio" checked="checked" name="shiyu" value="一般" id="shi_yu_yi_ban"/><label for="shi_yu_yi_ban"> 一般</label>
	                <input type="radio" name="shiyu" value="欠佳" id="shi_yu_qian_jia"/><label for="shi_yu_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.shiYu==3 }">
                	<input type="radio" checked="checked" name="shiyu" value="良好" id="shi_yu_liang_hao"/><label for="shi_yu_liang_hao"> 良好</label>
	                <input type="radio" name="shiyu" value="一般" id="shi_yu_yi_ban"/><label for="shi_yu_yi_ban"> 一般</label>
	                <input type="radio" checked="checked" name="shiyu" value="欠佳" id="shi_yu_qian_jia"/><label for="shi_yu_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.shiYu==null }">
                	<input type="radio" checked="checked" name="shiyu" value="良好" id="shi_yu_liang_hao"/><label for="shi_yu_liang_hao"> 良好</label>
	                <input type="radio" name="shiyu" value="一般" id="shi_yu_yi_ban"/><label for="shi_yu_yi_ban"> 一般</label>
	                <input type="radio" name="shiyu" value="欠佳" id="shi_yu_qian_jia"/><label for="shi_yu_qian_jia"> 欠佳</label>
                </c:if>
                <br/><br/>
                <label for="xing_sheng_huo_liang_hao"> 性生活：</label>
                <c:if test="${j.xingShengHuo==1 }">
                <input type="radio" checked="checked" name="xingshenghuo" value="良好" id="xing_sheng_huo_liang_hao"/><label for="xing_sheng_huo_liang_hao"> 良好</label>
                <input type="radio" name="xingshenghuo" value="一般" id="xing_sheng_huo_yi_ban"/><label for="xing_sheng_huo_yi_ban"> 一般</label>
                <input type="radio" name="xingshenghuo" value="欠佳" id="xing_sheng_huo_qian_jia"/><label for="xing_sheng_huo_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.xingShengHuo==2 }">
                <input type="radio" name="xingshenghuo" value="良好" id="xing_sheng_huo_liang_hao"/><label for="xing_sheng_huo_liang_hao"> 良好</label>
                <input type="radio" checked="checked" name="xingshenghuo" value="一般" id="xing_sheng_huo_yi_ban"/><label for="xing_sheng_huo_yi_ban"> 一般</label>
                <input type="radio" name="xingshenghuo" value="欠佳" id="xing_sheng_huo_qian_jia"/><label for="xing_sheng_huo_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.xingShengHuo==3 }">
                <input type="radio" name="xingshenghuo" value="良好" id="xing_sheng_huo_liang_hao"/><label for="xing_sheng_huo_liang_hao"> 良好</label>
                <input type="radio" name="xingshenghuo" value="一般" id="xing_sheng_huo_yi_ban"/><label for="xing_sheng_huo_yi_ban"> 一般</label>
                <input type="radio" checked="checked" name="xingshenghuo" value="欠佳" id="xing_sheng_huo_qian_jia"/><label for="xing_sheng_huo_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.xingShengHuo==null }">
                <input type="radio" name="xingshenghuo" value="良好" id="xing_sheng_huo_liang_hao"/><label for="xing_sheng_huo_liang_hao"> 良好</label>
                <input type="radio" name="xingshenghuo" value="一般" id="xing_sheng_huo_yi_ban"/><label for="xing_sheng_huo_yi_ban"> 一般</label>
                <input type="radio" name="xingshenghuo" value="欠佳" id="xing_sheng_huo_qian_jia"/><label for="xing_sheng_huo_qian_jia"> 欠佳</label>
                </c:if>
                <br/><br/>
                <label for="qing_xu_di_luo"> 是否出现：</label>
                <input type="hidden" value="${j.chuXian1 }" id="chu_xian1">
                <input type="checkbox" name="chu_xian_1" value="情绪低落" id="qing_xu_di_luo"/><label for="qing_xu_di_luo"> 情绪低落</label>
                <input type="checkbox" name="chu_xian_1" value="烦燥易怒" id="fan_zao_yi_nu"/><label for="fan_zao_yi_nu"> 烦燥易怒</label>
                <input type="checkbox" name="chu_xian_1" value="兴奋躁动" id="xing_fun_zao_daog"/><label for="xing_fun_zao_daog"> 兴奋躁动</label>
                <input type="checkbox" name="chu_xian_1" value="神经衰弱" id="shen_jing_shuai_ruo"/><label for="shen_jing_shuai_ruo"> 神经衰弱</label>
                <input type="checkbox" name="chu_xian_1" value="情感淡漠" id="qing_gan_dan_mo"/><label for="qing_gan_dan_mo"> 情感淡漠</label>
                <input type="checkbox" name="chu_xian_1" value="消极悲观" id="xiao_ji_bei_guan"/><label for="xiao_ji_bei_guan"> 消极悲观</label>
                <input type="checkbox" name="chu_xian_1" value="兴趣下降" id="xing_qu_xia_jiang"/><label for="xing_qu_xia_jiang"> 兴趣下降</label>
                <br/><br/>
                <label for="zhu_yi_fen_san"> 是否出现：</label>
                <input type="hidden" value="${j.chuXian2 }" id="chu_xian2">
                <input type="checkbox" name="chu_xian2" value="注意分散" id="zhu_yi_fen_san"/><label for="zhu_yi_fen_san"> 注意分散</label>
                <input type="checkbox" name="chu_xian2" value="记忆障碍" id="ji_yi_zhang_ai"/><label for="ji_yi_zhang_ai"> 记忆障碍</label>
                <input type="checkbox" name="chu_xian2" value="错觉" id="cuo_jue"/><label for="cuo_jue"> 错觉</label>
                <input type="checkbox" name="chu_xian2" value="幻觉" id="huan_jue"/><label for="huan_jue"> 幻觉</label>
                <input type="checkbox" name="chu_xian2" value="妄想" id="wang_xiang"/><label for="wang_xiang"> 妄想</label>
                <input type="checkbox" name="chu_xian2" value="意识障碍" id="yi_shi_zhang_ai"/><label for="yi_shi_zhang_ai"> 意识障碍</label>
                <input type="checkbox" name="chu_xian2" value="行为障碍" id="xing_wei_zhang_ai"/><label for="xing_wei_zhang_ai"> 行为障碍</label>
                <input type="checkbox" name="chu_xian2" value="行为退缩" id="xing_wei_tui_suo"/><label for="xing_wei_tui_suo"> 行为退缩</label>
                <input type="checkbox" name="chu_xian2" value="生活懒散" id="sheng_huo_lan_san"/><label for="sheng_huo_lan_san"> 生活懒散</label>
                <input type="checkbox" name="chu_xian2" value="意志力下降" id="yi_zhi_li_xia_jiang"/><label for="yi_zhi_li_xia_jiang"> 意志力下降</label>
                <br/><br/>
                <label>现病史：</label><label>1.有否类似发作: </label>
                <c:if test="${j.xianLeiSiFaZuo==1 }">
                <input type="radio" id="xian_has_lei_si_fa_zuo_wu" checked="checked" name="xian_has_lei_si_fa_zuo" value="反复发作"><label for="xian_has_lei_si_fa_zuo_wu">反复发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_ou_fa" name="xian_has_lei_si_fa_zuo" value="间断发作"><label for="xian_has_lei_si_fa_zuo_ou_fa">间断发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_duo_fa" name="xian_has_lei_si_fa_zuo" value="偶发"><label for="xian_has_lei_si_fa_zuo_duo_fa">偶发</label>
                </c:if>
                <c:if test="${j.xianLeiSiFaZuo==2 }">
                <input type="radio" id="xian_has_lei_si_fa_zuo_wu" name="xian_has_lei_si_fa_zuo" value="反复发作"><label for="xian_has_lei_si_fa_zuo_wu">反复发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_ou_fa" checked="checked" name="xian_has_lei_si_fa_zuo" value="间断发作"><label for="xian_has_lei_si_fa_zuo_ou_fa">间断发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_duo_fa" name="xian_has_lei_si_fa_zuo" value="偶发"><label for="xian_has_lei_si_fa_zuo_duo_fa">偶发</label>
                </c:if>
                <c:if test="${j.xianLeiSiFaZuo==3 }">
                <input type="radio" id="xian_has_lei_si_fa_zuo_wu" name="xian_has_lei_si_fa_zuo" value="反复发作"><label for="xian_has_lei_si_fa_zuo_wu">反复发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_ou_fa" name="xian_has_lei_si_fa_zuo" value="间断发作"><label for="xian_has_lei_si_fa_zuo_ou_fa">间断发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_duo_fa" checked="checked" name="xian_has_lei_si_fa_zuo" value="偶发"><label for="xian_has_lei_si_fa_zuo_duo_fa">偶发</label>
                </c:if>
                <c:if test="${j.xianLeiSiFaZuo==null }">
                <input type="radio" id="xian_has_lei_si_fa_zuo_wu" name="xian_has_lei_si_fa_zuo" value="反复发作"><label for="xian_has_lei_si_fa_zuo_wu">反复发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_ou_fa" name="xian_has_lei_si_fa_zuo" value="间断发作"><label for="xian_has_lei_si_fa_zuo_ou_fa">间断发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_duo_fa" name="xian_has_lei_si_fa_zuo" value="偶发"><label for="xian_has_lei_si_fa_zuo_duo_fa">偶发</label>
                </c:if>
                <label class="text_6">2.有否躯体疾病 :</label>
                <c:if test="${j.xianQuTiJiBing==1 }">
      			<input type="radio" id="xian_has_qu_ti_ji_bing_wu" checked="checked" name="xian_has_qu_ti_ji_bing" value="无"><label for="xian_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="xian_has_qu_ti_ji_bing_you" name="xian_has_qu_ti_ji_bing" value="偶发"><label for="xian_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.xianQuTiJiBing==2 }">
      			<input type="radio" id="xian_has_qu_ti_ji_bing_wu" name="xian_has_qu_ti_ji_bing" value="无"><label for="xian_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="xian_has_qu_ti_ji_bing_you" checked="checked" name="xian_has_qu_ti_ji_bing" value="偶发"><label for="xian_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.xianQuTiJiBing==null }">
      			<input type="radio" id="xian_has_qu_ti_ji_bing_wu" name="xian_has_qu_ti_ji_bing" value="无"><label for="xian_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="xian_has_qu_ti_ji_bing_you" name="xian_has_qu_ti_ji_bing" value="偶发"><label for="xian_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <br/><br/>
                <label> 具体疾病的诊断，时间 和用药史:</label>
                <br/>
                <textarea id="xian_bing_shi" name="xian_bing_shi" style="width: 800px;">
                	${j.xianJuTiJiBingZhenDuan }
                </textarea>
                <br/><br/>
                <label>既往病史：</label><label>1.有否类似发作: </label>
                <c:if test="${j.jiWangLeiSiFaZuo==1 }">
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_wu" checked="checked" name="ji_wang_has_lei_si_fa_zuo" value="无"><label for="ji_wang_has_lei_si_fa_zuo_wu">无</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_ou_fa" name="ji_wang_has_lei_si_fa_zuo" value="偶发"><label for="ji_wang_has_lei_si_fa_zuo_ou_fa">偶发</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_duo_fa" name="ji_wang_has_lei_si_fa_zuo" value="多发"><label for="ji_wang_has_lei_si_fa_zuo_duo_fa">多发</label>
                </c:if>
                <c:if test="${j.jiWangLeiSiFaZuo==2 }">
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_wu" name="ji_wang_has_lei_si_fa_zuo" value="无"><label for="ji_wang_has_lei_si_fa_zuo_wu">无</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_ou_fa" checked="checked" name="ji_wang_has_lei_si_fa_zuo" value="偶发"><label for="ji_wang_has_lei_si_fa_zuo_ou_fa">偶发</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_duo_fa" name="ji_wang_has_lei_si_fa_zuo" value="多发"><label for="ji_wang_has_lei_si_fa_zuo_duo_fa">多发</label>
                </c:if>
                <c:if test="${j.jiWangLeiSiFaZuo==3 }">
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_wu" name="ji_wang_has_lei_si_fa_zuo" value="无"><label for="ji_wang_has_lei_si_fa_zuo_wu">无</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_ou_fa" name="ji_wang_has_lei_si_fa_zuo" value="偶发"><label for="ji_wang_has_lei_si_fa_zuo_ou_fa">偶发</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_duo_fa" checked="checked" name="ji_wang_has_lei_si_fa_zuo" value="多发"><label for="ji_wang_has_lei_si_fa_zuo_duo_fa">多发</label>
                </c:if>
                <c:if test="${j.jiWangLeiSiFaZuo==null }">
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_wu" name="ji_wang_has_lei_si_fa_zuo" value="无"><label for="ji_wang_has_lei_si_fa_zuo_wu">无</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_ou_fa" name="ji_wang_has_lei_si_fa_zuo" value="偶发"><label for="ji_wang_has_lei_si_fa_zuo_ou_fa">偶发</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_duo_fa" name="ji_wang_has_lei_si_fa_zuo" value="多发"><label for="ji_wang_has_lei_si_fa_zuo_duo_fa">多发</label>
                </c:if>
                <label class="text_6">2.有否躯体疾病 :</label>
                <c:if test="${j.jiWangQuTiJiBing==1 }">
      			<input type="radio" id="ji_wang_has_qu_ti_ji_bing_wu" checked="checked" name="ji_wang_has_qu_ti_ji_bing" value="无"><label for="ji_wang_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="ji_wang_has_qu_ti_ji_bing_you" name="ji_wang_has_qu_ti_ji_bing" value="偶发"><label for="ji_wang_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.jiWangQuTiJiBing==2 }">
      			<input type="radio" id="ji_wang_has_qu_ti_ji_bing_wu" name="ji_wang_has_qu_ti_ji_bing" value="无"><label for="ji_wang_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="ji_wang_has_qu_ti_ji_bing_you" checked="checked" name="ji_wang_has_qu_ti_ji_bing" value="偶发"><label for="ji_wang_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.jiWangQuTiJiBing==null }">
      			<input type="radio" id="ji_wang_has_qu_ti_ji_bing_wu" name="ji_wang_has_qu_ti_ji_bing" value="无"><label for="ji_wang_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="ji_wang_has_qu_ti_ji_bing_you" name="ji_wang_has_qu_ti_ji_bing" value="偶发"><label for="ji_wang_has_qu_ti_ji_bing_you">有</label>          
                </c:if>
                <br/><br/>
                <label> 就诊医院，具体疾病的诊断及治疗，时间 和用药史:</label>
                <br/>
                <textarea id="ji_wang_bing_shi" name="ji_wang_bing_shi" style="width: 800px;">
                ${j.jiWangJuTiJiBingZhenDuan }
                </textarea>
                <br/><br/>
                <label>家族病史：</label><label>父系母系三代以内有否精神疾病、癫痫或心理疾病: </label>
                <c:if test="${j.jiaZuBingShi==1 }">
      			<input type="radio" id="jia_zu_has_ji_bing_wu" checked="checked" name="jia_zu_has_ji_bing" value="无"><label for="ji_wang_has_ji_bing_wu">无</label>
                <input type="radio" id="jia_zu_has_ji_bing_you" name="jia_zu_has_ji_bing" value="偶发"><label for="ji_wang_has_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.jiaZuBingShi==2 }">
      			<input type="radio" id="jia_zu_has_ji_bing_wu" name="jia_zu_has_ji_bing" value="无"><label for="ji_wang_has_ji_bing_wu">无</label>
                <input type="radio" id="jia_zu_has_ji_bing_you" checked="checked" name="jia_zu_has_ji_bing" value="偶发"><label for="ji_wang_has_ji_bing_you">有</label>          
                </c:if>
                <c:if test="${j.jiaZuBingShi==null }">
      			<input type="radio" id="jia_zu_has_ji_bing_wu" name="jia_zu_has_ji_bing" value="无"><label for="ji_wang_has_ji_bing_wu">无</label>
                <input type="radio" id="jia_zu_has_ji_bing_you" name="jia_zu_has_ji_bing" value="偶发"><label for="ji_wang_has_ji_bing_you">有</label>          
                </c:if>
                <br/><br/>
                <label> 具体疾病的诊断，时间 和用药史:</label>
                <br/>
                <textarea id="jia_zu_bing_shi" name="jia_zu_bing_shi" style="width: 800px;">
                	${j.jiaZuJuTiJiBingZhenDuan }
                </textarea>
                <br/><br/>
                <label for="nei_xiang"> 个性特点：</label>
                <c:if test="${j.geXingTeDian==1 }">
                <input type="radio" name="xingge" checked="checked" value="内向" id="nei_xiang"/><label for="nei_xiang"> 内向</label>
                <input type="radio" name="xingge" value="外向" id="wai_xiang"/><label for="wai_xiang"> 外向</label>
                <input type="radio" name="xingge" value="适中" id="shi_zhong"/><label for="shi_zhong"> 适中</label>
                </c:if>
                <c:if test="${j.geXingTeDian==2 }">
                <input type="radio" name="xingge" value="内向" id="nei_xiang"/><label for="nei_xiang"> 内向</label>
                <input type="radio" name="xingge" checked="checked" value="外向" id="wai_xiang"/><label for="wai_xiang"> 外向</label>
                <input type="radio" name="xingge" value="适中" id="shi_zhong"/><label for="shi_zhong"> 适中</label>
                </c:if>
                <c:if test="${j.geXingTeDian==3 }">
                <input type="radio" name="xingge" value="内向" id="nei_xiang"/><label for="nei_xiang"> 内向</label>
                <input type="radio" name="xingge" value="外向" id="wai_xiang"/><label for="wai_xiang"> 外向</label>
                <input type="radio" name="xingge" checked="checked" value="适中" id="shi_zhong"/><label for="shi_zhong"> 适中</label>
                </c:if>
                <c:if test="${j.geXingTeDian==null }">
                <input type="radio" name="xingge" value="内向" id="nei_xiang"/><label for="nei_xiang"> 内向</label>
                <input type="radio" name="xingge" value="外向" id="wai_xiang"/><label for="wai_xiang"> 外向</label>
                <input type="radio" name="xingge" value="适中" id="shi_zhong"/><label for="shi_zhong"> 适中</label>
                </c:if>
                <br/><br/>
                <label for="wen_ding">情绪稳定性：</label>
                <c:if test="${j.qingXuWenDingXing==1 }">
                <input type="radio" name="qingxu" checked="checked" value="稳定" id="wen_ding"/><label for="wen_ding"> 稳定</label>
                <input type="radio" name="qingxu" value="欠稳定" id="qian_wen_ding"/><label for="qian_wen_ding"> 欠稳定</label>
                </c:if>
                <c:if test="${j.qingXuWenDingXing==2 }">
                <input type="radio" name="qingxu" value="稳定" id="wen_ding"/><label for="wen_ding"> 稳定</label>
                <input type="radio" name="qingxu" checked="checked" value="欠稳定" id="qian_wen_ding"/><label for="qian_wen_ding"> 欠稳定</label>
                </c:if>
                <c:if test="${j.qingXuWenDingXing==null }">
                <input type="radio" name="qingxu" value="稳定" id="wen_ding"/><label for="wen_ding"> 稳定</label>
                <input type="radio" name="qingxu" value="欠稳定" id="qian_wen_ding"/><label for="qian_wen_ding"> 欠稳定</label>
                </c:if>
                <br/><br/>
                <label for="ren_ge_a_xing"> 人格特点：</label>
                <c:if test="${j.renGeTeDian==1 }">
                <input type="radio" name="tedian" checked="checked" value="A型" id="ren_ge_a_xing"/><label for="ren_ge_a_xing"> A型</label>
                <input type="radio" name="tedian" value="B型" id="ren_ge_b_xing"/><label for="ren_ge_b_xing"> B型</label>
                <input type="radio" name="tedian" value="C型" id="ren_ge_c_xing"/><label for="ren_ge_c_xing"> C型</label>
                </c:if>
                <c:if test="${j.renGeTeDian==2 }">
                <input type="radio" name="tedian" value="A型" id="ren_ge_a_xing"/><label for="ren_ge_a_xing"> A型</label>
                <input type="radio" name="tedian" checked="checked" value="B型" id="ren_ge_b_xing"/><label for="ren_ge_b_xing"> B型</label>
                <input type="radio" name="tedian" value="C型" id="ren_ge_c_xing"/><label for="ren_ge_c_xing"> C型</label>
                </c:if>
                <c:if test="${j.renGeTeDian==3 }">
                <input type="radio" name="tedian" value="A型" id="ren_ge_a_xing"/><label for="ren_ge_a_xing"> A型</label>
                <input type="radio" name="tedian" value="B型" id="ren_ge_b_xing"/><label for="ren_ge_b_xing"> B型</label>
                <input type="radio" name="tedian" checked="checked" value="C型" id="ren_ge_c_xing"/><label for="ren_ge_c_xing"> C型</label>
                </c:if>
                <c:if test="${j.renGeTeDian==null }">
                <input type="radio" name="tedian" value="A型" id="ren_ge_a_xing"/><label for="ren_ge_a_xing"> A型</label>
                <input type="radio" name="tedian" value="B型" id="ren_ge_b_xing"/><label for="ren_ge_b_xing"> B型</label>
                <input type="radio" name="tedian" value="C型" id="ren_ge_c_xing"/><label for="ren_ge_c_xing"> C型</label>
                </c:if>
                <br/><br/>
                <label for="xue_xing_a_xing"> 血型：</label>
                <c:if test="${j.xueXing==1 }">
                <input type="radio" name="xuexing" checked="checked" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                </c:if>
                <c:if test="${j.xueXing==2 }">
                <input type="radio" name="xuexing" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" checked="checked" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                </c:if>
                <c:if test="${j.xueXing==3 }">
                <input type="radio" name="xuexing" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" checked="checked" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                </c:if>
                <c:if test="${j.xueXing==4 }">
                <input type="radio" name="xuexing" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" checked="checked" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                </c:if>
                <c:if test="${j.xueXing==null }">
                <input type="radio" name="xuexing" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                </c:if>
                <br/><br/>
                <label for="ping_dan"> 人格特质：</label>
                <input type="hidden" value="${j.renGeTeZhi }" id="ren_ge_te_zhi" >
                <input type="checkbox" name="renge" value="平淡" id="ping_dan"/><label for="ping_dan"> 平淡</label>
                <input type="checkbox" name="renge" value="淡漠" id="dan_mo"/><label for="dan_mo"> 淡漠</label>
                <input type="checkbox" name="renge" value="活跃" id="huo_yue"/><label for="huo_yue"> 活跃</label>
                <input type="checkbox" name="renge" value="敌意" id="di_yi"/><label for="di_yi"> 敌意</label>
                <br/><br/>
                <label for="du_shu"> 兴趣：</label>
                <input type="hidden" value="${j.xingQu }" id="xing_qu">
                <input type="checkbox" name="xingqu" value="读书" id="du_shu"/><label for="du_shu"> 读书</label>
                <input type="checkbox" name="xingqu" value="听音乐" id="ting_yin_yue"/><label for="ting_yin_yue"> 听音乐</label>
                <input type="checkbox" name="xingqu" value="唱歌" id="chang_ge"/><label for="chang_ge"> 唱歌</label>
                <input type="checkbox" name="xingqu" value="跳舞" id="tiao_wu"/><label for="tiao_wu"> 跳舞</label>
                <input type="checkbox" name="xingqu" value="琴棋" id="qin_qi"/><label for="qin_qi"> 琴棋</label>
                <input type="checkbox" name="xingqu" value="书画" id="shu_hua"/><label for="shu_hua"> 书画</label>
                <input type="checkbox" name="xingqu" value="体育" id="ti_yu"/><label for="ti_yu"> 体育</label>
                <input type="checkbox" name="xingqu" value="影视（喜剧）" id="ying_shi_xi_ju"/><label for="ying_shi_xi_ju"> 影视（喜剧）</label>
                <input type="checkbox" name="xingqu" value="影视（悲剧）" id="ying_shi_bei_ju"/><label for="ying_shi_bei_ju"> 影视（悲剧）</label>
                <br/><br/>
                <label for="yan"> 烟</label><input type="number" value="${j.yan }" min="1" max="250" name="ya" id="yan" class="sheng_zhang_fa_yu" />支/天，
                <label for="jiu"> 酒</label><input type="number" min="1" value="${j.jiu }" max="250" name="jiu" id="jiu"  class="sheng_zhang_fa_yu" />两/天，
                <label for="qita"> 其他</label><input type="text" value="${j.yanJiuQiTa }" id="qita" name="yan_jiu_qi_ta" class="jianju">
                <br/><br/>
                <label for="zu_yue"> 生长发育：</label>
                <input type="hidden" value="${j.shengZhangFaYu }" id="sheng_zhang_fa_yu">
                <input type="checkbox" name="shengzhang" value="足月" id="zu_yue"/><label for="zu_yue"> 足月</label>
                <input type="checkbox" name="shengzhang" value="顺产" id="shun_chan"/><label for="shun_chan"> 顺产</label>
                <input type="checkbox" name="shengzhang" value="早产" id="zao_chan"/><label for="zao_chan"> 早产</label>
                <input type="checkbox" name="shengzhang" value="剖腹产" id="pao_fu_chan"/><label for="pao_fu_chan"> 剖腹产</label>
                <input type="checkbox" name="shengzhang" value="难产" id="nan_chan"/><label for="nan_chan"> 难产</label>
                <input type="checkbox" name="shengzhang" value="母乳" id="mu_ru"/><label for="mu_ru"> 母乳</label>
                <label for="huizou" class="text_6"> 学步</label><input type="number" value="${j.xueBu }" min="1" max="250" name="walk" id="huizou" class="sheng_zhang_fa_yu" />岁，
                <label for="huishuohua"> 语言</label><input type="number" value="${j.yuYan }" min="1" max="250" name="talk" id="huishuohua" class="sheng_zhang_fa_yu" />岁，
                <label for="yuejingchuchao"> 月经初潮</label><input type="number" value="${j.yueJingChuChao }" min="1" max="250" name="yuejing" id="yuejingchuchao" class="sheng_zhang_fa_yu" />岁，
                <label for="shouciyijing">首次遗精</label> <input type="number" value="${j.shouCiYiJing }" min="1" max="250" name="yijing" id="shouciyijing" class="sheng_zhang_fa_yu" />岁，
                <label for="tingjing"> 停经</label><input type="number" value="${j.tingJing }" min="1" max="250" name="ting" id="tingjing" class="sheng_zhang_fa_yu" />岁
                <br/><br/>
                <label for="zu_fu_mu"> 幼年抚养人：</label>
                <input type="hidden" value="${j.youNianFuYangRen }" id="you_nian_fu_yang_ren">
                <input type="checkbox" name="fuyangren" value="祖父/母" id="zu_fu_mu"/><label for="zu_fu_mu"> 祖父/母</label>
                 <input type="checkbox" name="fuyangren" value="外祖父/母" id="wai_zu_fu_mu"/> <label for="wai_zu_fu_mu"> 外祖父/母</label>
                <input type="checkbox" name="fuyangren" value="父" id="fu_mu"/><label for="fu_mu"> 父/母</label>
                <input type="checkbox" name="fuyangren" value="兄" id="xiong"/><label for="xiong"> 兄</label>
                <input type="checkbox" name="fuyangren" value="姐" id="jie"/> <label for="jie"> 姐</label>
                <!--<input type="checkbox" name="fuyangren" value="其他寄养" id="qi_ta_ji_yang"/><label for="qi_ta_ji_yang"> 其他寄养</label>-->
               <label for="jiyangshi1" class="text_6"> 其他寄养史（几岁到几岁）</label>
                <input type="number" value="${j.jiYangShi1 }" max="250" min="1" class="sheng_zhang_fa_yu" name="jiyang1" id="jiyangshi1">到<input type="number" value="${j.jiYangShi2 }" max="250" min="1" class="sheng_zhang_fa_yu" name="jiyang2" id="jiyangshi2">
                <br/><br/>
                <label for="you_nian_huan_jing_he_xie"> 幼年生活环境：</label>
                <input type="hidden" value="${j.youNianShengHuoHuanJing }" id="you_nian_sheng_huo_huan_jing">
                 <input type="checkbox" name="you_nian_huan_jing" value="和谐" id="you_nian_huan_jing_he_xie"/><label for="you_nian_huan_jing_he_xie"> 和谐</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="温暖" id="you_nian_huan_jing_wen_nuan"/><label for="you_nian_huan_jing_wen_nuan"> 温暖</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="一般" id="you_nian_huan_jing_yi_ban"/><label for="you_nian_huan_jing_yi_ban"> 一般</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="冷淡" id="you_nian_huan_jing_leng_dan"/><label for="you_nian_huan_jing_leng_dan" class="text_7">冷淡</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="敌意" id="you_nian_huan_jing_di_yi"/><label for="you_nian_huan_jing_di_yi"> 敌意</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="依赖" id="you_nian_huan_jing_yi_lai"/><label for="you_nian_huan_jing_yi_lai"> 依赖</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="过度保护" id="you_nian_huan_jing_guo_du_bao_hu"/><label for="you_nian_huan_jing_guo_du_bao_hu"> 过度保护</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="过度忽略" id="you_nian_huan_jing_guo_du_hu_lue"/><label for="you_nian_huan_jing_guo_du_hu_lue"> 过度忽略</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="民主" id="you_nian_huan_jing_min_zhu"/><label for="you_nian_huan_jing_min_zhu"> 民主</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="专制" id="you_nian_huan_jing_zhuan_zhi"/><label for="you_nian_huan_jing_zhuan_zhi"> 专制</label>
                 <br/><br/>
                 <label for="xian_zai_huan_jing_he_xie"> 现在生活环境：</label>
                 <input type="hidden" value="${j.xianZaiShengHuoHuanJing }" id="xian_zai_sheng_huo_huan_jing">
                 <input type="checkbox" name="xian_zai_huan_jing" value="和谐" id="xian_zai_huan_jing_he_xie"/><label for="xian_zai_huan_jing_he_xie"> 和谐</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="温暖" id="xian_zai_huan_jing_wen_nuan"/><label for="xian_zai_huan_jing_wen_nuan"> 温暖</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="一般" id="xian_zai_huan_jing_yi_ban"/><label for="xian_zai_huan_jing_yi_ban"> 一般</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="冷淡" id="xian_zai_huan_jing_leng_dan"/><label for="xian_zai_huan_jing_leng_dan"> 冷淡</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="敌意" id="xian_zai_huan_jing_di_yi"/><label for="xian_zai_huan_jing_di_yi"> 敌意</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="依赖" id="xian_zai_huan_jing_yi_lai"/><label for="xian_zai_huan_jing_yi_lai"> 依赖</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="过度保护" id="xian_zai_huan_jing_guo_du_bao_hu"/><label for="xian_zai_huan_jing_guo_du_bao_hu"> 过度保护</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="过度忽略" id="xian_zai_huan_jing_guo_du_hu_lue"/><label for="xian_zai_huan_jing_guo_du_hu_lue"> 过度忽略</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="民主" id="xian_zai_huan_jing_min_zhu"/><label for="xian_zai_huan_jing_min_zhu" class="text_7">民主</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="专制" id="xian_zai_huan_jing_zhuan_zhi"/><label for="xian_zai_huan_jing_zhuan_zhi"> 专制</label>
                <br/><br/>
                <label for="yu_xiong_di_jie_mei_liang_hao"> 与兄弟姐妹们关系：</label>
                <c:if test="${j.xiongDiJieMeiGuanXi==1 }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" checked="checked" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <c:if test="${j.xiongDiJieMeiGuanXi==2 }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" checked="checked" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <c:if test="${j.xiongDiJieMeiGuanXi==3 }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" checked="checked" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <c:if test="${j.xiongDiJieMeiGuanXi==4 }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" checked="checked" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <c:if test="${j.xiongDiJieMeiGuanXi==5 }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" checked="checked" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <c:if test="${j.xiongDiJieMeiGuanXi==null }">
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                </c:if>
                <br/><br/>
                <label for="fu_qi_guan_xi_liang_hao"> 夫妻关系：</label>
                <c:if test="${j.fuQiGuanXi==1 }">
                 <input type="radio" name="fu_qi_guan_xi" checked="checked" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.fuQiGuanXi==2 }">
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" checked="checked" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.fuQiGuanXi==3 }">
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" checked="checked" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.fuQiGuanXi==4 }">
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" checked="checked" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.fuQiGuanXi==5 }">
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" checked="checked" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.fuQiGuanXi==null }">
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                </c:if>
                <br/><br/>
                <label for="po_xi_guan_xi_liang_hao">婆媳关系：</label>
                <c:if test="${j.poXiGuanXi==1 }">
                 <input type="radio" name="po_xi_guan_xi" checked="checked" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.poXiGuanXi==2 }">
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" checked="checked" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.poXiGuanXi==3 }">
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" checked="checked" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.poXiGuanXi==4 }">
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" checked="checked" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.poXiGuanXi==5 }">
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" checked="checked" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                <c:if test="${j.poXiGuanXi==null }">
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                </c:if>
                 <br/><br/>
                <label>父母职业：父亲职业</label>
                <select name="fu_qin_zhi_ye">
                    <option>${j.fuQinZhiYe }</option>
                </select>
                <label class="text_6">母亲职业</label>
                <select name="mu_qin_zhi_ye">
                    <option>${j.muQinZhiYe }</option>
                </select>
                 <br/><br/>
                <label>父母文化程序：父亲文化程度</label>
                <select name="fu_qin_wen_hua">
                    <option>${j.fuQinWenHuaChengDu }</option>
                </select>
                <label class="text_6">母亲文化程度</label>
                <select name="mu_qin_wen_hua">
                    <option>${j.muQinWenHuaChengDu }</option>
                </select>
				<br/><br/>
                <label for="zhong_da_fu_xing_shi_jian_wu"> 重大负性事件（自幼年到现在）</label>
                <c:if test="${j.zhongDaFuXingShiJian1==1 }">
                <input type="radio" name="fu_xing_shi_jian" checked="checked" value="无" id="zhong_da_fu_xing_shi_jian_wu"/><label for="zhong_da_fu_xing_shi_jian_wu"> 无</label>
                <input type="radio" name="fu_xing_shi_jian" value="有" id="zhong_da_fu_xing_shi_jian_you"/><label for="zhong_da_fu_xing_shi_jian_you"> 有</label>
               	</c:if>
               	<c:if test="${j.zhongDaFuXingShiJian1==2 }">
                <input type="radio" name="fu_xing_shi_jian" value="无" id="zhong_da_fu_xing_shi_jian_wu"/><label for="zhong_da_fu_xing_shi_jian_wu"> 无</label>
                <input type="radio" name="fu_xing_shi_jian" checked="checked" value="有" id="zhong_da_fu_xing_shi_jian_you"/><label for="zhong_da_fu_xing_shi_jian_you"> 有</label>
               	</c:if>
               	<c:if test="${j.zhongDaFuXingShiJian1==null }">
                <input type="radio" name="fu_xing_shi_jian" value="无" id="zhong_da_fu_xing_shi_jian_wu"/><label for="zhong_da_fu_xing_shi_jian_wu"> 无</label>
                <input type="radio" name="fu_xing_shi_jian" value="有" id="zhong_da_fu_xing_shi_jian_you"/><label for="zhong_da_fu_xing_shi_jian_you"> 有</label>
               	</c:if>
               	<br/>
                <textarea id="fu_xing_shi_jian_nei_rong" name="fu_xing_shi_jian_nei_rong" style="width: 800px;">
                ${j.zhongDaFuXingShiJian2 }
                </textarea>
                <br/><br/>
                <label for="ying_ji_shi_jian_wu"> 应激事件（自幼年到现在）</label>
                <c:if test="${j.yingJiShiJian1==1 }">
                <input type="radio" name="ying_ji_shi_jian" checked="checked" value="无" id="ying_ji_shi_jian_wu"/><label for="ying_ji_shi_jian_wu"> 无</label>
                <input type="radio" name="ying_ji_shi_jian" value="有" id="ying_ji_shi_jian_you"/><label for="ying_ji_shi_jian_you"> 有</label>
                </c:if>
                <c:if test="${j.yingJiShiJian1==2 }">
                <input type="radio" name="ying_ji_shi_jian" value="无" id="ying_ji_shi_jian_wu"/><label for="ying_ji_shi_jian_wu"> 无</label>
                <input type="radio" name="ying_ji_shi_jian" checked="checked" value="有" id="ying_ji_shi_jian_you"/><label for="ying_ji_shi_jian_you"> 有</label>
                </c:if>
                <c:if test="${j.yingJiShiJian1==null }">
                <input type="radio" name="ying_ji_shi_jian" value="无" id="ying_ji_shi_jian_wu"/><label for="ying_ji_shi_jian_wu"> 无</label>
                <input type="radio" name="ying_ji_shi_jian" value="有" id="ying_ji_shi_jian_you"/><label for="ying_ji_shi_jian_you"> 有</label>
                </c:if>
                <br/>
                <textarea id="ying_ji_shi_jian_nei_rong" name="ying_ji_shi_jian_nei_rong" style="width: 800px;">
                ${j.yingJiShiJian2 }
                </textarea>
                <br/><br/>

                <label for="ren_ji_guan_xi_liang_hao"> 人际关系：</label>
                <c:if test="${j.renJiGuanXi==1 }">
                <input type="radio" name="renjiguanxi" checked="checked" value="良好" id="ren_ji_guan_xi_liang_hao"/><label for="ren_ji_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="renjiguanxi" value="一般" id="ren_ji_guan_xi_yi_ban"/><label for="ren_ji_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="renjiguanxi" value="欠佳" id="ren_ji_guan_xi_qian_jia"/><label for="ren_ji_guan_xi_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.renJiGuanXi==2 }">
                <input type="radio" name="renjiguanxi" value="良好" id="ren_ji_guan_xi_liang_hao"/><label for="ren_ji_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="renjiguanxi" checked="checked" value="一般" id="ren_ji_guan_xi_yi_ban"/><label for="ren_ji_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="renjiguanxi" value="欠佳" id="ren_ji_guan_xi_qian_jia"/><label for="ren_ji_guan_xi_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.renJiGuanXi==3 }">
                <input type="radio" name="renjiguanxi" value="良好" id="ren_ji_guan_xi_liang_hao"/><label for="ren_ji_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="renjiguanxi" value="一般" id="ren_ji_guan_xi_yi_ban"/><label for="ren_ji_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="renjiguanxi" checked="checked" value="欠佳" id="ren_ji_guan_xi_qian_jia"/><label for="ren_ji_guan_xi_qian_jia"> 欠佳</label>
                </c:if>
                <c:if test="${j.renJiGuanXi==null }">
                <input type="radio" name="renjiguanxi" value="良好" id="ren_ji_guan_xi_liang_hao"/><label for="ren_ji_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="renjiguanxi" value="一般" id="ren_ji_guan_xi_yi_ban"/><label for="ren_ji_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="renjiguanxi" value="欠佳" id="ren_ji_guan_xi_qian_jia"/><label for="ren_ji_guan_xi_qian_jia"> 欠佳</label>
                </c:if>
                <br/><br/>
                <label for="wen_ti_biao_xian_hai_xiu"> 问题表现为：</label>
                <input type="hidden" value="${j.wenTiBiaoXianWei }" id="wen_ti_biao_xian_wei">
                <input type="checkbox" name="wenti" value="害羞" id="wen_ti_biao_xian_hai_xiu"/><label for="wen_ti_biao_xian_hai_xiu"> 害羞</label>
                <input type="checkbox" name="wenti" value="自卑" id="wen_ti_biao_xian_zi_bei"/><label for="wen_ti_biao_xian_zi_bei"> 自卑</label>
                <input type="checkbox" name="wenti" value="顾虑" id="wen_ti_biao_xian_gu_lv"/><label for="wen_ti_biao_xian_gu_lv"> 顾虑</label>
                <input type="checkbox" name="wenti" value="恐惧" id="wen_ti_biao_xian_kong_jv"/><label for="wen_ti_biao_xian_kong_jv"> 恐惧</label>
                <input type="checkbox" name="wenti" value="敌对" id="wen_ti_biao_xian_di_dui"/><label for="wen_ti_biao_xian_di_dui"> 敌对</label>
                <input type="checkbox" name="wenti" value="封闭" id="wen_ti_biao_xian_feng_bi"/><label for="wen_ti_biao_xian_feng_bi" class="text_7">封闭</label>
                <input type="checkbox" name="wenti" value="误会" id="wen_ti_biao_xian_wu_hui"/><label for="wen_ti_biao_xian_wu_hui"> 误会</label>
                <input type="checkbox" name="wenti" value="不会相处" id="wen_ti_biao_xian_bu_hui_xiang_chu"/>不会相处
                 <br/><br/>
                <label for="wen_ti_fa_sheng_zai_shang_ji"> 问题发生在：</label>
                <input type="hidden" value="${j.wenTiFaShengZai }" id="wen_ti_fa_sheng_zai">
                <input type="checkbox" name="wentifasheng" value="上级" id="wen_ti_fa_sheng_zai_shang_ji"/><label for="wen_ti_fa_sheng_zai_shang_ji"> 上级</label>
                <input type="checkbox" name="wentifasheng" value="下级" id="wen_ti_fa_sheng_zai_xia_ji"/><label for="wen_ti_fa_sheng_zai_xia_ji">下级</label>
                <input type="checkbox" name="wentifasheng" value="同事" id="wen_ti_fa_sheng_zai_tong_shi"/><label for="wen_ti_fa_sheng_zai_tong_shi">同事</label>
                <input type="checkbox" name="wentifasheng" value="同学" id="wen_ti_fa_sheng_zai_tong_xue"/><label for="wen_ti_fa_sheng_zai_tong_xue"> 同学</label>
                <input type="checkbox" name="wentifasheng" value="朋友" id="wen_ti_fa_sheng_zai_peng_you"/><label for="wen_ti_fa_sheng_zai_peng_you"> 朋友</label>
                <input type="checkbox" name="wentifasheng" value="公婆" id="wen_ti_fa_sheng_zai_gong_po"/><label for="wen_ti_fa_sheng_zai_gong_po"> 公婆</label>
                <input type="checkbox" name="wentifasheng" value="岳父母" id="wen_ti_fa_sheng_zai_yue_fu_mu"/><label for="wen_ti_fa_sheng_zai_yue_fu_mu"> 岳父母</label>
                <input type="checkbox" name="wentifasheng" value="夫妻" id="wen_ti_fa_sheng_zai_fu_qi"/><label for="wen_ti_fa_sheng_zai_fu_qi"> 夫妻</label>
                <input type="checkbox" name="wentifasheng" value="子女" id="wen_ti_fa_sheng_zai_zi_nv"/><label for="wen_ti_fa_sheng_zai_zi_nv"> 子女</label>
                <input type="checkbox" name="wentifasheng" value="父母" id="wen_ti_fa_sheng_zai_fu_mu"/><label for="wen_ti_fa_sheng_zai_fu_mu"> 父母</label>
				<br/><br/>
                <label for="else"> 其他：</label><input type="text" value="${j.wenTiFaShengQiTa }" name="qitafangmian" id="else" class="jianju"/>
                <br/><br/>
                <label for="sheng_huo_man_yi_man_yi"> 生活满意与否：</label>
                <c:if test="${j.shengHuoManYiYuFou==1 }">
                <input type="radio" name="shenghuomianyiyufou" checked="checked" value="满意" id="sheng_huo_man_yi_man_yi"/><label for="sheng_huo_man_yi_man_yi"> 满意</label>
                <input type="radio" name="shenghuomianyiyufou" value="尚可" id="sheng_huo_man_yi_shang_ke"/><label for="sheng_huo_man_yi_shang_ke"> 尚可</label>
                <input type="radio" name="shenghuomianyiyufou" value="不满意" id="sheng_huo_man_yi_bu_man_yi"/><label for="sheng_huo_man_yi_bu_man_yi"> 不满意</label>
                </c:if>
                <c:if test="${j.shengHuoManYiYuFou==2 }">
                <input type="radio" name="shenghuomianyiyufou" value="满意" id="sheng_huo_man_yi_man_yi"/><label for="sheng_huo_man_yi_man_yi"> 满意</label>
                <input type="radio" name="shenghuomianyiyufou" checked="checked" value="尚可" id="sheng_huo_man_yi_shang_ke"/><label for="sheng_huo_man_yi_shang_ke"> 尚可</label>
                <input type="radio" name="shenghuomianyiyufou" value="不满意" id="sheng_huo_man_yi_bu_man_yi"/><label for="sheng_huo_man_yi_bu_man_yi"> 不满意</label>
                </c:if>
                <c:if test="${j.shengHuoManYiYuFou==3 }">
                <input type="radio" name="shenghuomianyiyufou" value="满意" id="sheng_huo_man_yi_man_yi"/><label for="sheng_huo_man_yi_man_yi"> 满意</label>
                <input type="radio" name="shenghuomianyiyufou" value="尚可" id="sheng_huo_man_yi_shang_ke"/><label for="sheng_huo_man_yi_shang_ke"> 尚可</label>
                <input type="radio" name="shenghuomianyiyufou" checked="checked" value="不满意" id="sheng_huo_man_yi_bu_man_yi"/><label for="sheng_huo_man_yi_bu_man_yi"> 不满意</label>
                </c:if>
                <c:if test="${j.shengHuoManYiYuFou==null }">
                <input type="radio" name="shenghuomianyiyufou" value="满意" id="sheng_huo_man_yi_man_yi"/><label for="sheng_huo_man_yi_man_yi"> 满意</label>
                <input type="radio" name="shenghuomianyiyufou" value="尚可" id="sheng_huo_man_yi_shang_ke"/><label for="sheng_huo_man_yi_shang_ke"> 尚可</label>
                <input type="radio" name="shenghuomianyiyufou" value="不满意" id="sheng_huo_man_yi_bu_man_yi"/><label for="sheng_huo_man_yi_bu_man_yi"> 不满意</label>
                </c:if>
                 <br/><br/>
                <label for="bu_man_yi_shen_ti"> 不满意的方面：</label>
                <input type="hidden" value="${j.buManYiDeFangMian }" id="bu_man_yi">
                 <input type="checkbox" name="bu_man_yi_fang_mian" value="身体" id="bu_man_yi_shen_ti"/><label for="bu_man_yi_shen_ti"> 身体</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="工作" id="bu_man_yi_gong_zuo"/><label for="bu_man_yi_gong_zuo"> 工作</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="学习" id="bu_man_yi_xue_xi"/><label for="bu_man_yi_xue_xi"> 学习</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="职称" id="bu_man_yi_zhi_cheng"/><label for="bu_man_yi_zhi_cheng"> 职称</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="经济" id="bu_man_yi_jing_ji"/><label for="bu_man_yi_jing_ji">经济</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="住房" id="bu_man_yi_zhu_fang"/><label for="bu_man_yi_zhu_fang"> 住房</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="周围环境" id="bu_man_yi_zhou_wei_huan_jing"/><label for="bu_man_yi_zhou_wei_huan_jing"> 周围环境</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="社交环境" id="bu_man_yi_she_jiao_huan_jing"/><label for="bu_man_yi_she_jiao_huan_jing">社交环境</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="家庭环境" id="bu_man_yi_jia_ting_huan_jing"/><label for="bu_man_yi_jia_ting_huan_jing"> 家庭环境</label>
                <br/><br/>
                <label for="bu_man_yi_fang_mian_qi_ta"> 其它：</label><input type="text" id="bu_man_yi_fang_mian_qi_ta" name="bu_man_yi_fang_mian" class="jianju">
                <br/><br/>
                <label for="dang_qian_ji_bing_wan_quan_zheng_que"> 当前疾病的认知：</label>
                <c:if test="${j.dangQianJiBingRenZhi==1 }">
                <input type="radio" name="ji_bing_ren_zhi" checked="checked" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <c:if test="${j.dangQianJiBingRenZhi==2 }">
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" checked="checked" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <c:if test="${j.dangQianJiBingRenZhi==3 }">
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" checked="checked" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <c:if test="${j.dangQianJiBingRenZhi==4 }">
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" checked="checked" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <c:if test="${j.dangQianJiBingRenZhi==5 }">
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" checked="checked" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <c:if test="${j.dangQianJiBingRenZhi==null }">
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                </c:if>
                <br/><br/>
                <label for="ji_bing_yu_hou_tai_du_fei_chang_ji_ji"> 疾病愈后的态度：</label>
                <c:if test="${j.jiBingYuHouTaiDu==1 }">
                <input type="radio" name="taidu" checked="checked" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.jiBingYuHouTaiDu==2 }">
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" checked="checked" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.jiBingYuHouTaiDu==3 }">
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" checked="checked" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.jiBingYuHouTaiDu==4 }">
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" checked="checked" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.jiBingYuHouTaiDu==5 }">
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" checked="checked" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.jiBingYuHouTaiDu==null }">
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <br/><br/>
                <label for="ying_dui_fang_shi_fei_chang_ji_ji"> 应对方式：</label>
                <c:if test="${j.yingDuiFangShi==1 }">
                <input type="radio" name="yingduifangshi" checked="checked" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.yingDuiFangShi==2 }">
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" checked="checked" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.yingDuiFangShi==3 }">
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" checked="checked" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.yingDuiFangShi==4 }">
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" checked="checked" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.yingDuiFangShi==5 }">
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" checked="checked" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <c:if test="${j.yingDuiFangShi==null }">
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                </c:if>
                <br/><br/>
                <label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 治疗参与程度：</label>
                <c:if test="${j.zhiLiaoCanYuChengDu==1 }">
                <input type="radio" name="zhiliaocanyu" checked="checked" value="积极主动" id="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"/><label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 积极主动</label>
                 <input type="radio" name="zhiliaocanyu" value="消极被动" id="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong"/><label for="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong">消极被动</label>
                 <input type="radio" name="zhiliaocanyu" value="一般" id="chan_yu_zhi_liao_cheng_du_yi_ban"/><label for="chan_yu_zhi_liao_cheng_du_yi_ban"> 一般</label>
                </c:if>
                <c:if test="${j.zhiLiaoCanYuChengDu==2 }">
                <input type="radio" name="zhiliaocanyu" value="积极主动" id="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"/><label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 积极主动</label>
                 <input type="radio" name="zhiliaocanyu" checked="checked" value="消极被动" id="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong"/><label for="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong">消极被动</label>
                 <input type="radio" name="zhiliaocanyu" value="一般" id="chan_yu_zhi_liao_cheng_du_yi_ban"/><label for="chan_yu_zhi_liao_cheng_du_yi_ban"> 一般</label>
                </c:if>
                <c:if test="${j.zhiLiaoCanYuChengDu==3 }">
                <input type="radio" name="zhiliaocanyu" value="积极主动" id="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"/><label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 积极主动</label>
                 <input type="radio" name="zhiliaocanyu" value="消极被动" id="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong"/><label for="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong">消极被动</label>
                 <input type="radio" name="zhiliaocanyu" checked="checked" value="一般" id="chan_yu_zhi_liao_cheng_du_yi_ban"/><label for="chan_yu_zhi_liao_cheng_du_yi_ban"> 一般</label>
                </c:if>
                <c:if test="${j.zhiLiaoCanYuChengDu==null }">
                <input type="radio" name="zhiliaocanyu" value="积极主动" id="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"/><label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 积极主动</label>
                 <input type="radio" name="zhiliaocanyu" value="消极被动" id="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong"/><label for="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong">消极被动</label>
                 <input type="radio" name="zhiliaocanyu" value="一般" id="chan_yu_zhi_liao_cheng_du_yi_ban"/><label for="chan_yu_zhi_liao_cheng_du_yi_ban"> 一般</label>
                </c:if>
                <br/><br/>
                <label for="she_hui_zhi_chi_ji_cha"> 社会支持：</label>
                <c:if test="${j.sheHuiZhiChi==1 }">
                <input type="radio" name="shehuizhichi" checked="checked" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.sheHuiZhiChi==2 }">
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" checked="checked" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.sheHuiZhiChi==3 }">
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" checked="checked" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.sheHuiZhiChi==4 }">
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" checked="checked" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.sheHuiZhiChi==5 }">
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" checked="checked" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.sheHuiZhiChi==null }">
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                </c:if>
                <br/><br/>
                <label for="peng_you_ji_cha"> 朋友：</label>
                <c:if test="${j.pengYou==1 }">
                <input type="radio" name="pengyou" checked="checked" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.pengYou==2 }">
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" checked="checked" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.pengYou==3 }">
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" checked="checked" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.pengYou==4 }">
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" checked="checked" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.pengYou==5 }">
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" checked="checked" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.pengYou==null }">
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                </c:if>
                <br/><br/>
                <label for="jia_ren_ji_cha"> 家人：</label>
                <c:if test="${j.jiaRen==1 }">
                <input type="radio" name="jiaren" checked="checked" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.jiaRen==2 }">
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" checked="checked" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.jiaRen==3 }">
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" checked="checked" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.jiaRen==4 }">
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" checked="checked" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.jiaRen==5 }">
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" checked="checked" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.jiaRen==null }">
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                </c:if>
                <br/><br/>
                <label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 对各项支持的利用度：</label>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==1 }">
                <input type="radio" name="gexiangzhichi" checked="checked" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==2 }">
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" checked="checked" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==3 }">
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" checked="checked" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==4 }">
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" checked="checked" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==5 }">
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" checked="checked" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                <c:if test="${j.duiGeXiangZhiChiLiYongDu==null }">
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                </c:if>
                 <br/><br/>
                家谱图：<!-- <input type="file" name="jiapu" style="width: 150px"/> -->
                房树人：<input type="file" name="jiapu"style="width: 150px"/>
                <br/>
                <!-- <input type="submit" value="上传"/>
                <input type="submit" value="上传"/> -->
                <br/>
                <img src="#" width="200px" height="200px">
                 <img src="#" width="200px" height="200px">
                <br/><br/>
               <label> 印象：</label>
               <c:if test="${j.yinXiang==1 }">
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==2 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==3 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==4 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==5 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==6 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==7 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==8 }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" checked="checked" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <c:if test="${j.yinXiang==null }">
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               </c:if>
               <br/><br/>
               <label>其它：</label><input type="text" name="yin_xiang_qi_ta" value="${j.yinXiangQiTa }" class="jianju"/>
               <br><br>
				<label>处置:</label>
				<c:if test="${j.chuZhi==1 }">
				<input type="radio" name="chu_zhi" checked="checked" id="chu_zhi_xin_shen" value="心身测评（脑功能检测，HRV检测，精神科A,B C类量表）"><label for="chu_zhi_xin_shen">心身测评（脑功能检测，HRV检测，精神科A,B C类量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_xin_nao" value="心脑检测（脑功能检测，HRV，首访量表）"><label for="chu_zhi_xin_nao">心脑检测（脑功能检测，HRV，首访量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_sjgn" value="植物神经功能检测（HRV，首访量表）"><label for="chu_zhi_sjgn">植物神经功能检测（HRV，首访量表）</label>
				</c:if>
				<c:if test="${j.chuZhi==2 }">
				<input type="radio" name="chu_zhi" id="chu_zhi_xin_shen" value="心身测评（脑功能检测，HRV检测，精神科A,B C类量表）"><label for="chu_zhi_xin_shen">心身测评（脑功能检测，HRV检测，精神科A,B C类量表）</label><br><br>
               <input type="radio" name="chu_zhi" checked="checked" id="chu_zhi_xin_nao" value="心脑检测（脑功能检测，HRV，首访量表）"><label for="chu_zhi_xin_nao">心脑检测（脑功能检测，HRV，首访量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_sjgn" value="植物神经功能检测（HRV，首访量表）"><label for="chu_zhi_sjgn">植物神经功能检测（HRV，首访量表）</label>
				</c:if>
				<c:if test="${j.chuZhi==3 }">
				<input type="radio" name="chu_zhi" id="chu_zhi_xin_shen" value="心身测评（脑功能检测，HRV检测，精神科A,B C类量表）"><label for="chu_zhi_xin_shen">心身测评（脑功能检测，HRV检测，精神科A,B C类量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_xin_nao" value="心脑检测（脑功能检测，HRV，首访量表）"><label for="chu_zhi_xin_nao">心脑检测（脑功能检测，HRV，首访量表）</label><br><br>
               <input type="radio" name="chu_zhi" checked="checked" id="chu_zhi_sjgn" value="植物神经功能检测（HRV，首访量表）"><label for="chu_zhi_sjgn">植物神经功能检测（HRV，首访量表）</label>
				</c:if>
				<c:if test="${j.chuZhi==null }">
				<input type="radio" name="chu_zhi" id="chu_zhi_xin_shen" value="心身测评（脑功能检测，HRV检测，精神科A,B C类量表）"><label for="chu_zhi_xin_shen">心身测评（脑功能检测，HRV检测，精神科A,B C类量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_xin_nao" value="心脑检测（脑功能检测，HRV，首访量表）"><label for="chu_zhi_xin_nao">心脑检测（脑功能检测，HRV，首访量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_sjgn" value="植物神经功能检测（HRV，首访量表）"><label for="chu_zhi_sjgn">植物神经功能检测（HRV，首访量表）</label>
				</c:if>
				<br><br>
            </div>
        </div>
            </div>
        </div>
<script type="text/javascript">
$(document).ready(function(){
	$("#suo_shu_ke_shi").change(function(){
		var ks = $.trim($("#suo_shu_ke_shi").val());
		$.post("jcxx?m=gzkys",{ks:ks},function(r){
			$("#zhuan_ke_yi_sheng").empty();
			for(var d in r) {
				$("#zhuan_ke_yi_sheng").append("<option value='"+r[d]+"'>"+r[d]+"</option>");
			}
		},"json");
	});
	$("#jcxx-all").submit(function(){
		if($.trim($("#zhuan_ke_yi_sheng").val()) == "") {
			alert("专科医生未填！！");
			return false;
		}
		if($.trim($("#xing_ming").val()) == "") {
			alert("姓名未填！！");
			return false;
		}
		if($.trim($("#nav").val()) == "" && $.trim($("#nv").val()) == "") {
			alert("性别未填！！");
			return false;
		}
		if($.trim($("#nian").val()) == "") {
			alert("出生日期未填！！");
			return false;
		}
		if($.trim($("#yue").val()) == "") {
			alert("出生日期未填！！");
			return false;
		}
		if($.trim($("#ri").val()) == "") {
			alert("出生日期未填！！");
			return false;
		}
		if($.trim($("#lian_xi_di_zhi").val()) == "") {
			alert("联系地址未填！！");
			return false;
		}
		if($.trim($("#lian_xi_dian_hua").val()) == "") {
			alert("联系电话未填！！");
			return false;
		}
	});  
});  $(document).ready(function(){
	setting();
});
</script>
  <%@include file="/commons/tail.jsp" %>
