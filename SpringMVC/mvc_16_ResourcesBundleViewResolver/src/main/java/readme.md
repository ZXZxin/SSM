


### 第四种视图解析器:  ResourcesBundleViewResolver

测试输入: `http://localhost:9091/mvc_16_ResourcesBundleViewResolver/my.do`


* 和`xmlViewResolver` 差不多，不同的是，这里用`properties`配置文件来替代 `xml`；

* 不过视图的配置稍微有点不同；


`properties`配置: 

```properties
taobao.(class)=org.springframework.web.servlet.view.RedirectView
taobao.url=http://www.taobao.com

jd.(class)=org.springframework.web.servlet.view.RedirectView
jd.url=http://www.jd.com

internalResource.(class)=org.springframework.web.servlet.view.JstlView
internalResource.url=/WEB-INF/jsp/welcome.jsp
```


xml中注册视图解析器: 


```xml
<!-- 注册视图解析器 -->
<bean class="org.springframework.web.servlet.view.ResourceBundleViewResolver">
    <property name="basename" value="myViews"/>
</bean>
```