<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link type="text/css" href="css/calendar.css" rel="stylesheet" />
<link type="text/css" href="css/activity.css" rel="stylesheet" />
<link type="text/css" href="css/top.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/activity.js"></script>

<title>admin</title>
</head>
<body>
	<h1>
		<a href="../user/homepage.jsp" id="logo">Health Club</a>
	</h1>
	<a href="activity.jsp" class="navigation">活动管理</a>
	<a href='<s:url action="place" />' class="navigation">场次信息</a>
	<div id="top"><div id="top_profile">
		<form action="userPage" method="get">
			<input type="text" name="userId" class="top-input" placeholder="请输入用户ID" />
		</form>
	</div></div>
	
	<div>
		<div class="main-left">
			<div class="month-container">
				<div class="month-head"><span></span></div>
				<ul class="month-body">
					<div class="month-cell orange"><span>日</span></div>    
					<div class="month-cell blue"><span>一</span></div>
					<div class="month-cell blue"><span>二</span></div>
					<div class="month-cell blue"><span>三</span></div>
					<div class="month-cell blue"><span>四</span></div>     
					<div class="month-cell blue"><span>五</span></div>      
					<div class="month-cell blue"><span>六</span></div>
				</ul> 
				<div class="clear"></div>
			</div>
			<a href="createActivity.jsp" class="right_button margin-top">创建新活动</a>
		</div>
		
		<div class="main-right">
		<%String queryString = request.getQueryString();
		if (queryString == null) {%>
		<s:action name="activity" executeResult="true"></s:action>
		<%} else if (queryString.contains("year")){%>
		<s:action name="activityForDate" executeResult="true"></s:action>
		<%} else {%>
		<s:action name="activityForId" executeResult="true"></s:action>
		<% }%>
		</div>
	</div>
</body>
</html>