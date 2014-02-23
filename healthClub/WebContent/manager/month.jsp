<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<select name="month" class="navigation" onchange="this.form.submit()">
		<s:iterator value="monthSelections" status="st">
		<option value="<s:property value="month"/>" <s:if test="%{selected==true}">selected="selected"</s:if>><s:property value="month"/></option>
		</s:iterator>
	</select>
</body>
</html>