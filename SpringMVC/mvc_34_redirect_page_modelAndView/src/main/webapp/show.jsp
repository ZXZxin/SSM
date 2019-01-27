<%--
  Created by IntelliJ IDEA.
  User: zxzxin
  Date: 23/01/19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    show page<br>
    <!--
        param.myStudent 的底层执行的是 request.getParameter("myStudent"); // 所以可以获取到
        requestScope.myStudent 的底层执行的是 request.getAttribute("myStudent");
    -->
    ModelAndView携带的数据<br>
    ${param.pname}<br>
    ${param.page}<br>

    HttpSession携带的数据<br>

    ${sessionScope.myStudent}<br>

</body>
</html>
