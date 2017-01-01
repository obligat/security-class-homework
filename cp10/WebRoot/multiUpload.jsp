<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ include file="head.txt"%>
<title>Insert title here</title>
</head>
<body>
	<form action="multiUpload" method="post" enctype="multipart/form-data">
		<ul>
			<li><label>文件1：</label> <input type="file" name="file1" value="" />
			</li>
			<li><label>文件2：</label> <input type="file" name="file1" value="" />
			</li>
			<li><label>文件3：</label> <input type="file" name="file1" value="" />
			</li>
		</ul>
		<input class="btn" type="submit" value="上传" name="upload">
	</form>
	<p id="backNews"></p>
	<!-- <div >
		<div>
			<img src="images/file1" />
		</div>
		<div>
			<img src="images/file1" />
		</div>
		<div>
			<img src="images/file1" />
		</div>
	</div> -->
</body>
</html>