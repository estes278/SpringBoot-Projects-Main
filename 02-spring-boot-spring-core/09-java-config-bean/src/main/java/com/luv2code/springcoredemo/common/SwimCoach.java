package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach
{
    public SwimCoach()
    {
        System.out.println("In Constructor of: " + getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout()
    {
        return "Ten Laps In The Pool!";
    }
}
