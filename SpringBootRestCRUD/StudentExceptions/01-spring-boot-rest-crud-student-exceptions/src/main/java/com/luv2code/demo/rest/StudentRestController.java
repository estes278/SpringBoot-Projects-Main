package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    private List<Student> theStudents;

    // define @PostConstruct to load the student data only once (after construction)

    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Super", "Mario"));
        theStudents.add(new Student("Prince", "Mallow"));
        theStudents.add(new Student("Geno", "JustADoll"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents()
    {


        return theStudents;
    }

    // define endpoint "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        // check studentId against list size to ensure it is in bounds

        if ( (studentId >= theStudents.size() ) || (studentId < 0) )
            throw new StudentNotFoundException("Student id not found: " + studentId);

        // just index into the list... keep it simple for now!

        return theStudents.get(studentId);
    }





}
