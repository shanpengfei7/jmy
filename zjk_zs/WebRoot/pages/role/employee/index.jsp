<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<script language="javascript" type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script src="js/frame.js" language="javascript" type="text/javascript"></script>
<link href="css/frame.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script src="js/DD_belatedPNG_0.0.8a-min.js" language="javascript" type="text/javascript"></script>
<script>
  DD_belatedPNG.fix('.nav ul li a,.top_link ul li,background');   /* string argument can be any CSS selector */
</script>
<![endif]-->
</head>
<body class="showmenu">
<div class="pagemask"></div>
<iframe class="iframemask"></iframe>
<div class="head">
<div class="top_logo"> <a href="login-index.php" target="main"><img src="images/main/logo.png" /></a></div>
     <div class="nav" id="nav">
      <ul><li id="menu_0"><a class="thisclass" href="#" onClick="javascript:history.go(-1);" _for="left_menu_0"><b>返回</b></a></li>
      <!-- 	<li id="menu_0"><a class="thisclass" href="#" _for="left_menu_0"><b>型号申请</b></a></li>
		<li id="menu_1"><a  href="#" _for="left_menu_3"><b>企业员工管理</b></a></li>    --> 
      </ul>
    </div>
	 <div class="top_link">
      <ul>
	    <li id="i_self">你好</li>
		<li id="i_hide_menu"><a href="#" id="togglemenu">隐藏菜单</a></li>
        <li id="i_exit"><a href="login-leave.jmy?role=2" target="_top">退出</a></li>		
      </ul>
    </div>
</div>
<!-- header end -->

<div class="left">
<div class="span"></div>
<div class="menu" id="menu">
		
<div id="items_left_menu_0">
	<c:if test="${employee.getBit(employee.power, 0) }">
		<dl id="dl_items_1_0">
			<dt>打包</dt>
			<dd>
				<ul>
					<li><a href="appinfo-packagelist.php?employeeid=${employee.id }" target="main">打包信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 1) }">
		<dl id="dl_items_2_0">
			<dt>发货</dt>
			<dd>
				<ul>
					<li><a href="appinfo-delist.php?employeeid=${employee.id }" target="main">发货信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 2) }">
		<dl id="dl_items_3_0">
			<dt>收货</dt>
			<dd>
				<ul>
		            <li><a href="appinfo-relist.php?employeeid=${employee.id }" target="main">收货信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 3) }">
		<dl id="dl_items_4_0">
			<dt>销售</dt>
			<dd>
				<ul>
		            <li><a href="circulate-sell.php" target="main">销售信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 4) }">
		<dl id="dl_items_5_0">
			<dt>员工管理</dt>
			<dd>
				<ul>
		            <li><a href="pages/employee/add.jsp" target="main">员工添加</a></li>
					<li><a href="employee-list.php" target="main">员工列表</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${enterprise.isconnect==0 }">
	<c:if test="${employee.getBit(employee.power, 5) }">
		<dl id="dl_items_6_0">
			<dt>企业身份管理</dt>
			<dd>
				<ul>
		            <li><a href="circulate-delist.php" target="main">企业身份管理</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 6) }">
		<dl id="dl_items_7_0">
			<dt>型号申请</dt>
			<dd>
				<ul>
		            <li><a href="version-applying.php" target="main">产品型号申请</a></li>
		            <li><a href="versionp-applying.php" target="main">包装型号申请</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 7) }">
		<dl id="dl_items_8_0">
			<dt>型号管理</dt>
			<dd>
				<ul>
		            <li><a href="version-applied.php" target="main">产品型号管理</a></li>
		            <li><a href="versionp-applied.php" target="main">包装型号管理</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 8) }">
		<dl id="dl_items_9_0">
			<dt>库存信息</dt>
			<dd>
				<ul>
		            <li><a href="repertory-list.php" target="main">库存信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 9) }">
		<dl id="dl_items_10_0">
			<dt>产品下线</dt>
			<dd>
				<ul>
		            <li><a href="product-list.php" target="main">产品下线</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 10) }">
		<dl id="dl_items_11_0">
			<dt>产品码打印</dt>
			<dd>
				<ul>
		            <li><a href="qrcode-list.php" target="main">产品码打印</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${employee.getBit(employee.power, 11) }">
		<dl id="dl_items_12_0">
			<dt>包装码打印</dt>
			<dd>
				<ul>
		            <li><a href="qrcode-plist.php" target="main">包装码打印</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
	</c:if>
</div>
<!-- <div id="items_left_menu_3">
	<dl id="dl_items_1_3">
		<dt>企业员工管理</dt>
		<dd>
			<ul>
				<li><a href="pages/employee/add.jsp" target="main">员工添加</a></li>
				<li><a href="employee-list.php" target="main">员工列表</a></li>
			</ul>
		</dd>
	</dl>
</div> -->

<!-- Item End -->


</div>
</div>
<!-- left end -->

<div class="right">
	<div class="rightContent">
	<iframe id="main" name="main" frameborder="0" scrolling="yes" src="login-index.php"></iframe>
	</div>    
</div>
<!-- right end -->

</body>
</html>