package com.example.TaskApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Logs before every repository, service, or controller method
    @Before("within(com.example.TaskApp..*)")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("➡️ Executing: {}", joinPoint.getSignature());
    }

    // Logs after a successful method execution
    @AfterReturning(pointcut = "within(com.example.TaskApp..*)", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("✅ Completed: {} | Returned: {}", joinPoint.getSignature(), result);
    }

    // Logs if a method throws an exception
    @AfterThrowing(pointcut = "within(com.example.TaskApp..*)", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.error("❌ Exception in: {} | Message: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }
}
