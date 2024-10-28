package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect
{
    @Before("com.luv2code.aopdemo.aspect.NJDPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloudAsync()
    {
        System.out.println(" (3) Before Advice of Log To Cloud !!! GO DEVILS !!!");
    }

}
