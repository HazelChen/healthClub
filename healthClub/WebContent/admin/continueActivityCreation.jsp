<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="edu.nju.healthClub.model.Activity"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>register</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link rel="stylesheet" type="text/css" href="css/top.css" />
</head>
<body>
	<div class="wrapper">
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
		
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="showId active" id="bankCardForm" action="createActivity.jsp" method="post" onsubmit="return checkForm()">
					<h3>Continue?</h3>
					<h2>继续添加？</h2>
					<div class="bottom">
						<input type="submit" value="是"></input> 
						<a href="activity.jsp" class="linkform">--添加完成--</a>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>