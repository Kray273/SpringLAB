package ex04.collection.properties;

import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CollectionBeanClient {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext04.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		Properties addressList = bean.getAddressList();
		
		for(String key : addressList.stringPropertyNames()) { 
			//map과 같은 key and value로 자료를 처리
			System.out.println(String.format("키: %s, 값: %s ",key, addressList.get(key)));
		}
	
		factory.close();
		
	}

}
