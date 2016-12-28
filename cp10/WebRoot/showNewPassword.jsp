<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.Password"%>
<jsp:useBean id="password" type="mybean.data.Password" scope="request" />
<html>
<head><%@ include file="head.txt"%></head>
<body bgcolor=yellow>
<center>
	<jsp:getProperty name="password" property="backNews" />
	<br>您的新密码：<jsp:getProperty name="password" property="newPassword" />
	<br>您的旧密码：<jsp:getProperty name="password" property="oldPassword" />
</center>
</body>
</html>
