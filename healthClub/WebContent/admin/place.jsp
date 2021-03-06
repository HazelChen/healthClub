<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/place.css" />
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link rel="stylesheet" type="text/css" href="css/top.css" />

<title>place</title>
</head>
<body>
	<h1>
		<a href="../user/homepage.jsp" id="logo">Health Club</a>
	</h1>
	<a href="activity.jsp" class="navigation">活动管理</a>
	<a href='<s:url action="place" />' class="navigation">场次信息</a>
	<div id="top"><div id="top_profile">
		<form action="userPage" method="get">
			<input type="text" name="userId" class="top-input" placeholder="请输入用户ID" />
		</form>
	</div></div>
	
	<div class="main">
		<div class="content">
    		<table>
    			<thread>
    				<tr class="bl">
    					<td class="activity-place">场地</td>
    					<td class="activity-title">活动</td>
    					<td class="activity-date">活动时间</td>
    				</tr>
    			</thread>
    			<tbody>
    				<s:iterator value="activities" status="st">
    					<tr class="bl">
    						<td class="activity-place"><s:property value="place"/></td>
    						<td class="activity-title"><a href="activity.jsp?id=<s:property value="id"/>"><s:property value="title"/></a></td>
    						<td class="activity-date"><s:date name="date" format="yyyy-MM-dd" /></td>
    					</tr>
    				</s:iterator>
    			</tbody>
    		</table>
    	</div>
	</div>
</body>
</html>