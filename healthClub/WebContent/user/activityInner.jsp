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
		<s:iterator value="activities" status="st">
		<div>
		<img src='<s:property value="imageUrl"/>'/>
		<div class="info">
			<h1><s:property value="title"/></h1>
			<ul>
				<li>
					<label class="t">时间</label>
					<div class="ri-t"><s:property value="date"/></div>
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
			session.setAttribute("queryUrl", queryUrl);
			boolean isScheduled = (Boolean)request.getAttribute("isScheduled");
			if(isScheduled) {
			%>
			<a href='<s:url action="reserve"/>' class="right_button">立即预定</a>
			<%}else {%>
			<a href="cancelReserve?userId=<s:property value="session.id"/>&activityId=<s:property value="activityId"/>">取消预订</a>
			<%}%>
		</div>
		</div>
		</s:iterator>
</body>
</html>