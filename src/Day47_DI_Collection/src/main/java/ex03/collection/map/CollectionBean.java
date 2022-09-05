package ex03.collection.map;

import java.util.Map;

public class CollectionBean {

	private Map<String, String> addressList; //참조자료형을 설정
	//getter and setter 자동생성
	public Map<String, String> getAddressList() { //데이터를 호출
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) { //데이터를 저장
		this.addressList = addressList;
	}
	
}
