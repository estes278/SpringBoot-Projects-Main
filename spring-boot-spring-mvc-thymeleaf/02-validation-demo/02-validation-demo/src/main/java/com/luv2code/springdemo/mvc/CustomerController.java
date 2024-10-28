package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{
    // add an initbinder to trim input strings
    // resolve issue for our validation
    // Pre-process every string form data, remove leading and trailing whitespace,
    // if string is only whitespace, trim it down to null
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        // initializing with true allows it to trim down to null if necessary
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        // by passing in String.class, it will automatically process every string
        // that goes through our controller
        dataBinder.registerCustomEditor(String.class, ste);
    }


    @GetMapping("/")
    public String showForm(Model theModel)
    {
        // Important that we use the same attribute name both here and on
        // our HTML form
        theModel.addAttribute("customer", new Customer());

        // Name of the HTML page
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult)
    {
        System.out.println("| Last Name: " + theCustomer.getLastName() + " |");
        if(theBindingResult.hasErrors())
            return "customer-form";
        else return "customer-confirmation";
    }

}
