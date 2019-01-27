<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/zxin/register.do" method="post">
        姓名: <input type="text" name="name"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" name="注册"><br>
    </form>
</body>
</html>
