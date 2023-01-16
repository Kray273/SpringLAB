package anotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 1. 필요하지 않음 매개변수 선언
// 2. 리턴타입 고정
// 3. 1개 URL 처리 context:componet-scan 

//public class HelloController implements Controller { 어노테이션 적용으로 변경
@Controller
public class HelloController{
		
	//@Override 오버라이드 되는것 아님
	// public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	@RequestMapping("/hello")
	public ModelAndView a () {
	// 매서드 선언부를 자유롭게 수정가능
		
		//model 설정
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); //request.setAttribute()를 대신
		mv.setViewName("hello");
				
		// view 설정
		return mv; 
	}
	
	@RequestMapping("/hello2")
	public String b() {
	//매핑메소드 리턴타입 String, model없고, -jsp이동 자동
		return "hello2임"; // WEB_INF/views/?.jsp로 인식
	}
	
	@RequestMapping("/hello3")
	public void c() { //매핑메소드 리턴타입 String, model없고, -jsp이동 자동
		 // WEB_INF/views/url동일 hello3.jsp로 인식
	}
	
	
	
}
