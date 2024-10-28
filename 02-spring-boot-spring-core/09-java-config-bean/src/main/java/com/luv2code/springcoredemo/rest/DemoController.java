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

    // Uses Qualifier and the specific name "aquatic" to determine which
    // bean to use if multiple beans of the same type are found
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach)
    {
        System.out.println("In Constructor: " + getClass().getSimpleName() );
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

}
