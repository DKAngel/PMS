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
    <li>缴费管理</li>
    <li><a href="${pageContext.request.contextPath}/adminMain/payCurrentSituation">房间缴费信息查询</a></li>
    <li>单元房详情</li>
    </ul>
    </div>

	<div class="panel ">
        <div class="panel-heading">
        	<h4>房间号：${ room.roomId }</h4>
        	<h4>房间大小：${ room.roomSize }</h4>
        	<h4>缴费情况：${ room.roomPay }</h4>
        	<h4>业主邮箱：${ room.owner.ownersEmail }</h4>
        	<h4>业主姓名：${ room.owner.ownersName }</h4>
        	<h4>业主电话：${ room.owner.ownersPhone }</h4>
        	<h4>缴费时间：<fmt:formatDate value = "${room.pay.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
        	<h4>缴费金额：${ room.pay.payPrice }</h4>
        	
        	<h4>到期时间：<fmt:formatDate value = "${ deadLine }" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
        	<span style="font:400 19px NSimsun;color:#F00;">${payError}${ days }</span>
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