
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试ajax</title>
</head>
<body>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">

    $(function () {
        $("#myButton").click(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/zxin/myAjax.do",
                success: function (data) {
                    alert("success")
                    alert(data) // 这个是和上个项目不同的地方, 直接得到返回的值
                },
                dataType: "json"
            })
        })
    })

</script>

<button id="myButton">提交ajax请求</button>
</body>
</html>
