<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>报表管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		.select_bbgl{
			border:solid 1px #fff;
			appearance:none;
			-moz-appearance:nne;
			-webkit-appearance:none;
			background:url(image/arrow.png) no-repeat scroll right center transparent;
			border-radius:2px; 
			padding-right:14px;
			/* height:30px; */
		}
		.text{
			margin-left:30px;
		}
	</style>
	
  <%@include file="/commons/header.jsp" %>
  <script type="text/javascript" src="js/bbgl.js"></script>
  <link href="css/upcss/jiancexiangmu.css" rel="stylesheet" type="text/css">
  	<input type="hidden" name="r" id="r" value="${param.r }"/>
	<input type="hidden" name="q" id="q" value="${param.q }"/>
    <input type="hidden" name="y" id="y" value="${param.y }"/>
    <input type="hidden" name="k" id="k" value="${param.k }"/>
	<input type="hidden" name="z" id="z" value="${param.z }"/>
    <input type="hidden" name="j" id="j" value="${param.j }"/>
    <input type="hidden" name="c" id="c" value="${param.c }"/>
  <div class="all__content">
  
  	
            <div class="search">
            <br/>
	            <form action="bbgl?m=ibb" method="post">
	                <label for="ri_qi_1">诊疗日期：</label>
	                <input type="text" id="ri_qi_1" value="${r }" name="r" class="date_picker" placeholder="点击选择日期"/>至
	                <input type="text" id="ri_qi_2" value="${q }" name="q" class="date_picker" placeholder="点击选择日期"/>
					<input type="submit" value="查询" class="button"/>
					<input type="button" id="pbb" value="导出报表" class="button"/>
					<br>
					<br/>
	                <c:choose>
				        <c:when test="${sessionScope.quanxian == 1 }">
			                <label for="yi_yuan">医院：</label>
			                <select id="yi_yuan" name="y" class="select_bbgl">
			                	<option value="">请选择</option>
			                	<c:forEach items="${ys }" var="y">
			                		<option value="${y.id }">${y.mingCheng }</option>
			                	</c:forEach>
			                </select>
			                
			                <label for="ke_shi" class="text">科室：</label>
			                <select id="ke_shi" name="k"  class="select_bbgl">
			                </select>
			                
							<label for="zhuan_ke_yi_sheng" class="text">专科医生：</label>	
			                <select id="zhuan_ke_yi_sheng" name="z"  class="select_bbgl">
			                </select>
			                
							<label for="jing_shen_ke_yi_sheng" class="text">精神科医生：</label>
			                <select id="jing_shen_ke_yi_sheng" name="j" class="select_bbgl">
			                </select>
			                
							<label for="ce_ping_shi" class="text">测评师：</label>
			                <select id="ce_ping_shi" name="c" class="select_bbgl">
			                </select>
				        </c:when>
				        <c:when test="${sessionScope.quanxian == 2 || sessionScope.quanxian == 3 || sessionScope.quanxian == 4 }">
			                <label for="yi_yuan">医院：</label>
			                ${sessionScope.yiYuanMingCheng }
				        	<input type="hidden" name="y" value="${sessionScope.yiYuanMingCheng }">
			                
			                <label for="ke_shi" class="text">科室：</label>
			                <select id="ke_shi" name="k" class="select_bbgl">
			                	<option value="">请选择</option>
			                	<c:forEach items="${ks }" var="y">
			                		<option value="${y.mingCheng }">${y.mingCheng }</option>
			                	</c:forEach>
			                </select>
			                
							<label for="zhuan_ke_yi_sheng" class="text">专科医生：</label>	
			                <select id="zhuan_ke_yi_sheng" name="z" class="select_bbgl">
			                </select>
			                
							<label for="jing_shen_ke_yi_sheng" class="text">精神科医生：</label>
			                <select id="jing_shen_ke_yi_sheng" name="j" class="select_bbgl">
			                	<option value="">请选择</option>
			                	<c:forEach items="${jsk }" var="y">
			                		<option value="${y.xingMing }">${y.xingMing }</option>
			                	</c:forEach>
			                </select>
			                
							<label for="ce_ping_shi" class="text">测评师：</label>
			                <select id="ce_ping_shi" name="c" class="select_bbgl">
			                	<option value="">请选择</option>
			                	<c:forEach items="${cps }" var="y">
			                		<option value="${y.xingMing }">${y.xingMing }</option>
			                	</c:forEach>
			                </select>
				        </c:when>
				        <c:when test="${sessionScope.quanxian == 5 }">
			                <label for="yi_yuan">医院：</label>
			                ${sessionScope.yiYuanMingCheng }
				        	<input type="hidden" name="y" value="${sessionScope.yiYuanMingCheng }">
			                
			                <label for="ke_shi" class="text">科室：</label>
			                ${sessionScope.keShi }
				        	<input type="hidden" name="k" value="${sessionScope.keShi }">
			                
							<!-- <label for="zhuan_ke_yi_sheng">专科医生：</label>	
			                <select id="zhuan_ke_yi_sheng" name="z">
			                </select> -->
			                
							<label for="jing_shen_ke_yi_sheng" class="text">精神科医生：</label>
			                 ${sessionScope.xingMing }
				        	<input type="hidden" name="j" value="${sessionScope.xingMing }">
			                
			                
							<!-- <label for="ce_ping_shi">测评师：</label>
			                <select id="ce_ping_shi" name="c">
			                </select> -->
				        </c:when>
				        <c:when test="${sessionScope.quanxian == 6 }">
			                <label for="yi_yuan">医院：</label>
			                ${sessionScope.yiYuanMingCheng }
				        	<input type="hidden" name="y" value="${sessionScope.yiYuanMingCheng }">
			                
			                <label for="ke_shi" class="text">科室：</label>
			                ${sessionScope.keShi }
			                <input type="hidden" name="k" value="${sessionScope.keShi }">
			                
							<label for="zhuan_ke_yi_sheng" class="text">专科医生：</label>	
			                <select id="zhuan_ke_yi_sheng" name="z" class="select_bbgl">
			                	<option value="">请选择</option>
			                	<c:forEach items="${ys }" var="y">
			                		<option value="${y.xingMing }">${y.xingMing }</option>
			                	</c:forEach>
			                </select>
			                
							<!-- <label for="jing_shen_ke_yi_sheng">精神科医生：</label>
			                 <select id="zhuan_ke_yi_sheng" name="j">
			                </select>
			                
							<label for="ce_ping_shi">测评师：</label>
			                <select id="ce_ping_shi" name="c">
			                </select> -->
				        </c:when>
				        <c:when test="${sessionScope.quanxian == 7 }">
			                <label for="yi_yuan">医院：</label>
			                ${sessionScope.yiYuanMingCheng }
				        	<input type="hidden" name="y" value="${sessionScope.yiYuanMingCheng }">
			                
			                <label for="ke_shi" class="text">科室：</label>
			                ${sessionScope.keShi }
				        	<input type="hidden" name="k" value="${sessionScope.keShi }">
			                
							<label for="zhuan_ke_yi_sheng" class="text">专科医生：</label>	
							${sessionScope.xingMing }
				        	<input type="hidden" name="z" value="${sessionScope.xingMing }">
			                
							<!-- <label for="jing_shen_ke_yi_sheng">精神科医生：</label>
			                 <select id="zhuan_ke_yi_sheng" name="j">
			                </select>
			                
							<label for="ce_ping_shi">测评师：</label>
			                <select id="ce_ping_shi" name="c">
			                </select> -->
				        </c:when>
				        <c:otherwise>
				        	${sessionScope.yiYuanMingCheng }
				        	<input type="hidden" name="y" value="${sessionScope.yiYuanMingCheng }">
				        </c:otherwise>
		        	</c:choose>
	                
					
	
	                
	            </form>
                
            </div>
            <table class="table" border="1" cellspacing="0">
	            <tr class="tr3">
	                    <td>次数</td>
	                    <td></td>
	                    <td></td>
	                    <td>${nd }</td>
	                    <td>${ccbt }</td>
	                    <td>${nrz }</td>
	                    <td>${xlcp }</td>
	                    <td>${yy }</td>
	                    <td>${hrv }</td>
	                    <td>${y }</td>
	                    <td>${k }</td>
	                    <td>${z }</td>
	                    <td>${j }</td>
	                    <td>${c }</td>
	                </tr>
                <tr class="tr1">
                    <td>用户ID</td>
                    <td>姓名</td>
                    <td>日期</td>
                    <td>脑电</td>
                    <td>CCBT</td>
                    <td>脑认知</td>
                    <td>心理测评</td>
                    <td>鹰演</td>
                    <td>HRV</td>
                    <td>医院</td>
                    <td>科室</td>
                    <td>专科医生</td>
                    <td>精神科医生</td>
                    <td>测评师</td>
                </tr>
                <c:forEach items="${page.list }" var="b" varStatus="s">
               		<tr class="tr${s.index%2==0?2:3 }">
	                    </td>
	                    <td>${b.yongHuId }</td>
	                    <td>${b.xingMing }</td>
	                    <td>${b.riQi }</td>
	                    <c:if test="${b.naoDian }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.naoDian }"><td></td></c:if>
	                    
	                    <c:if test="${b.ccbt }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.ccbt }"><td></td></c:if>
	                    
	                    <c:if test="${b.naoRenZhi }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.naoRenZhi }"><td></td></c:if>
	                    
	                    <c:if test="${b.xinLiCePing }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.xinLiCePing }"><td></td></c:if>
	                    
	                    <c:if test="${b.yingYan }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.yingYan }"><td></td></c:if>
	                    
	                    <c:if test="${b.hrv }"><td style="background-color: green;"></td></c:if>
	                    <c:if test="${!b.hrv }"><td></td></c:if>
	                    <c:if test="${sessionScope.quanxian == 1 }">
	                    	<c:forEach items="${ys }" var="y">
			                     <c:choose>
			                     	<c:when test="${b.yiYuanId==y.id }">
			                     		<td>${y.mingCheng }</td>
			                     	</c:when>
			                     </c:choose>
			                </c:forEach>
	                    </c:if>
	                    <c:if test="${sessionScope.quanxian != 1 }">
	                    	<td>${sessionScope.yiYuanMingCheng }</td>
	                    </c:if>
	                    <td>${b.keShi }</td>
	                    <td>${b.zhuanKeYiSheng }</td>
	                    <td>${b.jingShenKeYiSheng }</td>
	                    <td>${b.cePingShi }</td>
	                    <c:if test="${s.last }">
	                    	<input type="hidden" id="pageCount" value="${s.count }">
	                    </c:if>
                	</tr>
                </c:forEach>
                <tr class="tr4">
                    <td colspan="14">
                       第${page.getpageNow() }页，共${page.getTotalPageNumber() }页（<span id="showPageCount"></span>记录）
                        <a href="javascript:void(0);" onclick="aq('bbgl?m=ibb&pn=1')">首页</a>
                        <a href="javascript:void(0);" onclick="aq('bbgl?m=ibb&pn=${page.getPrevPage() }')">上一条</a>
                        <a href="javascript:void(0);" onclick="aq('bbgl?m=ibb&pn=${page.getNextPage() }')">下一条</a>
                        <a href="javascript:void(0);" onclick="aq('bbgl?m=ibb&pn=${page.getTotalPageNumber() }')">末页</a>
                        跳到<input type="number" id="change_page">页
                        <input type="button" value="跳转">
                    </td>
                </tr>
            </table>
        </div>
<script type="text/javascript">
$(document).ready(function(){
	setting();
});

</script>
  <%@include file="/commons/tail.jsp" %>
