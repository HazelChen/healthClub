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
		<%String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<img src='<%=basePath %>images/activity\<s:property value="imageUrl"/>'/>
		<div class="info">
			<h4><a href="../admin/activity.jsp?id=<s:property value="id"/>"><s:property value="title"/></a></h4>
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
				<li>
					<label class="t">预定会员</label>
					<div class="ri-t">
						<s:iterator value="users" status="st">
						<a href="userPage?userId=<s:property value="id"/>"><s:property value="id"/></a>&nbsp;
						</s:iterator>
					</div>
				</li>
			</ul>
			<%String url = request.getRequestURL().toString();
			String queryUrl = request.getQueryString();
			session.setAttribute("prePage", url);
			session.setAttribute("queryUrl", queryUrl);%>
			<a href='changeActivity?id=<s:property value="id"/>' class="right_button">修改活动</a>
			<a class="right_button reserve">预定活动</a>
			
			<form action="adminReserve" method="get">
				<input type="submit" class="right_button hide" value="确定"/>
				<input type="text" name="userId" class="reserve-input hide" placeholder="请输入用户ID" />
				<input type="text" name="activityId" class="hide" value="<s:property value="id"/>"/>
			</form>
		</div>
	</div>
	</s:iterator>
</body>
</html>