package aop.animal1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop/animal1/animal.xml");
		
		Animal[] animals = new Animal[3];
		animals[0] = (Animal)factory.getBean("dog"); //Dog객체
		animals[1] = (Animal)factory.getBean("cat"); //Cat 객체
		animals[2] = (Animal)factory.getBean("rabbit"); //Rabbit 객체
		
		for(Animal a : animals) a.lunch();
		

	}

}
