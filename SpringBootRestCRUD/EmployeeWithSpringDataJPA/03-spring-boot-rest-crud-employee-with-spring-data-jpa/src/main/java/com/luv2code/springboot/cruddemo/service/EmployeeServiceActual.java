package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceActual implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    // inject the DAO which is doing the actual CRUD work
    @Autowired
    public EmployeeServiceActual(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    // delegate this operation to the DAO
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    // delegate this operation to the DAO

    @Override
    public Employee findById(int id)
    {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent())
            employee = result.get();
        else throw new RuntimeException("Did not find employee with ID: " + id);

        return employee;
    }

    // delegate this operation to the DAO
    @Override
    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    // delegate this operation to the DAO
    @Override
    public void deleteById(int id)
    {
        employeeRepository.deleteById(id);
    }
}
