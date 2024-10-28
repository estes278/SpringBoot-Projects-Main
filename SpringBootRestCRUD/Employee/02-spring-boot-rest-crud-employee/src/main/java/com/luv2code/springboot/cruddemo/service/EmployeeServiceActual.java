package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceActual implements EmployeeService
{
    private EmployeeDAO employeeDAO;

    // inject the DAO which is doing the actual CRUD work
    @Autowired
    public EmployeeServiceActual(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    // delegate this operation to the DAO
    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    // delegate this operation to the DAO

    @Override
    public Employee findById(int id)
    {
        return employeeDAO.findById(id);
    }

    // delegate this operation to the DAO
    @Transactional
    @Override
    public Employee save(Employee employee)
    {
        return employeeDAO.save(employee);
    }

    // delegate this operation to the DAO
    @Transactional
    @Override
    public void deleteById(int id)
    {
        employeeDAO.deleteById(id);
    }
}
