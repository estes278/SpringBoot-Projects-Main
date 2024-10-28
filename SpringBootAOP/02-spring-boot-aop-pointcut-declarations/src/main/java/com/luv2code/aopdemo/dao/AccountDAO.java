package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO
{
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
