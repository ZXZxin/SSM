### 关于对象Student有一个属性也是对象(School也是一个类)的情况



测试: 

输入: 


 
```html
<form action="${pageContext.request.contextPath }/test/register.do" method="POST">
    <!-- 整体接收时，要求表单参数名与对象属性名相同 -->
    姓名：<input type="text" name="name"/><br>
    年龄：<input type="text" name="age"/><br>
    学校：<input type="text" name="school.sname"/><br>
    校址：<input type="text" name="school.address"/><br>
    <input type="submit" value="注册"/>
</form>
```