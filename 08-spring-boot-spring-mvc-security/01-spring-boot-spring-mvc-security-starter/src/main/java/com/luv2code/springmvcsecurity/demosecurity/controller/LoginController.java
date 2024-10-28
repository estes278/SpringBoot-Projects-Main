package com.luv2code.springmvcsecurity.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage()
    {
        return "fancy-login";
    }

    // We're placing the access denied mapping here because it's security related
    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        return "access-denied";
    }
}
