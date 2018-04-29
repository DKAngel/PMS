<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/pms/static/js/jquery.js"></script>
<script type="text/javascript" src="/pms/static/editor/kindeditor.js"></script>
	<link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/pms/static/vendor/morrisjs/morris.css" rel="stylesheet">
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/pms/static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="/pms/static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
	
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/adminMain/index">首页</a></li>
    <li>活动管理</li>
    <li><a href="${pageContext.request.contextPath}/adminMain/chat">待审核活动查询</a></li>
    <li>审核活动</li>
    </ul>
    </div>

	<div class="panel ">
        <div class="panel-heading">
        	<h4>发起人：${ activityOwner.ownersName }</h4>
        	<h4>电话：${ activityOwner.ownersPhone }</h4>
        	<h4>房间：${ activityOwner.roomId }</h4>
           	<h4>提交时间：<fmt:formatDate value = "${activity.activityPtime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
           	<h4>举行时间：<fmt:formatDate value = "${activity.activityHtime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
           	<h4>活动主题：${ activity.activityTheme }</h4>
           	<h4>活动内容：</h4>
           	<h5>${ activity.activityContent }</h5>
        </div>
        <hr>
        <div class="panel-heading">
           	<h4>审核内容：</h4>
           	<form action="${pageContext.request.contextPath}/adminHandle/updateActivity/${activity.activityId}" method="post">
           		<textarea class="form-control" name="verifyContent" rows="3" ></textarea>
           	<h4>是否通过审核：<input type="radio" name="verifyResult" value="是" checked="checked" />是&nbsp;&nbsp;&nbsp;<input type="radio" name="verifyResult" value="否" />否
           	</h4>
           		<div align="center">
	       			<button type="submit" class="loginbtn">提交</button>
	    		</div>
           	</form>
           	
        </div>
    </div>
    
    <script src="/pms/static/vendor/jquery/jquery.min.js"></script>
    <script src="/pms/static/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/pms/static/vendor/metisMenu/metisMenu.min.js"></script>
    <script src="/pms/static/vendor/raphael/raphael.min.js"></script>
    <script src="/pms/static/vendor/morrisjs/morris.min.js"></script>
    <script src="/pms/static/data/morris-data.js"></script>
    <script src="/pms/static/dist/js/sb-admin-2.js"></script>
    <script src="/pms/static/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/pms/static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/pms/static/vendor/datatables-responsive/dataTables.responsive.js"></script>
    
</body>
</html>