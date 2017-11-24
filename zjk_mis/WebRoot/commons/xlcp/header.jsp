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
    	$(document).ready(function(){
    		$(".body-right").css("width", $(window).width()-155); 
    	});
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
	            
            </ul>
        </div>
        
    </div>
    <div class="body-right">  
