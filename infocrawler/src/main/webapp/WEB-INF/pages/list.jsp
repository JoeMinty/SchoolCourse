\<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/bootstrap-3.3.6/css/bootstrap.min.css" />
    <script type="application/javascript" src="/static/jquery-1.12.3.min.js"></script>
    <script type="application/javascript" src="/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        $(function () {

            // 文档就绪
            $("#selectTime").val("${time}");
            $("#selectResource").val("${resource}");
            $("#keyword").val("${keyword}");


            $("#selectTime").change(function () {
                $("#queryForm").submit();
                //alert($("#select").val());
            });
            $("#selectResource").change(function () {
                $("#queryForm").submit();
                //alert($("#select").val());
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <form id="queryForm" action="/item/list" method="get">
            <label>爬取时间（yyyy-mm-dd-HH）</label>
            <select id="selectTime" name="time">
                <option value="">请选择</option>
                <c:forEach var="t" items="${times }">
                    <option value="${t }">${t }</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>爬取来源</label>
            <select id="selectResource" name="resource">
                <option value="">请选择</option>
                <c:forEach var="r" items="${resources }">
                    <option value="${r }">${r }</option>
                </c:forEach>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="keyword" type="text" name="keyword"/>
            <input type="submit"/>
        </form>

    </tr>
    <tr>
        <td>ID</td>
        <td>Title</td>
        <td>Resource</td>
        <td>URL</td>
        <td>Time</td>
    </tr>
    <c:forEach var="item" items="${itemList }">
        <tr>
            <td>${item.id }</td>
            <td>${item.title }</td>
            <td>${item.resource }</td>
            <td><a target="_blank" href="${item.url}">${item.url}</a></td>
            <td>${item.time}</td>
            <td><a target="_blank" href="detail/${item.id }">查看</a></td>
        </tr>
    </c:forEach>

</table>
<a href="list?curPage=1&keyword=${keyword }&time=${time }&resource=${resource }">首页</a>
<a href="list?curPage=${page.currentPage-1 }&keyword=${keyword }&time=${time }&resource=${resource }">上一页</a>
<a href="list?curPage=${page.currentPage+1 }&keyword=${keyword }&time=${time }&resource=${resource }">下一页</a>
<a href="list?curPage=${page.totalPage }&keyword=${keyword }&time=${time }&resource=${resource }">尾页</a>
第${page.currentPage}页/共${page.totalPage }页
<br />
<a href="list?curPage=1">listall</a> <br/>


<form action="/item/export" method="post">
    <input type="hidden" value="${keyword }" name="exportKeyword" />
    <input type="hidden" value="${time }" name="exportTime">
    <input type="hidden" value="${resource }" name="exportResource">
    <input type="submit" value="export"/>
</form>
</body>
</html>