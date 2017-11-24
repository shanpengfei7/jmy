<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>诊疗方案</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/table_css.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/cepingshi/jian_ce_xiang_mu_tian_jia.js"></script>
    <link href="css/modal.css" rel="stylesheet" type="text/css" />
    <link href="css/datePicker.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery.date_input.pack.js"></script>

  <%@include file="/commons/header.jsp" %>
  <input type="hidden" name="r" id="r" value="${param.r }"/>
	<input type="hidden" name="q" id="q" value="${param.q }"/>
    <input type="hidden" name="n" id="n" value="${param.n }"/>
  <div class="all__content">
  
  	
            <div class="search">
            
	            <form action="zlfa?m=iZlfa" method="post">
	                <label for="ri_qi_1">诊疗日期：</label>
	                <input type="text" id="ri_qi_1" name="r" class="date_picker" placeholder="点击选择日期"/>至
	                <input type="text" id="ri_qi_2" name="q" class="date_picker" placeholder="点击选择日期"/>
	
	                <label for="name">姓名：</label>
	                <input type="text" name="n" class="date_picker" id="name" />
	
	                <input type="submit" value="查询" class="button"/>
	            
	                <a href="zlfa?m=iZlfaAdd&f=o"><input type="button" value="添加诊疗方案" class="button"/></a>
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
                    <td>首诊日期</td>
                    <td>诊疗次数</td>
                    <td>诊疗日期</td>
                    <td>回访状态</td>
                </tr>
                <c:forEach items="${page.list }" var="jcxx" varStatus="s">
               		<tr class="tr${s.index%2==0?2:3 }">
	                    <td><a href="zlfa?m=gzl&id=${jcxx.id }&z=b">编辑</a><span style="margin-left: 10px;"></span>
		                    <a href="zlfa?m=gzl&id=${jcxx.id }&z=x">详情</a><span style="margin-left: 10px;"></span>
		                    <a href="javascript:0; return false;" onclick="openModal('${jcxx.id}');">回访</a>
	                    </td>
	                    <td>${jcxx.yongHuId }</td>
	                    <td>${jcxx.xingMing }</td>
	                    <c:if test="${jcxx.xingBie==1 }">
	                    <td>男</td>
	                    </c:if>
	                    <c:if test="${jcxx.xingBie==2 }">
	                    <td>女</td>
	                    </c:if>
	                     <td>${jcxx.chuShengNian }-${jcxx.chuShengYue }-${jcxx.chuShengRi }</td>
	                    <td>${jcxx.jingShenKeYiSheng }</td>
	                    <td>${jcxx.cePingShi }</td>
	                    <td>${jcxx.shouZhenRiQi }</td>
	                    <td>${jcxx.ciShu }</td>
	                    <td>${jcxx.riQi }</td>
	                    <c:if test="${jcxx.huiFangZhuangTai }">
	                    	<td>已回访</td>
	                    </c:if>
	                    <c:if test="${!jcxx.huiFangZhuangTai }">
	                    	<td style="background-color: #FCF54C">未回访</td>
	                    </c:if>
	                    <c:if test="${s.last }">
	                    	<input type="hidden" id="pageCount" value="${s.count }">
	                    </c:if>
                	</tr>
                </c:forEach>
                <tr class="tr4">
                    <td colspan="11">
                       第${page.getpageNow() }页，共${page.getTotalPageNumber() }页（<span id="showPageCount"></span>记录）
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfa&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfa&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfa&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('zlfa?m=iZlfa&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                    </td>
                </tr>
            </table>
        </div>
        <!--模态对话框-->
            <div id="formTable" class="modal hide">

                <form id="form0" action="zlfa?m=shf" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">回访的内容</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut();" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    		<input type="hidden" name="id" id="hui_fang_id">
						   <textarea rows="10" cols="115" id="hui_fang_nei_rong" name="hui_fang_nei_rong"></textarea>                     
                    </div>
                    <div class="modal-footer">
                    	<input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut();" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </form>
            </div>
            <!--模态对话框结束-->
<script type="text/javascript">
	function openModal(id) {
		$.post("zlfa?m=ihf", {id:id}, function(r) {
			$("#hui_fang_id").val(id);
			if(r == 'null') {
				$("#hui_fang_nei_rong").text("");
			} else {
				$("#hui_fang_nei_rong").text(r);
			}
			fadeIn();
		});
		
	}
	$(document).ready(function(){
        		$("#ri_qi_1").val($("#r").val());
        		$("#ri_qi_2").val($("#q").val());
        		$("#name").val($("#n").val());
        	
        		$("#showPageCount").text($("#pageCount").val());
        		$("#change_page").change(function(){
        			var href="zlfa?m=iZlfa&pn="+$("#change_page").val();
        			aq(href);
        		});
        	});
$(document).ready(function(){
	setting();
});
</script>
  <%@include file="/commons/tail.jsp" %>
