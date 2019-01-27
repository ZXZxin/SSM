<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/zxin/upload.do" method="POST" enctype="multipart/form-data">
    	文件：<input type="file" name="img"/><br>
    	<input type="submit" value="上传"/>
    </form>
  </body>
</html>
