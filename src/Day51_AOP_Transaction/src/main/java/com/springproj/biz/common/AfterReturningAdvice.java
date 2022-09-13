package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;

@Service
//@Aspect
public class AfterReturningAdvice {
	
	//@Pointcut("execution(* com.springproj.biz..*Impl.get*(..))")
	//public void getPointcut() {} 
		
		//@AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
		//반환값을 처리해 줘야할때는 위와 같이 적용.
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")	
	public void afterLog(JoinPoint jp, Object returnObj) {
			String method = jp.getSignature().getName(); 
			
			if(returnObj instanceof BoardVO) {
				BoardVO board = (BoardVO) returnObj;
				if(board.getWriter().equals("euiseok")) {
					System.out.println("This name is euiseok");
				}
			}
			
			System.out.println("[정상 종료(AfterReturn)] "+method+" 비지니스 로직 수행 후 동작");
			
		}
			
}
