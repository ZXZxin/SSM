package handlers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        // 其底层调用的是 request.setAttribute()方法
        mv.addObject("message", "Hello SpringMVC !");
        mv.setViewName("welcome"); //配置了视图解析器之后，直接写逻辑视图即可
        return mv;
    }
}
