//package com.rvy.aop;
//
//import java.util.logging.Logger;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//
//import lombok.extern.slf4j.Slf4j;
//@Slf4j
//@Aspect
//public class OrderAspect {
//	
//
//	
//	@Pointcut("execution(* com.rvy.service.OrderMasterService.*(..))")
//	private void pointCut() {
//		
//	}
//	
//	
//	@Pointcut("execution(* com.rvy.dao.OrderMasterRepository.*(..))")
//	private void pointCutDao() {
//		
//	}
//	
//	
//	@Before("pointCut()")
//	public void  beforeServiceMethod(JoinPoint joinPoint) {
////		System.out.println("Before execution of the method, "+ joinPoint.getSignature().getName());
//		
//		log.info("Before execution of the method in service layer : "+joinPoint.getSignature().getName());
//	}
//	
//	
//	@After("pointCut()")
//	public void  afterServiceMethod(JoinPoint joinPoint) {
////		System.out.println("After execution of the method, "+ joinPoint.getSignature().getName());
//		
//		log.info("After execution of the method in service layer : "+joinPoint.getSignature().getName());
//	}
//	
//	@Around("pointCut()")
//	public Object  aroundServiceMethod(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
////		System.out.println("Before  @Around ");
//		
//		log.info("Before  @Around : "+proceedJoinPoint.getSignature().getName());
//
//		Object object = proceedJoinPoint.proceed(); 
////		System.out.println("After @Around ");
//		
//		log.info("After  @Around : "+proceedJoinPoint.getSignature().getName());
//		return object;
//	}
//	
//	
//	
//	@Before("pointCutDao()")
//	public void  beforeServiceMethodDao(JoinPoint joinPoint) {
////		System.out.println("Before execution of the method, "+ joinPoint.getSignature().getName());
//		
//		log.info("Before execution of the method in service layer : "+joinPoint.getSignature().getName());
//	}
//	
//	
//	@After("pointCutDao()")
//	public void  afterServiceMethodDao(JoinPoint joinPoint) {
////		System.out.println("After execution of the method, "+ joinPoint.getSignature().getName());
//		
//		log.info("After execution of the method in dao layer : "+joinPoint.getSignature().getName());
//	}
//	
//	@Around("pointCutDao()")
//	public Object  aroundServiceMethodDao(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
////		System.out.println("Before  @Around ");
//		
//		log.info("Before  @Around : "+proceedJoinPoint.getSignature().getName());
//
//		Object object = proceedJoinPoint.proceed(); 
////		System.out.println("After @Around ");
//		
//		log.info("After  @Around : "+proceedJoinPoint.getSignature().getName());
//		return object;
//	}
//	
//
//}
