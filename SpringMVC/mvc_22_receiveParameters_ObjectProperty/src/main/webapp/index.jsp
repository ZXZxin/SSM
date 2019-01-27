<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/zxin/register.do" method="POST">
    	<!-- 整体接收时，要求表单参数名与对象属性名相同 -->
    	姓名：<input type="text" name="name"/><br>
    	年龄：<input type="text" name="age"/><br>
    	学校：<input type="text" name="school.sname"/><br>
    	校址：<input type="text" name="school.address"/><br>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>
