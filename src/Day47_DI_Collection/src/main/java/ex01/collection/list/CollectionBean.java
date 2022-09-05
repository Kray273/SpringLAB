package ex01.collection.list;

import java.util.List;

public class CollectionBean {

	private List<String> addressList; //참조자료형을 설정
	//getter and setter 자동생성
	public List<String> getAddressList() { //데이터를 호출
		return addressList;
	}

	public void setAddressList(List<String> addressList) { //데이터를 저장
		this.addressList = addressList;
	}
	
}
