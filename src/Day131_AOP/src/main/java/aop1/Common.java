package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long start = 0;
	public void a() {
		start = System.currentTimeMillis();
		System.out.println("===> a메소드는 핵심관심 이전에 호출 : " 
				+ new Date(start));
	}
	public void b() {
		start = System.currentTimeMillis();
		System.out.println("===> b메소드는 핵심관심 이후에 호출 : " 
				+ (System.currentTimeMillis() - start) + "소요시간(1/1000초)");
	}
	public void c(ProceedingJoinPoint joinpoint) {//이전 + 이후 모두 실행
		try {
			System.out.println("===> c메소드는 핵심관심 이전/이후에 호출 : joinpoint 이전" );
			System.out.println("타겟클래스 객체 :" + joinpoint.getTarget());
			System.out.println("실행 메서드 이름 :" + joinpoint.toLongString());
			Object[] args = joinpoint.getArgs();
			for(Object o : args) System.out.println("실행 메서드 매개변수 :" + o);	
			Object returnVal = joinpoint.proceed(); //around의 시점을 분리
			System.out.println("===> c메소드는 핵심관심 이전/이후에 호출 : joinpoint 이후");			
			if(returnVal != null) System.out.println("===> joinpoint return값" + returnVal );			
 
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	

}
//aop1패키지 모든 클래스의 모든 매서드 실행 이전 a 매소드 실행구성
// xml 방식
	/*<bean id="common" class="aop1.Common"/> //객체생성
	 * <aop:config>
	 * 	<aop:pointcut expression="(접근지시자 리턴타입 매서드위치[aop1.*.*(..)])" id="pc" /> //
	 * 	<aop:aspect id="aopaspect" ref="common"/> //객체를 aspect로 사용하겠다는 선언
	 * 	<aop:xxx /> 3가지 방법이 있음
	 * 	 1. <aop:before method="a" pointcut-ref="pc" /> // 매서드 실행 이전 common.a()매서드 실행 
	 * 	 2. <aop:after method="a" ""/> //매서드 실행 이후 
	 * 	 3. <aop:around method="a" ""/> //매서드 실행 이전 이후 모두 
	 *</aop:config>
	 * */
	
// @ 방식
