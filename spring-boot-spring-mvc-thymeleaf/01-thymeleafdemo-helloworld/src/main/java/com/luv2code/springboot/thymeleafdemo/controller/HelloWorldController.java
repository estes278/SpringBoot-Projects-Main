package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController
{
    // controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    // controller method to process the form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "todayistheday";
    }

    // controller method to read form data and add it to the model
    @RequestMapping("/shout")
    public String letsShout(HttpServletRequest request, Model model)
    {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert that to all upper case using built in string methods
        theName = theName.toUpperCase();
        // create our own custom message based on their input
        String result = "HELLO THERE " + theName + "!!!";
        // add the resulting message to our model
        model.addAttribute("message", result);

        return "todayistheday";
    }

    // This time we will use @RequestParam to bind studentName from the form
    // to our own string variable theName
    @GetMapping("/three")
    public String three(@RequestParam("studentName") String theName, Model model)
    {

        // convert that to all upper case using built in string methods
        theName = theName.toUpperCase();

        // create our own custom message based on their input
        String result = "HELLO THERE " + theName + "! version 3 :D";

        // add the resulting message to our model
        model.addAttribute("message", result);

        return "todayistheday";
    }
}
