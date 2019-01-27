package com.zxin.handlers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/myAjax.do")
//	@ResponseBody // 将返回的数据放入到响应体中，这样才能接收到 Ajax的数据 但是这里不需要，因为我不是返回String，而是void
	// 有关博客: https://www.cnblogs.com/yanghaolie/p/9681148.html  & https://www.cnblogs.com/NieXiaoHui/p/5053997.html
	public void doAjax(String name, int age, HttpServletResponse response)throws IOException{

		System.out.println("this it controller! ");

		HashMap<String,Object> map = new HashMap<>();

		map.put("pname", name);
		map.put("page", age);

		Gson gson = new Gson();
		response.getWriter().print(gson.toJson(map));
	}
}


















