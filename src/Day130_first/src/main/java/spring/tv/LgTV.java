package spring.tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("lgTV: 전원을 켜다");
	}
	public void powerOff() {
		System.out.println("lgTV: 전원을 끄다");
	}
	public void soundUp(int v) {
		System.out.println("lgTV:" + v + "볼륨을 올리다");
	}
	public void soundDown(int v) {
		System.out.println("lgTV:" + v + "볼륨을 낮추다.");
	}

}
