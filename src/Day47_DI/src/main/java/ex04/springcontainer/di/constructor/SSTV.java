package ex04.springcontainer.di.constructor;

public class SSTV implements TV{

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SSTv가 꺼집니다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SSTv가 꺼집니다.");
		
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SSTv 소리가 1 증가합니다.");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SSTv 소리가 1 감소합니다.");
		
	}
	
}
