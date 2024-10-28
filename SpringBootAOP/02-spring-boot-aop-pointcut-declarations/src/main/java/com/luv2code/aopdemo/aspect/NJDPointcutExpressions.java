package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// Aspect annotation is optional for this class since there are no actual "Advices"
// and we only have pointcut declarations. But in case we decide to add advices later,
// we will keep the @Aspect annotation. Plus it's a good indication of what this
// class is used for
@Aspect
public class NJDPointcutExpressions
{
    // Pointcut declaration for re-using pointcuts
    // All access modifier types, any class and method that is part of
    // the indicated package, any number and order of params
    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    // Pointcuts for getter and setter methods
    // All access modifier types, any class and method that is part of
    // the indicated package AND starts with "get", any number and order of params
    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..)) ")
    public void getter() {}

    // Pointcuts for getter and setter methods
    // All access modifier types, any class and method that is part of
    // the indicated package AND starts with "set", any number and order of params
    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..)) ")
    public void setter() {}

    // Combo pointcut declaration to exclude getters and setters
    // Makes use of the previous 3 Pointcut Declarations above
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() {}
}
