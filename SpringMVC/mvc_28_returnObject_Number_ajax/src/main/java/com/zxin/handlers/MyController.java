package com.zxin.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
	@ResponseBody   // 这个是必须的，因为有返回值， 放到响应体，而不是看做视图: 将返回的数据放入到响应体中
	public Object doAjax()  {
		return 123.456;
	}
}


















