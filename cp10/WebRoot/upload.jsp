<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><%@ include file="head.txt"%></head>
<body bgcolor=yellow>

	<form action="helpUpload" method="post" ENCTYPE="multipart/form-data">
		<h3>
			<BR>文件将被上传到D:/j2ee-homework/cp10/WebRoot/Images中。 <BR>选择要上传的图像照片文件(名字不可以含有非ASCII码字符，比如汉字等)：
		</h3>
		<input style="margin-left: 150px;margin-bottom:50px;" type=file
			name="fileName" size="40">
		<input class="btn" type="submit" name="g" value="提交">
	</form>
</body>
</html>