package com.example.TaskApp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    // Introduce Auditable behavior to all Task beans
    @DeclareParents(
            value = "com.example.TaskApp.service.TaskService",
            defaultImpl = AuditableImpl.class
    )
    public static Auditable mixin;
}
