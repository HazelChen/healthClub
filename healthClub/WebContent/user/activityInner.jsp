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
			
			<s:if test="%{session.id in users.id}">
				<a href="cancelReserve?userId=<s:property value="session.id"/>&activityId=<s:property value="activityId"/>" class="right_button">取消预订</a>
			</s:if>
			<s:else>
				<a href='<s:url action="reserve"/>' class="right_button">立即预定</a>
			</s:else>
		</div>
		</div>
		</s:iterator>
</body>
</html>