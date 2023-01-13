package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {
		
	@Override 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
