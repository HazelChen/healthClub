<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div class="row">
		<div class="span6">
			<h1><a href="../user/homepage.jsp" id="logo">Health Club</a></h1>
			<a href="user.jsp" class="navigation">会员统计</a>
			<a href='<s:url action="place" />' class="navigation">活动统计</a>
			<form action="" method="get">
				<select name="month" class="navigation" onchange="this.form.submit()";>
					<s:iterator value="months" status="st">
					<option value="<s:property value="place"/>"><s:property /></option>
					</s:iterator>
				</select>
			</form>
			<p class="lead">This project is an attempt to build re-usable charts and chart components for d3.js without taking away the power that d3.js gives you. This is a very young collection of components, with the goal of keeping these components very customizeable, staying away from your standard cookie cutter solutions.</p>
		</div>
		<div class="span6">
			<div id="member"></div>
<pre id="tsv" style="display:none">Browser Version	Total Market Share
Microsoft Internet Explorer 8.0	26.61%
Microsoft Internet Explorer 9.0	16.96%
Chrome 18.0	8.01%
Chrome 19.0	7.73%
Firefox 12	6.72%
Microsoft Internet Explorer 6.0	6.40%
Firefox 11	4.72%
Microsoft Internet Explorer 7.0	3.55%
Safari 5.1	3.53%
Firefox 13	2.16%
Firefox 3.6	1.87%
Opera 11.x	1.30%
Chrome 17.0	1.13%
Firefox 10	0.90%
Safari 5.0	0.85%
Firefox 9.0	0.65%
Firefox 8.0	0.55%
Firefox 4.0	0.50%
Chrome 16.0	0.45%
Firefox 3.0	0.36%
Firefox 3.5	0.36%
Firefox 6.0	0.32%
Firefox 5.0	0.31%
Firefox 7.0	0.29%
Proprietary or Undetectable	0.29%
Chrome 18.0 - Maxthon Edition	0.26%
Chrome 14.0	0.25%
Chrome 20.0	0.24%
Chrome 15.0	0.18%
Chrome 12.0	0.16%
Opera 12.x	0.15%
Safari 4.0	0.14%
Chrome 13.0	0.13%
Safari 4.1	0.12%
Chrome 11.0	0.10%
Firefox 14	0.10%
Firefox 2.0	0.09%
Chrome 10.0	0.09%
Opera 10.x	0.09%
Microsoft Internet Explorer 8.0 - Tencent Traveler Edition	0.09%</pre>
		</div>
	</div>
	<div class="row">
		<div class="span4">
			<div id="residence" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<pre id="tsv" style="display:none">Browser Version	Total Market Share
Microsoft Internet Explorer 8.0	26.61%
Microsoft Internet Explorer 9.0	16.96%
Chrome 18.0	8.01%
Chrome 19.0	7.73%
Firefox 12	6.72%
Microsoft Internet Explorer 6.0	6.40%
Firefox 11	4.72%
Microsoft Internet Explorer 7.0	3.55%
Safari 5.1	3.53%
Firefox 13	2.16%
Firefox 3.6	1.87%
Opera 11.x	1.30%
Chrome 17.0	1.13%
Firefox 10	0.90%
Safari 5.0	0.85%
Firefox 9.0	0.65%
Firefox 8.0	0.55%
Firefox 4.0	0.50%
Chrome 16.0	0.45%
Firefox 3.0	0.36%
Firefox 3.5	0.36%
Firefox 6.0	0.32%
Firefox 5.0	0.31%
Firefox 7.0	0.29%
Proprietary or Undetectable	0.29%
Chrome 18.0 - Maxthon Edition	0.26%
Chrome 14.0	0.25%
Chrome 20.0	0.24%
Chrome 15.0	0.18%
Chrome 12.0	0.16%
Opera 12.x	0.15%
Safari 4.0	0.14%
Chrome 13.0	0.13%
Safari 4.1	0.12%
Chrome 11.0	0.10%
Firefox 14	0.10%
Firefox 2.0	0.09%
Chrome 10.0	0.09%
Opera 10.x	0.09%
Microsoft Internet Explorer 8.0 - Tencent Traveler Edition	0.09%</pre>
		</div>
		<div class="span4">
			<div id="age"></div>
		</div>
		<div class="span4">
			<div id="sex"></div>
		</div>
	</div>
</body>
</html>