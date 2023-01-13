package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")// HTTP프로토콜의 "/"모든 요청을 처리한다는 의미
public class DispatcherServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); //   /nonspringMVC/hello
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length -1]; // hello
		System.out.println(result);
		
		// url - controller 매핑
			// hello -> HelloController() -> HelloDTO -> hello.jsp
			// list -> ListController() -> ArrayList<HelloDTO> -> list.jsp
		HandlerMapping mappings = new HandlerMapping();
		Controller controller =  mappings.getController(result);
		String viewname = controller.hendleRequst(request, response);
		//포워드
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);

	}

}
