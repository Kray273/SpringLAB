package ex04.collection.properties;

import java.util.Properties;

public class CollectionBean {

	private Properties addressList; //자바에서 제공하는 자바의 자료형을 설정
	//getter and setter 자동생성
	public Properties getAddressList() { //데이터를 호출
		return addressList;
	}

	public void setAddressList(Properties addressList) { //데이터를 저장
		this.addressList = addressList;
	}
	
}
