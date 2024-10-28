package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect
{
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    // match on any class+method+params of controller package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // same thing for service package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    // same thing for DAO package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    // match on anything in any of these packages
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint)
    {
        // display the method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===>> in @Before advice of calling method: " + method);

        // display the parameters of the method we are calling
        // get the arguments + loop through and display them

        Object[] args = joinPoint.getArgs();

        for(Object tempArg: args)
            myLogger.info("Argument: " + tempArg);
    }

    // add @AferReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        // display the method we are returning from
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===>> in @AfterReturning advice of calling method: " + method);

        // display the data that was returned
        myLogger.info("===>> Result: " + result);
    }
}
