package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {
	
	public static void main(String[] args) {
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.soundUp(5);
//		tv.soundDown(3);
//		tv.powerOff();
		
		
//		tv = new LgTV(); 
//		tv.powerOn();
//		tv.soundUp(5);
//		tv.soundDown(3);
//		tv.powerOff();
		
		
//		TVFactory factory = new TVFactory();
//		TV tv = factory.getTV("����"); 
//		TV tv = factory.getTV("�Ｚ");
//		tv.powerOn();
//		tv.soundUp(5);
//		tv.soundDown(3);
//		tv.powerOff();
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = (TV)factory.getBean("tv2"); // 1.tv = new xxxTV();
		tv.powerOn();
		tv.soundUp(5);
		tv.soundDown(3);
		tv.powerOff();
		TV tv2 = (TV)factory.getBean("tv2"); // 2. return tv
		TV tv3 = (TV)factory.getBean("tv2"); // 3. return tv
		
		
	}
}

/* 
 * 	일부 
 * 
 * 
 */
