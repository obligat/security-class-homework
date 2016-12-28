<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><%@ include file="head.txt"%></head>
<body bgcolor=cyan>

	<form action="helpShowMember" method="post" name="form">
		<h3>分页显示全体会员：</h3>
		<input type="hidden" value="1" name="showPage" size=5>
		<input class="btn" type="submit" value="显示" name="submit">
	</form>
	<form action="helpShowMember" method="get" name="form">
		<ul>
			<li><label>输入要查找的会员名：</label> <input type="text" name="logname"
					size=5>
			</li>
		</ul>
		<input class="btn" type="submit" value="显示" name="submit">
	</form>
</body>
</html>
