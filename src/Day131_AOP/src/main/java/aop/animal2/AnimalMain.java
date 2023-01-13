package aop.animal2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop/animal2/animal.xml");
		
		Animal[] animals = new Animal[3];
		// Animal인터페이스 상속 구현 클래스 
		//aspect pointcut시 인터페이스타입(O)
		animals[0] = (Animal)factory.getBean("dog"); //Dog객체
		animals[1] = (Animal)factory.getBean("cat"); //Cat 객체
		//각각 구현클래스로 변경가능
		animals[2] = (Rabbit)factory.getBean("rabbit"); //Rabbit 객체
		
		for(Animal a : animals) a.lunch();
		

	}

}
