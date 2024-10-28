package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private EmployeeService employeeService;

    // Since we only have one constructor, Autowired is optional
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        // get the employees from the database
        List<Employee> theEmployees = employeeService.findAll();

        // add employee to the spring model
        theModel.addAttribute("employees", theEmployees);

        // name of the HTML page we'll return this view to
        return "employees/list-employees";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        // create and add model attribute for data binding the form data
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);

        // Return the HTML page we wish to go to
        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel)
    {
        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);


        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
        // save the Employee
        employeeService.save(theEmployee);

        System.out.println(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
