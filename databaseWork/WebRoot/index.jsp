<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login page</title>
<script type="text/javascript" src="js/useJS.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<h3>
		<a style="float:left;" class="btn" href="login.jsp">去登录</a> <a
			style="float:right;" class="btn" href="message.jsp">去发消息</a>
	</h3>
	<form action="AddServlet" method="post">
	<h3>注册界面</h3>
		<ul>
			<li><label>学号：</label> <input type="text" name="username" />
			</li>
			<li><label>密码：</label> <input type="text" name="password" />
			</li>
			<li><label>公钥：</label> <input type="text" name="publicKey"
					placeholder="我的公钥" />
			</li>
			<li><label>摘要算法：</label> <input type="radio"
					name="digestAlgorithm" value="MD5" checked="checked" /> MD5 <input
					type="radio" name="digestAlgorithm" value="SHA" /> SHA</li>
			<li><label>非对称加密算法 ：</label> <input type="radio" name="RSA"
					value="RSA" checked="checked" /> RSA</li>
		</ul>
		<input class="btn" type="submit" value="注册" />
	</form>


</body>
</html>
