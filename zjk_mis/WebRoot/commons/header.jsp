<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link rel="icon" href="W-MIS.ico" type="image/x-icon" />   
    <link rel="shortcut icon" href="W-MIS.ico" type="image/x-icon" /> 
    <link href="css/table_css.css" rel="stylesheet" type="text/css">
    <link href="css/datePicker.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <link href="css/frame.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.date_input.pack.js"></script>
    <script type="text/javascript">
    	function aq(h) {
			var href = h + "&r=" + $("#r").val() + "&q=" + $("#q").val() + "&n=" + $("#n").val();
			window.location.href = href;			
			return false;
    	}
    </script>
</head>
<body>
<div class="header">
    <img src="image/index.jpg" width="50px" height="55px" style="margin-left: 80px">
    <label class="index_label_nav">
    W-MIS系统</label>
    <div class="exit_div">
    	<a href="login?m=lv" class="exit">退出</a>
    </div>
    <div class="exit_div">
    <span class="exit">
    	欢迎您！
    	${sessionScope.nav }
    	</a>
    </span>
    </div>
</div>
<div class="body">
    <div class="body-left">
        <div class="nav">
            <ul>
            <li style="margin-top: 60px"></li>
	            <c:choose>
			        <c:when test="${sessionScope.quanxian == 1 }">
		                <li class="con"><a href="csh?m=iGlyCsh" id="nav_xxcsh">信息初始化</a></li>
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_brxx">病人信息</a></li>
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 2 }">
		                <li class="con"><a href="csh?m=iYyCsh" id="nav_xxcsh">信息初始化</a></li>
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_brxx">病人信息</a></li>
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 3 }">
		                <li class="con"><a href="jcxx?m=iJcxx" id="nav_jcxx">基础信息</a></li>
		                <li class="con"><a href="jcxm?m=iJcxm" id="nav_jcxm">检测项目</a></li>
		                <li class="con"><a href="zlfa?m=iZlfa" id="nav_zlfa">诊疗方案</a></li>
		                <li class="con"><a href="jcxm?m=iJcxm" id="nav_fzxm">复诊项目</a></li>
		                <li class="con"><a href="zlfa?m=iZlfa" id="nav_fzfa">复诊方案</a></li>
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_blgl">病例管理</a></li>
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 4 }">
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_bexx">病人信息</a></li>
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 5 }">
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_brxx">病人信息</a></li>
		                <!-- <li class="con"><a href="zlfa?m=gd&id=">完成冶疗</a></li> -->
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 6 }">
		               <li class="con"><a href="blgl?m=iBlgl" id="nav_brxx">病人信息</a></li>
		               <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:when test="${sessionScope.quanxian == 7 }">
		                <li class="con"><a href="blgl?m=iBlgl" id="nav_brxx">病人信息</a></li>
		                <li class="con"><a href="bbgl?m=ibb" id="nav_bbgl">报表管理</a></li>
			        </c:when>
			        <c:otherwise>
			        	<%
							response.sendRedirect("pages/login.jsp");
						%>
			        </c:otherwise>
	        	</c:choose>
            </ul>
        </div>
        
    </div>
    <div class="body-right">  
