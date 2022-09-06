package ex05.annotation.xml.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired  //동일한 자료형이 2개일때 문제 발생
	Speaker speaker; 
	
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
		speaker.volumeUp(); 
	}

	@Override
	public void volumeDown() {
 		speaker.volumeDown(); 
	}
	
}
