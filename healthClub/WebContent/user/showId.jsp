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

<script src="js/jquery-1.8.2.js"></script>
<script src="js/showId.js" type="text/javascript"></script>
</head>
<body>
	<div class="wrapper">
		<h1>
			<a href="homepage.jsp" id="logo">Health Club</a>
		</h1>
		<div class="content">
			<div id="form_wrapper" class="form_wrapper">
				<form class="showId active" id="bankCardForm" action="submitCardId" method="post" onsubmit="return checkForm()">
					<h3>Register Success!</h3>
					<h2>ID:${id}</h2>
					<div>
						<label>银行卡号:</label> 
						<input type="text" name="cardId" id="cardId"/>
						<span class="error"></span>
					</div>
					<div class="bottom">
						<input type="submit" value="现在激活"></input> 
						<a href='notActive' class="linkform">→暂时不激活→</a>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>