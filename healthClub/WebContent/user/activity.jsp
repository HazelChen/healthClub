<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="css/activity.css" type="text/css"/>
<link rel="stylesheet" href="css/top.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link type="text/css" href="css/calendar.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>

<title>activity</title>
</head>
<body>
	<h1>
		<a href="homepage.jsp" id="logo">Health Club</a>
	</h1>
	<div id="top">
		<s:action name="userBar" executeResult="true"></s:action>
	</div>
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
	<div class="main-right">
		<%String queryString = request.getQueryString();
		if (queryString.contains("id")) {%>
		<s:action name="activityForId" executeResult="true">
		</s:action>
		<%} else {%>
		<s:action name="activityForDate" executeResult="true">
		</s:action>
		<%} %>
	</div>
</body>
</html>