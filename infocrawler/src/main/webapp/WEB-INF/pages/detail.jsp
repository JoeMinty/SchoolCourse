<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ITEM${item.id}</title>
    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
<h2>${item.title}</h2>

<div>
    <p>
        ${item.content}
    </p>

    <p>来源：${item.resource}</p>

    <p class="bootstrap-class">爬取时间：${item.time}</p>

    <p>链接：<a target="_blank" href="${item.url}">点击进入</a></p>
</div>

</body>
</html>