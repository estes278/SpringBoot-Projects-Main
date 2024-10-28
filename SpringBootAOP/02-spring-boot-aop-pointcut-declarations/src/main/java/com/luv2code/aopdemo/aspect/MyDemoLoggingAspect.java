package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect
{
    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
    {
        // print out which method we are advising
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n========>>> result of method call: " + result);

        // Post process the data and modify it before it makes it back to the original caller
        // Use caution when doing this!
        if(!result.isEmpty())
        {
            Account tempAccount = result.get(0);
            tempAccount.setFirstName("Trevor Belmont");
        }

        // print out the results of our edits to the return value
        System.out.println("\n\n========>>> result of method call AFTER edits using @AfterAdvice: " + result);
    }

    @Before("com.luv2code.aopdemo.aspect.NJDPointcutExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println(" (1) Inside BeforeAdvice of beforeAddAccount() and Let's Go NJD!!!");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display the method parameters

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args and print them
        for(Object tempArg : args)
        {
            System.out.println(tempArg);
            if (tempArg instanceof Account)
            {
                // downcast and print Account specifics
                Account account = (Account) tempArg;
                System.out.println("Account Name: " + account.getFirstName());
                System.out.println("Account Level: " + account.getLevel());
            }
        }


    }

    @AfterThrowing(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "ex"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex)
    {
        // print out which method we are advising
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n========>>> Exception Thrown: " + ex);



    }

    @After("execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint)
    {
        // print out which method we are advising
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @After (finally) on method: " + method);


    }

    @Around("execution (* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        // print out which method we are advising
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @Around on method: " + method);

        // get beginning timestamp
        long start = System.currentTimeMillis();

        // execute the  method
        Object result = null;
        try
        {
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception ex)
        {
            // log the exception
            System.out.println("Exception Caught!!! Details: " + ex.getMessage());

            // rethrow the exception
            throw ex;
        }

        // get ending timestamp
        long end = System.currentTimeMillis();

        // compute the duration of execution and display it
        long duration = end - start;
        System.out.println("\n\nDuration of Execution: " + (duration / 1000) + " seconds");

        return result;
    }

}
