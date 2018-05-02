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
    <li><a href="${pageContext.request.contextPath}/adminMain/manageOwner">业主管理</a></li>
    </ul>
    </div>
    
	<div class="formbody">
	
    <div class="col-lg-12">
        <div class="panel panel-default">
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                        <tr>
                            <th>房间号</th>
                            <th>业主邮箱</th>
                            <th>业主姓名</th>
                            <th>业主性别</th>
                            <th>业主电话</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
				    <c:choose>
				        <c:when test="${not empty ownerList}">
				            <c:forEach items="${ownerList}" var="owner">  
				                <tr class="even gradeX">
				                    <td>${ owner.roomId}</td>
				                    <td>${ owner.ownersEmail }</td>
				                    <td>${ owner.ownersName }</td>
				                    <td>${ owner.ownersSex }</td>
				                    <th>${ owner.ownersPhone }</th>
				                    <td>
				                   	<a href="${pageContext.request.contextPath}/adminHandle/updateOwner/${owner.ownersId}" >
				                   		修改 /</a>
				                   	<a href="${pageContext.request.contextPath}/adminHandle/deleteOwner/${owner.ownersId}" >
				                   		删除</a>
				                    </td>
				                    
								</tr>
				           </c:forEach>
				       </c:when>
				       <c:otherwise>
				          <tr>
				              <td colspan="5">没有房间信息！</td>
				          </tr>
				       </c:otherwise>
				   </c:choose>
                   </tbody>
                </table>
            </div>
        </div>
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

    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>
</html>