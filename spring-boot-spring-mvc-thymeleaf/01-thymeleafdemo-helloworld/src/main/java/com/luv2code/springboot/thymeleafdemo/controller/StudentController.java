package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    // Here we use @value to pull the countries variable from the app.properties file
    @Value("${countries}")
    private List<String> countries;

    @Value("${teams}")
    private List<String> teams;

    @Value("${genres}")
    private List<String> genres;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel)
    {
        // create a new student object
        Student theStudent = new Student();

        // add student object to the model as an attribute
        // Two parameters - name (as a string) and the object itself
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);

        // add list of hockey teams from app.properties
        theModel.addAttribute("teams", teams);

        // add list of movie genres from app.properties
        theModel.addAttribute("genres", genres);

        return "student-form";
    }

    // Be sure to match the name of this endpoint to the one that you declared
    // on the HTML form, same thing with the student attribute in the model
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName()
        + " " + theStudent.getLastName());

        // Name of the HTML page
        return "student-confirmation";
    }


}
