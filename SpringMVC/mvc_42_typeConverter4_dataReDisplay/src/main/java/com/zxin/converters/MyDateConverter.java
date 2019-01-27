package com.zxin.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

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
		} else {
			throw new TypeMismatchException("test", Date.class); //不同时就抛出异常，这里是随便填的一个不匹配的
		}
		return sdf;
	}

}
