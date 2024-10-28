package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // expose /employees endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    // add mapping for GET by id, /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById((employeeId));

        if(employee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return employee;
    }

    // add mapping for POST - adding a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        // in case the id is passed in JSON, we will set the id to 0
        // this is to force the save of a new item, instead of update

        employee.setId(0);

        // Add employee using service and return the result
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    // add mapping for DELETE /employees/{employeeId} - deletes employee with given id
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee with id: " + id + " was not found");

        employeeService.deleteById(id);

        return "Deleted employee with ID: " + id;
    }


}
