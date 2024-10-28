package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOActual implements AccountDAO
{

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


}
