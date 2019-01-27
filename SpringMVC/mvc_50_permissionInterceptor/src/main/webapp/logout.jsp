<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>welcome page</title>
  </head>
  
  <body>
     <%
     	session.removeAttribute("user");
     %>
     成功退出
  </body>
</html>
