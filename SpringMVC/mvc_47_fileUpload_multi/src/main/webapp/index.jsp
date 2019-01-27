<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/zxin/upload.do" method="POST" enctype="multipart/form-data">
    	文件1：<input type="file" name="imgs"/><br>
    	文件2：<input type="file" name="imgs"/><br>
    	文件3：<input type="file" name="imgs"/><br>
    	<input type="submit" value="上传"/>
    </form>
  </body>
</html>
