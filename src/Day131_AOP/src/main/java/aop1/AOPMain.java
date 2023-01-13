package aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop1/aop1.xml");
		Member m = factory.getBean("member",Member.class);
		System.out.println("====insert ====");
		m.insert("spring", 1111);
		System.out.println("====login ====");
		m.login("spirng");
		System.out.println("====logout ====");
		m.logout();
		
		Board b = factory.getBean("board",Board.class);
		System.out.println("====insert ====");
		b.insert(1);
		System.out.println("====getList ====");
		b.getList();
		
	}

}
