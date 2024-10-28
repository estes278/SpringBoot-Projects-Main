package com.luv2code.aopdemo;

public class Account
{
    private String firstName;
    private String level;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public Account(String firstName, String level)
    {
        this.firstName = firstName;
        this.level = level;
    }
}
