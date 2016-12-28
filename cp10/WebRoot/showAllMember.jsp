<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.ShowByPage"%>
<jsp:useBean id="show" type="mybean.data.ShowByPage" scope="session" />
<html>
<head><%@ include file="head.txt"%></head>
<body bgcolor="pink">
	<center>
		<P>
			显示会员信息。 <BR>每页最多显示<jsp:getProperty name="show"
				property="pageSize" />条信息。 <BR>当前显示第<Font color=blue> <jsp:getProperty
					name="show" property="showPage" /> </Font>页,共有 <Font color=blue><jsp:getProperty
					name="show" property="pageAllCount" /> </Font>页。 <BR>当前显示的内容是：
		<table border=2>
			<tr>
				<th>会员名</th>
				<th>广告标题</th>
				<th>电话</th>
				<th>email</th>
				<th>广告词</th>
				<th>广告照片</th>
			</tr>
			<jsp:getProperty name="show" property="presentPageResult" />
		</table>
		<br>单击“前一页”或“后一页”按钮查看信息
		<table>
			<tr>
				<td><form action="helpshowmember" method=post>
						<input type=hidden name="showPage"
							value="<%=show.getShowPage() - 1%>"> <input class="btn" type=submit
							name="g" value="前一页">
					</form></td>
				<td><form action="helpShowMember" method=post>
						<input type=hidden name="showPage"
							value="<%=show.getShowPage() + 1%>"> <input class="btn" type=submit
							name="g" value="后一页">
					</form></td>
				<td>
					<form action="helpShowMember" method=post>
						输入页码：<input type=text name="showPage" size=5> <input class="btn"
							type=submit name="g" value="提交">
					</form></td>
			</tr>
		</table>
	</center>
</body>
</html>
