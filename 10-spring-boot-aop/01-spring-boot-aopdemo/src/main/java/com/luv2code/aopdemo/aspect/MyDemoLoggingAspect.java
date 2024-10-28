package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect
{
    // Pointcut expression, run this code BEFORE (insert expression here)
    // Below matches on any return type + any method starting with "add" and any number of params
    /*@Before("execution( * add*(..))")
    public void beforeAddAccountAdvice()
    {
        System.out.println("Inside BeforeAdvice of beforeAddAccount() and Let's Go NJD!!!");
    }*/

    // This one matches on any return type, any class and any method WITHIN
    // the given package, and any number/order of parameters
    @Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice()
    {
        System.out.println("Inside BeforeAdvice of beforeAddAccount() and Let's Go NJD!!!");
    }
}
