<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
</head>

<body>
<!--
    请求路径 = 访问路径 + 资源名称
    不带斜杠的相对路径，其参照路径是：  当前的访问路径

    绝对路径 = 参照路径 + 相对路径
    发出第一次请求时的访问路径是：  http://127.0.0.1:8080/mvc_05_pathProblem
    当前超链接所提交的相对路径转变为绝对路径是： http://127.0.0.1:8080/mvc_05_pathProblem/test/my.do
    发出第一次请求时的访问路径是： http://127.0.0.1:8080/mvc_05_pathProblem/test
    当前超链接所提交的相对路径转变为绝对路径是：http://127.0.0.1:8080/mvc_05_pathProblem/test/test/my.do
 -->
<a href="test/my.do">我是一个表单的提交按键</a>
</body>
</html>
