<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        </div>
      
        </div>
      </div>
      
      
      <div class="layui-tab-item">
<textarea class="layui-border-box site-demo-text site-demo-code" id="LAY_democode" spellcheck="false" readonly>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="//res.layui.com/layui/build/css/layui.css"  media="all">
</head>
</textarea>
      </div>
      
      
      <div class="layui-tab-item">
        <div class="layui-main">
          
<div style="margin: 15px 0;">
  <ins class="adsbygoogle"
  style="display:inline-block;width:970px;height:90px"
  data-ad-client="ca-pub-6111334333458862"
  data-ad-slot="6835627838"></ins>
</div>

          
          <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>相关</legend>
          </fieldset>
          <a class="layui-btn layui-btn-normal" href="/doc/element/nav.html" target="_blank">导航元素文档</a>
          <a class="layui-btn layui-btn-normal" href="/doc/modules/element.html" target="_blank">常用元素操作</a>
        </div>
      </div>
        
    </div>
  </div>
  <div class="layui-footer footer footer-demo">
  <div class="layui-main">
    <p>2017 &copy; <a href="/">zjk-net.com</a> ZJK jmy</p>
    <p>
      <a href="http://www.zjk-net.com" target="_blank">张家口</a>
      <a href="http://www.zjk-net.com" target="_blank">金蚂蚁</a>
      <!--<a href="javascript:layer.msg('暂无此页');">关于我们</a>-->
      <a href="http://www.zjk-net.com">科技</a>
      <a href="http://www.zjk-net.com" target="_blank">有限</a>
      <a href="http://www.zjk-net.com" target="_blank">公司</a>
    </p>
  </div>
<!--   <div class="layui-main">
    <p>2017 &copy; <a href="/">layui.com</a> MIT license</p>
    <p>
      <a href="http://fly.layui.com/case/2017/" target="_blank">案例</a>
      <a href="http://fly.layui.com/jie/3147.html" target="_blank">捐赠</a>
      <a href="javascript:layer.msg('暂无此页');">关于我们</a>
      <a href="mailto:xianxin@layui.com">联系</a>
      <a href="https://github.com/sentsin/layui/" target="_blank">Git仓库</a>
      <a href="http://fly.layui.com/jie/2461.html" target="_blank">微信公众号</a>
    </p>
  </div> -->
</div>
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<div class="site-tree-mobile layui-hide">
  <i class="layui-icon">&#xe602;</i>
</div>
<div class="site-mobile-shade"></div>
<script src="//res.layui.com/layui/build/layui.js?t=1488795362026" charset="utf-8"></script>
<script>
layui.config({
  base: '//res.layui.com/lay/modules/layui/'
  ,version: '1488795362026'
}).use('global');
 
window.global = {
  preview: function(){
    var preview = document.getElementById('LAY_preview');
    return preview ? preview.innerHTML : '';
  }()
};
</script>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>
</div>
<div id="LAY_democodejs">
<script>
layui.use('element', function(){
  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});
</script>
</div>
</body>
</html>