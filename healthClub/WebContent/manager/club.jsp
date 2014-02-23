<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>
	
		<link type="text/css" href="css/user.css" rel="stylesheet" />
		<link type="text/css" href="css/logo_small.css" rel="stylesheet" />
		<link type="text/css" href="css/club.css" rel="stylesheet" />

		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		<script src="js/highcharts.js"></script>
		<script src="js/exporting.js"></script>
		<script src="js/clubChart.js"></script>
	</head>
	<body>
		<s:action name="club" executeResult="true"></s:action>
	</body>
</html>
