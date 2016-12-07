<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/useJS.js"></script>
</head>
<body>

	<form action="">
		input message:
		<input type="text" name="message"><br>
		send to this guy (his username) :
		<input type="text" name="username">
		<br>
		<button onClick="encrypt()">encryptMessage</button>
		<br> encryptedMessage:
		<textarea rows="5" cols="30" value="showEncrytedMessage"></textarea>
		<br>
		<input type="button" name="submit" value="submit">
		<br>
	</form>

</body>
</html>