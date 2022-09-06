package ex03.annotation.qualifier;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("SonySpeaker 객체생성.");		
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker---sound -1");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker---sound -1");
	}

}
