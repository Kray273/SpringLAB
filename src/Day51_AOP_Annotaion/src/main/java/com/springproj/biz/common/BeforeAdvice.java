package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

		public void beforeLog(JoinPoint jp) {
			String method = jp.getSignature().getName(); 
			//매서드에 대한 시그니쳐를 전달받고, 수행되는 매서드의 이름을 받는다.
			Object[] args = jp.getArgs();
			//매서드에 전달되는 값을 알고 싶다. 
			System.out.println("[공통로그] "+method+" 비지니스 로직 수행 전 동작");
			System.out.println("args 정보 : "+args[0].toString());
		}
			
}
