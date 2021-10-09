package com.kulinichev.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	//setup logger
		private Logger myLogger = Logger.getLogger(getClass().getName());
		
	//setup pointcut declaration
			
		//pointcut from controller
		@Pointcut("execution(* controller.*.*(..))")
		private void forControllerPackage() {
			
		}
		
		//pointcut from service and DAO
		@Pointcut("execution(* service.*.*(..))")
		private void forServicePackage() {
			
		}
		
		@Pointcut("execution(* dao.*.*(..))")
		private void forDaoPackage() {
			
		}
		
		//combine poincut declaration
		@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
		private void forAppFlow() {
			
		}
		
	//add @Before advice
		@Before("forAppFlow()")
		public void before(JoinPoint theJoinPoint ) {
			
		//display method we are calling
			String theMetod = theJoinPoint.getSignature().toShortString();
			myLogger.info("======>in @Before: calling method: " + theMetod);
			
		//display the arguments to the method
			
			//get the argument
			Object[] args = theJoinPoint.getArgs();
			
			//loop thru and display argument
			for (Object tempArg: args) {
				myLogger.info("===========> Argument: "+ tempArg);
			}
		} 
		
		
	//add @AfterReturning advice
		@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
		public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
			
			//display method we are returning from
			String theMetod = theJoinPoint.getSignature().toShortString();
			myLogger.info("======>in @AfterReturning: from method: " + theMetod);
			
			//display data returned
			myLogger.info("==========>> Result: "+theResult);
			
		}
	
}
