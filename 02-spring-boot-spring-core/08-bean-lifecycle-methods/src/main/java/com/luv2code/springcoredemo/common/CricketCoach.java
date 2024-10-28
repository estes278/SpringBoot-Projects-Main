package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    public CricketCoach()
    {
        System.out.println("In Constructor: " + getClass().getSimpleName() );
    }
    // define our init method
    @PostConstruct
    public void doStartupStuff()
    {
        System.out.println("Doing Startup Stuff in: " + getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void doCleanupStuff()
    {
        System.out.println("Doing Cleanup Stuff in: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout()
    {
        return "Take slapshots for an hour!!! :D";
    }
}
