<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><%@ include file="head.txt"%>
</head>
<body bgcolor=cyan onload="document.forms.form.logname.focus()">
	<form action="helpRegister" name=form method="post">
		<h3>输入您的信息，会员名字必须由字母和数字组成，带*号项必须填写。</h3>
		<ul>
			<li><label>会员名称:</label> <input type=text name="logname">&nbsp;*</li>
			<li><label>设置密码:</label> <input type=password name="password">&nbsp;*</li>
			<li><label>广告标题:</label> <input type=text name="advertiseTitle">
			</li>
			<li><label>电子邮件:</label> <input type=text name="email">
			</li>
			<li><label>联系电话:</label> <input type=text name="phone">
			</li>
			<li><label class="label-textarea">输入您的广告词:</label> <textarea
					name="message" rows="6" cols="30"></textarea>
			</li>
		</ul>
		<input class="btn" type=submit name="g" value="提交">

	</form>
</body>
</html>
