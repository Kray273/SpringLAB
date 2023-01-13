package mvc;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap();
 		mappings.put("hello", new HelloController());
		//mappings.put("list", new ListController());
	}
	
	Controller getController(String url) {
		System.out.println("HandlerMapping실행 중");
		return mappings.get(url);
	}
}
