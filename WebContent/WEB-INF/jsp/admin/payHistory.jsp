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
    <li><a href="${pageContext.request.contextPath}/adminMain/payHistory">缴费记录查询</a></li>
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
                            <th>缴费时间</th>
                            <th>缴费金额</th>
                            <th>房间号</th>
                            <th>房间大小</th>
                            <th>缴费人</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
				    <c:choose>
				        <c:when test="${not empty payList}">
				            <c:forEach items="${payList}" var="pay">  
				                <tr class="even gradeX">
				                	<td><fmt:formatDate value = "${ pay.payTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				                    <td>${ pay.payPrice }</td>
				                    <td>${ pay.room.roomId}</td>
				                    <td>${ pay.room.roomSize}</td>
				                    <td>${ pay.owner.ownersName }</td>
				                    <td>
				                   	<a href="${pageContext.request.contextPath}/adminHandle/handlePay/${pay.payId}" >
				                   		查看</a>
				                    </td>
								</tr>
				           </c:forEach>
				       </c:when>
				       <c:otherwise>
				          <tr>
				              <td colspan="6">没有缴费记录！</td>
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