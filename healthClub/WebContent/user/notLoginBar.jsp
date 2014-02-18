<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
	<div id="top_profile">
		<%String url = request.getRequestURL().toString();
		String queryUrl = request.getQueryString();
		session.setAttribute("prePage", url);
		session.setAttribute("queryUrl", queryUrl);%>
		
		<a href="login.jsp" class="top_href"> 
			<span id="name">登录</span>
		</a>
		<a href="register.html" class="top_href">
			<span id="name">注册</span>
		</a>
	</div>
</body>