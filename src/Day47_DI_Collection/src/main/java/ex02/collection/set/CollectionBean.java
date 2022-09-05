package ex02.collection.set;

import java.util.Set;

public class CollectionBean {

	private Set<String> addressList; //참조자료형을 설정
	//getter and setter 자동생성
	public Set<String> getAddressList() { //데이터를 호출
		return addressList;
	}

	public void setAddressList(Set<String> addressList) { //데이터를 저장
		this.addressList = addressList;
	}
	
}
