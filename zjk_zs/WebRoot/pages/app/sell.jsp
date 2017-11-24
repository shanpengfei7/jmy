<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="wilih=device-wilih, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
<link rel='stylesheet' type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 物流信息  &gt 销售信息</div> -->
    <div class="operate">
        <div class="left">
                <!-- <input type="button" onclick="btn_apply()" class="btn_blue" value="型号申请"> -->
        </div>
        <div class="left_pad">
            <!-- <form method="post" action="">
                <input type="text" name="keyword" title="关键字" class="inp_default" value="">
                <input type="submit" class="btn_blue" value="查  询">
            </form> -->
        </div>
    </div>
    <div class="list">   
    <dl>
            <dt> 日期时间：</dt>
            <dd>
                <input type="text" class="inp_one" name="publishtime" id="publishtime" value="${packagetime }">
                <input type="hidden" id="employeeid" value="${employeeid }"/>
                <script type="text/javascript">
                    Calendar.setup({
                        weekNumbers: true,
                        inputField : "publishtime",
                        trigger    : "publishtime",
                        dateFormat: "%Y-%m-%d",
                        showTime: true,
                        minuteStep: 1,
                        onSelect   : function() {
                        	this.hide();
                        	window.location.href="appinfo-sell.php?employeeid="+$("#employeeid").val()+"&packagetime=" + $("#publishtime").val();	
                        }
                    });
                </script>
            </dd>
        </dl>     
    <form action="" method="post" id="form_do" name="form_do">
        <table width="100%">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>销售企业</th>
                <th>销售员工</th>
                <th>销售时间</th>
                <th>销售地点</th>
                <th>是否销售</th>
                <th>操作</th>
            </tr>
			<c:forEach items="${sellinformations }" var="c" varStatus="s">
				<tr>
	                <td>${s.index+1 }</td>
	                <td>${c.qrcode.product.tradename }</td>
	                <td>${c.enterprise.company }</td>
	                <td>${c.employee.name }</td>
	                <td><date:date value="${c.time }"></date:date></td>
	                <td>${c.place }</td>
	                <td>
	                	<c:if test="${c.qrcode.issell==1 }">
			                是
	                	</c:if>
	                	<c:if test="${c.qrcode.issell==0 }">
			                否
	                	</c:if>
					</td>
					<td><a href="shows.php?token=${c.qrcode.qrcode }">查看详细信息</a></td>
            </tr>
			</c:forEach>
        </table>

    </form>
    </div>
</div>
  </body>
</html>
