package com.springproj.ex02;

public class TVuser {

	public static void main(String[] args) {
		
		// SSTV tv = new SSTV(); SSTV로 자료형을 설정할 수 있지만 
		
		//TV tv = new SSTV(); 자식의 자료형을 부모의 자료형으로 호출할 수 있다. (다형성)
		TV tv = new LgTV(); //호출되는 참조변수만 수정하면 기능을 강제로 사용할 수 있다.
		tv.powerOn();
	}
}
