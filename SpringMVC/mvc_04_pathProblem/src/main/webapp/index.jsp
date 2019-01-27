<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
</head>

<body>
<!-- 这个请求是访问不到的 -->
<!--
    这个是前台路径：出现在jsp页面中的路径，就是前台路径
    前台路径的参照路径是：当前web服务器的根，就本例而言，当前web服务器的根是：  http://127.0.0.1:8080
    绝对路径 = 参照路径 + 相对路径
    这里提交的请求是以相对路径的方式提交的，将这个相对路径转变为绝对路径是：  http://127.0.0.1:8080/my.do
    也就是说，这里提交的请求是：   http://127.0.0.1:8080/my.do
 -->
<!-- <a href="/my.do">跳转到welcome页面</a> -->

<!--
    当前的访问路径是：  http://127.0.0.1:8080/mvc_04_pathProblem
    转变为绝对路径是：   http://127.0.0.1:8080/mvc_04_pathProblem/my.do
 -->
<!-- <a href="my.do">跳转到welcome页面</a> -->


<!-- <a href="/06-requestPath/my.do">跳转到welcome页面</a> -->
<a href="${pageContext.request.contextPath }/my.do">跳转到welcome页面</a>
</body>
</html>











