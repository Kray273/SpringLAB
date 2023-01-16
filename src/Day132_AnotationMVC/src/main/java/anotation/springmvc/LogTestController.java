package anotation.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping("/test")
	public void test() {
		logger.trace("trece 레벨테스트"); //레벨 1
		logger.debug("debug 레벨테스트");//레벨 2
		logger.info("info 레벨테스트"); //레벨 3
		logger.warn("warn 레벨테스트"); //레벨 4
		logger.error("error 레벨테스트"); //레벨 5
	}
}
