package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("annotation/member/member.xml");
		MemberDAO dao = factory.getBean("dao",MemberDAO.class);
		
		boolean isLogin = dao.selectMember();
		// 두개 비교 
		
		if(isLogin) {
			System.out.println(dao.dto.getId()+"회원님 정상로그인 되었습니다.");
		}else {
			dao.insertMember();
		}
		System.out.println("======================================");
		String[] beanNames =factory.getBeanDefinitionNames();
		for(String name: beanNames) {
			System.out.println(name);
		}
	}
}
