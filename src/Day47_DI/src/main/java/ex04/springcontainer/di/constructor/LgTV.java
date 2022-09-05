package ex04.springcontainer.di.constructor;

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
	

	public LgTV() {
		//speaker = new SonySpeaker();
	}
	
	//SonySpeaker speaker; //apple스피커로 변경시 수정해야한다.
	//AppleSpeaker speaker; //상속의 관계로 이 부분도 수정
	Speaker speaker;

	//public LgTV(SonySpeaker speaker) { //오버라이드_ 매개변수를 통해 선언(스프링이 만들어 놓은)
	public LgTV(Speaker speaker) { //상속의 관계
		//speaker = new SonySpeaker(); Spring이 주입함으로 불 필요.
		this.speaker = speaker;
	}
	
	int price;
	
	//public LgTV(SonySpeaker speaker, int price) { //오버라이드_2개의 변수 받기
	public LgTV(Speaker speaker, int price) { //상속의 관계
		//speaker = new SonySpeaker(); Spring이 주입함으로 불 필요.
		this.speaker = speaker;
		this.price = price;
		System.out.println("price :"+ this.price);
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		speaker.volumeDown();
	}
	

}
