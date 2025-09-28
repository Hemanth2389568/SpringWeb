package com.example.springweb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLoggingAspect {
	
	@Around("execution(* com.example.springweb.controller..*(..))")
	public Object controllerloggingaspect(ProceedingJoinPoint jointpoint) throws Throwable {
		
		System.out.println(jointpoint.getSignature());
		
		Object result=jointpoint.proceed();
		
		System.out.println(jointpoint.getSignature());
		
		System.out.println(result);
		
		return result;
	}

}
