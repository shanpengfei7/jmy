<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="common/css/timers.css">
<link href="common/css/modal.css" rel="stylesheet" type="text/css" />
<ul class="layui-nav" pc>
      <li class="layui-nav-item ">
        <a href="user/leave.jmy">退出</a>
      </li>
      <!-- <li class="layui-nav-item layui-this">
        <a href="/demo/">示例</a>
      </li>
      <li class="layui-nav-item" pc>
        <a href="http://fly.layui.com/" target="_blank">社区</a>
      </li>
      <li class="layui-nav-item" pc>
        <a href="javascript:;">周边</a>        
      </li>      --> 
    </ul>
  </div>
</div>
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
<ul class="layui-nav layui-nav-tree site-demo-nav">
  
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">用户信息管理</a>
    <dl class="layui-nav-child">
      <dd>
        <a href="user/info.jmy?o=c">用户资料查看</a>
        <a href="user/info.jmy?o=x">用户资料修改</a>
       <!--  <a href="user/username.jsp">用户帐号修改</a> -->
        <a href="user/password.jsp">用户密码修改</a>
      </dd>
    </dl>
  </li>
  
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">套餐管理</a>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="faceapplay/list.jmy">套餐申请</a>
        <a href="faceinfo/list.jmy">接口信息</a>
      </dd>      
    </dl>
  </li>
  
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">消息通知</a>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="notice/list.jmy">
          <i class="layui-icon" style="top: 3px;">&#xe63a;</i><cite>消息通知<span id="unread">0</span></cite>
        </a>
      </dd>      
    </dl>
  </li>
  
  <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
</ul>

    </div>
  </div>
  <div class="layui-tab layui-tab-brief" lay-filter="demoTitle">
    
    <div class="layui-body layui-tab-content site-demo site-demo-body">    
  
      <div class="layui-tab-item layui-show">
        <div class="layui-main">
          <div id="LAY_preview">
          <!--模态对话框-->
            <div id="formTable" class="modal hide">

                <form id="form0" action="jcxm?m=iJcxmAdd" method="post">
                    <div class="modal-header" style=" height:40px;">
                        <div style=" float:left;">消息通知</div>
                        <div style=" float:right;"><a class="close" id="close" onclick="fadeOuts();" style="cursor:pointer;">×</a></div>
                    </div>
                    <div class="modal-body" id="formTableBody">
                    
                        
                    </div>
                    <div class="modal-footer">
                        <a  href="javascript:void(0);" onclick="fadeOuts();" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </form>
            </div>
            <!--模态对话框结束-->
<script>
function fadeIns() {
    document.getElementById("formTable").className = 'modal';
}

function fadeOuts() {
    document.getElementById("formTable").className = 'modal hide';
}
</script>
<script type="text/javascript" src="common/js/timers.js"></script>
  <script type="text/javascript">

  $(function() {
	  $.get("notice/unread.jmy", function (data) {
	  	$("#unread").text(data.count);
	  	if(data.status==1) {
	  		$("#formTableBody").text(data.title);
	  		fadeIns();
	  	}
	  }, "json");
  })
$('body').everyTime('10s',function(){
  $.get("notice/unread.jmy", function (data) {
  	$("#unread").text(data.count);
  	if(data.status==1) {
  		$("#formTableBody").text(data.title);
  		fadeIns();
  	}
  }, "json");
});

 </script>