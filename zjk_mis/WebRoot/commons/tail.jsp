<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- </div> -->
<!-- </div> -->
<style>
.footer{
	/* position: fixed !important; */
	bottom: 30px;
	_position: absolute;
	_top: expression_r(eval_r(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight));
    text-align: center;
    font-size: 12px;
}
</style>
<div class="footer" id="footer_footer">
 <p>Copyrights  &copy; 2016-2018 All Rights Reserved. 河北张家口医院 版权所有 如有转载或引用本站文章涉及版权问题，请与我们联系 <br/>
      医院地址:河北省张家口市纬一路A110号      邮编:760000      冀ICP备 05004666   E-Mail:w-mis@163.com </p>
</div>
<script type="text/javascript">
	$("#footer_footer").css("left", $(window).width()/2-270);
	if (document.documentElement.clientHeight >= document.documentElement.offsetHeight) {
		$("#footer_footer").css("position","fixed");
	}
</script>
</body>
</html>
