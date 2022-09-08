package com.springproj.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

		public Object aroundLog(ProceedingJoinPoint pjp) {
			String method = pjp.getSignature().getName();
			StopWatch stopWatch = new StopWatch();
			//시간을 찍는 매서드
			stopWatch.start();
			//시작시간

			try {
				Object returnObj = pjp.proceed();
				//사용될 pointcut를 수행.
				
				stopWatch.stop();//끝나는 시간
				
				System.out.println(method +"() 메서드 수행 걸린 시간 :"+stopWatch.getTotalTimeMillis()+"(ms)초");
				//걸리는 시간을 계산
				
				return returnObj;
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
			
		}
			
}
