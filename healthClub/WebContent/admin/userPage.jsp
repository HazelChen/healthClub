<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="edu.nju.healthClub.model.User"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/top.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/logo_small.css" />
<link rel="stylesheet" type="text/css" href="css/userPage.css" />
<link href="css/userpage_test_base.css" rel="stylesheet" type="text/css" />
<link href="css/userpage_tabs.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.8.2.js"></script>
<script src="js/jquery.tabs.js"></script>
<script src="js/userPage.js"></script>
<title>user page</title>
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
	<%String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/user\\";
	%>
	<div class="main">
		<div class="info-left">
			<div class="portrait">
				<image class="portrait-img" src="<%=basePath %><s:property value="user.headerUrl"/>"></image>
			</div>
		</div>
		<div class="info-right">
			<div class="id">
				<h2 class="float-left"><s:property value="user.id"/></h2>
			</div>
			<div class="username">
				<h3><s:property value="user.username"/></h3>
			</div>
			<div class="username">
				<%User user = (User)request.getAttribute("user");
				boolean isActive = (user.getBank() != null);
				boolean isSuspend = user.getSuspendCount() > 0 ? true:false;
				if(isActive && !isSuspend){%>
				<h4>会员资格：已激活</h4>
				<% }else if (isActive){  %>
				<h4>会员资格：暂停</h4>
				<%} else {%>
				<h4>会员资格：未激活</h4>
				<%} %>
			</div>
		</div>
		
		<div id="content">
		<div id="tabs">
			<div class="tabs-title">
				<div class="tabs-lbg"></div>
				<ul class="tabs-list">
					<li class="tabs-option">
        				<span class="tabs-option-lbg"></span>
        				<span class="tabs-option-text">活动记录</span>
        				<span class="tabs-option-rbg"></span>
      				</li>
      				<li class="tabs-option">
        				<span class="tabs-option-lbg"></span>
        				<span class="tabs-option-text">缴费记录</span>
        				<span class="tabs-option-rbg"></span>
      				</li>
      				<li class="tabs-option">
        				<span class="tabs-option-lbg"></span>
        				<span class="tabs-option-text">个人信息</span>
        				<span class="tabs-option-rbg"></span>
      				</li>
      				<li class="tabs-option">
        				<span class="tabs-option-lbg"></span>
        				<span class="tabs-option-text">会员激活</span>
        				<span class="tabs-option-rbg"></span>
      				</li>
    			</ul>
    			<div class="tabs-rbg"></div>
    			<div class="clear"></div>
  			</div>
  			<div class="tabs-box">
    		<div class="fatbox">
    		<div class="tabs-content">
    			<h2>活动预定记录</h2>
    			<table>
    				<thread>
    					<tr class="bl">
    						<td class="activity-title">标题</td>
    						<td class="activity-reserve-date">预定时间</td>
    						<td class="activity-date">活动时间</td>
    						<td class="activity-date"></td>
    					</tr>
    				</thread>
    				<tbody>
    				<%String url = request.getRequestURL().toString();
    				url = url.substring(0, url.length() - 4);
					String queryUrl = request.getQueryString();
					session.setAttribute("prePage", url);
					session.setAttribute("queryUrl", queryUrl);%>
    				<s:iterator value="activityReserves" status="st">
    					<tr class="bl">
    						<td class="activity-title"><a href="activity.jsp?id=<s:property value="activity.id"/>"><s:property value="activity.title"/></a></td>
    						<td class="activity-reserve-date"><s:date name="date" format="yyyy-MM-dd" /></td>
    						<td class="activity-date"><s:date name="activity.date" format="yyyy-MM-dd" /></td>
    						<td class="activity-date"><a href="cancelReserve?userId=<s:property value="user.id"/>&activityId=<s:property value="activity.id"/>">取消预订</a></td>
    					</tr>
    					</s:iterator>
    				</tbody>
    			</table>
    		</div>
    		<div class="tabs-content">
    			<h2>缴费记录</h2>
    			<table>
    				<thread>
    					<tr class="bl">
    						<td class="activity-title">项目</td>
    						<td class="activity-reserve-date">金额</td>
    						<td class="activity-date">时间</td>
    					</tr>
    				</thread>
    				<tbody>
    					<s:iterator value="paymentRecords" status="st">
    					<tr class="bl">
    						<td class="activity-title"><s:property value="reason"/></td>
    						<td class="activity-reserve-date"><s:property value="count"/></td>
    						<td class="activity-date"><s:date name="date" format="yyyy-MM-dd" /></td>
    					</tr>
    					</s:iterator>
    				</tbody>
    			</table>
    		</div>
    		<div class="tabs-content">
    			<form onsubmit="return register_checkForm()"  action="change" method="post">
    				<div class="column">
    					<div class="formColumn">
    						<label>id:<s:property value="user.id"/></label>
    					</div>
    					<div class="formColumn">
    						<label>头像：</label>
    						<input name="imgfile" type="file" id="imgfile" /> 
    					</div>  
    					<div class="formColumn">
							<label>用户名:</label> 
							<input type="text" id="username" name="username" value="<s:property value="user.username"/>"/> 
							<span class="error"></span>
						</div>
    					<div  class="formColumn">
							<label>身份证号:</label> 
							<input type="text" id="email" name="email" value="<s:property value="user.email"/>"/> 
							<span class="error"></span>
						</div>
					</div>
					<div class="column">
						<div  class="formColumn">
							<label>密码:</label> 
							<input type="password" id="rg_password" name="password" value="<s:property value="user.password"/>"/>
							<span class="error"></span>
						</div>
						<div  class="formColumn">
							<label>确认密码:</label> 
							<input type="password" id="confirmPassword" value="<s:property value="user.password"/>"/>
							<span class="error"></span>
						</div>
						<div class="hide">
							<input type="text" name="id" value="<s:property value="user.id"/>" />
							<input type="text" name="type" value="<s:property value="user.type"/>" />
							<input type="text" name="headerUrl" value="<s:property value="user.headerUrl"/>" />
							<input type="text" name="bank" value="<s:property value="user.bank.id"/>" />
							<input type="text" name="newDate" value="<s:date name="user.newDate" format="yyyy-MM-dd"/>" />
							<input type="text" name="suspendDate" value="<s:date name="user.suspendDate" format="yyyy-MM-dd"/>" />
							<input type="text" name="stopDate" value="<s:date name="user.stopDate" format="yyyy-MM-dd"/>" />
						</div>
						<%String type = user.getType();
						if(type.equals("family")){%>
						<div id="childCountDiv" class="formColumn">
							<label>孩子（10~18岁）数量:</label> 
							<input type="text" id="childCount" name="childCount" value="<s:property value="user.childCount"/>"/>
							<span class="error"></span>
						</div><%} %>
						<div class="formColumn">
							<input type="submit" value="提交修改" />
						</div>
					</div>
    			</form>
    		</div>
    		<div class="tabs-content align-center">
    			<%if(isActive){ %>
    			<h1>该用户已成功激活！</h1>
    			<h2><a id="cancel" href="cancel?userId=<s:property value="user.id"/>">---取消激活---</a></h2>
    			<%} else { %>
    			<div id="activationDiv">
    			<form onsubmit="return cardIdFormCheck()"  action="submitCardId" method="post">
    				<div class="formColumn">
						<label>银行卡号:</label> 
						<input type="text" id="cardId" name="cardId"/> 
						<span class="error"></span>
					</div>
					<div class="hide">
						<input type="text" name="userId" value="<s:property value="user.id"/>"/>
					</div>
					<div class="formColumn">
						<input type="submit" value="激活" />
					</div>
    			</form>
    			<%} %>
    			</div>
    		</div>
    		<div class="clear"></div>
    	</div>
  		</div>
 <script type="text/javascript">
	$("#tabs").tabs({xScroll:true});
</script>	
	</div>
	</div>
	</div>
</body>
</html>