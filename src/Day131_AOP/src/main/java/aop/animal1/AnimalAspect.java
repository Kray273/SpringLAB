package aop.animal1;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAspect {
	
	public void feed(ProceedingJoinPoint p) {
		try {
			System.out.println("오늘은 뭐 먹을거에요" );	
			String target = (String)p.getTarget().toString();
			String[] names = target.split("@")[0].split("\\.");
			String classname = names[names.length - 1];
			Object o = p.proceed(); //around의 시점을 분리
			if(o != null) System.out.println(classname + " 먹었군요!Good!" );			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
