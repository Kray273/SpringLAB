package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
		
	@Override 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//model 설정
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); //request.setAttribute()를 대신
		mv.setViewName("hello");
				
		// view 설정
		return mv; 
	}
	
}
