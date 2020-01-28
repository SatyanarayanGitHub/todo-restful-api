package org.srysoft.todo.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * @author SATYA
 *
 */
@Component
@Aspect
public class LoggingAOP {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAOP.class);

	// Before
	@Before("within(org.srysoft.todo.controller..*)")
	public void controllerLayerBefore(JoinPoint joinPoint) {
		logger.info("==>>Before Class: [" + joinPoint.getSignature().getDeclaringTypeName() + "] method : ["
				+ joinPoint.getSignature().getName() + "]");
		logger.info("==>> Parameters: " + Arrays.deepToString(joinPoint.getArgs()));

	}

	// Before
	@Before("within(org.srysoft.todo.service..*)")
	public void serviceLayer(JoinPoint joinPoint) {
		logger.info("==>>Before Class: [" + joinPoint.getSignature().getDeclaringTypeName() + "] method : ["
				+ joinPoint.getSignature().getName() + "]");
		logger.info("==>> Parameters: " + Arrays.deepToString(joinPoint.getArgs()));
	}

	// After returning
	@AfterReturning(pointcut = "within(org.srysoft.todo.controller..*) || within(org.srysoft.todo.service..*)", returning = "result")
	public void controllerLayerAfterReturn(JoinPoint joinPoint, Object result) {
		logger.info("After Class: [" + joinPoint.getSignature().getDeclaringType() + "] method: ["
				+ joinPoint.getSignature().getName() + "]");
		logger.info("==>> Result : " + result);

	}

}
