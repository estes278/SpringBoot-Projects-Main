package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceActual implements TrafficFortuneService
{
    @Override
    public String getFortune()
    {
        // simulate a delay
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "The Devils Will Win The Stanley Cup!!!";
    }

    @Override
    public String getFortune(boolean tripWire)
    {
        if(tripWire)
            throw new RuntimeException("\nTripped!!! Oh No!!!");

        return getFortune();
    }
}
