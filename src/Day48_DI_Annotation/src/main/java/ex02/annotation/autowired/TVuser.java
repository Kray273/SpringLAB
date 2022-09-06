package ex02.annotation.autowired;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {	
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext02.xml");
		
		TV tv = (TV)factory.getBean("tv"); 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close(); 
			
	}
}
