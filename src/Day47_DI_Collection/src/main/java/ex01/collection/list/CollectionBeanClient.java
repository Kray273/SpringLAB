package ex01.collection.list;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CollectionBeanClient {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext01.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		List<String> list = bean.getAddressList();
		for(String address : list) {
			System.out.println(address);
		}
		
		factory.close();
		
	}

}
