package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOActual implements EmployeeDAO
{
    // define field for EntityManager
    private EntityManager entityManager;

    // set up constructor injection using Autowired
    @Autowired
    public EmployeeDAOActual(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get results list
        List<Employee> employees = query.getResultList();

        // return the results list
        return employees;
    }

    @Override
    public Employee findById(int id)
    {
        // Find the employee by id and return it right away
        // no reason to store it in a local variable
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee)
    {
        // merge will decide whether to create or update existing employee
        // then we return the result
        // no reason to store it in a local variable
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id)
    {
        // first we need to find it to ensure it exists
        // can't delete something that doesn't exist in the first place!
        Employee employee = entityManager.find(Employee.class, id);

        // now we assume the find operation was successful and delete it
        // Could likely use an exception handling clause in case this fails
        entityManager.remove(employee);
    }
}
