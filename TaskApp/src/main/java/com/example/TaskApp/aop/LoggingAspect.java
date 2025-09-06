package com.example.TaskApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Logs before every repository, service, or controller method
    @Before("execution(* com.example.TaskApp..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("➡️ Executing: " + joinPoint.getSignature());
    }

    // Logs after a successful method execution
    @AfterReturning(pointcut = "execution(* com.example.TaskApp..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ Completed: " + joinPoint.getSignature() + " | Returned: " + result);
    }

    // Logs if a method throws an exception
    @AfterThrowing(pointcut = "execution(* com.example.TaskApp..*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("❌ Exception in: " + joinPoint.getSignature() + " | Message: " + ex.getMessage());
    }
}
