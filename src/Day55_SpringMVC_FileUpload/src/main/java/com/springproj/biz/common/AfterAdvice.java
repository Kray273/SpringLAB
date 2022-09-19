package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springproj.biz.domain.BoardVO;



public class AfterAdvice { //메서드가 반드시 실행(예외 or 동작 할 때) 

	public void afterAdviceLog(JoinPoint jp) {
	String method =	jp.getSignature().getName();
			
	

		
	
	
	System.out.println("[상시 작동] "+method+" 눈이오나 비가오나 작동");
	
	
	}
	
}
