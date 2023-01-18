package ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("service")
	MemberService service;

	@GetMapping("/loginajax")
	public String loginajax() {
		return "ajax/loginform";
	}
	
	@ResponseBody
	@PostMapping(value = "/loginajax", 
		produces = "application/json;charset=utf-8")
	public String loginajax2(String id, String pw) {
		String result = "";
		if(id.equals("ajax") && pw.equals("123")) {
			result = "로그인 성공";
		} else {
			result = "로그인 실패";
		}
		return "{ \"process\" : \"" + result + "\"}";
	}
	
	@ResponseBody
	@PostMapping(value = "/myinformajax", 
	produces = "application/json;charset=utf-8")
	public MemberDTO myinformajax(String id, String pw) {
		MemberDTO dto = service.onemember(id);
		if(dto.getPw().equals(pw)) {
			return dto;				
		} else {
			return null;	
		}
	}
	
	@GetMapping(value = "/memeberlistajax", 
	produces = "application/json;charset=utf-8")
	public @ResponseBody List<MemberDTO> memeberlistajax() {
		List<MemberDTO> list = service.memberlist();
		return list;
	}
	
	@GetMapping(value = "/pageinglistajax/{page}", 
			produces = "application/json;charset=utf-8")
	public @ResponseBody List<MemberDTO> pageinglistajax(@PathVariable("page") int page) {
		//전달받은 page변수를 int page으로 사용하겠다. 
		//page 변수 1 / 2 / 3
		// select ..limit 0/3/6,3
		int limit = (page - 1) * 3;
		int[] limitarr = new int[] {limit, 3};
		List<MemberDTO> list = service.pageinglist(limitarr);
		return list;
	}
	
}
