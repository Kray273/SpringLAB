package com.springproj.ex03;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println(" Lg Tv가 켜집니다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("Lg Tv가 꺼집니다.");
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("Lg Tv 소리가 1 증가합니다.");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("Lg Tv 소리가 1 감소합니다.");
		
	}
	

}
