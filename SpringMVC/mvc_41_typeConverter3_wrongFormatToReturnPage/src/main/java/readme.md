### 这个程序解决的问题是 当你填错信息时，会返回到index.jsp页面


##### (1)在Controller中添加TypeMismatchException的处理过程

```java
//发生 TypeMismatchException的时候就　返回到index.jsp
@ExceptionHandler(TypeMismatchException.class)
public ModelAndView exceptionResolver(Exception ex) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/index.jsp");
    return mv;
}
```

##### (2)更新DataConverter处理器 (添加else 的处理)

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
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else {  //日期不匹配就抛出这个异常
			// 如果第一个参数和第二个参数不匹配就抛出TypeMismatchException
			throw new TypeMismatchException("", Date.class);
		}
		return sdf;
	}

}
```