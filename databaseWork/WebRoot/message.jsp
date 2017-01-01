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
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/useJS.js"></script>
</head>
<body>
	<h3>
		<a style="float:left;" class="btn" href="login.jsp">去登录</a> <a
			style="float:right;" class="btn" href="index.jsp">去注册</a>
	</h3>
	<%
		String username = (String) request.getSession().getAttribute(
				"username");
	%>
	<h3>
		welcome 【<span id="username"><%=username%></span>】
	</h3>
	<form action="AddEncrptMessage" method="post">
<h3>发送消息界面</h3>
		<ul>
			<li><label>输入对方的用户名：</label> <input type="text" name="othername"
					id="othername">
			</li>
			<li><input class="btn" style="width:150px;" type="button"
					value="获取对方的公钥" onClick="getOtherPubKey()" /><label id="pubKey"></label>
			</li>
			<li><label>请输入加密后的信息：</label> <textarea rows="5" cols="30"
					name="encryptMes"></textarea>
			</li>
		</ul>
		<input class="btn" type="submit" value="提交">
		<input class="btn" type="button" style="width:150px;" value="查看我的消息"
			onClick="lookMyMessage()" />
		<label id="myMessage" style="magin-right:100px;"></label>
	</form>


</body>
</html>