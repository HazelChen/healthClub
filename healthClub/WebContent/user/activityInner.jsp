<%@page import="java.util.Set"%>
<%@page import="edu.nju.healthClub.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/activity\\";
	%>
		<s:iterator value="activities" status="st">
		<div>
		<img src='<%=basePath %><s:property value="imageUrl"/>'/>
		<div class="info">
			<h1><s:property value="title"/></h1>
			<ul>
				<li>
					<label class="t">时间</label>
					<div class="ri-t"><s:date name="date" format="yyyy-MM-dd"/></div>
				</li>
				<li>
					<label class="t">场地</label>
					<div class="ri-t"><s:property value="place"/></div>
				</li>
				<li>
					<label class="t">教练</label>
					<div class="ri-t"><s:property value="coach"/></div>
				</li>
			</ul>
			<p><s:property value="paragraph"/></p>
			<%String url = request.getRequestURL().toString();
			String queryUrl = request.getQueryString();
			session.setAttribute("prePage", url);
			session.setAttribute("queryUrl", queryUrl);%>
			
			<%boolean isReserved = false; %>
			<s:iterator value="users" status="status" id="inner">
				<%if (!isReserved) {%>
					<s:if test='#session.userid==#inner.id'>
						<%isReserved = true;%>
					</s:if>
				<%} %>
			</s:iterator>
			
			<%if (isReserved) {%>
				<a href="cancelReserve?userId=<s:property value="session.userid"/>&activityId=<s:property value="id"/>" class="right_button">取消预订</a>
			<%} else { %>
				<a href='reserve?activityId=<s:property value="id"/>' class="right_button">立即预定</a>
			<%} %>
		</div>
		</div>
		</s:iterator>
		
		
</body>
</html>