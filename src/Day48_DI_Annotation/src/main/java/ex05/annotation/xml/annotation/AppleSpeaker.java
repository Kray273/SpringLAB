package ex05.annotation.xml.annotation;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("AppleSpeaker 객체생성.");
	}
	
	public void volumeUp() {
		System.out.println("AppleSpeaker---sound -1");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker---sound -1");
	}
								
}
