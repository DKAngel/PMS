<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>活动记录</title>
    
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/pms/static/vendor/morrisjs/morris.css" rel="stylesheet">
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/pms/static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="/pms/static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

</head>
<body>
    <div id="wrapper">
    
	<!-- top -->
	
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/frontLogin/index">PMS物业管理系统</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                       
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="${pageContext.request.contextPath}/frontSetAccount/index"><i class="fa fa-user fa-fw"></i>账号设置</a>
                        </li>
                        <li>
                        	<a href="${pageContext.request.contextPath}/frontSetInfo/index"><i class="fa fa-gear fa-fw"></i>资料设置</a>
                        </li>
                        
                        <li class="divider"></li>
                        <li>
                        	<a href="${pageContext.request.contextPath}/frontLogin/loginOut"><i class="fa fa-sign-out fa-fw"></i>注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
	
	<!-- top -->            
            
    <!-- left -->    
    
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/showNotice"><i class="fa fa-bullhorn"></i> 公告查询 </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/complain"><i class="fa fa-phone"></i> 投诉直通车 </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/suggest"><i class="fa  fa-lightbulb-o"></i> 提出建议 </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/upkeep"><i class="fa fa-wrench"></i> 提交报修订单</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/chat"><i class="fa fa-comments"></i> 聊天室</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/frontIndex/activity"><i class="fa fa-smile-o"></i> 发起活动</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dollar"></i> 缴纳物业费<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/payByWeiChat">微信</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/payByAlipay">支付宝</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/payByBankCard">银行卡</a>
                                </li>
                            </ul>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-user"></i> 个人中心<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfComplain">投诉记录</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfSuggest">建议记录</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfPay">缴费记录</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfUpkeep">报修记录</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfActivity">活动记录</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontIndex/recordOfChat">聊天记录</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-gear"></i> 个人信息设置<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontSetAccount/index">账号设置</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/frontSetInfo/index">资料设置</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

<!-- left -->

<!-- right -->

		<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">活动记录</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>提交时间</th>
                                        <th>主题</th>
                                        <th>举行时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
							        <c:choose>
							            <c:when test="${not empty activityList}">
							                <c:forEach items="${activityList}" var="activity">  
							                    <tr class="even gradeX">
							                     	<td><fmt:formatDate value = "${activity.activityPtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							                        <td>
							                        	${activity.activityTheme}
							                        </td>
							                        <td><fmt:formatDate value = "${activity.activityHtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							                        <td>
								                        <c:if test="${activity.activityState == 0 }">
								                        	待审核
								                        </c:if>
								                        <c:if test="${activity.activityState == 1 }">
								                        	通过
								                        </c:if>
								                        <c:if test="${activity.activityState == 2 }">
								                        	不通过
								                        </c:if>
							                        </td>
							                        <td>
							                        	<a href="${pageContext.request.contextPath}/frontActivity/activityVerify/${activity.activityId}"  title = "查看活动详情"> 
							                        		查看 /
							                        	</a>
							                        	<a href="${pageContext.request.contextPath}/frontActivity/activityDelete/${activity.activityId}"  title = "点击删除活动"> 
							                        		删除
							                        	</a>
							                        </td>
												</tr>
							                </c:forEach>
							            </c:when>
							            <c:otherwise>
							               <tr>
							                   <td colspan="5">您没有发起过活动!</td>  
							               </tr>
							            </c:otherwise>
							        </c:choose>  
                                </tbody>
                            </table>
                        </div>
                    </div>
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
    
    <!-- 显示条数 -->
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
