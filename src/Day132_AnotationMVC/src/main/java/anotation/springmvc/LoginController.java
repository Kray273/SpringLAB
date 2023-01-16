package anotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	//@RequestMapping(value="/login", method= RequestMethod.GET)
	@GetMapping(value="/login") // 4.3버전 이상만 가능 
	public String loginform() {
		return "loginform";
	}
	
	// 기본적인 형태_HttpServletRequest
//	//@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@PostMapping(value="/login")
//	public ModelAndView loginprocess(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		// db로그인 정상 확인
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("loginresult",dto);
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
	
	//매개변수 수정1 @RequestParam
//	@PostMapping(value="/login")
//	public ModelAndView loginprocess(
//		@RequestParam(value = "id", required = false, defaultValue = "고정고정") String id2, String pw) { 
	
//		//전달하는 파라미터와 변수명 동일하면 외부로부터 주입된다.
////		String id = request.getParameter("id"); 받아오는 작업 불필요
////		String pw = request.getParameter("pw");
//		
//		// @RequestParam으로 값을 전달하게되면 한글은 깨지게 됨으로 인코딩 필터 추가 설정 필요
//		
//		// db로그인 정상 확인
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("loginresult",dto);
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
	
	//매개변수 수정2 _ DTO
//	@PostMapping(value="/login")
//	public ModelAndView loginprocess(LoginDTO dto, int age) {
//		
//		// db로그인 정상 확인
//		//LoginDTO dto = new LoginDTO(); 매개변수로 받으므로 불필요
//		//dto.setId(id);
//		//dto.setPw(pw);
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("loginresult",dto);
//		mv.setViewName("loginsuccess");
//		return mv;
//	}

	//매개변수 수정2 _ @ModelAttribute
	@PostMapping(value="/login")
	public String loginprocess(@ModelAttribute("loginresult") LoginDTO dto) {
	//model은 컨트롤러가 뷰로 전달하는 객체하는 의미
		
		// db로그인 정상 확인 Model 객체 불필요
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("loginresult",dto);
//		mv.setViewName("loginsuccess");
		return "loginsuccess";
	}
	
	@ModelAttribute("all") //모든 뷰에서 사용가능하다.
	public String all() {
		return "모든 뷰에서 사용 가능합니다.";
	}
}
