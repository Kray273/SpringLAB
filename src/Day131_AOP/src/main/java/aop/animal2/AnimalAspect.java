package aop.animal2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnimalAspect {
	
	@Pointcut("execution(public String aop.animal2.*.lunch())")
	public void an() {} 
	
	@Around("an()")
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
