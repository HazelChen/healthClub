<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="edu.nju.healthClub.model.Activity"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="article" content="/technology/jquerytutorial/20120813-css-animation-timeline/" />
	<title>health club</title>
 
	<link rel="stylesheet" href="css/top.css" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="css/logo.css"/>
	<link type="text/css" href="css/calendar.css" rel="stylesheet" />
	<link rel="stylesheet" href="css/reco_style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/reco_animate.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
        
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="js/logo.js"></script>
	<script type="text/javascript" src="js/calendar.js"></script>
</head>
<body>
	<div id="top">
		<s:action name="userBar" executeResult="true"></s:action>
	</div>
    <div id="indexgs"> 
		<img id="indexg2" src="images/g3.png" width="180" height="285"/>
		<div id="indexg1">
			<img src="images/g2.png" width="273" height="300"/>
		</div>
		<div id="indexg0">
			<img src="images/g1.png" width="904" height="245"/>
		</div>
    </div>
		
	<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#014d67 SIZE=7 />
		
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
		
	<div>
		<s:action name="recommand" executeResult="true"></s:action>
	</div>
	
</body>
</html>