package tn.esprit.Config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class Logging {
	
	private long t1, t2;
	
	@Before("execution(* tn.esprit.Service.*.*(..))")
	public void before(JoinPoint jp) {
		t1 = System.currentTimeMillis();
		log.info("Method (Before) " + jp.getSignature().getName() + "Execution started at : " + t1);
	}
	
	@After("execution(* tn.esprit.Service.*.*(..))")
	public void after(JoinPoint jp) {
		t2 = System.currentTimeMillis();
		long exec = t2-t1;
		log.info("Method (After) "+ jp.getSignature().getName() + "Execution Time : " + exec); 
	}
	
	@AfterReturning("execution(* tn.esprit.Service.*.*(..))")
	public void afterReturn(JoinPoint jp) {
		t2 = System.currentTimeMillis();
		long exec = t2-t1;
		log.info("Method (AfterReturning) "+ jp.getSignature().getName() + "Execution Time : " + exec); 
	}
	
}
