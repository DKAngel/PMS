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
    <li><a href="${pageContext.request.contextPath}/adminMain/complain">维修管理</a></li>
    <li><a href="${pageContext.request.contextPath}/adminMain/complain">维修记录查询</a></li>
    <li>处理维修订单</li>
    </ul>
    </div>

	<div class="panel ">
        <div class="panel-heading">
        	<h4>报修业主：${ upkeepOwner.ownersName }</h4>
        	<h4>电话：${ upkeepOwner.ownersPhone }</h4>
        	<h4>房间：${ upkeepOwner.roomId }</h4>
           	<h4>维修类型：${ upkeep.upkeepType }</h4>
           	<h4>维修时间：<fmt:formatDate value = "${upkeep.upkeepTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
           	<h4>维修内容：</h4>
           	<h5>${ upkeep.upkeepContent }</h5>
        </div>
		<hr>
        <div class="panel-heading">
            <h4 style="text-align:left">处理人：${ adminName }</h4>
           	<h4 style="text-align:left">处理时间：<fmt:formatDate value = "${upkeep.upkeepHandleTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
           	
           	<h4>处理过程：</h4>
           	<form action="${pageContext.request.contextPath}/adminHandle/updateUpkeep/${upkeep.upkeepId}" method="post">
           		<textarea class="form-control" name="upkeepProcess" rows="3" >${ upkeep.upkeepProcess }</textarea>
           	<h4>处理结果：</h4>
           		<textarea class="form-control" name="upkeepResult" rows="3" >${ upkeep.upkeepResult }</textarea>
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