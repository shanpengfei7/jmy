<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心理测评</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  <%@include file="/commons/xlcp/header.jsp" %>
  <link href="css/xin_li_ce_ping/kao_shi.css" rel="stylesheet" type="text/css">
  <div class="all__content">
            <div class="dt__select">
                <div class="dt__box">
                    <div class="dt__header">正在答题<span id="syt" style="margin-left: 60px;"></span><span id="xx"></span></div>
                    <c:forEach items="${daAns }" var="d" varStatus="s">
                    	<c:if test="${s.last }">
                            	<input type="hidden" value="${s.count }" id="l_ge_shu">
                            </c:if>
                    	<input type="hidden" id="l_th${s.index }" value="${d.tiHao }">
                        <input type="hidden" id="l_da${s.index }" value="${d.daAn }">
                    </c:forEach>
                    <c:forEach items="${shiTis }" var="s" varStatus="statu">
                    	<div class="dt__body" id="st${statu.index }">
                        <div class="sj_row">
                        <input type="hidden" id="xzst${statu.index }" value="${statu.count }">
                        <input type="hidden" id="xzda${statu.index }" value="空">
                        	
                            <div>${s.tiHao }.${s.tiMu }</div>
                            <c:if test="${statu.last }">
                            	<input type="hidden" value="${statu.count }" id="ti_mu_ge_shu">
                            	<input type="hidden" id="liang_biao_id" value="${s.liangBiaoId }">
                            </c:if>
                            <br>
                            <c:if test="${s.a!=null }">
                            	<div><input type="radio" onclick="daan('a','${s.tiHao }','${s.liangBiaoId }')" id="a${statu.index }" name="test" value="a"><label for="a${statu.index }">&nbsp;A.&nbsp;${s.a }</label></div>
                            </c:if>
                            <c:if test="${s.b!=null }">
                            	<div><input type="radio" onclick="daan('b','${s.tiHao }','${s.liangBiaoId }')" id="b${statu.index }" name="test" value="b"><label for="b${statu.index }">&nbsp;B.&nbsp;${s.b }</label></div>
                            </c:if>
                            <c:if test="${s.c!=null }">
                            	<div><input type="radio" onclick="daan('c','${s.tiHao }','${s.liangBiaoId }')" id="c${statu.index }" name="test" value="c"><label for="c${statu.index }">&nbsp;C.&nbsp;${s.c }</label></div>
                            </c:if>
                            <c:if test="${s.d!=null }">
                            	<div><input type="radio" onclick="daan('d','${s.tiHao }','${s.liangBiaoId }')" id="d${statu.index }" name="test" value="d"><label for="d${statu.index }">&nbsp;D.&nbsp;${s.d }</label></div>
                            </c:if>
                            <c:if test="${s.e!=null }">
                            	<div><input type="radio" onclick="daan('e','${s.tiHao }','${s.liangBiaoId }')" id="e${statu.index }" name="test" value="e"><label for="e${statu.index }">&nbsp;E.&nbsp;${s.e }</label></div>
                            </c:if>
                            <c:if test="${s.f!=null }">
                            	<div><input type="radio" onclick="daan('f','${s.tiHao }','${s.liangBiaoId }')" id="f${statu.index }" name="test" value="f"><label for="f${statu.index }">&nbsp;F.&nbsp;${s.f }</label></div>
                            </c:if>
                            <c:if test="${s.g!=null }">
                            	<div><input type="radio" onclick="daan('g','${s.tiHao }','${s.liangBiaoId }')" id="g${statu.index }" name="test" value="g"><label for="g${statu.index }">&nbsp;G.&nbsp;${s.a }</label></div>
                            </c:if>
                            <br><br>
                        </div>
						
                    </div>
                    </c:forEach>
                    <div class="dt__footer">
                        <div class="dt__btn">
                                <!-- <input type="button" id="last_ti" value="上一题">
                                <input type="button" id="next_ti" value="下一题"> -->
                                <!-- <input type="button" value="退出"> -->
                            </div>
                    </div>
                </div>
            </div>
            <input type="hidden" id="index" value="0">
            <input type="hidden" id="cs" value="${cs }">
            <input type="hidden" id="jId" value="${jId }">
            
        </div>
        
        <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
        		$(".body-right").css("width", $(window).width()-150);
        		var count = $("#ti_mu_ge_shu").val();
        		for(var i = 0; i < count; i++) {
        			$("#st" + i).css("display", "none");
        		}
        		
        		if($("#l_ge_shu").val()>0){
	        		for(var i = 0; i < $("#l_ge_shu").val(); i++) {
	        			if($("#l_th" + i).size()>0 && $("#l_da" + i).size()>0) {
		        			$("#xzst"+i).val($("#l_th"+i).val());
		        			$("#xzda"+i).val($("#l_da"+i).val());
	        			}
	        		}
				}


        		for(var i = 0; i < count; i++) {
        			if($("#xzda"+i).val()=="空") {
        				$("#st" + i).css("display", "block");
        				$("#index").val(i);
        				i -= 1;
        				if($("l_da" + i).size()>0 && $("l_da" + i).size()>0) {
	        				$("#syt").text($("#l_th" + i).val());
	        				$("#xx").text($("#l_da" + i).val());
	        			}
        				break;
        			}
        		}
        		/* $("#st0").css("display", "block"); */
        		
        		/* $("#last_ti").click(function() {
        		
        			if($("#index").val() != 0) {
        				var index = $("#index").val();
        				$("#st" + index).css("display", "none");
        				index = Number(index);
        				$("#syt").text($("#xzst" + index).val());
        				$("#xx").text($("#xzda" + index).val());
        				index -= 1;
        				$("#index").val(index);
        				$("#st" + index).css("display", "block");
        				
        				if($("#xzda" + index).val()=="a") {
        					$("#a" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="b") {
        					$("#b" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="c") {
        					$("#c" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="d") {
        					$("#d" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="e") {
        					$("#e" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="f") {
        					$("#f" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="g") {
        					$("#g" + index).attr("checked", true);
        				}
        			}
        		});
        		$("#next_ti").click(function() {
        			if($("#index").val() != count) {
        				var index = $("#index").val();
        				$("#st" + index).css("display", "none");
        				index = Number(index);
        				$("#syt").text($("#xzst" + index).val());
        				$("#xx").text($("#xzda" + index).val());
        				index += 1;
        				$("#index").val(index);
        				$("#st" + index).css("display", "block");
        				
        				
        				if($("#xzda" + index).val()=="a") {
        					$("#a" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="b") {
        					$("#b" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="c") {
        					$("#c" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="d") {
        					$("#d" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="e") {
        					$("#e" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="f") {
        					$("#f" + index).attr("checked", true);
        				} else if($("#xzda" + index).val()=="g") {
        					$("#g" + index).attr("checked", true);
        				}
        			}
        		}); */
        	});
        	function daan(d, t, l) {
        		if(Number($("#index").val()) < $("#ti_mu_ge_shu").val()) {
       				var index = $("#index").val();
       				$("#st" + index).css("display", "none");
       				index = Number(index);
       				$.post("kaoshi?m=td",{t:t,j:$("#jId").val(),d:d,l:l,c:$("#cs").val()},function(r){
       					$("#xzst" + index).val(index+1);
        				$("#xzda" + index).val(d);
        				//$("#syt").text($("#xzst" + index).val());
        				//$("#xx").text($("#xzda" + index).val());
        				index += 1;
        				$("#index").val(index);
        				$("#st" + index).css("display", "block");
        				if(t==$("#ti_mu_ge_shu").val()) {
	       					window.location.href="bggl?m=mbg&j="+$("#jId").val()+"&l="+$("#liang_biao_id").val();
	       				}
       				});
       			}
        	}
        </script>
  <%@include file="/commons/tail.jsp" %>
