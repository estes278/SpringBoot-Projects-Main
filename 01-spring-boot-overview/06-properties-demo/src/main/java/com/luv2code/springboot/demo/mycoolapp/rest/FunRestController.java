package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController
{
    // expose "/" that returns HelloWorld
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run five minutes without collapsing :D";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune()
    {
        return "You will have.... BIG TROUBLE. ";
    }

    // inject properties for coach and team name
    // these come from the application.properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name} ")
    private String teamName;

    // expose new endpoint for team info
    @GetMapping("/teaminfo")
    public String getTeamInfo()
    {
        return "Coach Name: " + coachName + ", Team Name: " + teamName;
    }
}
