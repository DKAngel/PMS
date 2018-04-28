<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="/pms/static/js/jquery.js"></script>

<script type="text/javascript">
$(function(){
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
    
    <dl class="leftmenu">
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>
    	<a href="${pageContext.request.contextPath}/adminMain/notice"  target="rightFrame">公告管理</a>
    </div>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>
    <a href="${pageContext.request.contextPath}/adminMain/complain"  target="rightFrame">投诉管理</a>
    </div>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>
    <a href="${pageContext.request.contextPath}/adminMain/suggest"  target="rightFrame">建议管理</a>
    </div>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>
    <a href="${pageContext.request.contextPath}/adminMain/upkeep"  target="rightFrame">报修管理</a>
    </div>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>
    <a href="${pageContext.request.contextPath}/adminMain/chat"  target="rightFrame">聊天管理</a>
    </div>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>活动管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath}/adminMain/activityVerify" target="rightFrame">活动审核</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/adminMain/activity" target="rightFrame">活动查询</a><i></i></li>
        </ul>
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico01.png" /></span>缴费管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
        </ul>    
    </dd>
        
    <dd>
    <div class="title">
    <span><img src="/pms/static/images/leftico02.png" /></span>统计分析
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
        </ul>     
    </dd> 
    
    </dl>
</body>
</html>
