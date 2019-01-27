package com.zxin.handlers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	// 乱码问题解决深入: https://blog.csdn.net/qq_32361173/article/details/79364866
	@RequestMapping(value = "/myAjax.do", produces = "text/html;charset=utf-8") // 配置后面这个是为了防止乱码
	@ResponseBody   //  将返回的数据放入到响应体中
//	public String doAjax()  {
	public Object doAjax()  {
//		return 123.123; // 可以正常返回
		return "china中国"; // 返回不了，不知道为什么
	}
}


















