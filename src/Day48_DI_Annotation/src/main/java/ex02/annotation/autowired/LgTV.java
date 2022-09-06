package ex02.annotation.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
//bean을 설정해야 했었던 내용을 자동으로 함.
public class LgTV implements TV {
	
	//Speaker speaker = new SonySpeaker() ; DI를 하기 위한 변수 설정
	
	//@Autowired
	@Inject  //autowwired와 동일한 기능
	Speaker speaker; //sony의 기능을 사용하기 위한 변수 설정(Annotation 방법)
	
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
		//System.out.println("Lg Tv Sound가 1 증가합니다."); 기존 TV 자체 소리
		speaker.volumeUp(); // 스피커를 통해 기능 실행(생성자, 매서드 2가지 방법으로 주입(DI))
	}

	@Override
	public void volumeDown() {
		//System.out.println("Lg Tv Sound가 1 감소합니다."); 기존 TV 자체 소리
 		speaker.volumeDown(); // 스피커를 통해 기능 실행(생성자, 매서드 2가지 방법으로 주입(DI))
	}
	
}
