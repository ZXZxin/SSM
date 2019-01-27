<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function() {
			$("button").click(function() {
				$.ajax({
					url:"zxin/myAjax.do",
					success:function(data){
						alert(data.stu1.name + "  " + data.stu2.age);
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <button>提交Ajax请求</button>
  </body>
</html>
