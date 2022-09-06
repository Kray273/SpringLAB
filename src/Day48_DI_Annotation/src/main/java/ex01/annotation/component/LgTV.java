package ex01.annotation.component;

import org.springframework.stereotype.Component;

@Component("tv")
//bean을 설정해야 했었던 내용을 자동으로 함.
public class LgTV implements TV {

	public LgTV() {
		System.out.println("Lg Tv객체를 생성했습니다.");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Lg Tv가 켜집니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("Lg Tv가 꺼집니다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("Lg Tv Sound가 1 증가합니다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("Lg Tv Sound가 1 감소합니다.");		
	}
	
}
