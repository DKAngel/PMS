<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script  src="/pms/static/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style= "background-image:url(/pms/static/images/topbg.gif);background-repeat:repeat-x;">

    <div class="topleft">
    <a href="${pageContext.request.contextPath}/adminMain/main" target="_parent"><img src="/pms/static/images/logo.png" title="系统首页" /></a>
    </div>
        
    <div class="topright">    
    <ul>
    <li><span><img src="/pms/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/adminLogin/index" target="_parent">退出</a></li>
    </ul>

    <div class="user">
    <span>${sessionScope.user.getAdminName()}</span>
    <i>您好</i>
    </div>    
    
    </div>
</body>
</html>