package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOActual implements MembershipDAO
{

    @Override
    public void addAccount()
    {
        System.out.println("This is addAccount() of " + getClass() + "  but GO DEVILS!!! Two more Weeks!");
    }

    @Override
    public void goToSleep()
    {
        System.out.println(getClass() + " is sleeping.");
    }
}
