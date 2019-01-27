package com.zxin.handlers.handlers;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller    
@RequestMapping("/zxin")
public class MyController {

	@RequestMapping("/upload.do")
	public String doFileUpload(MultipartFile img, HttpSession session) throws Exception {
		
		// String path = "d:/images";
		String path = session.getServletContext().getRealPath("/images");
		if (img.getSize() > 0) { // 当没有选择文件的时候还是直接返回success.jsp
			// 获取到上传文件的原始名称
			String fileName = img.getOriginalFilename();
			if (fileName.endsWith("jpg") || fileName.endsWith("png")) { // 限制上传的类型
				File file = new File(path, fileName);
				img.transferTo(file);
			}
		}
		return "/success.jsp";
	}

}


















