### 使用正则表达式解决需要多种日期格式的问题


##### 上一个项目的问题: 我们配置了 `2016-08-25`的格式，但是此时`20160825`的格式就不起作用了


##### 所以我们想同时配置满足可以输入 `2016-08-24  |  2016/08/24   | 20160824` 的日期格式


#### 使用正则表达式可以解决上面的问题


后台代码的更改: 

```java
// Converter接口中的两个泛型表示：
// 第一个：表示源的类型
// 第二个：表示宿的类型，即转换为的目标类型
public class MyDateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		SimpleDateFormat sdf = getDateFormat(source);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {   
			e.printStackTrace();
		}
		return null;
	}

	private SimpleDateFormat getDateFormat(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat();

		//　使用正则表达式　　解决需要同时满足可以输入 2016-08-24  |  2016/08/24   | 20160824  的问题
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} 
		return sdf;
	}

}
```