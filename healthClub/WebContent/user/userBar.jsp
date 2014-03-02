<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="s" uri="/struts-tags"%>

<body>
	<div id="top_profile" >
		<%String url = request.getRequestURL().toString();
		String queryUrl = request.getQueryString();
		session.setAttribute("prePage", url);
		session.setAttribute("queryUrl", queryUrl);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/user\\";
		%>
		
		<a href="userPage" class="top_href">
			<img id="avatar" src="<%=basePath %><s:property value="user.headerUrl" />" />
			<s:if test="user.username != null">
				<span id="name"><s:property value="user.username" /></span>
			</s:if>
			<s:else>
				<span id="name"><s:property value="user.id" /></span>
			</s:else>
		</a>
		
		<a href='<s:url action="logout"/>' class="top_href">
			<span id="name">注销</span>
		</a>
	</div>
</body>