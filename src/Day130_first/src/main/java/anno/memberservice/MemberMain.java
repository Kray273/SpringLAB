package anno.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("memberservice/member.xml");
		MemberService service = factory.getBean("service2",MemberBasicService.class);
		//MemberService service = factory.getBean("service1",MemberJenService.class);
		
		service.registerMember();
		
		
	}
}
