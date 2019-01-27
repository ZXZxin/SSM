<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/zxin/register.do" method="POST">
    	姓名：<input type="text" name="name"/>${nameErrorMSG }<br>
    	成绩：<input type="text" name="score"/>${scoreErrorMSG }<br>
    	电话：<input type="text" name="mobile"/>${mobileErrorMSG }<br>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>
