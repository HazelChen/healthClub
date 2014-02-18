<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="s" uri="/struts-tags"%>

<body>
	<div id="top_profile" >
		<%String url = request.getRequestURL().toString();
		String queryUrl = request.getQueryString();
		session.setAttribute("prePage", url);
		session.setAttribute("queryUrl", queryUrl);%>
		
		<a href="userPage" class="top_href">
			<img id="avatar" src="images/spa.jpg" />
			<span id="name">Hazel Chen</span>
		</a>
		
		<a href='<s:url action="logout"/>' class="top_href">
			<span id="name">注销</span>
		</a>
	</div>
</body>