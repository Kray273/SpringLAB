package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String hendleRequst(HttpServletRequest request, HttpServletResponse response);
}
