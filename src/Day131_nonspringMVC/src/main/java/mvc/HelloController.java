package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String hendleRequst(HttpServletRequest request, HttpServletResponse response) {
		//model 설정
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		request.setAttribute("model", dto); //값을 전달.
		
		// view 설정
		return "hello.jsp";  //${model.message} 하면 set한 값이 출력될것.
	}
	
	
}
