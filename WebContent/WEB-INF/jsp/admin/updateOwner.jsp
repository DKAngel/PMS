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

<script>  
	function checkPhone(s){  
		var str = s;
		var reg = /^1\d{10}$/;
	    if (reg.test(str)==false){
		    alert("号码格式不正确");
	    }
	}  
</script>

<body>
    
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/adminMain/index">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/adminMain/manageOwner">业主管理</a></li>
    <li>修改业主信息</li>
    </ul>
    </div>
    
	<div class="formbody">
	
    	<div class="panel-body">
           <form action="${pageContext.request.contextPath}/adminHandle/submitUpdateOwner/${owner.ownersId}" method="post" >
               <fieldset>
               
               	   <!-- 姓名  -->
                   <div class="form-group">
				       <input class="form-control" value ="${owner.ownersName}" name="name" type="text">
                   </div>
                   
                   <!-- 性别  -->
                   <div class="form-group">
                   	   <select class="form-control" name="sex">
						   <option value="男">男</option>
						   <option value="女">女</option>
					   </select>
                   </div>
                   
                   <div class="form-group">
				       <input class="form-control" value="${owner.ownersPhone}"
				        name="phone" type="text" onchange="checkPhone(this.value)">
                   </div>
                   
                   <button id="btSetInfo" type = "submit" class="btn btn-lg btn-success btn-block">修改</button>
              	   
               </fieldset>
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

    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>
</html>