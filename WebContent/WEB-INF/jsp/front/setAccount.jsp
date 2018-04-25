<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>账号设置</title>
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script>  
        function checkLength(){  
            var pwd1 = document.getElementById("pwd1").value;  
            var spanLen = document.getElementById("spanLen");  
  
            if(pwd1.length <= 3 && pwd1.length > 0)  
                spanLen.innerHTML="密码强度：弱";  
            else if(pwd1.length <= 6)  
                spanLen.innerText="密码强度：中";  
            else  
                spanLen.innerText="密码强度：强";  
  
        }  
  
        function checkPSW(){
            var pwd1 = document.getElementById("pwd1").value;  
            var pwd2 = document.getElementById("pwd2").value;  
            var pswInfo = document.getElementById("pswInfo");  

            if(pwd1 != pwd2){
            	pswInfo.innerText="两次密码不同";   // alert("两次密码不同");
                document.getElementById("btregister").disabled = true;
            }
            else {
            	pswInfo.innerText="";
            	document.getElementById("btregister").disabled = false;
            } 
        }
        
        function getEmail(){
        	var email = document.getElementById("email").value; 
        	if(email != ''){
        		window.location.href = "${pageContext.request.contextPath}/frontSetAccount/setAccountCode?email="+email;
        	}else{
        		alert("邮箱不能为空");
        	}
        }
    </script> 
</head>
<body>

   <div class="container">
    <div class="row">
     <div class="col-md-4 col-md-offset-4">
      <div class="login-panel panel panel-default">
       <div class="panel-heading">
           <h3 class="panel-title">账号设置</h3>
       </div>
       <div class="panel-body">
           <form role="form" action = "${pageContext.request.contextPath}/frontSetAccount/handle" method="post" >
               <fieldset>
                   <div class="form-group">
		               <input class="form-control" placeholder="New:E-mail" value = "${requestScope.newEmail}" id="email" name="email" type="email" required autofocus>
		         	   <font size = 3>
                           <a href="javascript:void" style="float:center" onclick = "getEmail()">发送验证码</a>
                       </font>
                   </div>
                   
                   <div class="form-group">
				       <input class="form-control" placeholder="验证码" name="code" type="text" required >
                   </div>
                   
                   <div class="form-group">
                       <c:choose>  
				         <c:when test="${not empty newPassword}">
				             <input class="form-control" value = "${requestScope.newPassword}" id="pwd1" name="password" type="password" required onkeyup="checkLength()">
				         	 <span id="spanLen"></span>
				         </c:when>
				         <c:otherwise>
				             <input class="form-control" placeholder="密码" id="pwd1" name="password" type="password" required onkeyup="checkLength()">
				         	 <span id="spanLen"></span>
				         </c:otherwise>
				       </c:choose>
                   </div>
                   
                   <div class="form-group">
                       <input class="form-control" placeholder="确认密码" id="pwd2" name="password2" type="password" required onblur="checkPSW()">
                       <span id="pswInfo" style="color: #c41a15;"></span>
                   </div>
                   <font size = 3>
                       <a href="${pageContext.request.contextPath}/frontLogin/loginOut" style="float:right"> 注销 </a>
                       <a href="${pageContext.request.contextPath}/frontLogin/index" style="float:left"> 返回主页 </a>
                   </font>
                   <br><br>
                   <font size = 4 color = red> ${loginError} </font>
                   <button id="btSetAccount" type = "submit" class="btn btn-lg btn-success btn-block">修改</button>
              	   
               </fieldset>
           </form>
       </div>
      </div>
     </div>
    </div>
   </div>

    <script src="/pms/static/vendor/jquery/jquery.min.js"></script>
    <script src="/pms/static/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/pms/static/vendor/metisMenu/metisMenu.min.js"></script>
    <script src="/pms/static/dist/js/sb-admin-2.js"></script>
</body>

</html>
