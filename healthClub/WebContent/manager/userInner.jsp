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
			<form action="userWithMonth" method="get">
				<select name="month" class="navigation" onchange="this.form.submit()">
					<s:iterator value="monthSelections" status="st">
					<option value="<s:property value="month"/>" <s:if test="%{selected==true}">selected="selected"</s:if>><s:property value="month"/></option>
					</s:iterator>
				</select>
			</form>
			<p class="lead">这个月新增会员数为<s:property value="membershipStatistics.newCount"/>，暂停会员数为<s:property value="membershipStatistics.suspendCount"/>，停止会员数为<s:property value="membershipStatistics.stopCount"/>，净增长<s:property value="membershipStatistics.netGrowthCount"/>人。使用者中，年龄段<s:property value="memberAgeStatistics.bestAge"/>的人数最多，<s:property value="memberSexStatistics.bestSex"/>性使用者较多，而且大多居住在<s:property value="memberPlaceStatistics.bestPlace"/>。</p>
		</div>
		<div class="span6">
			<div id="member"></div>
			<pre id="tsv" style="display:none">Browser Version	Total Market Share
新增  <s:property value="membershipStatistics.newCount"/>	<s:property value="membershipStatistics.newPercent"/>%
暂停 <s:property value="membershipStatistics.suspendCount"/>	<s:property value="membershipStatistics.suspendPercent"/>%
停止 <s:property value="membershipStatistics.stopCount"/>	<s:property value="membershipStatistics.stopPercent"/>%
			</pre>
		</div>
	</div>
	<div class="row">
		<div class="span4">
			<div id="residence"></div>
				<pre id="residence-tsv" style="display:none">Browser Version	Total Market Share
<s:iterator value="memberPlaceStatistics.memberPlaceColumns" status="st">
<s:property value="place"/> <s:property value="count"/>	<s:property value="percent"/>%
</s:iterator>
				</pre>
		</div>
		<div class="span4">
			<div id="age"></div>
		</div>
		<div class="span4">
			<div id="sex"></div>
		</div>
		<div id="ageInfomation" class="hide" >
			 [['0~20岁',   <s:property value="memberAgeStatistics.percent0"/>],
			 ['20~40岁',   <s:property value="memberAgeStatistics.percent1"/>],
			 ['40~60岁',   <s:property value="memberAgeStatistics.percent2"/>],
			 ['60~80岁',   <s:property value="memberAgeStatistics.percent3"/>],
			 ['80岁以上',   <s:property value="memberAgeStatistics.percent4"/>]]
		</div>
		<div class="hide" id="sexInfomation">
			[<s:property value="memberSexStatistics.maleCount"/>,<s:property value="memberSexStatistics.femaleCount"/>]
		</div>
	</div>
</body>
</html>