package ex01.annotation.component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {	
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext01.xml");
		
		TV tv = (TV)factory.getBean("tv"); 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close(); 
			
	}
}
