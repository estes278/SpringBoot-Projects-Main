package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach
{
    public CricketCoach()
    {
        System.out.println("In Constructor: " + getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout()
    {
        return "Take slapshots for an hour!!! :D";
    }
}
