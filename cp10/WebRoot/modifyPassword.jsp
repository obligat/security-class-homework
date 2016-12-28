<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=pink onLoad="document.forms.modifyPas.oldPassword.focus()">
	<form name="modifyPas" action="helpModifyPassword" Method="post">
		<h3>输入您的密码：</h3>
		<ul>
			<li><label>当前密码:</label> <input type=text name="oldPassword">
			</li>
			<li><label>新密码:</label> <input type=password name="newPassword">
			</li>
		</ul>
		<input class="btn" type=submit name="g" value="提交">
	</form>
</body>
</html>
