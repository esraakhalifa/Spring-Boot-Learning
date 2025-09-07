package com.example.TaskApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    // Intercept all methods inside your controllers
    @Around("execution(* com.example.TaskApp.controller..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with the actual method
        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;
        logger.info("Execution of {} took {} ms", joinPoint.getSignature(), duration);

        return result;
    }
}
