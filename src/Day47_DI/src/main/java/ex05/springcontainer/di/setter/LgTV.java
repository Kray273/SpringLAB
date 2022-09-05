package ex05.springcontainer.di.setter;

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
	
	Speaker speaker;
	int price;
	
	public LgTV() {
		
	}
	
	/* 생성자 방식
	 * public LgTV(Speaker speaker) { this.speaker = speaker; }
	 * 
	 * 
	 * public LgTV(Speaker speaker, int price) { this.speaker = speaker; this.price
	 * = price; System.out.println("price :"+ this.price); }
	 */
	
	public void setSpeaker(Speaker speaker) {//setter 메서드 자동생성 
		System.out.println("setSpeaker() 매서드 호출");
		this.speaker = speaker;
	}
	
	

	public void setPrice(int price) {
		System.out.println("setPrice() 매서드 호출");
		this.price = price;
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		speaker.volumeUp();
	}

	

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("setSpeaker() 매서드 호출");
		speaker.volumeDown();
	}
	

}
