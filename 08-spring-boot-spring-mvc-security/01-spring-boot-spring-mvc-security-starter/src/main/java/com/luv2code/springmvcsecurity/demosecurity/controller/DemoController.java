package com.luv2code.springmvcsecurity.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController
{
    @GetMapping("/")
    public String showHome()
    {
        // return the name of the page we're going to view
        return "home"; //.html
    }

    @GetMapping("/leaders")
    public String showLeaders()
    {
        return "leaders"; //.html
    }

    // Better than the ugly unformatted error page
    @GetMapping("/error")
    public String showError()
    {
        return "error"; //.html
    }

    @GetMapping("/systems")
    public String showSystems()
    {
        return "systems"; //.html
    }
}
