<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="../admin/nav.jsp" %>
 <title>通知消息列表</title>
  <table width="100%" class="layui-table" lay-even="" lay-skin="row">
         <tr>
             <th>序号</th>
             <th>用户姓名</th>
             <th>通知标题</th>
             <th>阅读时间</th>
         </tr>
<c:forEach items="${data.rows }" var="d" varStatus="s">
<tr class="table_tr">
	<td>${s.index+1 }</td>
	<td>${d.user }</td>
	<td>${d.noticeTitle }</td>
	<td>${d.createTimeStr }</td>
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
        location.href="notice/adlist.jmy?page=" +obj.curr;
      }
    }
    ,skip: true
  });
  
});
</script>
  <%@ include file="../common/tail.jsp" %>