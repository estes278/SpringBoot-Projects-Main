package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdLineRunner(StudentDAO studentDAO)
	{
		return runner ->
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);

	}

	private void deleteAllStudents(StudentDAO studentDAO)
	{
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students from database.");
	}

	private void deleteStudent(StudentDAO studentDAO)
	{
		// print the student we are deleting
		int studentID = 1;
		System.out.println("Deleting student with ID: " + studentID);

		// perform delete operation
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		// retrieve student based on ID
		int studentID = 1;
		System.out.println("Getting student with ID: " + studentID);
		Student myStudent = studentDAO.findByID(studentID);

		// change first name to "Cortana"
		System.out.println("Updating student...");
		myStudent.setFirstName("Cortana");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO)
	{
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("ESTES");

		// display list of students
		for(Student s : theStudents)
			System.out.println(s);
	}

	private void queryForStudents(StudentDAO studentDAO)
	{
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent : theStudents)
			System.out.println(tempStudent);
	}

	private void readStudent(StudentDAO studentDAO)
	{
		// create student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Master","Chief","spartan117@unsc.com");

		// save student
		System.out.println("Saving the new student...");
		studentDAO.save(tempStudent);

		// display ID of saved student
		int studentID = tempStudent.getId();
		System.out.println("Displaying ID of new student: " + studentID);

		// retrieve student based on id (which is the primary key)
		System.out.println("Retrieving new student with ID: " + studentID);
		Student myStudent = studentDAO.findByID(studentID);

		// display the retrieved student
		System.out.println("Retrieval Success! Found Student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO)
	{
		// create multi students
		System.out.println("Creating new student objects...");
		Student tempStudent1 = new Student("Allan", "Estes", "estes278@gmail.com");
		Student tempStudent2 = new Student("Bianca", "Estes", "estes278@gmail.com");
		Student tempStudent3 = new Student("Dave", "Estes", "estes278@gmail.com");

		// save student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of the students
		System.out.println("Student Saved Successfully with ID: " + tempStudent1.getId());
		System.out.println("Student Saved Successfully with ID: " + tempStudent2.getId());
		System.out.println("Student Saved Successfully with ID: " + tempStudent3.getId());



	}

	private void createStudent(StudentDAO studentDAO)
	{
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Allan", "Estes", "estes278@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the student
		System.out.println("Student Saved Successfully with ID: " + tempStudent.getId());
	}
}
