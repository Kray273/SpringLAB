package ex06.springcontainer.di.xmlns.p;

public class SonySpeaker implements Speaker{
	//생성자(constructor)
	// 자바에서는 객체의 생성과 동시에 인스턴스 변수를 원하는 값으로 초기화할 수 있는 
	//생성자(constructor)라는 메소드를 제공합니다.
	// 생성자는 클래스의 이름과 동일 해야한다.
	// 매서드와 다르게 반환형이 없다. why? 호출하지 않는다.
	// 객체를 생성할 때 자바에 의해 생성된다. 
	
	/*
	 * 생성자 작동원리 
	 * 1)new 메모리 할당 2) this라는 참조변수를 만듦 
	 * 3) SonySpeaker() 생성자 호출 4) this에 대한 주소값 return
	 */ 
	
	public SonySpeaker() {
		System.out.println("SonySpeaker 객체생성.");
		
	}
	
	public void volumeUp() {
		System.out.println("SonySpeaker---sound -1");
	}
	public void volumeDown() {
		System.out.println("SonySpeaker---sound -1");
	}

}
