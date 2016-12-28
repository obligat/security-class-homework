<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<%@ page import="mybean.data.Register"%>
<jsp:useBean id="register" type="mybean.data.Register" scope="request" />
<html>
<body bgcolor=pink
	onload="document.forms.form.newadvertisetitle.focus()">

	<form action="helpModifyMess" name=form method="post">
		<h3>
			<font color=blue size=4> 以下是您(<jsp:getProperty name="register"
					property="logname" />)曾注册的信息， 您可以修改这些信息。 </font>

		</h3>
		<ul>
			<li><label>广告标题:</label> <input type=text
					name="newAdvertiseTitle"
					value=<jsp:getProperty name="register" property="advertiseTitle" />>
			</li>
			<li><label>联系电话:</label> <input type=text name="newPhone"
					value=<jsp:getProperty name="register" property="phone" />>
			</li>
			<li><label>电子邮件:</label> <input type=text name="newEmail"
					value=<jsp:getProperty name="register" property="email" />>
			</li>
			<li><label>广告词：</label> <textarea name="newMessage" rows="6"
					cols="30">
								<jsp:getProperty name="register" property="message" />
								</textarea>
			</li>
		</ul>
		<input class="btn" type=submit name="g" value="提交修改">
		<input class="btn" type=reset value="重置">
	</form>
</body>
</html>
