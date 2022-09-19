package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.springproj.biz..*Impl.*(..))")
	public void allPointcut() {}  //annotation에서 참조 매서드로 아이디를 등록 
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		System.out.println("[공통로그(Before)] " + method + " 비즈니스 로직 수행 전 동작.");

		
		for(int x=0; x<args.length ; x++)
		{
			System.out.println("args 정보 : " + args[x].toString());
			
			
		}
		
		//System.out.println("args 정보 : " + args[0].toString());
			
		

	}

}