package websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.wls.shaded.org.apache.regexp.recompile;

@Controller
public class ChatController {
	@RequestMapping("/chat")
	public String chat(String id) {
		return "websocket/websocket";
	}
	
	
}
