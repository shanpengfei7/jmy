<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>检测项目添加</title>
    
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
</style>
  <%@include file="/commons/header.jsp" %>
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="js/jcxm.js"></script>
  <div class="all__content">
            <div style="margin-left: 20px">
                <label class="text_3">首诊信息</label><br>
                <label for="yong_hu_id">用户ID：</label>
                <input type="text" name="yong_hu_id" id="yong_hu_id" value="" readonly="readonly" class="text_5"/>
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
                <input type="text" name="chu_sheng_di" id="chu_sheng_di" readonly="readonly" class="jianju"/>
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
                <label for="jiang_ji_zhuang_kuang" class="text_1">经济状况：</label>
                <input type="text" name="jiang_ji_zhuang_kuang" id="jiang_ji_zhuang_kuang" value="" readonly="readonly" />
                <br/><br/>
                <label for="lian_xi_di_zhi">联系地址：</label><input type="text" name="lian_xi_di_zhi" id="lian_xi_di_zhi" readonly="readonly" />
        </div><br>
<form action="jcxm?m=sjcxm" method="post" id="jcxm_form" target="_blank">
	<input type="hidden" value="${token }" name="token">
	<input type="hidden" name="ci_shu" id="ci_shu">
	<input type="hidden" name="ci_shu_j" id="ci_shu_j">
	<input type="hidden" name="ji_chu_xin_xi_id" id="ji_chu_xin_xi_id">
        <div class="all__content">
            <label class="text_3">检测项目</label><br><br>
            <span class="text_2"></span><label for="nao_dian">检测项目：</label>
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
	            <span class="text_2"></span><label>心理测评项目：</label>
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
            <input type="submit" id="save" value="保存">
</form>

<input type="hidden" name="r" id="r" value="${param.r }"/>
	<input type="hidden" name="q" id="q" value="${param.q }"/>
    <input type="hidden" name="n" id="n" value="${param.n }"/>
      <input type="hidden" id="j" value="${j }">
            <!--模态对话框-->
            <div id="formTable" class="modal hide">

                <form id="form0" action="jcxm?m=iJcxmAdd" method="post">
                <input type="hidden" value="t" name="j">
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
        </div>
<script type="text/javascript">
$(document).ready(function(){
	setting();
});
</script>
  <%@include file="/commons/tail.jsp" %>
