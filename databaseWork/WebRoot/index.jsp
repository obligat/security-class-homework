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
</head>

<body>

	<form action="AddServlet" method="post">
		<ul>
			<li>学号：<input type="text" name="username" id="username" />
			</li>
			<li>密码：<input type="text" name="password" />
			</li>
			<li>公钥：<input type="text" name="publicKey" id="publicKey" />
			</li>
			<li><input type="button" value="getPublicKey" id="btn"
					onClick="getPublicKey();" />
			</li>
			<li>摘要算法：<input type="radio" name="digestAlgorithm" value="MD5"
					checked="checked" /> MD5 <input type="radio"
					name="digestAlgorithm" value="SHA" /> SHA</li>
			<li>非对称加密算法 ：<input type="radio" name="RSA" value="RSA"
					checked="checked" /> RSA</li>
			<li><input type="submit" value="add" /></li>
		</ul>

	</form>

	<a href="login.jsp">login</a>
</body>
</html>
