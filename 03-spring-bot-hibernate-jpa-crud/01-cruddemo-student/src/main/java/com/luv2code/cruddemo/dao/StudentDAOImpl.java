package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(Integer id)
    {
        return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> findAll()
    {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lastName)
    {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student Where lastName = :theData", Student.class);
        // set query parameters
        theQuery.setParameter("theData", lastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer studentID)
    {
       // retrieve student
       Student theStudent = entityManager.find(Student.class, studentID );
       // delete student
       entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll()
    {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
