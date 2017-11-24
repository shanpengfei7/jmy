<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link href="css/insert.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/calendar.config.js"></script>
  </head>
  
  <body>
    <div class="main">
    <!-- <div class="pos">当前位置 | 生产二维码  &gt 生产产品码</div> -->
	<div class="form">
		<form method='post' id="form_do" name="form_do" action="qrcode-add.php">
		<input type="hidden" name="pid" value="${pid }">
		<input type="hidden" name="operate" value="${operate }">
		<dl>
			<dt> 打印二维码数量：</dt>
			<dd>
				<input type="number" min="1" name="count">
			</dd>
		</dl>
		<dl>
			<dt> 单价（两位小数）：</dt>
			<dd>
				<input type="text" name="price" id="price" />
			</dd>
		</dl>
		
			<c:if test="${!empty productproperties }">
			<c:forEach items="${productproperties }" var="p">
			<dl>
				<c:if test="${!empty p.name }">
					<dt> ${p.name }：</dt>
				</c:if>
				<dd>
					<%-- <c:if test="${!empty p.name }"> --%>
						<input type="hidden" name="propertyName" value="${p.name }">
					<%-- </c:if> --%>
					<%-- <c:if test="${!empty p.value }"> --%>
						<input type="text" name="propertyValue" value="${p.value }">
					<%-- </c:if> --%>
				</dd>
			
		</dl>
			</c:forEach>
			</c:if>
		
		
		<div class="form_b">		
			<input type="reset" class="btn_green" id="" value="重置"> <input type="submit" class="btn_blue" id="" value="提 交"> 
			${error } 
		</div>
	   </form>
	</div>
</div>
<script type="text/javascript">
$("#price").on('keyup', function (event) {
    var $amountInput = $(this);
    //响应鼠标事件，允许左右方向键移动 
    event = window.event || event;
    if (event.keyCode == 37 | event.keyCode == 39) {
        return;
    }
    //先把非数字的都替换掉，除了数字和. 
    $amountInput.val($amountInput.val().replace(/[^\d.]/g, "").
        //只允许一个小数点              
        replace(/^\./g, "").replace(/\.{2,}/g, ".").
        //只能输入小数点后两位
        replace(".", "$#$").replace(/\./g, "").replace("$#$", ".").replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'));
            });
$("#price").on('blur', function () {
    var $amountInput = $(this);
    //最后一位是小数点的话，移除
    $amountInput.val(($amountInput.val().replace(/\.$/g, "")));
});
</script>
 </body>
</html>
