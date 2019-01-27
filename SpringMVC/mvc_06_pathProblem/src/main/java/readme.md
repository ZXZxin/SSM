

### 解决重复点击时相对路径发生变化的方法


* 第一种，写成以斜杠开头的，然后前面带上项目名称; 

```html

<a href="${pageContext.request.contextPath }/test/my.do">我是一个表单的提交按键</a>

```

* 第二种，加上basePath；


```html
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <base href="<%=basePath%>">

```
