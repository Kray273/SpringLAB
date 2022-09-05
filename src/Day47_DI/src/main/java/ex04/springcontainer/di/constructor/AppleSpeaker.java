package ex04.springcontainer.di.constructor;

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
