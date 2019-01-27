

### 数据验证(表单格式验证问题)


#### 需要导入的新的Jar包(这里使用hibernate=validator)



### 注意注意!! 踩坑多!! 这里的jar包版本一定要正确不然会报错

参考博客: `https://www.cnblogs.com/or2-/p/3519111.html`

```xml
<!--和 数据验证有关的java包-->
<!--版本太高-->
<!--<dependency>-->
    <!--<groupId>org.hibernate.validator</groupId>-->
    <!--<artifactId>hibernate-validator</artifactId>-->
    <!--<version>6.0.11.Final</version>-->
<!--</dependency>-->

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>4.3.1.Final</version>
</dependency>
<dependency>
    <groupId>org.jboss.logging</groupId>
    <artifactId>jboss-logging</artifactId>
    <version>3.1.0.CR2</version>
</dependency>
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>1.0.0.GA</version>
</dependency>
```

### 相关核心代码


```java
public class Student {
	
	@NotNull(message="姓名不能为空")
	@Size(min=3, max=6, message="姓名长度应在{min}-{max}个字符")
	private String name;
	
	@Min(value=0, message="成绩不能小于{value}")
	@Max(value=100, message="成绩不能大于{value}")
	@NotNull(message = "成绩不能为空")
	private double score;
	
	
	@NotNull(message="电话不能为空")
	@Pattern(regexp="^1[34578]\\d{9}$", message="手机号格式不正确") // 手机号码的正则表达式
	private String mobile;
}
```

`Controller`

```java
@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/register.do")
	public ModelAndView doRegister(@Validated Student student, BindingResult br) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", student);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");

		int errorCount = br.getErrorCount();  // 获取到
		if(errorCount > 0) {
			FieldError nameError = br.getFieldError("name");
			FieldError scoreError = br.getFieldError("score");
			FieldError mobileError = br.getFieldError("mobile");
			
			if (nameError != null) {
				String nameErrorMSG = nameError.getDefaultMessage();
				mv.addObject("nameErrorMSG", nameErrorMSG);
			}
			if (scoreError != null) {
				String scoreErrorMSG = scoreError.getDefaultMessage();
				mv.addObject("scoreErrorMSG", scoreErrorMSG);
			}
			if (mobileError != null) {
				String mobileErrorMSG = mobileError.getDefaultMessage();
				mv.addObject("mobileErrorMSG", mobileErrorMSG);
			}
			mv.setViewName("/index.jsp");
		}
		return mv;
	}
}
```

xml配置
```xml
<!-- 注册组件扫描器 -->
<context:component-scan base-package="com.zxin.handlers"/>

<!-- 生成验证器 -->
<bean id="myValidator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
    <property name="providerClass" value="org.hibernate.validator.HibernateValidator"/>
</bean>

<!-- 注册mvc注解驱动, 将数据验证器 给到mvc注解驱动-->
<mvc:annotation-driven validator="myValidator"/>
```