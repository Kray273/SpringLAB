package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springproj.biz.board.BoardVO;

public class AfterReturningAdvice {

		public void afterLog(JoinPoint jp, Object returnObj) {
			String method = jp.getSignature().getName(); 
			//Object[] args = jp.getArgs();
			// 결과를 보고 수행되기에 args는 의미가 없다. 즉 시점에 따라 메세지를 수정해야한다.
			if(returnObj instanceof BoardVO) {
				//instanceof 어떤 객체가 어떤 클래스의 자료형인지 확인하는 연산자.
				BoardVO board = (BoardVO) returnObj;
				if(board.getWriter().equals("euiseok")) {
					System.out.println("This name is euiseok");
				}
			}
			
			System.out.println("[정상 종료] "+method+" 비지니스 로직 수행 후 동작");
			//System.out.println("args 정보 : "+args[0].toString());
			
		}
			
}
