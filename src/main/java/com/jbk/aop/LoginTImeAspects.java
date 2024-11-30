package com.jbk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginTImeAspects {

    Logger logger = LoggerFactory.getLogger (LoginTImeAspects.class);

    @Around("execution(* com.jbk.controller.AuthController.*(..))")
    public Object trackExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        long startTime = System.currentTimeMillis ();
        Object obj = proceedingJoinPoint.proceed ();
        long endTime = System.currentTimeMillis ();

        logger.info ("Execution Time: " + (startTime - endTime));
        return obj;
    }
}
