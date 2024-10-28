package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController
{
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach)
    {
        System.out.println("In Constructor: " + getClass().getSimpleName() );
        myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check()
    {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
