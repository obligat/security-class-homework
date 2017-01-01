<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mybean.data.*"%>
<%-- <jsp:useBean id="upFile" class="mybean.data.UploadFile" scope="request" /> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="head.txt"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#f7f1e0">
	<div class="flex">
		<%
			List<UploadFile> list = (List<UploadFile>) request
					.getAttribute("upFiles");
			if (list != null) {
				for (UploadFile upFile : list) {
		%>
		<div class="flex-item">
			<ul>
				<li><%=upFile.getBackNews()%></li>
				<li>上传的文件名字：<%=upFile.getFileName()%></li>
				<li>保存后的名字：<%=upFile.getSavedFileName()%></li>
			</ul>
			<h3>图像效果：</h3>
			<img src="images/<%=upFile.getSavedFileName()%>" width="150"
				height="150" />
		</div>
		<%
			}
			}
		%>
	</div>
</body>
</html>