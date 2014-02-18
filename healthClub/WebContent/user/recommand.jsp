<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body> 
		<div id="timeline">
		<ul id="dates">
		<%int i = 0; %>
		<s:iterator value="recommandActivities" status="st">
			<%i++;%>
			<li><a href="#<%=i%>"><s:property value="date"/></a></li>
		</s:iterator>
		
		</ul>
		<ul id="issues">
		<%i = 0;%>
		<s:iterator value="recommandActivities" status="st">
			<li id="<%=i%>">
				<img width="256" height="256" src="<s:property value="imageUrl"/>"></img>
				<h1><a href="activity.jsp?id=<s:property value="id"/>"><s:property value="date"/></a></h1>
				<p><s:property value="paragraph"/></p>
			</li>
		</s:iterator>	
		</ul>
		<div id="grad_left"></div>
		<div id="grad_right"></div>
		<a href="#" id="next">+</a>
		<a href="#" id="prev">-</a>
	</div>
	
	<script src="js/jquery.timelinr-gbin1.js" type="text/javascript"></script>
	<script src="js/reco_cufon-yui.js" type="text/javascript"></script>
	<script src="js/reco_voxBOX_400.font.js" type="text/javascript"></script>	
	<script type="text/javascript" src="js/recommendation.js"></script>
	
</body>