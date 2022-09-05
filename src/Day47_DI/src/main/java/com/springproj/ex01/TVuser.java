package com.springproj.ex01;

public class TVuser {

	public static void main(String[] args) {
		/*
		 * LgTV lgTv = new LgTV();
		 * 
		 * lgTv.turnOn();//원하는 기능을 호출. 
		 * lgTv.soundUp();
		 */
		
		//매서드가 달라지면 자료형의 이름이 같아도 전부 바꿔줘야한다.
		// 이를 해결하기 위해 인터페이스가 등장
		SSTV lgTv = new SSTV();
		
		lgTv.powerOn();
		lgTv.volumeUp();
		
		
	}
}
