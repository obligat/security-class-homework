<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h3>
		<a style="float:left;" class="btn" href="index.jsp">去注册</a> <a
			style="float:right;" class="btn" href="message.jsp">去发消息</a>
	</h3>
	<form action="FindUserServlet" method="post">
	<h3>登录界面</h3>
		<ul>
			<li><label>学号：</label>
			<input type="text" name="username" /></li>
			<li><label>密码：</label>
			<input type="password" name="password" /></li>
		</ul>
		<input class="btn" type="submit" value="登录" />
	</form>

</body>
</html>