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
    <title>主页</title>
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/pms/static/vendor/morrisjs/morris.css" rel="stylesheet">
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                    <h1 class="page-header">Welcome to use PMS</h1>
                </div>
            </div>
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-star fa-fw"></i> 功能介绍	
                </div>
                
                <div class="panel-body">
	                <ul class="timeline">
	                    <li>
	                        <div class="timeline-badge info"><i class="fa fa-child"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">发起活动</h4>
	                                <p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">来一场说走就走的活动</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	                                	由发起人发起活动，刚发起的活动需要管理员审核，通过才算发起成功，只要活动内容符合规定都能通过，待活动通过后其他业主可以选择参加活动，参加活动不仅可以增进邻里的感情，还能培养孩子们的沟通交友能力</p>
	                            </div>
	                        </div>
	                    </li>
	                    <li class="timeline-inverted">
	                        <div class="timeline-badge warning"><i class="fa fa-comments"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">聊天室</h4>
	                                <p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">邻里群聊增进感情</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                	 类似于QQ群的功能，业主们可以在这个模块相互沟通、交流。随着社会大的发展，越来越多的人们住进了智能小区，可以说生活质量得到了极大的提升。但是，收获方便舒适的生活的同时，人们好像又失去了什么，所谓的邻居真的就只是邻居了，可以发现小区房阻碍了邻居与邻居之间的交流</p>
	                            </div>
	                        </div>
	                    </li>
	                    <li>
	                        <div class="timeline-badge danger"><i class="fa fa-bomb"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">投诉</h4>
	                            	<p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">您的烦恼就是我们的烦恼</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                	 是否对现在的服务不满意？您的满意是我们最大的收获，所以大胆放心的投诉吧，我们将全心全意为您们服务！请务必填写清楚投诉内容，方便我们及时正确的处理</p>
	                            </div>
	                        </div>
	                    </li>
	                    <li class="timeline-inverted">
	                    	<div class="timeline-badge success"><i class="fa fa-heart"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">建议</h4>
	                            	<p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">真诚的感谢您</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                	首先感谢您能提出您宝贵的建议，为了完善我们的体制，提高服务质量，您的建议至关重要，请填写清楚建议内容，方便我们及时正确的改正</p>
	                            </div>
	                        </div>
	                    </li>
	                    
	                    <li>
	                    	<div class="timeline-badge primary"><i class="fa fa-bullhorn"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">查看公告</h4>
	                            	<p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">重要的事情在这里</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                	公告是由管理员发布的，内容主要是小区重要通知，为了不错过重要、有用的消息，请及时查看公告模块</p>
	                            </div>
	                        </div>
	                    </li>
	                    <li class="timeline-inverted">
	                        <div class="timeline-badge"><i class="fa fa-user"></i>
	                        </div>
	                        <div class="timeline-panel">
	                            <div class="timeline-heading">
	                                <h4 class="timeline-title">个人中心</h4>
	                            	<p>
	                                	<small class="text-muted"><i class="fa fa-hand-o-right"></i>
	                                		<a href="#">历史记录都在这里</a>
	                                	</small>
	                                </p>
	                            </div>
	                            <div class="timeline-body">
	                                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                                	业主们可以在个人中心查询自己的操作记录，如：物业缴费记录、报修记录、投诉记录、建议记录等等</p>
	                            </div>
	                        </div>
	                    </li>
	                </ul>
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

</body>

</html>
