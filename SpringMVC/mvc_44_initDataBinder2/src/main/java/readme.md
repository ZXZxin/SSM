### 这个也是 数据初始化绑定


#### 这个项目和 `mvc_40_typeConverter2_regexp`实现的功能是一样的


#### 因为这里不好获取 原来的字符串`source`，所以要创建一个DataEditor

```java
public class MyDateEditor extends PropertiesEditor {

	@Override
	public void setAsText(String source) throws IllegalArgumentException {
		SimpleDateFormat sdf = getDateFormat(source);
		try {
			Date date = sdf.parse(source);
			setValue(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private SimpleDateFormat getDateFormat(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else {
			throw new TypeMismatchException("test2", Date.class); // 这里test2也是简单的不匹配
		}
		return sdf;
	}
	
}

```