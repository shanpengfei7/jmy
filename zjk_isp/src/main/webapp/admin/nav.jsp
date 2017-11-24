<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<ul class="layui-nav" pc>
      <li class="layui-nav-item ">
        <a href="admin/leave.jmy">退出</a>
      </li>
      <!-- <li class="layui-nav-item layui-this">
        <a href="/demo/">示例</a>
      </li>
      <li class="layui-nav-item" pc>
        <a href="http://fly.layui.com/" target="_blank">社区</a>
      </li>
      <li class="layui-nav-item" pc>
        <a href="javascript:;">周边</a>      -->   
      </li>      
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
        <a href="admin/list.jmy">用户列表</a>
      </dd>
    </dl>
  </li>
  
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">接口管理</a>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="class/list.jmy">接口分类列表</a>
      </dd>      
    </dl>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="package/list.jmy">接口套餐列表</a>
      </dd>      
    </dl>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="faceapplay/adlist.jmy">接口申请列表</a>
      </dd>      
    </dl>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="faceinfo/adlist.jmy">接口信息列表</a>
      </dd>      
    </dl>
  </li>
  
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">通知消息</a>
    <dl class="layui-nav-child">
      <dd class="">
        <a href="notice/adlist.jmy">
          <i class="layui-icon" style="top: 3px;">&#xe63a;</i><cite>通知消息管理</cite>
        </a>
      </dd>  
    </dl>   
    <dl class="layui-nav-child"> 
      <dd class="">
        <a href="notice/noticereadlist.jmy">
          <i class="layui-icon" style="top: 3px;">&#xe63a;</i><cite>阅读通知</cite>
        </a>
      </dd>      
    </dl>
  </li>
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">分类缓存</a>
    <dl class="layui-nav-child">
      <dd>
        <a href="category/one.jmy">分类缓存</a>
      </dd>
    </dl>
  </li>
  <li class="layui-nav-item layui-nav-itemed">
    <a class="javascript:;" href="javascript:;">地区缓存</a>
    <dl class="layui-nav-child">
      <dd>
        <a href="area/sheng.jmy">地区缓存</a>
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
