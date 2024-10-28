package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyAPIAnalyticsAspect
{
    @Before("com.luv2code.aopdemo.aspect.NJDPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void performAnalytics()
    {
        System.out.println(" (2) Before Advice of API ANALYTICS - GO NJD!!!");
    }
}
