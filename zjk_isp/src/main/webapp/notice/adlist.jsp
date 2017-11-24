<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
 <title>通知消息列表</title>
 <input type="hidden" id="title" value="${title }">
 <form class="layui-form" action="notice/adlist.jmy" method="post">

  <div class="layui-form-item">
    <div class="layui-input-block">
    
     <label class="layui-form-label">标题</label>
      <div class="layui-input-inline">
        <input name="title" value="${title }" lay-verify="title" autocomplete="off" class="layui-input" type="text">
      </div>
      <div class="layui-form-item">
  </div>
      <label class="layui-form-label"></label>
      <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即查找</button>
		 <a href="notice/add.jsp" class="layui-btn">添加通知消息</a>
      </div>
      
    </div>
  </div>
 </form>
  <table width="100%" class="layui-table" lay-even="" lay-skin="row">
         <tr>
             <th>序号</th>
             <th>标题</th>
             <th>操作</th>
         </tr>
<c:forEach items="${data.rows }" var="d" varStatus="s">
<tr class="table_tr">
	<td>${s.index+1 }</td>
	<td>${d.title }</td>
	<td>
		<a href="notice/adshow.jmy?o=c&id=${d.id }" class="layui-btn layui-btn-mini">查看</a>
		<a href="notice/adshow.jmy?o=x&id=${d.id }" class="layui-btn layui-btn-mini">修改</a>
	</td>
        	</tr>
</c:forEach>
     </table>
     <div id="pagedata"></div>
     <input type="hidden" value="${data.count }" id="datacount">
     <input type="hidden" value="${param.page }" id="page">
     <script>
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  laypage({
    cont: 'pagedata'
    ,pages: document.getElementById("datacount").value //总页数
    ,groups: 5 //连续显示分页数
    ,skin: '#1E9FFF'
    ,curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	    var page = location.search.match(/page=(\d+)/);
	    return page ? page[1] : 1;
	 }() 
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第 '+ obj.curr +' 页');
        location.href="notice/adlist.jmy?page=" +obj.curr
        + "&title=" + $("#title").val();
      }
    }
    ,skip: true
  });
  
});
</script>
  <%@ include file="../common/tail.jsp" %>