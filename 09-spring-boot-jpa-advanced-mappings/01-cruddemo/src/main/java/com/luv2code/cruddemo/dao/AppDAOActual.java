package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// needs to be annotated as Repository so Spring can find it during initialization
@Repository
public class AppDAOActual implements AppDAO
{
    // define field for entity manager
    // inject entity manager

    EntityManager entityManager;

    @Autowired
    public AppDAOActual(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // making a save/update/delete to needs to be transactional
    public void save(Instructor instructor)
    {
        entityManager.persist(instructor);
    }

    public Instructor findInstructorById(int id)
    {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id)
    {
        // find instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // get a list of his/her courses and break the associations
        // but DO NOT delete the courses!
        List<Course> courses = instructor.getCourses();
        for(Course course : courses)
            course.setInstructor(null);

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id)
    {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id)
    {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);

        // Remove the bi-directional association
        // Allows us to retain the Instructor while deleting the Instructor Detail
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id)
    {
        // create query to search for courses by instructor id
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        // we set up the parameter :data in the method call and then define it here
        // no need for the colon here : but it is needed above
        query.setParameter("data", id);

        // execute query and return the results
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id)
    {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data",
                Instructor.class);
        query.setParameter("data", id);

        // execute query and return result
        return query.getSingleResult();

    }

    @Override
    public Course findCourseById(int id)
    {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Instructor instructor)
    {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course)
    {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id)
    {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course)
    {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id)
    {
        // create and execute query to find multiple items
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id)
    {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c JOIN FETCH c.students where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();

    }
}
