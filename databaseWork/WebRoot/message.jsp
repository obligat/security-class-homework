<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/useJS.js"></script>
</head>
<body>

	<form action="AddEncrptMessage" method="post">
		input message:
		<input type="text" name="message" id="message">
		<br> send to this guy (his username) :
		<input type="text" name="username" id="username">
		<br>
		<input type="button" value="encryptMessage" id="btn"
			onClick="encrypt();" />
		<!-- 		<button onClick="encrypt();">encryptMessage</button> -->
		<br> encryptedMessage:
		<div id="show"></div>
		<textarea rows="5" cols="30" name="encryptMes"
			id="showEncrytedMessage"></textarea>
		<br>
		<input type="submit" name="submit" value="submit">
		<br>
	</form>

</body>
</html>