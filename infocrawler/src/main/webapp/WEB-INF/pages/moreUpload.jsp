<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>多文件上传</title>
</head>
<body>
<div style="margin: 0 auto;margin-top:100px;">
	<form action="/infocrawler/moreUpload" method="post" enctype="multipart/form-data">
		<p>
		<span>文件:</span>
		<input id="title" name="filename1" type="file" />
		</p>
		<p>
		<span>文件:</span>
		<input id="title" name="filename2" type="file" />
		</p>
		<p>
		<input type="submit" value="提交">
		</p>
	</form>
</div>
</body>
</html>
