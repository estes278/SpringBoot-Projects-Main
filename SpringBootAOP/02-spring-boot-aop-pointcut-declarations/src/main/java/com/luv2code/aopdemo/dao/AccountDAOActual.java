package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOActual implements AccountDAO
{

    private String firstName;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag)
    {
        System.out.println("This is Add Account of " + getClass() + " but GO DEVILS!!!");
    }

    @Override
    public boolean doWork()
    {
        System.out.println(getClass() + " is Doing Work!");
        return true;
    }

    public String getFirstName()
    {
        System.out.println(getClass() + "inside getFirstName()");
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
        System.out.println(getClass() + "inside setFirstName()");
    }

    public String getServiceCode()
    {

        System.out.println(getClass() + "inside getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
        System.out.println(getClass() + "inside setServiceCode()");
    }

    @Override
    public List<Account> findAccounts()
    {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire)
    {
        // for academic purposes, we will simulate an exception
        if(tripWire)
            throw new RuntimeException("Back to Back Opener is Crap");


        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts and add them to the list
        Account a1 = new Account("Jesper Bratt", "First Line LW");
        Account a2 = new Account("Jack Hughes", "Second Line Center");
        Account a3 = new Account("Jonas Siegenthaler", "First Pair D");

        myAccounts.add(a1);
        myAccounts.add(a2);
        myAccounts.add(a3);


        return myAccounts;
    }
}
