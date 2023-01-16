package anotation.springmvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController  {
		
	@RequestMapping("/list") 
	public ModelAndView list() throws Exception {
		ArrayList<String> names = new ArrayList<String>();
		names.add("1번 감자");
		names.add("2번 고구마");
		names.add("3번 오트밀");
		names.add("4번 당근");
		names.add("5번 AOP");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", names); 
		mv.setViewName("list");
				
		// view 설정
		return mv; 
	}
	
}
