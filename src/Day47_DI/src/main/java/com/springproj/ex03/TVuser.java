package com.springproj.ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		
		//TV tv = new LgTV(); 스프링이 관리함으로 필요 없어짐.

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext03.xml");
		//위의 작업을 할 수 있도록 스프링에게 요청(DL)
		
		TV tv = (TV)factory.getBean("tv"); //tv의 주소값을 요청(getBean은 tv를 검색)
		//강제 형변환이 필요_리턴값을 getBean이 Object로 보고 있다.  
		
		tv.powerOn();//기존의 코드를 그대로 사용. 
		
		factory.close(); // 사용한 메모리를 종료. 
		
		
	}
}
