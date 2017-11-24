<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/modal.css" rel="stylesheet" type="text/css" />
	<link href="css/yiyuan/xin_xi_chu_shi_hua.css" rel="stylesheet" type="text/css">
  <%@include file="/commons/header.jsp" %>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/gly-csh.js"></script>
	
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<style type="text/css">
     	.modal{
     		top: 50%;
  			left: 55%;
     		width: 500px;
     	}
     	
	 </style>
  <div class="all__content">
            <div>
                <!-- <input type="button" id="ke_shi_btn" value="医院初始化"> -->
            </div>
            <div id="ke_shi" class="xuan_xiang_ka">
                <div class="csh_biao_ti"><h3>医院初始化</h3></div>
                <input type="button" id="yi_yuan_tian_jia" value="医院添加" class="add_btn">
                <br><br>
                <div class="csh_content">
                    <table class="table" border="1" cellspacing="0">
                        <tr class="tr1">
                            <td></td>
                            <td>医院名称</td>
                            <td>医院代号</td>
                            <td>省</td>
                            <td>市</td>
                            <td>县</td>
                            <td>联系电话</td>
                            <td>状态</td>
                        </tr>
                        <c:forEach items="${yiYuans }" var="yiYuan" varStatus="s">
	                       <tr class="tr${s.index%2==0?2:3 }">
                            <td><a href="javascript:0; return false" onclick="edited('${yiYuan.id }', 'yi_yuan_edit')">编辑</a><span class="csh_bj"></span>
     						<c:if test="${yiYuan.isUse==true }">                       
                            	<a href="javascript:0; return false" onclick="deleted('${yiYuan.id }')">禁用</a>
                            </c:if>
                            <c:if test="${yiYuan.isUse==false }">                       
                            	<a href="javascript:0; return false" onclick="will_deleted('${yiYuan.id }')">启用</a>
                            </c:if>
                            </td>
                            <td>${yiYuan.mingCheng }</td>
                            <td>${yiYuan.daiHao }</td>
                            <td>${yiYuan.sheng }</td>
                            <td>${yiYuan.shi }</td>
                            <td>${yiYuan.xian }</td>
                            <td>${yiYuan.lianXiDianHua }</td>
                            <c:if test="${yiYuan.isUse==true }"><td>启用</td></c:if>
							<c:if test="${yiYuan.isUse==false }"><td>禁用</td></c:if>
                           </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            
            <!-- 模态框开始 -->
            <div id="yi_yuan_add" class="modal hide">

                <form id="form_yi_yuan_add" action="csh?m=sYy" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">医院信息添加</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('yi_yuan_add');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="yi_yuan_ming_cheng_add">医院名称：</label>
                        <input type="text" placeholder="请输入医院的名称" id="yi_yuan_ming_cheng_add" name="yi_yuan_ming_cheng_add"><br><br>
	                    <label for="sheng_add">省：</label>    
                        <select id="sheng_add" name="sheng_add">
                        	<option value="0">请选择</option>
                        </select>
                        <label for="shi_add">市：</label>    
                        <select id="shi_add" name="shi_add">
                        	<option value="0">请选择</option>
                        </select>
                        <label for="xian_add">县：</label>    
                        <select id="xian_add" name="xian_add">
                        	<option value="0">请选择</option>
                        </select><br><br>
                        <label for="shou_ji_hao_add">手机号：</label>
                        <input type="text" placeholder="请输入手机号码" id="shou_ji_hao_add" name="shou_ji_hao_add"><br><br>
                        <label for="den_lu_hao_add">登陆号：</label>
                        <input type="text" placeholder="请输入登陆的账号" id="den_lu_hao_add" name="den_lu_hao_add"><br><br>
                        <label for="mi_ma_add">密码：</label>
                        <input type="password" placeholder="请输入密码" id="mi_ma_add" name="mi_ma_add"><br><br>
                        <label for="yi_yuan_dai_hao_add">医院代号：</label>
                        <input type="text" id="yi_yuan_dai_hao_add" placeholder="请选择省市县" name="yi_yuan_dai_hao_add" readonly="readonly">
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('yi_yuan_add');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
            <!-- 模态框开始 -->
            <div id="yi_yuan_edit" class="modal hide">

                <form id="form_yi_yuan_edit" action="csh?m=cYy" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">医院信息修改</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOut('yi_yuan_edit');" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body">
                    	<label for="yi_yuan_ming_cheng_edit">医院名称：</label>
                        <input type="text" id="yi_yuan_ming_cheng_edit" name="yi_yuan_ming_cheng_edit"><br><br>
	                    
                        <label for="shou_ji_hao_edit">手机号：</label>
                        <input type="text" id="shou_ji_hao_edit" name="shou_ji_hao_edit"><br><br>
                        <label for="deng_lu_hao_edit">登陆号：</label>
                        <input type="text" id="deng_lu_hao_edit" name="deng_lu_hao_edit"><br><br>
                        <label for="mi_ma_edit">密码：</label>
                        <input type="password" id="mi_ma_edit" name="mi_ma_edit"><br><br>
                        <input type="hidden" id="yyId" name="yyId">
                        <input type="hidden" id="dlId" name="dlId">
                        <input type="hidden" id="dlmm_edit">
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="保存" class="btn btn-success" id="tijiao">
                        <a href="javascript:void(0);" onclick="fadeOut('yi_yuan_edit');" class="btn" data-dismiss="modal">关闭</a>
                        
                    </div>
                </form>
            </div>
            <!-- 态框结束 -->
        </div>
        <script language="javascript">
$(document).ready(function(){
	setting();
});
</script>
  <%@include file="/commons/tail.jsp" %>
