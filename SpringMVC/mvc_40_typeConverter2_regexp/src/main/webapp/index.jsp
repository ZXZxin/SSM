<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/zxin/register.do" method="POST">
    	年龄：<input type="text" name="age"/><br>
        <!--这里使用了birthday, 默认是 2016/9/24的形式，但是我需要2016-9-24所以需要类型转换器-->
    	生日：<input type="text" name="birthday"/><br>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>
