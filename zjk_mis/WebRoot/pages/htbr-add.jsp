<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>回头病人</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/upcss/jichuxinxi.css" rel="stylesheet" type="text/css" />
	<link href="css/cepingshi/ji_chu_xin_xi_tian_jia.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/cepingshi/jian_ce_xiang_mu_tian_jia.js"></script>
    <link href="css/modal.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/htbr.js"></script>
  <%@include file="/commons/header.jsp" %>
  
  <div class="all__content">
            <div style="margin-left: 20px">
            <form action="jcxx?m=sssht" enctype="multipart/form-data" method="post" id="jcxx-all">
            <label for="yong_hu_id">用户ID：</label>
                <input type="hidden" value="${token }" name="token">
                <input type="text" name="yong_hu_id" id="yong_hu_id" readonly="readonly" />
                <input type="button" value="选择病人" id="ji_chu_xin_xi_btn" onclick="fadeIns('formTable_jcxx');">
                <label for="ri_qi" class="text_4">首诊日期：</label>
                <input type="datetime-local " name="ri_qi" id="ri_qi" value="${shou_zhen_ri_qi }" readonly="readonly" />
                <label for="men_zhen_hao" class="text_4"> 门诊号：</label>
                <input type="text" name="men_zhen_hao" id="men_zhen_hao" value="" />
                <label for="bing_an_hao" class="text_4">病案号：</label>
                <input type="text" name="bing_an_hao" id="bing_an_hao" value=""/>
                <br /><br />
                <label for="zhu_guan_yi_shi"> 主管医师：</label>
                <select name="zhu_guan_yi_shi" id="zhu_guan_yi_shi">
                	<option>请选择</option>
                	<c:forEach items="${zhuGuanYiShengs }" var="ys">
                		<option value="${ys.xingMing }">${ys.xingMing }</option>
                	</c:forEach>
                </select>
                <label for="suo_shu_ke_shi" class="text_2">所属科室：</label>
                <select name="suo_shu_ke_shi" id="suo_shu_ke_shi">
                	<option>请选择</option>
                    <c:forEach items="${keShis }" var="ks">
                		<option value="${ks.mingCheng }">${ks.mingCheng }</option>
                	</c:forEach>
                </select>
                <label for="zhuan_ke_yi_sheng" class="text_2">专科医生：</label>
                <select name="zhuan_ke_yi_sheng" id="zhuan_ke_yi_sheng">
                    
                </select>
                
                <br/> <br/>
                <label for="xing_ming">姓名：</label>
                <input type="text" name="xing_ming" id="xing_ming">
                <label for="nan" class="text_2">性别：</label>
                <input type="radio" id="nan" name="xing_bie" value="男"><label for="nan">男</label>
                <input type="radio" id="nv" name="xing_bie" value="女"><label for="nv">女</label>
                <label for="nian" class="text_2">出生日期：</label>
                <input type="number" min="0" max="3000" name="nian" id="nian" style="width: 50px;" />年
                <input type="number" min="0" max="12" name="yue" id="yue" style="width: 50px;" />月
                <input type="number" min="0" max="31" name="ri" id="ri" style="width: 50px;" />日
                <br><br>
                <label for="min_zu">民族：</label>
                <input type="text" name="min_zu" id="min_zu" value="汉" /><span>族</span>
                <label for="hun_yin_zhuang_kuang" class="text_2">婚姻状况：</label>
                <select name="hun_yin_zhuang_kuang" id="hun_yin_zhuang_kuang">
                    <option value="已婚">已婚</option>
                    <option value="未婚">未婚</option>
                    <option value="丧偶">丧偶</option>
                    <option value="离婚">离婚</option>
                </select>
                <label for="shen_gao" class="text_2">身高：</label>
                <input type="number" min="0" max="350" id="shen_gao" name="shen_gao" /><span>cm</span>
                <label for="ti_zhong" class="text_2">体重：</label>
                <input type="number" min="0" max="350" name="ti_zhong" id="ti_zhong"/><span>kg</span>
                <br /><br />
                <label for="chu_sheng_di">出生地：</label>
                <input type="text" name="chu_sheng_di" id="chu_sheng_di" class="jianju">
                <br/><br/>
                <label for="zhi_ye">职业：</label>
                <select name="zhi_ye" id="zhi_ye">
                    <option value="一般职业">一般职业</option>
                    <option value="农牧业">农牧业</option>
                    <option value="渔业">渔业</option>
                    <option value="木材、森林业">木材、森林业</option>
                    <option value="矿业、采石业">矿业、采石业</option>
                    <option value="交通运输业">交通运输业</option>
                    <option value="餐旅业">餐旅业</option>
                    <option value="建筑工程业（土木工程）">建筑工程业（土木工程）</option>
                    <option value="制造业">制造业</option>
                    <option value="新闻、出版、广告业">新闻、出版、广告业</option>
                    <option value="卫生">卫生</option>
                    <option value="娱乐业">娱乐业</option>
                    <option value="文教">文教</option>
                    <option value="宗教">宗教</option>
                    <option value="公共事业">公共事业</option>
                    <option value="商业">商业</option>
                    <option value="金融业">金融业</option>
                    <option value="服务业">服务业</option>
                    <option value="家庭管理">家庭管理</option>
                    <option value="治安人员">治安人员</option>
                    <option value="军人">军人</option>
                    <option value="体育">体育</option>
                    <option value="资讯">资讯</option>
                    <option value="其他">其他</option>
                </select>
                <label for="wen_hua_cheng_du">文化程度：</label>
                <select name="wen_hua_cheng_du" id="wen_hua_cheng_du">
                    <option value="小学">小学</option>
                    <option value="初中">初中</option>
                    <option value="高中">高中</option>
                    <option value="本科">本科</option>
                    <option value="本科以上">本科以上</option>
                </select>
                <label for="jia_li_pai_hang_1">家里排行：</label>
                <input type="number" min="1" max="31" name="jia_li_pai_hang_1" id="jia_li_pai_hang_1" style="width: 50px;" value="${j.paiHang1 }" />
                /
                <input type="number" min="1" max="31" name="jia_li_pai_hang_2" id="jia_li_pai_hang_2" style="width: 50px;" value="${j.paiHang2 }" />
                <br/><br/>
                <label for="lian_xi_dian_hua">联系电话：</label><input type="text" name="lian_xi_dian_hua" id="lian_xi_dian_hua"/>
                <label for="liang_hao" class="text_2">经济状况：</label>
                      <input type="radio" name="jing_ji_zhuang_kuang" id="liang_hao" value="良好"/><label for="liang_hao">良好</label>
                      <input type="radio" name="jing_ji_zhuang_kuang" id="yi_ban" value="一般"/><label for="yi_ban">一般</label>
                      <input type="radio" name="jing_ji_zhuang_kuang" id="jiao_cha" value="较差"/><label for="jiao_cha">较差</label>
                      <input type="radio" name="jing_ji_zhuang_kuang" id="hen_cha" value="很差"/><label for="hen_cha">很差</label>
                
                <br/><br/>
                
                <label for="lian_xi_di_zhi">联系地址：</label>
                <input type="text" name="lian_xi_di_zhi" id="lian_xi_di_zhi" class="jianju"/>
                <br/><br/><hr><br>
                <label for="ji_bing_wen_ti">就诊原因：</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="疾病问题" id="ji_bing_wen_ti"/><label for="ji_bing_wen_ti" class="jianju8">疾病问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="睡眠问题" id="shui_mian_wen_ti"/><label for="shui_mian_wen_ti" class="jianju8">睡眠问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="情绪问题" id="qing_xu_wen_ti"/><label for="qing_xu_wen_ti" class="jianju8">情绪问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="认知问题" id="ren_zhi_wen_ti"/><label for="ren_zhi_wen_ti" class="jianju8">认知问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="记忆问题" id="ji_yi_wen_ti"/><label for="ji_yi_wen_ti" class="jianju8">记忆问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="注意力问题" id="zhu_yi_li_wen_ti"/><label for="zhu_yi_li_wen_ti" class="jianju8">注意力问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="人际关系" id="ren_ji_wen_ti"/><label for="ren_ji_wen_ti" class="jianju8">人际关系</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="婚恋情感" id="hun_lian_qing_gan"/><label for="hun_lian_qing_gan" class="jianju8">婚恋情感</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="工作问题" id="gong_zuo_wen_ti"/><label for="gong_zuo_wen_ti" class="jianju8">工作问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="学习问题" id="xue_xi_wen_ti"/><label for="xue_xi_wen_ti" class="jianju8">学习问题</label>
                      <input type="checkbox" name="jiu_zhen_yuan_yin" value="个性问题" id="ge_xing_wen_ti"/><label for="ge_xing_wen_ti" class="jianju8">个性问题</label>
                      <br><br>
                      <label for="jiu_zhen_yuan_yin_qi_ta">其它：</label>
                      <!-- <input type="text" name="jiu_zhen_yuan_yin" id="jiu_zhen_yuan_yin_qi_ta" class="jianju"> -->
                      <textarea rows="" cols=""  name="jiu_zhen_yuan_yin" id="jiu_zhen_yuan_yin_qi_ta" style="width:800px;"></textarea>
                <br/><br/>
                <label for="liang_hao"> 睡眠：</label>
                <input type="checkbox" name="shuimian" value="良好" id="shui_mian_liang_hao"/><label for="shui_mian_liang_hao">良好</label>
                <input type="checkbox" name="shuimian" value="一般" id="shui_mian_yi_ban"/><label for="shui_mian_yi_ban">一般</label>
                <input type="checkbox" name="shuimian" value="欠佳" id="shui_mian_qian_jia"/><label for="shui_mian_qian_jia">欠佳</label>
                <input type="checkbox" name="shuimian" value="入睡困难" id="ru_shui_kun_nan"/><label for="ru_shui_kun_nan"> 入睡困难</label>
                <input type="checkbox" name="shuimian" value="早醒" id="shui_mian_zao_xing"/><label for="shui_mian_zao_xing"> 早醒</label>
                <input type="checkbox" name="shuimian" value="睡眠深度不足" id="shui_mian_shen_du_bu_zu"/><label for="shui_mian_shen_du_bu_zu"> 睡眠深度不足</label>
                <input type="checkbox" name="shuimian" value="嗜睡" id="shui_mian_shi_shui"/><label for="shui_mian_shi_shui"> 嗜睡</label>
                <input type="checkbox" name="shuimian" value="醒后无力" id="xing_hou_wu_li"/><label for="xing_hou_wu_li"> 醒后无力</label>
                <br/><br/>
                <label for="shi_yu_liang_hao"> 食欲：</label>
                <input type="radio" name="shiyu" value="良好" id="shi_yu_liang_hao"/><label for="shi_yu_liang_hao"> 良好</label>
                <input type="radio" name="shiyu" value="一般" id="shi_yu_yi_ban"/><label for="shi_yu_yi_ban"> 一般</label>
                <input type="radio" name="shiyu" value="欠佳" id="shi_yu_qian_jia"/><label for="shi_yu_qian_jia"> 欠佳</label>
                <br/><br/>
                <label for="xing_sheng_huo_liang_hao"> 性生活：</label>
                <input type="radio" name="xingshenghuo" value="良好" id="xing_sheng_huo_liang_hao"/><label for="xing_sheng_huo_liang_hao"> 良好</label>
                <input type="radio" name="xingshenghuo" value="一般" id="xing_sheng_huo_yi_ban"/><label for="xing_sheng_huo_yi_ban"> 一般</label>
                <input type="radio" name="xingshenghuo" value="欠佳" id="xing_sheng_huo_qian_jia"/><label for="xing_sheng_huo_qian_jia"> 欠佳</label>
                <br/><br/>
                <label for="qing_xu_di_luo"> 是否出现：</label>
                <input type="checkbox" name="chu_xian_1" value="情绪低落" id="qing_xu_di_luo"/><label for="qing_xu_di_luo"> 情绪低落</label>
                <input type="checkbox" name="chu_xian_1" value="烦燥易怒" id="fan_zao_yi_nu"/><label for="fan_zao_yi_nu"> 烦燥易怒</label>
                <input type="checkbox" name="chu_xian_1" value="兴奋躁动" id="xing_fun_zao_daog"/><label for="xing_fun_zao_daog"> 兴奋躁动</label>
                <input type="checkbox" name="chu_xian_1" value="神经衰弱" id="shen_jing_shuai_ruo"/><label for="shen_jing_shuai_ruo"> 神经衰弱</label>
                <input type="checkbox" name="chu_xian_1" value="情感淡漠" id="qing_gan_dan_mo"/><label for="qing_gan_dan_mo"> 情感淡漠</label>
                <input type="checkbox" name="chu_xian_1" value="消极悲观" id="xiao_ji_bei_guan"/><label for="xiao_ji_bei_guan"> 消极悲观</label>
                <input type="checkbox" name="chu_xian_1" value="兴趣下降" id="xing_qu_xia_jiang"/><label for="xing_qu_xia_jiang"> 兴趣下降</label>
                <br/><br/>
                <label for="zhu_yi_fen_san"> 是否出现：</label>
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
                <input type="radio" id="xian_has_lei_si_fa_zuo_wu" name="xian_has_lei_si_fa_zuo" value="反复发作"><label for="xian_has_lei_si_fa_zuo_wu">反复发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_ou_fa" name="xian_has_lei_si_fa_zuo" value="间断发作"><label for="xian_has_lei_si_fa_zuo_ou_fa">间断发作</label>
                <input type="radio" id="xian_has_lei_si_fa_zuo_duo_fa" name="xian_has_lei_si_fa_zuo" value="偶发"><label for="xian_has_lei_si_fa_zuo_duo_fa">偶发</label>
                <label class="text_2">2.有否躯体疾病 :</label>
      			<input type="radio" id="xian_has_qu_ti_ji_bing_wu" name="xian_has_qu_ti_ji_bing" value="无"><label for="xian_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="xian_has_qu_ti_ji_bing_you" name="xian_has_qu_ti_ji_bing" value="偶发"><label for="xian_has_qu_ti_ji_bing_you">有</label>          
                <br/><br/>
                <label> 具体疾病的诊断，时间 和用药史:</label>
                <br/>
                <textarea id="xian_bing_shi" name="xian_bing_shi" style="width: 800px;">
                </textarea>
                <br/><br/>
                <label>既往病史：</label><label>1.有否类似发作: </label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_wu" name="ji_wang_has_lei_si_fa_zuo" value="无"><label for="ji_wang_has_lei_si_fa_zuo_wu">无</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_ou_fa" name="ji_wang_has_lei_si_fa_zuo" value="偶发"><label for="ji_wang_has_lei_si_fa_zuo_ou_fa">偶发</label>
                <input type="radio" id="ji_wang_has_lei_si_fa_zuo_duo_fa" name="ji_wang_has_lei_si_fa_zuo" value="多发"><label for="ji_wang_has_lei_si_fa_zuo_duo_fa">多发</label>
                <label class="text_2">2.有否躯体疾病 :</label>
      			<input type="radio" id="ji_wang_has_qu_ti_ji_bing_wu" name="ji_wang_has_qu_ti_ji_bing" value="无"><label for="ji_wang_has_qu_ti_ji_bing_wu">无</label>
                <input type="radio" id="ji_wang_has_qu_ti_ji_bing_you" name="ji_wang_has_qu_ti_ji_bing" value="偶发"><label for="ji_wang_has_qu_ti_ji_bing_you">有</label>          
                <br/><br/>
                <label> 就诊医院，具体疾病的诊断及治疗，时间 和用药史:</label>
                <br/>
                <textarea id="ji_wang_bing_shi" name="ji_wang_bing_shi" style="width: 800px;">
                </textarea>
                <br/><br/>
                <label>家族病史：</label><label>父系母系三代以内有否精神疾病、癫痫或心理疾病: </label>
      			<input type="radio" id="jia_zu_has_ji_bing_wu" name="jia_zu_has_ji_bing" value="无"><label for="ji_wang_has_ji_bing_wu">无</label>
                <input type="radio" id="jia_zu_has_ji_bing_you" name="jia_zu_has_ji_bing" value="偶发"><label for="ji_wang_has_ji_bing_you">有</label>          
                <br/><br/>
                <label> 具体疾病的诊断，时间 和用药史:</label>
                <br/>
                <textarea id="jia_zu_bing_shi" name="jia_zu_bing_shi" style="width: 800px;">
                </textarea>
                <br/><br/>
                <label for="nei_xiang"> 个性特点：</label>
                <input type="radio" name="xingge" value="内向" id="nei_xiang"/><label for="nei_xiang"> 内向</label>
                <input type="radio" name="xingge" value="外向" id="wai_xiang"/><label for="wai_xiang"> 外向</label>
                <input type="radio" name="xingge" value="适中" id="shi_zhong"/><label for="shi_zhong"> 适中</label>
                <br/><br/>
                <label for="wen_ding">情绪稳定性：</label>
                <input type="radio" name="qingxu" value="稳定" id="wen_ding"/><label for="wen_ding"> 稳定</label>
                <input type="radio" name="qingxu" value="欠稳定" id="qian_wen_ding"/><label for="qian_wen_ding"> 欠稳定</label>
                <br/><br/>
                <label for="ren_ge_a_xing"> 人格特点：</label>
                <input type="radio" name="tedian" value="A型" id="ren_ge_a_xing"/><label for="ren_ge_a_xing"> A型</label>
                <input type="radio" name="tedian" value="B型" id="ren_ge_b_xing"/><label for="ren_ge_b_xing"> B型</label>
                <input type="radio" name="tedian" value="C型" id="ren_ge_c_xing"/><label for="ren_ge_c_xing"> C型</label>
                <br/><br/>
                <label for="xue_xing_a_xing"> 血型：</label>
                <input type="radio" name="xuexing" value="A型" id="xue_xing_a_xing"/><label for="xue_xing_a_xing"> A型</label>
                <input type="radio" name="xuexing" value="B型" id="xue_xing_b_xing"/><label for="xue_xing_b_xing"> B型</label>
                <input type="radio" name="xuexing" value="AB型" id="xue_xing_ab_xing"/><label for="xue_xing_ab_xing"> AB型</label>
                <input type="radio" name="xuexing" value="O型" id="xue_xing_o_xing"/><label for="xue_xing_o_xing"> O型</label>
                <br/><br/>
                <label for="ping_dan"> 人格特质：</label>
                <input type="checkbox" name="renge" value="平淡" id="ping_dan"/><label for="ping_dan"> 平淡</label>
                <input type="checkbox" name="renge" value="淡漠" id="dan_mo"/><label for="dan_mo"> 淡漠</label>
                <input type="checkbox" name="renge" value="活跃" id="huo_yue"/><label for="huo_yue"> 活跃</label>
                <input type="checkbox" name="renge" value="敌意" id="di_yi"/><label for="di_yi"> 敌意</label>
                <br/><br/>
                <label for="du_shu"> 兴趣：</label>
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
                <label for="yan"> 烟</label><input type="number" min="0" max="250" name="ya" id="yan" class="sheng_zhang_fa_yu" />支/天，
                <label for="jiu"> 酒</label><input type="number" min="0" max="250" name="jiu" id="jiu"  class="sheng_zhang_fa_yu" />两/天，
                <label for="qita"> 其他</label><input type="text" id="qita" name="yan_jiu_qi_ta" class="jianju">
                <br/><br/>
                <label for="zu_yue"> 生长发育：</label>
                <input type="checkbox" name="shengzhang" value="足月" id="zu_yue"/><label for="zu_yue"> 足月</label>
                <input type="checkbox" name="shengzhang" value="顺产" id="shun_chan"/><label for="shun_chan"> 顺产</label>
                <input type="checkbox" name="shengzhang" value="早产" id="zao_chan"/><label for="zao_chan"> 早产</label>
                <input type="checkbox" name="shengzhang" value="剖腹产" id="pao_fu_chan"/><label for="pao_fu_chan"> 剖腹产</label>
                <input type="checkbox" name="shengzhang" value="难产" id="nan_chan"/><label for="nan_chan"> 难产</label>
                <input type="checkbox" name="shengzhang" value="母乳" id="mu_ru"/><label for="mu_ru"> 母乳</label>
                <label for="huizou" class="text_2"> 学步</label><input type="number" min="1" max="250" name="walk" id="huizou" class="sheng_zhang_fa_yu" />岁，
                <label for="huishuohua"> 语言</label><input type="number" min="1" max="250" name="talk" id="huishuohua" class="sheng_zhang_fa_yu" />岁，
                <label for="yuejingchuchao"> 月经初潮</label><input type="number" min="1" max="250" name="yuejing" id="yuejingchuchao" class="sheng_zhang_fa_yu" />岁，
                <label for="shouciyijing">首次遗精</label> <input type="number" min="1" max="250" name="yijing" id="shouciyijing" class="sheng_zhang_fa_yu" />岁，
                <label for="tingjing"> 停经</label><input type="number" min="1" max="250" name="ting" id="tingjing" class="sheng_zhang_fa_yu" />岁
                <br/><br/>
                <label for="zu_fu_mu"> 幼年抚养人：</label>
                <input type="checkbox" name="fuyangren" value="祖父/母" id="zu_fu_mu"/><label for="zu_fu_mu"> 祖父/母</label>
                 <input type="checkbox" name="fuyangren" value="外祖父/母" id="wai_zu_fu_mu"/> <label for="wai_zu_fu_mu"> 外祖父/母</label>
                <input type="checkbox" name="fuyangren" value="父" id="fu_mu"/><label for="fu_mu"> 父/母</label>
                <input type="checkbox" name="fuyangren" value="兄" id="xiong"/><label for="xiong"> 兄</label>
                <input type="checkbox" name="fuyangren" value="姐" id="jie"/> <label for="jie"> 姐</label>
                <!--<input type="checkbox" name="fuyangren" value="其他寄养" id="qi_ta_ji_yang"/><label for="qi_ta_ji_yang"> 其他寄养</label>-->
               <label for="jiyangshi1" class="text_2"> 其他寄养史（几岁到几岁）</label>
                <input type="number" max="250" min="1" class="sheng_zhang_fa_yu" name="jiyang1" id="jiyangshi1">到<input type="number" max="250" min="1" class="sheng_zhang_fa_yu" name="jiyang2" id="jiyangshi2">
                <br/><br/>
                <label for="you_nian_huan_jing_he_xie"> 幼年生活环境：</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="和谐" id="you_nian_huan_jing_he_xie"/><label for="you_nian_huan_jing_he_xie"> 和谐</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="温暖" id="you_nian_huan_jing_wen_nuan"/><label for="you_nian_huan_jing_wen_nuan"> 温暖</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="一般" id="you_nian_huan_jing_yi_ban"/><label for="you_nian_huan_jing_yi_ban"> 一般</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="冷淡" id="you_nian_huan_jing_leng_dan"/><label for="you_nian_huan_jing_leng_dan" class="jianju8">冷淡</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="敌意" id="you_nian_huan_jing_di_yi"/><label for="you_nian_huan_jing_di_yi"> 敌意</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="依赖" id="you_nian_huan_jing_yi_lai"/><label for="you_nian_huan_jing_yi_lai"> 依赖</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="过度保护" id="you_nian_huan_jing_guo_du_bao_hu"/><label for="you_nian_huan_jing_guo_du_bao_hu"> 过度保护</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="过度忽略" id="you_nian_huan_jing_guo_du_hu_lue"/><label for="you_nian_huan_jing_guo_du_hu_lue"> 过度忽略</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="民主" id="you_nian_huan_jing_min_zhu"/><label for="you_nian_huan_jing_min_zhu"> 民主</label>
                 <input type="checkbox" name="you_nian_huan_jing" value="专制" id="you_nian_huan_jing_zhuan_zhi"/><label for="you_nian_huan_jing_zhuan_zhi"> 专制</label>
                 <br/><br/>
                 <label for="xian_zai_huan_jing_he_xie"> 现在生活环境：</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="和谐" id="xian_zai_huan_jing_he_xie"/><label for="xian_zai_huan_jing_he_xie"> 和谐</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="温暖" id="xian_zai_huan_jing_wen_nuan"/><label for="xian_zai_huan_jing_wen_nuan"> 温暖</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="一般" id="xian_zai_huan_jing_yi_ban"/><label for="xian_zai_huan_jing_yi_ban"> 一般</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="冷淡" id="xian_zai_huan_jing_leng_dan"/><label for="xian_zai_huan_jing_leng_dan"> 冷淡</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="敌意" id="xian_zai_huan_jing_di_yi"/><label for="xian_zai_huan_jing_di_yi"> 敌意</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="依赖" id="xian_zai_huan_jing_yi_lai"/><label for="xian_zai_huan_jing_yi_lai"> 依赖</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="过度保护" id="xian_zai_huan_jing_guo_du_bao_hu"/><label for="xian_zai_huan_jing_guo_du_bao_hu"> 过度保护</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="过度忽略" id="xian_zai_huan_jing_guo_du_hu_lue"/><label for="xian_zai_huan_jing_guo_du_hu_lue"> 过度忽略</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="民主" id="xian_zai_huan_jing_min_zhu"/><label for="xian_zai_huan_jing_min_zhu" class="jianju8">民主</label>
                 <input type="checkbox" name="xian_zai_huan_jing" value="专制" id="xian_zai_huan_jing_zhuan_zhi"/><label for="xian_zai_huan_jing_zhuan_zhi"> 专制</label>
                <br/><br/>
                <label for="yu_xiong_di_jie_mei_liang_hao"> 与兄弟姐妹们关系：</label>
                 <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="良好" id="yu_xiong_di_jie_mei_liang_hao"/><label for="yu_xiong_di_jie_mei_liang_hao"> 良好</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="尚可" id="yu_xiong_di_jie_mei_shang_ke"/><label for="yu_xiong_di_jie_mei_shang_ke"> 尚可</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="一般" id="yu_xiong_di_jie_mei_yi_ban"/><label for="yu_xiong_di_jie_mei_yi_ban"> 一般</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="冷淡" id="yu_xiong_di_jie_mei_leng_dan"/><label for="yu_xiong_di_jie_mei_leng_dan"> 冷淡</label>
                <input type="radio" name="yu_xiong_di_jie_mei_guan_xi" value="差" id="yu_xiong_di_jie_mei_cha"/><label for="yu_xiong_di_jie_mei_cha"> 差</label>
                 <br/><br/>
                <label for="fu_qi_guan_xi_liang_hao"> 夫妻关系：</label>
                 <input type="radio" name="fu_qi_guan_xi" value="良好" id="fu_qi_guan_xi_liang_hao"/><label for="fu_qi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="fu_qi_guan_xi" value="尚可" id="fu_qi_guan_xi_shang_ke"/><label for="fu_qi_guan_xi_shang_ke"> 尚可</label>
                <input type="radio" name="fu_qi_guan_xi" value="一般" id="fu_qi_guan_xi_yi_ban"/><label for="fu_qi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="fu_qi_guan_xi" value="冷淡" id="fu_qi_guan_xi_leng_dan"/><label for="fu_qi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="fu_qi_guan_xi" value="差" id="fu_qi_guan_xi_cha"/><label for="fu_qi_guan_xi_cha"> 差</label>
                <br/><br/>
                <label for="po_xi_guan_xi_liang_hao">婆媳关系：</label>
                 <input type="radio" name="po_xi_guan_xi" value="良好" id="po_xi_guan_xi_liang_hao"/><label for="po_xi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="po_xi_guan_xi" value="尚可" id="po_xi_guan_xi_shang_ke"/><label for="po_xi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="po_xi_guan_xi" value="一般" id="po_xi_guan_xi_yi_ban"/><label for="po_xi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="po_xi_guan_xi" value="冷淡" id="po_xi_guan_xi_leng_dan"/><label for="po_xi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="po_xi_guan_xi" value="差" id="po_xi_guan_xi_cha"/><label for="po_xi_guan_xi_cha"> 差</label>
                 <br/><br/>
                <label for="qin_zi_guan_xi_liang_hao">亲子关系：</label>
                 <input type="radio" name="qin_zi_guan_xi" value="良好" id="qin_zi_guan_xi_liang_hao" class="text_6"/><label for="qin_zi_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="qin_zi_guan_xi" value="尚可" id="qin_zi_guan_xi_shang_ke"/><label for="qin_zi_guan_xi_shang_ke">尚可</label>
                <input type="radio" name="qin_zi_guan_xi" value="一般" id="qin_zi_guan_xi_yi_ban"/><label for="qin_zi_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="qin_zi_guan_xi" value="冷淡" id="qin_zi_guan_xi_leng_dan"/><label for="qin_zi_guan_xi_leng_dan"> 冷淡</label>
                <input type="radio" name="qin_zi_guan_xi" value="差" id="qin_zi_guan_xi_cha"/><label for="qin_zi_guan_xi_cha"> 差</label>
                  <br/>
                <br/>
                <label>父母职业：父亲职业</label>
                <select name="fu_qin_zhi_ye">
                    <option value="一般职业">一般职业</option>
                    <option value="农牧业">农牧业</option>
                    <option value="渔业">渔业</option>
                    <option value="木材、森林业">木材、森林业</option>
                    <option value="矿业、采石业">矿业、采石业</option>
                    <option value="交通运输业">交通运输业</option>
                    <option value="餐旅业">餐旅业</option>
                    <option value="建筑工程业（土木工程）">建筑工程业（土木工程）</option>
                    <option value="制造业">制造业</option>
                    <option value="新闻、出版、广告业">新闻、出版、广告业</option>
                    <option value="卫生">卫生</option>
                    <option value="娱乐业">娱乐业</option>
                    <option value="文教">文教</option>
                    <option value="宗教">宗教</option>
                    <option value="公共事业">公共事业</option>
                    <option value="商业">商业</option>
                    <option value="金融业">金融业</option>
                    <option value="服务业">服务业</option>
                    <option value="家庭管理">家庭管理</option>
                    <option value="治安人员">治安人员</option>
                    <option value="军人">军人</option>
                    <option value="体育">体育</option>
                    <option value="资讯">资讯</option>
                    <option value="其他">其他</option>
                </select>
                <label class="text_2">母亲职业</label>
                <select name="mu_qin_zhi_ye">
                    <option value="一般职业">一般职业</option>
                    <option value="农牧业">农牧业</option>
                    <option value="渔业">渔业</option>
                    <option value="木材、森林业">木材、森林业</option>
                    <option value="矿业、采石业">矿业、采石业</option>
                    <option value="交通运输业">交通运输业</option>
                    <option value="餐旅业">餐旅业</option>
                    <option value="建筑工程业（土木工程）">建筑工程业（土木工程）</option>
                    <option value="制造业">制造业</option>
                    <option value="新闻、出版、广告业">新闻、出版、广告业</option>
                    <option value="卫生">卫生</option>
                    <option value="娱乐业">娱乐业</option>
                    <option value="文教">文教</option>
                    <option value="宗教">宗教</option>
                    <option value="公共事业">公共事业</option>
                    <option value="商业">商业</option>
                    <option value="金融业">金融业</option>
                    <option value="服务业">服务业</option>
                    <option value="家庭管理">家庭管理</option>
                    <option value="治安人员">治安人员</option>
                    <option value="军人">军人</option>
                    <option value="体育">体育</option>
                    <option value="资讯">资讯</option>
                    <option value="其他">其他</option>
                </select>
                 <br/><br/>
                <label>父母文化程序：父亲文化程度</label>
                <select name="fu_qin_wen_hua">
                	<option value="文盲">文盲</option>
                    <option value="小学">小学</option>
                    <option value="初中">初中</option>
                    <option value="高中">高中</option>
                    <option value="高中">本科</option>
                    <option value="本科以上">本科以上</option>
                </select>
                <label class="text_2">母亲文化程度</label>
                <select name="mu_qin_wen_hua">
                	<option value="文盲">文盲</option>
                    <option value="小学">小学</option>
                    <option value="初中">初中</option>
                    <option value="高中">高中</option>
                    <option value="本科">本科</option>
                    <option value="本科以上">本科以上</option>
                </select>
				<br/><br/>
                <label for="zhong_da_fu_xing_shi_jian_wu"> 重大负性事件（自幼年到现在）</label>
                <input type="radio" name="fu_xing_shi_jian" value="无" id="zhong_da_fu_xing_shi_jian_wu"/><label for="zhong_da_fu_xing_shi_jian_wu"> 无</label>
                <input type="radio" name="fu_xing_shi_jian" value="有" id="zhong_da_fu_xing_shi_jian_you"/><label for="zhong_da_fu_xing_shi_jian_you"> 有</label>
               	<br/>
                <textarea id="fu_xing_shi_jian_nei_rong" name="fu_xing_shi_jian_nei_rong" style="width: 800px;">
                </textarea>
                <br/><br/>
                <label for="ying_ji_shi_jian_wu"> 应激事件（自幼年到现在）</label>
                <input type="radio" name="ying_ji_shi_jian" value="无" id="ying_ji_shi_jian_wu"/><label for="ying_ji_shi_jian_wu"> 无</label>
                <input type="radio" name="ying_ji_shi_jian" value="有" id="ying_ji_shi_jian_you"/><label for="ying_ji_shi_jian_you"> 有</label>
                <br/>
                <textarea id="ying_ji_shi_jian_nei_rong" name="ying_ji_shi_jian_nei_rong" style="width: 800px;">
                </textarea>
                <br/><br/>

                <label for="ren_ji_guan_xi_liang_hao"> 人际关系：</label>
                <input type="radio" name="renjiguanxi" value="良好" id="ren_ji_guan_xi_liang_hao"/><label for="ren_ji_guan_xi_liang_hao"> 良好</label>
                <input type="radio" name="renjiguanxi" value="一般" id="ren_ji_guan_xi_yi_ban"/><label for="ren_ji_guan_xi_yi_ban"> 一般</label>
                <input type="radio" name="renjiguanxi" value="欠佳" id="ren_ji_guan_xi_qian_jia"/><label for="ren_ji_guan_xi_qian_jia"> 欠佳</label>
                <br/><br/>
                <label for="wen_ti_biao_xian_hai_xiu"> 问题表现为：</label>
                <input type="checkbox" name="wenti" value="害羞" id="wen_ti_biao_xian_hai_xiu"/><label for="wen_ti_biao_xian_hai_xiu"> 害羞</label>
                <input type="checkbox" name="wenti" value="自卑" id="wen_ti_biao_xian_zi_bei"/><label for="wen_ti_biao_xian_zi_bei"> 自卑</label>
                <input type="checkbox" name="wenti" value="顾虑" id="wen_ti_biao_xian_gu_lv"/><label for="wen_ti_biao_xian_gu_lv"> 顾虑</label>
                <input type="checkbox" name="wenti" value="恐惧" id="wen_ti_biao_xian_kong_jv"/><label for="wen_ti_biao_xian_kong_jv"> 恐惧</label>
                <input type="checkbox" name="wenti" value="敌对" id="wen_ti_biao_xian_di_dui"/><label for="wen_ti_biao_xian_di_dui"> 敌对</label>
                <input type="checkbox" name="wenti" value="封闭" id="wen_ti_biao_xian_feng_bi"/><label for="wen_ti_biao_xian_feng_bi">封闭</label>
                <input type="checkbox" name="wenti" value="误会" id="wen_ti_biao_xian_wu_hui"/><label for="wen_ti_biao_xian_wu_hui"> 误会</label>
                <input type="checkbox" name="wenti" value="不会相处" id="wen_ti_biao_xian_bu_hui_xiang_chu"/>不会相处
                 <br/><br/>
                <label for="wen_ti_fa_sheng_zai_shang_ji"> 问题发生在：</label>
                <input type="checkbox" name="wentifasheng" value="上级" id="wen_ti_fa_sheng_zai_shang_ji"/><label for="wen_ti_fa_sheng_zai_shang_ji"> 上级</label>
                <input type="checkbox" name="wentifasheng" value="下级" id="wen_ti_fa_sheng_zai_xia_ji"/><label for="wen_ti_fa_sheng_zai_xia_ji" class="jianju8">下级</label>
                <input type="checkbox" name="wentifasheng" value="同事" id="wen_ti_fa_sheng_zai_tong_shi"/><label for="wen_ti_fa_sheng_zai_tong_shi" class="jianju8">同事</label>
                <input type="checkbox" name="wentifasheng" value="同学" id="wen_ti_fa_sheng_zai_tong_xue"/><label for="wen_ti_fa_sheng_zai_tong_xue"> 同学</label>
                <input type="checkbox" name="wentifasheng" value="朋友" id="wen_ti_fa_sheng_zai_peng_you"/><label for="wen_ti_fa_sheng_zai_peng_you"> 朋友</label>
                <input type="checkbox" name="wentifasheng" value="公婆" id="wen_ti_fa_sheng_zai_gong_po"/><label for="wen_ti_fa_sheng_zai_gong_po"> 公婆</label>
                <input type="checkbox" name="wentifasheng" value="岳父母" id="wen_ti_fa_sheng_zai_yue_fu_mu"/><label for="wen_ti_fa_sheng_zai_yue_fu_mu"> 岳父母</label>
                <input type="checkbox" name="wentifasheng" value="夫妻" id="wen_ti_fa_sheng_zai_fu_qi"/><label for="wen_ti_fa_sheng_zai_fu_qi"> 夫妻</label>
                <input type="checkbox" name="wentifasheng" value="子女" id="wen_ti_fa_sheng_zai_zi_nv"/><label for="wen_ti_fa_sheng_zai_zi_nv"> 子女</label>
                <input type="checkbox" name="wentifasheng" value="父母" id="wen_ti_fa_sheng_zai_fu_mu"/><label for="wen_ti_fa_sheng_zai_fu_mu"> 父母</label>
				<br/><br/>
                <label for="else"> 其他：</label>
                <input type="text" name="qitafangmian" id="else" class="jianju"/>
                <br/><br/>
                <label for="sheng_huo_man_yi_man_yi"> 生活满意与否：</label>
                <input type="radio" name="shenghuomianyiyufou" value="满意" id="sheng_huo_man_yi_man_yi"/><label for="sheng_huo_man_yi_man_yi"> 满意</label>
                <input type="radio" name="shenghuomianyiyufou" value="尚可" id="sheng_huo_man_yi_shang_ke"/><label for="sheng_huo_man_yi_shang_ke"> 尚可</label>
                <input type="radio" name="shenghuomianyiyufou" value="不满意" id="sheng_huo_man_yi_bu_man_yi"/><label for="sheng_huo_man_yi_bu_man_yi"> 不满意</label>
                 <br/><br/>
                <label for="bu_man_yi_shen_ti"> 不满意的方面：</label>
                 <input type="checkbox" name="bu_man_yi_fang_mian" value="身体" id="bu_man_yi_shen_ti"/><label for="bu_man_yi_shen_ti"> 身体</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="工作" id="bu_man_yi_gong_zuo"/><label for="bu_man_yi_gong_zuo"> 工作</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="学习" id="bu_man_yi_xue_xi"/><label for="bu_man_yi_xue_xi"> 学习</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="职称" id="bu_man_yi_zhi_cheng"/><label for="bu_man_yi_zhi_cheng"> 职称</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="经济" id="bu_man_yi_jing_ji"/><label for="bu_man_yi_jing_ji">经济</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="住房" id="bu_man_yi_zhu_fang"/><label for="bu_man_yi_zhu_fang"> 住房</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="周围环境" id="bu_man_yi_zhou_wei_huan_jing"/><label for="bu_man_yi_zhou_wei_huan_jing"> 周围环境</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="社交环境" id="bu_man_yi_she_jiao_huan_jing"/><label for="bu_man_yi_she_jiao_huan_jing" class="jianju8">社交环境</label>
                <input type="checkbox" name="bu_man_yi_fang_mian" value="家庭环境" id="bu_man_yi_jia_ting_huan_jing"/><label for="bu_man_yi_jia_ting_huan_jing"> 家庭环境</label>
                <br/><br/>
                <label for="bu_man_yi_fang_mian_qi_ta"> 其它</label>
                <input type="text" id="bu_man_yi_fang_mian_qi_ta" name="bu_man_yi_fang_mian" class="jianju">
                <br/><br/>
                <label for="dang_qian_ji_bing_wan_quan_zheng_que"> 当前疾病的认知：</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全正确" id="dang_qian_ji_bing_wan_quan_zheng_que"/><label for="dang_qian_ji_bing_wan_quan_zheng_que"> 完全正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本正确" id="dang_qian_ji_bing_ji_ben_zheng_que"/><label for="dang_qian_ji_bing_ji_ben_zheng_que"> 基本正确</label>
                <input type="radio" name="ji_bing_ren_zhi" value="不确定" id="dang_qian_ji_bing_bu_que_ding"/><label for="dang_qian_ji_bing_bu_que_ding"> 不确定</label>
                <input type="radio" name="ji_bing_ren_zhi" value="基本错误" id="dang_qian_ji_bing_ji_ben_cuo_wu"/><label for="dang_qian_ji_bing_ji_ben_cuo_wu"> 基本错误</label>
                <input type="radio" name="ji_bing_ren_zhi" value="完全错误" id="dang_qian_ji_bing_wan_quan_cuo_wu"/><label for="dang_qian_ji_bing_wan_quan_cuo_wu"> 完全错误</label>
                <br/><br/>
                <label for="ji_bing_yu_hou_tai_du_fei_chang_ji_ji"> 疾病愈后的态度：</label>
                <input type="radio" name="taidu" value="非常乐观" id="ji_bing_yu_hou_tai_du_fei_chang_le_guan"/><label for="ji_bing_yu_hou_tai_du_fei_chang_le_guan"> 非常乐观</label>
                <input type="radio" name="taidu" value="乐观" id="ji_bing_yu_hou_tai_du_le_guan"/><label for="ji_bing_yu_hou_tai_du_le_guan"> 乐观</label>
                <input type="radio" name="taidu" value="不确定" id="ji_bing_yu_hou_tai_du_bu_que_ding"/><label for="ji_bing_yu_hou_tai_du_bu_que_ding"> 不确定</label>
                <input type="radio" name="taidu" value="消极" id="ji_bing_yu_hou_tai_du_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_xiao_ji"> 消极</label>
                <input type="radio" name="taidu" value="非常消极" id="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"/><label for="ji_bing_yu_hou_tai_du_fei_chang_xiao_ji"> 非常消极</label>
                <br/><br/>
                <label for="ying_dui_fang_shi_fei_chang_ji_ji"> 应对方式：</label>
                <input type="radio" name="yingduifangshi" value="非常积极" id="ying_dui_fang_shi_fei_chang_ji_ji"/><label for="ying_dui_fang_shi_fei_chang_ji_ji"> 非常积极</label>
                <input type="radio" name="yingduifangshi" value="积极" id="ying_dui_fang_shi_ji_ji"/><label for="ying_dui_fang_shi_ji_ji"> 积极</label>
                <input type="radio" name="yingduifangshi" value="一般" id="ying_dui_fang_shi_yi_ban"/><label for="ying_dui_fang_shi_yi_ban"> 一般</label>
                <input type="radio" name="yingduifangshi" value="消极" id="ying_dui_fang_shi_xiao_ji"/><label for="ying_dui_fang_shi_xiao_ji"> 消极</label>
                <input type="radio" name="yingduifangshi" value="非常消极" id="ying_dui_fang_shi_fei_chang_xiao_ji"/><label for="ying_dui_fang_shi_fei_chang_xiao_ji"> 非常消极</label>
                <br/><br/>
                <label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 治疗参与程度：</label>
                <input type="radio" name="zhiliaocanyu" value="积极主动" id="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"/><label for="chan_yu_zhi_liao_cheng_du_ji_ji_zhu_dong"> 积极主动</label>
                 <input type="radio" name="zhiliaocanyu" value="消极被动" id="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong"/><label for="chan_yu_zhi_liao_cheng_du_xiao_ji_bei_dong">消极被动</label>
                 <input type="radio" name="zhiliaocanyu" value="一般" id="chan_yu_zhi_liao_cheng_du_yi_ban"/><label for="chan_yu_zhi_liao_cheng_du_yi_ban"> 一般</label>
                <br/><br/>
                <label for="she_hui_zhi_chi_ji_cha"> 社会支持：</label>
                <input type="radio" name="shehuizhichi" value="极差" id="she_hui_zhi_chi_ji_cha"/><label for="she_hui_zhi_chi_ji_cha"> 极差</label>
                <input type="radio" name="shehuizhichi" value="差" id="she_hui_zhi_chi_cha"/><label for="she_hui_zhi_chi_cha"> 差</label>
                <input type="radio" name="shehuizhichi" value="一般" id="she_hui_zhi_chi_yi_ban"/><label for="she_hui_zhi_chi_yi_ban"> 一般</label>
                <input type="radio" name="shehuizhichi" value="好" id="she_hui_zhi_chi_hao"/><label for="she_hui_zhi_chi_hao"> 好</label>
                <input type="radio" name="shehuizhichi" value="极好" id="she_hui_zhi_chi_ji_hao"/><label for="she_hui_zhi_chi_ji_hao"> 极好</label>
                <br/><br/>
                <label for="peng_you_ji_cha"> 朋友：</label>
                <input type="radio" name="pengyou" value="极差" id="peng_you_ji_cha"/><label for="peng_you_ji_cha"> 极差</label>
                <input type="radio" name="pengyou" value="差" id="peng_you_cha"/><label for="peng_you_cha"> 差</label>
                <input type="radio" name="pengyou" value="一般" id="peng_you_yi_ban"/><label for="peng_you_yi_ban"> 一般</label>
                <input type="radio" name="pengyou" value="好" id="peng_you_hao"/><label for="peng_you_hao"> 好</label>
                <input type="radio" name="pengyou" value="极好" id="peng_you_ji_hao"/><label for="peng_you_ji_hao"> 极好</label>
                <br/><br/>
                <label for="jia_ren_ji_cha"> 家人：</label>
                <input type="radio" name="jiaren" value="极差" id="jia_ren_ji_cha"/><label for="jia_ren_ji_cha"> 极差</label>
                <input type="radio" name="jiaren" value="差" id="jia_ren_cha"/><label for="jia_ren_cha"> 差</label>
                <input type="radio" name="jiaren" value="一般" id="jia_ren_yi_ban"/><label for="jia_ren_yi_ban"> 一般</label>
                <input type="radio" name="jiaren" value="好" id="jia_ren_hao"/><label for="jia_ren_hao"> 好</label>
                <input type="radio" name="jiaren" value="极好" id="jia_ren_ji_hao"/><label for="jia_ren_ji_hao"> 极好</label>
                <br/><br/>
                <label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 对各项支持的利用度：</label>
                <input type="radio" name="gexiangzhichi" value="极差" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_cha"> 极差</label>
                <input type="radio" name="gexiangzhichi" value="差" id="dui_ge_xiang_zhi_chi_li_yong_du_cha"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_cha"> 差</label>
                <input type="radio" name="gexiangzhichi" value="一般" id="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_yi_ban"> 一般</label>
                <input type="radio" name="gexiangzhichi" value="好" id="dui_ge_xiang_zhi_chi_li_yong_du_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_hao"> 好</label>
                <input type="radio" name="gexiangzhichi" value="极好" id="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"/><label for="dui_ge_xiang_zhi_chi_li_yong_du_ji_hao"> 极好</label>
                 <br/><br/>
              <label> 家谱图：</label><input type="button" id="jia_pu_tu_btn" value="选择家谱图">
			    <input type="hidden" id="jia_pu_tu_hou" name="jia_pu_tu" /><span id="jia_pu_tu_qian"></span>
			   
			    <label>备注：</label>
			    <input type="text" name="jia_pu_tu_bei_zhu" class="jianju">
			   <br/>
               <br/>
			   <label>房树人：</label><input type="file" name="fang_shu_ren" value="上传房树人" id="fang_shu_ren" style="width: 150px"/>
               <br/><br/>
               <label> 印象：</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_shuai_ruo" value="神经衰弱"><label for="yin_xiang_shuai_ruo">神经衰弱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wen_luan" value="植物神经功能紊乱"><label for="yin_xiang_wen_luan">植物神经功能紊乱</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lv" value="焦虑状态"><label for="yin_xiang_jiao_lv">焦虑状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_yi_yu" value="抑郁状态"><label for="yin_xiang_yi_yu">抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_jiao_lu_yi_yu" value="焦虑抑郁状态"><label for="yin_xiang_jiao_lu_yi_yu">焦虑抑郁状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_qiang_po" value="强迫状态"><label for="yin_xiang_qiang_po">强迫状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_zao_kuang" value="躁狂状态"><label for="yin_xiang_zao_kuang">躁狂状态</label>
               <input type="radio" name="yin_xiang" id="yin_xiang_wang_xiang" value="妄想状态"><label for="yin_xiang_wang_xiang">妄想状态</label>
               <br/><br/>
               <label>其它</label><input type="text" name="yin_xiang_qi_ta" class="jianju"/>
               <br><br>
				<!-- <label>处置:</label>
				<input type="radio" name="chu_zhi" id="chu_zhi_xin_shen" value="心身测评（脑功能检测，HRV检测，精神科A,B C类量表）"><label for="chu_zhi_xin_shen">心身测评（脑功能检测，HRV检测，精神科A,B C类量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_xin_nao" value="心脑检测（脑功能检测，HRV，首访量表）"><label for="chu_zhi_xin_nao">心脑检测（脑功能检测，HRV，首访量表）</label><br><br>
               <input type="radio" name="chu_zhi" id="chu_zhi_sjgn" value="植物神经功能检测（HRV，首访量表）"><label for="chu_zhi_sjgn">植物神经功能检测（HRV，首访量表）</label>
				<br><br> -->
				<input type="hidden" name="chu_zhi">
                <input type="submit" value="保存" id="baocun">&nbsp;&nbsp;
                <input type="reset" value="清空" id="qingkong">
            </form>
            </div>
        </div>
        
		<input type="hidden" name="r" id="r" value="${param.r }"/>
		<input type="hidden" name="q" id="q" value="${param.q }"/>
	    <input type="hidden" name="n" id="n" value="${param.n }"/>
	    <input type="hidden" id="f" value="${f }">
	    
	    <style type="text/css">
 	.pic{
 		float: left;
 	}
 </style>
	    <link href="css/modal.css" rel="stylesheet" type="text/css" />
             <!--模态对话框-->
            <div id="formTable_jcxx" class="modal hide">

                <form>
                    <input type="hidden" value="t" name="f">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">选择基础信息</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOuts('formTable_jcxx');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    <div class="search">
						<form id="form_zl" action="jcxx?m=iHtbrAdd" method="post">
			                <label for="name">姓名：</label>
			                <input type="text" name="n" class="date_picker" id="name" />
			
			                <input type="submit" value="查询" class="button" id="search_btn" />
		                </form>
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
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iHtbrAdd&f=t&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iHtbrAdd&f=t&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iHtbrAdd&f=t&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('jcxx?m=iHtbrAdd&f=t&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                        </td>
                    </tr>
                </table>
                    </div>
                    <div class="modal-footer">
                        <a  href="javascript:void(0);" onclick="fadeOuts('formTable_jcxx');" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </form>
            </div>
            <!--模态对话框结束-->
            
            
<!--模态对话框-->
            <div id="formTable_pic" class="modal hide">

                <form id="form_zl" action="zlfa?m=iZlfaAdd" method="post">
                    <input type="hidden" value="t" name="f">
                    <div class="modal-header" style="height:40px;">
                        <div style=" float:left;">选择家谱图图片</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOuts('formTable_pic');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                       <div class="pic">
                       		<img alt="1.jpg" src="img/imgs/1.jpg" id="jpt_pic1" onclick="big_small('jpt_pic1')" width="65px" height="65px">
                       		<a href="javascript:xz_pic('1.jpg');">选择</a>
                       </div>
			           <div class="pic">
			           		<img alt="2.jpg" src="img/imgs/2.jpg" id="jpt_pic2" onclick="big_small('jpt_pic2')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('2.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="3.jpg" src="img/imgs/3.jpg" id="jpt_pic3" onclick="big_small('jpt_pic3')" width="65px" height="65px">
			          		<a href="javascript:xz_pic('3.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="4.jpg" src="img/imgs/4.jpg"  id="jpt_pic4" onclick="big_small('jpt_pic4')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('4.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="5.jpg" src="img/imgs/5.jpg"  id="jpt_pic5" onclick="big_small('jpt_pic5')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('5.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="6.jpg" src="img/imgs/6.jpg"  id="jpt_pic6" onclick="big_small('jpt_pic6')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('6.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="7.jpg" src="img/imgs/7.jpg"  id="jpt_pic7" onclick="big_small('jpt_pic7')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('7.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="8.jpg" src="img/imgs/8.jpg"  id="jpt_pic8" onclick="big_small('jpt_pic8')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('8.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="9.jpg" src="img/imgs/9.jpg"  id="jpt_pic9" onclick="big_small('jpt_pic9')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('9.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="10.jpg" src="img/imgs/10.jpg"  id="jpt_pic10" onclick="big_small('jpt_pic10')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('10.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="11.jpg" src="img/imgs/11.jpg"  id="jpt_pic11" onclick="big_small('jpt_pic11')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('11.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="12.jpg" src="img/imgs/12.jpg"  id="jpt_pic12" onclick="big_small('jpt_pic12')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('12.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="13.jpg" src="img/imgs/13.jpg"  id="jpt_pic13" onclick="big_small('jpt_pic13')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('13.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="14.jpg" src="img/imgs/14.jpg"  id="jpt_pic14" onclick="big_small('jpt_pic14')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('14.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="15.jpg" src="img/imgs/15.jpg"  id="jpt_pic15" onclick="big_small('jpt_pic15')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('4.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="16.jpg" src="img/imgs/16.jpg"  id="jpt_pic16" onclick="big_small('jpt_pic16')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('16.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="17.jpg" src="img/imgs/17.jpg"  id="jpt_pic17" onclick="big_small('jpt_pic17')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('17.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="18.jpg" src="img/imgs/18.jpg"  id="jpt_pic18" onclick="big_small('jpt_pic18')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('18.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="19.jpg" src="img/imgs/19.jpg"  id="jpt_pic19" onclick="big_small('jpt_pic19')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('19.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="20.jpg" src="img/imgs/20.jpg"  id="jpt_pic20" onclick="big_small('jpt_pic20')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('20.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="21.jpg" src="img/imgs/21.jpg"  id="jpt_pic21" onclick="big_small('jpt_pic21')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('21.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="22.jpg" src="img/imgs/22.jpg"  id="jpt_pic22" onclick="big_small('jpt_pic22')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('22.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="23.jpg" src="img/imgs/23.jpg"  id="jpt_pic23" onclick="big_small('jpt_pic23')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('23.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="24.jpg" src="img/imgs/24.jpg"  id="jpt_pic24" onclick="big_small('jpt_pic24')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('24.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="25.jpg" src="img/imgs/25.jpg"  id="jpt_pic25" onclick="big_small('jpt_pic25')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('25.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="26.jpg" src="img/imgs/26.jpg"  id="jpt_pic26" onclick="big_small('jpt_pic26')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('26.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="27.jpg" src="img/imgs/27.jpg"  id="jpt_pic27" onclick="big_small('jpt_pic27')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('27.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="28.jpg" src="img/imgs/28.jpg"  id="jpt_pic28" onclick="big_small('jpt_pic28')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('28.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="29.jpg" src="img/imgs/29.jpg"  id="jpt_pic29" onclick="big_small('jpt_pic29')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('29.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="30.jpg" src="img/imgs/30.jpg"  id="jpt_pic30" onclick="big_small('jpt_pic30')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('30.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="31.jpg" src="img/imgs/31.jpg"  id="jpt_pic31" onclick="big_small('jpt_pic31')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('31.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="32.jpg" src="img/imgs/32.jpg"  id="jpt_pic32" onclick="big_small('jpt_pic32')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('32.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="33.jpg" src="img/imgs/33.jpg"  id="jpt_pic33" onclick="big_small('jpt_pic33')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('33.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="34.jpg" src="img/imgs/34.jpg"  id="jpt_pic34" onclick="big_small('jpt_pic34')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('34.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="35.jpg" src="img/imgs/35.jpg"  id="jpt_pic35" onclick="big_small('jpt_pic35')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('35.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="36.jpg" src="img/imgs/36.jpg"  id="jpt_pic36" onclick="big_small('jpt_pic36')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('36.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="37.jpg" src="img/imgs/37.jpg"  id="jpt_pic37" onclick="big_small('jpt_pic37')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('37.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="38.jpg" src="img/imgs/38.jpg"  id="jpt_pic38" onclick="big_small('jpt_pic38')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('38.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="39.jpg" src="img/imgs/39.jpg"  id="jpt_pic39" onclick="big_small('jpt_pic39')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('39.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="40.jpg" src="img/imgs/40.jpg"  id="jpt_pic40" onclick="big_small('jpt_pic40')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('40.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="41.jpg" src="img/imgs/41.jpg"  id="jpt_pic41" onclick="big_small('jpt_pic41')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('41.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="42.jpg" src="img/imgs/42.jpg"  id="jpt_pic42" onclick="big_small('jpt_pic42')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('42.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="43.jpg" src="img/imgs/43.jpg"  id="jpt_pic43" onclick="big_small('jpt_pic43')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('43.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="44.jpg" src="img/imgs/44.jpg"  id="jpt_pic44" onclick="big_small('jpt_pic44')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('44.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="45.jpg" src="img/imgs/45.jpg"  id="jpt_pic45" onclick="big_small('jpt_pic45')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('45.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="46.jpg" src="img/imgs/46.jpg"  id="jpt_pic46" onclick="big_small('jpt_pic46')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('46.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="47.jpg" src="img/imgs/47.jpg"  id="jpt_pic47" onclick="big_small('jpt_pic47')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('47.jpg');">选择</a>
			           </div>
			           <div class="pic">
			           		<img alt="48.jpg" src="img/imgs/48.jpg"  id="jpt_pic48" onclick="big_small('jpt_pic48')" width="65px" height="65px">
			           		<a href="javascript:xz_pic('48.jpg');">选择</a>
			           </div>
			           
                    </div>
                    <div class="modal-footer">
                        <a  href="javascript:void(0);" onclick="fadeOuts('formTable_pic');" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </form>
            </div>
<!--模态对话框结束-->                  
            
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
});  
$(document).ready(function(){
	setting();
});
$(document).ready(function(){
	if($("#f").val() == 't') {
			$("#name").val($("#n").val());
    		fadeIns('formTable_jcxx');
    	}
});
$(document).ready(function(){
	$("#jia_pu_tu_btn").click(function(){
		fadeIns('formTable_pic');
	});
});
function xz_pic(id) {
	$("#jia_pu_tu_hou").val(id);
	$("#jia_pu_tu_qian").text('已选择家谱图！');
	fadeOuts('formTable_pic');
}

function big_small(id) {
	if(document.getElementById(id).style.width=='550px') {
		smaller(id);
	} else {
		bigger(id);
	}
}

function bigger(id){
	document.getElementById(id).style.width='550px';
	document.getElementById(id).style.height='400px';
	/* document.getElementById(id).style.margin='-200px 0 0 0'; */
}
function smaller(id){
	document.getElementById(id).style.width='65px';
	document.getElementById(id).style.height='65px';
	/* document.getElementById(id).style.margin='16px 0 0 10px'; */
}
</script>
  <%@include file="/commons/tail.jsp" %>
