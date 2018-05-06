<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/pms/static/js/jquery.js"></script>
<script type="text/javascript" src="/pms/static/editor/kindeditor.js"></script>
    
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/pms/static/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<script>

$(function() {
    var data = [{
        label: "服务态度",
        data: <%= session.getAttribute("dataService")%>
    }, {
        label: "设备设施",
        data: <%= session.getAttribute("dataEquipment")%>
    }, {
        label: "收费标准",
        data: <%= session.getAttribute("dataCharge") %>
    },{
        label: "办事效率",
        data: <%= session.getAttribute("dataWork") %>
    },{
        label: "其他",
        data: <%= session.getAttribute("dataOther") %>
    }];

    var plotObj = $.plot($("#flot-pie-chart"), data, {
        series: {
            pie: {
                show: true
            }
        },
        grid: {
            hoverable: true
        },
        tooltip: true,
        tooltipOpts: {
            content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
            shifts: {
                x: 20,
                y: 0
            },
            defaultTheme: false
        }
    });

});
</script>

<body>
    
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/adminMain/index">首页</a></li>
    <li>统计分析</li>
    <li><a href="${pageContext.request.contextPath}/adminMain/analyOfComplain">线上投诉分析</a></li>
    </ul>
    </div>
    
	<div class="formbody">
		<div class="col-lg-12">
		<div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    	历史投诉类型饼状图
                </div>
                <div class="panel-body">
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-pie-chart"></div>
                    </div>
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

    <!-- Flot Charts JavaScript -->
    <script src="/pms/static/vendor/flot/excanvas.min.js"></script>
    <script src="/pms/static/vendor/flot/jquery.flot.js"></script>
    <script src="/pms/static/vendor/flot/jquery.flot.pie.js"></script>
    <script src="/pms/static/vendor/flot/jquery.flot.resize.js"></script>
    <script src="/pms/static/vendor/flot/jquery.flot.time.js"></script>
    <script src="/pms/static/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
    <script src="/pms/static/data/flot-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/pms/static/dist/js/sb-admin-2.js"></script>
    
</body>
</html>