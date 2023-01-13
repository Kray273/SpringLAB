package aop2;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Common {
	long start = 0;
	
	@Pointcut("execution(public * aop2.*.*(..))")
	public void pc() {/* aop 실제 동작시 타겟 메소드 자동 포함*/} 
	
	@Before("pc()")
	public void a() {
		start = System.currentTimeMillis();
		System.out.println("===> a메소드는 핵심관심 이전에 호출 : " 
				+ new Date(start));
	}
	@After("pc()")
	public void b() {
		start = System.currentTimeMillis();
		System.out.println("===> b메소드는 핵심관심 이후에 호출 : " 
				+ (System.currentTimeMillis() - start) + "소요시간(1/1000초)");
	}
	@Around("pc()")
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
	
// @ 방식
/*  <!-- aop설정 필요없음-->
*   <aop:aspectj-autoproxy/>
*/
