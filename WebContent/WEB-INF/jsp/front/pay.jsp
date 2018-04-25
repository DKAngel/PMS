<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>缴纳物业费</title>
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<script>
	setTimeout(function(){
		var timeOut = '${timeError}'
		if(timeOut != ''){
			alert(timeOut);
		}
	}, 50)
</script>
<body>

   <div class="container">
    <div class="row">
     <div class="col-md-4 col-md-offset-4">
      <div class="login-panel panel panel-default">
       <div class="panel-heading">
           <h3 class="panel-title">缴纳物业费</h3>
       </div>
       <div class="panel-body">
           <form role="form" action="${pageContext.request.contextPath}/frontPay/surePay" method="post" >
               <fieldset>
               
                   <div class="form-group">
	                   <font size = 3>
	                   		房号：${ roomId }
	                   </font>
                   </div>
                   
                   <div class="form-group">
	                   <font size = 3>
	                   		单元房大小：${ roomSize } ㎡
	                   </font>
                   </div>
                   
                   <div class="form-group">
	                   <font size = 3>
	                   		物业费：${ cost } ￥ / 月
	                   </font>
                   </div>
                   
                   <font size = 3>
                       <a href="${pageContext.request.contextPath}/frontLogin/loginOut" style="float:right"> 注销 </a>
                       <a href="${pageContext.request.contextPath}/frontLogin/index" style="float:left"> 返回主页 </a>
                   </font>
                   <br><br>
                   <button type = "submit" class="btn btn-lg btn-success btn-block">确认支付</button>
               </fieldset>
           </form>
       </div>
      </div>
     </div>
    </div>
   </div>

    <!-- jQuery -->
    <script src="/pms/static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/pms/static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/pms/static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/pms/static/dist/js/sb-admin-2.js"></script>

</body>

</html>
