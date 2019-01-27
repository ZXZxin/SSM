package com.zxin.editors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

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
