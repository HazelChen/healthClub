<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="edu.nju.healthClub.model.Activity"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>activity</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link rel="stylesheet" type="text/css" href="css/top.css" />

<script src="js/jquery-1.8.2.js"></script>
<script src="js/login_cufon-yui.js" type="text/javascript"></script>
<script src="js/login_ChunkFive_400.font.js" type="text/javascript"></script>
<script src="js/login.js" type="text/javascript"></script>
<script src="js/createActivity.js" type="text/javascript"></script>
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
	</div>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="register active" id="createActivity" action="createActivity" method="post" enctype="multipart/form-data">
					<h3>Activity</h3>
					<div class="column">
						<div>
							<label>标题:</label> 
							<input type="text" name="title" id="title" />
							<span class="error"></span>
						</div>
						<div>
    						<label>图片：</label>
    						<input name="imgFile" type="file" id="imgFile" /> 
    						<span class="error"></span>
    					</div>  
						<div>
							<label>场地:</label> 
							<input type="text" name="place" id="place" />
							<span class="error"></span>
						</div>
						<div>
							<label>教练:</label> 
							<input type="text" name="coach" id="coach" />
							<span class="error"></span>
						</div>
					</div>
					<div class="column">
						<div>
							<label>日期:</label> 
							<input type="text" name="date" id="date" onfocus="HS_setDate(this)" />
							<span class="error"></span>
						</div>
						<div>
							<label>描述:</label> 
							<textarea rows="11" cols="23" name="paragraph" id="paragraph"></textarea>
							<span class="error"></span>
						</div>
					</div>
					<div class="bottom">
						<input type="submit" value="完成" onclick="checkForm()"></input> 
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>