<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
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
			<a href="homepage.jsp" id="logo">Health Club</a>
		</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="register" id="register" action="register" method="post">
						<h3>Register</h3>
						<div class="column">
					<div>
						<label>Email:</label> 
						<input type="text" id="email" name="email"/> 
						<span class="error"></span>
					</div>
					<div>
						<label>密码:</label> 
						<input type="password" id="rg_password" name="password"/>
						<span class="error"></span>
					</div>
					<div>
						<label>确认密码:</label> 
						<input type="password" id="confirmPassword"/>
						<span class="error"></span>
					</div>
				</div>
				<div class="column">
					<div id="typeDiv">
						<label>类型:</label>
						<br />
						<div id="radioDiv">
							&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
							<input type="radio" name="type" id="personal" value="person" />个人
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<input id="family" type="radio" name="type" value="family" />家庭
							<span class="error"></span>
						</div>
					</div>
						<div id="childCountDiv">
						<label>孩子（10~18岁）数量:</label> 
						<input type="text" id="childCount" name="childCount"/>
						<span class="error"></span>
					</div>
				</div>
						<div class="bottom">
							<input type="submit" value="注册" onclick="register_checkForm()"/>
							<a href="index.html" rel="login" class="linkform">已经有账号？点此登录！</a>
							<div class="clear"></div>
						</div>
					</form>

				<form id="login" class="login active" action="loginlogin" method="post">
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
						<a href="register.html" rel="register" class="linkform">没有账号？点此注册！</a>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>