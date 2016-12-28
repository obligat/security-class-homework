<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><%@ include file="head.txt"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body bgcolor=pink onload="document.forms.login.logname.focus()">
	<form name="login" action="helpLogin" method="post">
		<h3>请您登录</h3>
		<ul>
			<li><label>登录名称:</label> <input type=text name="logname" />
			</li>
			<li><label>输入密码:</label> <input type=password name="password">
			</li>
		</ul>
		<input class="btn" type=submit name="g" value="提交">
	</form>
</body>
</html>


