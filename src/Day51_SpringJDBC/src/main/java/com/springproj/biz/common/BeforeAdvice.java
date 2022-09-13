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
		public void allPointcut() {} 
		//참조메서드 적용, pointcut의 Id로 등록이 되어짐. 
		//추상메서드와 기능 부분이 없다는 차이점을 가짐. 
		
		@Before("allPointcut()")//Id(참조매서드)와 매칭
		public void beforeLog(JoinPoint jp) {
			String method = jp.getSignature().getName(); 

			Object[] args = jp.getArgs();
		 
			System.out.println("[공통로그(Before)] "+method+" 비지니스 로직 수행 전 동작");
			System.out.println("args 정보 : "+args[0].toString());
		}
			
}
