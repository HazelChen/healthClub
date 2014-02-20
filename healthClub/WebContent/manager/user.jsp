<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/user.css" rel="stylesheet" />
<link type="text/css" href="css/logo_small.css" rel="stylesheet" />
<link type="text/css" href="css/top.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/data.js"></script>
<script src="js/drilldown.js"></script>
<script src="js/exporting.js"></script>
<script src="js/chart.js"></script>

<title>user</title>
</head>
<body>
	<s:action name="user" executeResult="true"></s:action>
</body>
</html>