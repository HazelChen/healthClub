<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />

<script src="js/jquery-1.8.2.js"></script>
<script src="js/login_cufon-yui.js" type="text/javascript"></script>
<script src="js/login_ChunkFive_400.font.js" type="text/javascript"></script>
<script src="js/login.js" type="text/javascript"></script>
</head>
<body>
	<div class="wrapper">
		<h1>
			<a href="../user/homepage.jsp" id="logo">Health Club</a>
		</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form id="login" class="login active" action="managerLogin" method="post" namespace="/user">
					<h3>Login</h3>
					<%String failMsg = (String)session.getAttribute("fail");
					if (failMsg != null) {%>
					<span class="error">
						<%=failMsg%>				
					</span>
					<%} %>
					<div>
						<label>识别码:</label> 
						<input type="text" name="id" id="id"/>
						<span class="error"></span>
					</div>
					<div>
						<label>密码: </label> 
						<input id="password" name="password" type="password" />
						<span class="error"></span>
					</div>
					<div class="bottom">
						<input type="submit" value="登录" onclick="login_checkForm()"></input> 
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>