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
		<div class="span12">
			<h1><a href="../user/homepage.jsp" id="logo">Health Club</a></h1>
			<a href="user.jsp" class="navigation">会员统计</a>
			<a href='club.jsp' class="navigation">活动统计</a>
			<form action="clubWithMonth" method="get">
				<s:action name="month" executeResult="true"></s:action>
			</form>
			<p>本月俱乐部会员人数为为<s:property value="clubMemberStatistics.totalCount"/>人。</p>
			<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		</div>
	</div>	
	<div class="row">
		<div class="span6 decoration">
			<h3>场地使用情况</h3>
			<table>
    			<thread>
    				<tr>
    					<td>场地</td>
   						<td>本月使用次数</td>
   					</tr>
  				</thread>
   				<tbody>
   					<s:iterator value="placeColumns" status="st">
    				<tr>
    					<td class="activity-title"><s:property value="place"/></td>
    					<td class="activity-reserve-date"><s:property value="count"/></td>
    				</tr>
    				</s:iterator>
   				</tbody>
   			</table>
		</div>
		
		<div class="span6 decoration">
			<h3>教练活动情况</h3>
			<table>
    			<thread>
    				<tr>
    					<td>教练</td>
   						<td>活动次数</td>
   					</tr>
  				</thread>
   				<tbody>
   					<s:iterator value="coachColumns" status="st">
    				<tr class="bl">
    					<td class="activity-title"><s:property value="coach"/></td>
    					<td class="activity-reserve-date"><s:property value="count"/></td>
    				</tr>
    				</s:iterator>
   				</tbody>
   			</table>
		</div>
		<div class="hide" id="data">
			[<s:property value="clubMemberStatistics.dayCount"/>]
		</div>
	</div>
</body>
</html>