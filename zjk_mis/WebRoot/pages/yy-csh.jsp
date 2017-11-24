<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>医院</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link href="css/yiyuan/xin_xi_chu_shi_hua.css" rel="stylesheet" type="text/css">
    
  <%@include file="/commons/header.jsp" %>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/yy-csh.js"></script>
    <link href="css/modal.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/md5.js"></script>
    <style type="text/css">
     	.modal{
     		top: 50%;
  			left: 55%;
     		width: 500px;
     	}
     	
	 </style>
  <div class="all__content">
  			<div class="chu"></div>
            <div>
            	<div class="chu2"></div>
                <input type="button" id="ke_shi_btn" value="科室初始化" class="chushihua">
                <input type="button" id="yi_sheng_btn" value="医生初始化" class="chushihua">
            </div>
            <div id="ke_shi" class="xuan_xiang_ka">
                <div class="csh_biao_ti"><h3>科室初始化</h3></div>
                <input type="button" id="ke_shi_tian_jia" value="科室添加" class="add_btn">
                <br><br>
                <div class="csh_content">
                    <table class="table" border="1" cellspacing="0">
                        <tr class="tr1">
                            <td></td>
                            <td>医院名称</td>
                            <td>科室名称</td>
                            <td>状态</td>
                        </tr>
                        <c:forEach items="${keShis }" var="keShi" varStatus="s">
                         <tr class="tr${s.index%2==0?2:3 }">
                            <td><a href="javascript:0; return false" onclick="edited('${keShi.id }', 'ke_shi_edit')">编辑</a><span class="csh_bj"></span>
                            <c:if test="${keShi.isUse==true }">
                            	<a href="javascript:0; return false" onclick="deleted('${keShi.id }')">禁用</a>
                            </c:if>
                            <c:if test="${keShi.isUse==false }">
                            	<a href="javascript:0; return false" onclick="will_deleted('${keShi.id }')">启用</a>
                            </c:if>
                            
                            </td>
                            <td>${keShi.yiYuan }</td>
                            <td>${keShi.mingCheng }</td>
                            <c:if test="${keShi.isUse==true }"><td>启用</td></c:if>
                            <c:if test="${keShi.isUse==false }"><td>禁用</td></c:if>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <!-- 模态框开始 -->
            <div id="ke_shi_add" class="modal hide">

                <form id="form_ke_shi_add" action="csh?m=sks" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">科室信息添加</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('ke_shi_add');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="ke_shi_ming_cheng_add">科室名称：</label>
                        <input type="text" placeholder="请输入科室的名称" id="ke_shi_ming_cheng_add" name="ke_shi_ming_cheng_add"><br><br>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('ke_shi_add');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
            <!-- 模态框开始 -->
             <div id="ke_shi_edit" class="modal hide">

                <form id="form_ke_shi_edit" action="csh?m=cks" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">科室信息修改</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('ke_shi_edit');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="ke_shi_ming_cheng_edit">科室名称：</label>
                        <input type="text" placeholder="请输入科室的名称" id="ke_shi_ming_cheng_edit" name="ke_shi_ming_cheng_edit"><br><br>
                    	<input type="hidden" id="ksId" name="ksId"> 
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('ke_shi_edit');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
    <!-- ================================================================================== -->
            <div id="yi_sheng" class="xuan_xiang_ka">
                <div class="csh_biao_ti"><h3>医生初始化</h3></div>
                <input type="button" id="yi_sheng_tian_jia" value="医生添加" class="add_btn">
                <br><br>
                <div class="csh_content">
                    <table class="table" border="1" cellspacing="0">
                        <tr class="tr1">
                            <td></td>
                            <td>科室名称</td>
                            <td>姓名</td>
                            <td>性别</td>
                            <td>角色</td>
                            <td>是否主任</td>
                            <td>联系方式</td>
                        </tr>
                        <c:forEach items="${yiShengs }" var="yiSheng" varStatus="s">
                        <tr class="tr${s.index%2==0?2:3 }">
                            <td><a href="javascript:0; return false" onclick="editedys('${yiSheng.id }', 'yi_sheng_edit')">编辑</a><span class="csh_bj"></span><a href="javascript:0; return false" onclick="deletedys('${yiSheng.id }')">删除</a></td>
                            <td>${yiSheng.keShi }</td>
                            <td>${yiSheng.xingMing }</td>
                            <c:if test="${yiSheng.xingBie==1 }">
                            	<td>男</td>
                            </c:if>
                            <c:if test="${yiSheng.xingBie==2 }">
                            	<td>女</td>
                            </c:if>
                            <td>${yiSheng.jueSe }</td>
                            <c:if test="${yiSheng.isZhuRen }">
                            	<td>是</td>
                            </c:if>
                            <c:if test="${!yiSheng.isZhuRen }">
                            	<td>否</td>
                            </c:if>
                            <td>${yiSheng.lianXiFangShi }</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            
            <!-- 模态框开始 -->
            <div id="yi_sheng_add" class="modal hide">

                <form id="form_yi_sheng_add" action="csh?m=sys" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">医生信息添加</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('yi_sheng_add');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="yi_sheng_ming_cheng_add">姓名：</label>
                        <input type="text" placeholder="请输入您的姓名" id="xing_ming_add" name="xing_ming_add"><br><br>
                        <label for="nan_add">性别：</label>
                        <input type="radio" id="nan_add" name="xing_bie_add" value="1"><label for="nan_add">男</label>
                        <input type="radio" id="nv_add" name="xing_bie_add" value="2"><label for="nv_add">女</label><br><br>
                        <label for="ke_shi_ming_cheng_add">科室名称：</label>
                        <select id="ke_shi_ming_cheng_add" name="ke_shi_ming_cheng_add">
                        	<c:forEach items="${keShis }" var="keShi">
                            <option value="${keShi.id },${keShi.mingCheng }">${keShi.mingCheng }</option>
                        </tr>
                        </c:forEach>
                        </select><br><br>
                        <label for="shi_add">是否主任：</label>
                        <input type="radio" id="shi_add" name="is_zhu_ren_add" value="1"><label for="shi_add">是</label>
                        <input type="radio" id="fou_add" name="is_zhu_ren_add" value="2"><label for="fou_add">否</label><br><br>
                        <label for="jue_se_add">角色：</label>
                        <select name="jue_se_add" id="jue_se_add">
                        	<option value="测评师">测评师</option>
                        	<option value="精神科主任">精神科主任</option>
                        	<option value="精神科医生">精神科医生</option>
                        	<option value="专科主任">专科主任</option>
                        	<option value="专科医生">专科医生</option>
                        </select><br><br>
                        <label for="lian_xi_fang_shi_add">手机号：</label>
                        <input type="text" placeholder="请输入您的手机号码" id="lian_xi_fang_shi_add" name="lian_xi_fang_shi_add"><br><br>
                        <label for="deng_lu_hao_add">登陆号：</label>
                        <input type="text" placeholder="请输入您的账号" id="deng_lu_hao_add" name="deng_lu_hao_add"><br><br>
                        <label for="mi_ma_add">密码：</label>
                        <input type="password" placeholder="请输入您的登陆密码" id="mi_ma_add" name="mi_ma_add"><br><br>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('yi_sheng_add');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
            <!-- 模态框开始 -->
              <div id="yi_sheng_edit" class="modal hide">

                <form id="form_yi_sheng_edit" action="csh?m=cys" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">医生信息修改</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('yi_sheng_edit');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="yi_sheng_ming_cheng_edit">姓名：</label>
                        <input type="text" placeholder="请输入您的姓名" id="xing_ming_edit" name="xing_ming_edit"><br><br>
                        <label for="nan_edit">性别：</label>
                        <input type="radio" id="nan_edit" name="xing_bie_edit" value="1"><label for="nan_edit">男</label>
                        <input type="radio" id="nv_edit" name="xing_bie_edit" value="2"><label for="nv_edit">女</label><br><br>
                        <label for="ke_shi_ming_cheng_edit">科室名称：</label>
                        <select id="ke_shi_ming_cheng_edit_e">
                        	<option> </option>
                        	<c:forEach items="${keShis }" var="keShi">
	                            <option value="${keShi.id },${keShi.mingCheng }">${keShi.mingCheng }</option>
	                            <%-- <option value="${keShi.mingCheng }">${keShi.mingCheng }</option> --%>
	                        </c:forEach>
                        </select><br><br>
                        <input type="hidden" name="ke_shi_ming_cheng_edit" id="ksmc_edit">
                        <label for="shi_edit">是否主任：</label>
                        <input type="radio" id="shi_edit" name="is_zhu_ren_edit" value="1"><label for="shi_edit">是</label>
                        <input type="radio" id="fou_edit" name="is_zhu_ren_edit" value="2"><label for="fou_edit">否</label><br><br>
                        <label for="jue_se_edit">角色：</label>
                        <select name="jue_se_edit" id="jue_se_edit">
                        	<option value="测评师">测评师</option>
                        	<option value="精神科主任">精神科主任</option>
                        	<option value="精神科医生">精神科医生</option>
                        	<option value="专科主任">专科主任</option>
                        	<option value="专科医生">专科医生</option>
                        </select><br><br>
                        <label for="lian_xi_fang_shi_edit">手机号：</label>
                        <input type="text" placeholder="请输入您的手机号码" id="lian_xi_fang_shi_edit" name="lian_xi_fang_shi_edit"><br><br>
                        <label for="deng_lu_hao_edit">登陆号：</label>
                        <input type="text" placeholder="请输入您的账号" id="deng_lu_hao_edit" name="deng_lu_hao_edit"><br><br>
                        <label for="mi_ma_edit">密码：</label>
                        <input type="password" placeholder="请输入您的登陆密码" id="mi_ma_edit" name="mi_ma_edit"><br><br>
                    	<input type="hidden" id="dlId_edit" name="dlId_edit">
                    	<input type="hidden" id="ysId_edit" name="ysId_edit">
                    	<input type="hidden" id="dlmm_edit">
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('yi_sheng_edit');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
            <input type="hidden" value="${xxk }" id="xxk"> 
  <!-- =============================================================================== -->
            
        </div>
        <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
        	$("#lian_xi_fang_shi_add").change(function(){
    			$("#deng_lu_hao_add").val($("#lian_xi_fang_shi_add").val());
    			$.post("login?m=hdl", {h:$("#deng_lu_hao_add").val()}, function(r){
	    			if(r == 'true') {
	    				alert('该用户已存在！！');
	    			}
	    		});
	    	});
	    	
	    	$("#deng_lu_hao_add").change(function(){
	    		$.post("login?m=hdl", {h:$("#deng_lu_hao_add").val()}, function(r){
	    			if(r == 'true') {
	    				alert('该用户已存在！！');
	    			}
	    		});
	    	});
	    	$("#deng_lu_hao_edit").change(function(){
	    		$.post("login?m=hdl", {h:$("#deng_lu_hao_edit").val()}, function(r){
	    			if(r == 'true') {
	    				alert('该用户已存在！！');
	    			}
	    		});
	    	});
			    $("#ke_shi").css("display", "block");
			    $("#yi_sheng").css("display", "none");
			
			    $("#ke_shi_btn").click(function () {
			        $("#ke_shi").css("display", "block");
			        $("#yi_sheng").css("display", "none");
			    });
			    $("#yi_sheng_btn").click(function () {
			        $("#yi_sheng").css("display", "block");
			        $("#ke_shi").css("display", "none");
			    });
			    
			    if($("#xxk").val() == 'ys') {
			    	$("#yi_sheng").css("display", "block");
			        $("#ke_shi").css("display", "none");
			    }
			    
			    setting();
        		/* $("#form_yi_sheng_edit").submit(function(){
		    		if($.trim($("#mi_ma_edit").val()) == "") {
    					$("#mi_ma_edit").val($("#dlmm_edit").val());
		    		}else {
		    			document.getElementById("mi_ma_edit").value = hex_md5(document.getElementById("mi_ma_edit").value);
		    		}
		    	}); */
		    	
        	});
        </script>
  <%@include file="/commons/tail.jsp" %>
