<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业后台管理</title>
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
<div class="top_logo"> <a href="login-index.php" target="main"><img src="images/main/logo.png" /></a> </div>
     <div class="nav" id="nav">
      <ul>
      <li id="menu_0">
      	<a class="thisclass" href="#" onClick="javascript:history.go(-1);"><b>返回</b></a>
      </li>
      <c:if test="${enterprise.getBit(enterprise.role,0) }">
      <li id="menu_1">
      	<a href="login-index.php" _for="left_menu_0" target="main"><b>厂家</b></a>
      </li>
      </c:if>
      <c:if test="${enterprise.getBit(enterprise.role,1) }">
      <li id="menu_2">
      	<a href="login-index.php" _for="left_menu_1" target="main"><b>代理商</b></a>
      </li>
      </c:if>
      <c:if test="${enterprise.getBit(enterprise.role,2) }">
      <li id="menu_3">
      	<a href="login-index.php" _for="left_menu_2" target="main"><b>经销商</b></a>
      </li>
      </c:if>
      </ul>
    </div>
	 <div class="top_link">
      <ul>
	    <li id="i_self">你好，企业管理员</li>
		<li id="i_hide_menu"><a href="#" id="togglemenu">隐藏菜单</a></li>
        <li id="i_exit"><a href="login-leave.jmy?role=1" target="_top">退出</a></li>		
      </ul>
    </div>
</div>
<!-- header end -->

<div class="left">
<div class="span"></div>
<div class="menu" id="menu">
		
	<div id="items_left_menu_0">
		<dl id="dl_items_1_0">
			<dt>企业信息管理</dt>
			<dd>
				<ul>
					<li><a href="enterprise-show.php?operate=5" target="main">企业信息查看</a></li>
					<c:if test="${enterprise.isconnect==1 }">
					<li><a href="enterprise-show.php?operate=55" target="main">企业信息修改</a></li>
					</c:if>
					<li><a href="pages/enterprise/pswd.jsp" target="main">企业密码修改</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="dl_items_2_0">
			<dt>企业员工管理</dt>
			<dd>
				<ul>
					<!-- <li><a href="pages/employee/add.jsp" target="main">员工添加</a></li> -->
					<li><a href="employee-list.php" target="main">员工列表</a></li>
				</ul>
			</dd>
		</dl>
		<c:if test="${enterprise.isconnect==0 }">
			<dl id="dl_items_3_0">
				<dt>产品型号申请</dt>
				<dd>
					<ul>
						<li><a href="version-applying.php" target="main">型号申请</a></li>
						<li><a href="version-applied.php" target="main">型号管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="dl_items_4_0">
				<dt>包装型号申请</dt>
				<dd>
					<ul>
						<li><a href="versionp-applying.php" target="main">型号申请</a></li>
						<li><a href="versionp-applied.php" target="main">型号管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="dl_items_5_0">
				<dt>产品下线</dt>
				<dd>
					<ul>
						<li><a href="product-list.php" target="main">产品下线</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="dl_items_6_0">
			<dt>生产二维码</dt>
			<dd>
				<ul>
		            <li><a href="qrcode-list.php" target="main">生产产品码</a></li>
		            <li><a href="qrcode-plist.php" target="main">生产包装码</a></li>
		            <li><a href="qrcode-qlist.php" target="main">列出二维码</a></li>
				</ul>
			</dd>
		</dl>
			<dl id="dl_items_7_0">
			<dt>库存信息</dt>
			<dd>
				<ul>
		            <li><a href="repertory-list.php" target="main">库存信息</a></li>
				</ul>
			</dd>
		</dl>
			<dl id="dl_items_8_0">
			<dt>物流信息</dt>
			<dd>
				<ul>
		            <li><a href="waybill-delist.php" target="main">发货信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
</div>
<div id="items_left_menu_1">
		<dl id="dl_items_1_0">
			<dt>企业信息管理</dt>
			<dd>
				<ul>
					<li><a href="enterprise-show.php?operate=5" target="main">企业信息查看</a></li>
					<c:if test="${enterprise.isconnect==1 }">
					<li><a href="enterprise-show.php?operate=55" target="main">企业信息修改</a></li>
					</c:if>
					<li><a href="pages/enterprise/pswd.jsp" target="main">企业密码修改</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="dl_items_2_0">
			<dt>企业员工管理</dt>
			<dd>
				<ul>
					<!-- <li><a href="pages/employee/add.jsp" target="main">员工添加</a></li> -->
					<li><a href="employee-list.php" target="main">员工列表</a></li>
				</ul>
			</dd>
		</dl>
		<c:if test="${enterprise.isconnect==0 }">
			<dl id="dl_items_3_0">
			<dt>库存信息</dt>
			<dd>
				<ul>
		            <li><a href="repertory-list.php" target="main">库存信息</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="dl_items_4_0">
			<dt>物流信息</dt>
			<dd>
				<ul>
		            <li><a href="waybill-delist.php" target="main">发货信息</a></li>
		            <li><a href="waybill-relist.php" target="main">收货信息</a></li>
				</ul>
			</dd>
		</dl>
		</c:if>
</div>
<div id="items_left_menu_2">
		<dl id="dl_items_1_0">
			<dt>企业信息管理</dt>
			<dd>
				<ul>
					<li><a href="enterprise-show.php?operate=5" target="main">企业信息查看</a></li>
					<c:if test="${enterprise.isconnect==1 }">
					<li><a href="enterprise-show.php?operate=55" target="main">企业信息修改</a></li>
					</c:if>
					<li><a href="pages/enterprise/pswd.jsp" target="main">企业密码修改</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="dl_items_2_0">
			<dt>企业员工管理</dt>
		<dd>
			<ul>
				<!-- <li><a href="pages/employee/add.jsp" target="main">员工添加</a></li> -->
				<li><a href="employee-list.php" target="main">员工列表</a></li>
			</ul>
		</dd>
		</dl>
		<c:if test="${enterprise.isconnect==0 }">
		</dl>
			<dl id="dl_items_3_0">
			<dt>库存信息</dt>
			<dd>
				<ul>
		            <li><a href="repertory-list.php" target="main">库存信息</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="dl_items_4_0">
			<dt>物流信息</dt>
			<dd>
				<ul>
		           <!--  <li><a href="circulate-delist.php" target="main">发货信息</a></li> -->
		            <li><a href="waybill-relist.php" target="main">收货信息</a></li>
		            <li><a href="circulate-sell.php" target="main">销售信息</a></li>
				</ul>
			</dd>
		</dl>
	</c:if>
</div>
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
