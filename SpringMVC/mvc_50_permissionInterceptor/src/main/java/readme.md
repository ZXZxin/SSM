### 权限拦截器的使用



#### 测试


* (1):一开始直接访问 `http://localhost:9091/mvc_50_permissionInterceptor/zxin/system.do`失败(fail page)，
因为没有登录

* (2):这里提供一个login.jsp(假装登录) ，即先进入`http://localhost:9091/mvc_50_permissionInterceptor/login.jsp`

只要先在login.jsp，然后就可以访问 `system.do`了。
```html
<body>
 <%
    session.setAttribute("user", "zxzxin");
 %>
 登录成功
</body>
``` 

* (3)这里也提供一个登出(logout.jsp)


```html
<body>
 <%
    session.removeAttribute("user");
 %>
 成功退出
</body>
```
