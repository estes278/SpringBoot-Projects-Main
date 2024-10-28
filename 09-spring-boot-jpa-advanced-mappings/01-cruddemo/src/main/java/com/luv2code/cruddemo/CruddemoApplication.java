package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	// executes after spring beans have been loaded
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner ->
		{
			 // createInstructor(appDAO);
			
			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			// deleteCourse(appDAO);

			// createCourseAndReviews(appDAO);

			// getCourseAndReviews(appDAO);

			// deleteCourseAndReviews(appDAO);

			// createCourseAndStudents(appDAO);

			findCourseAndStudents(appDAO);
		};
	}

	private void findCourseAndStudents(AppDAO appDAO)
	{
		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);
		System.out.println("Course Found: ");
		System.out.println(course);
		System.out.println("Students in this course: ");
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO)
	{
		// create courses
		// create students
		// add students to courses
		// save the course and associated students

		Course course = new Course("Slaying Evil 101");
		Student s1 = new Student("Trevor", "Belmont" ,"nothing@nothing.com");
		Student s2 = new Student("Sypher", "Velnades" ,"nothing@nothing.com");
		course.addStudent(s1);
		course.addStudent(s2);
		System.out.println("Saving course");
		appDAO.save(course);
		System.out.println(("Success!!!"));

	}

	private void deleteCourseAndReviews(AppDAO appDAO)
	{
		int id = 10;
		System.out.println("Deleting Course with ID: " + id + " as well as Associated Reviews");
		appDAO.deleteCourseById(id);
		System.out.println("Success!!!");
	}

	private void getCourseAndReviews(AppDAO appDAO)
	{
		int id = 10;
		System.out.println("Finding Course with ID: " + id + " and associated reviews");
		Course course = appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Success!!!");
	}

	private void createCourseAndReviews(AppDAO appDAO)
	{
		// create a course
		// add some reviews
		// save the course (and by cascade, the reviews!)

		Course course = new Course("NHL Defense 101");
		course.add(new Review("Outstanding! Simply the best!!!"));
		course.add(new Review("A real Barn Burner!"));
		course.add(new Review("ABSOLUTE DOGSHIT!"));

		System.out.println("Saving the course with following reviews...");
		System.out.println(course);
		System.out.println(course.getReviews());
		appDAO.save(course);
		System.out.println("Success!!!");

	}

	private void deleteCourse(AppDAO appDAO)
	{
		int id = 12;
		System.out.println("Deleting Course with ID: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Success!!!");
	}

	private void updateCourse(AppDAO appDAO)
	{
		// Remember that the SQL code for Course starts the Auto Increment at 10
		int id = 10;

		System.out.println("Finding course with ID: " + id);
		Course course = appDAO.findCourseById(id);
		System.out.println("Found! Details below: ");
		System.out.println(course);

		System.out.println("Updating course with ID: " + id);
		course.setTitle("Morningstar 202");

		appDAO.update(course);

		System.out.println("Done!");

		System.out.println(appDAO.findCourseById(id));
	}

	private void updateInstructor(AppDAO appDAO)
	{
		int id = 1;
		System.out.println("Finding Instructor with ID: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(("Instructor Found!"));
		System.out.println(instructor);

		System.out.println("Updating instructor with ID: " + id);
		instructor.setLastName("Velnades");

		appDAO.update(instructor);

		System.out.println("Success!!!");
		System.out.println(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO)
	{
		int id = 1;

		// find the instructor
		System.out.println("Finding Instructor with ID: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(("Instructor Found!"));
		System.out.println(instructor);
		System.out.println("Associated Courses for this Instructor: ");
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO)
	{
		int id = 1;

		// find the Instructor
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(("Instructor Found: " + instructor));

		// find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate the objects
		instructor.setCourses(courses);

		System.out.println("The Associated Courses for this Instructor: \n" + courses);
	}

	private void findInstructorWithCourses(AppDAO appDAO)
	{
		int id = 1;
		System.out.println("Finding instructor with ID: " + id);

		// Loads instructor but not courses since they are lazy by default
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor Found! Details: ");
		System.out.println(instructor);
		System.out.println("Associated Course List: ");
		System.out.println(instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO)
	{
		Instructor instructor = new Instructor("Trevor", "Belmont", "tbelmont@castlevania.com");
		InstructorDetail instructorDetail = new InstructorDetail("www.castlevania.com/youtube","Slaying Vampires and Defeating Death");
		Course course1 = new Course("Weapons 101");
		Course course2 = new Course("Dealing With Vampires 320");
		Course course3 = new Course("Being A Grumpy Drunk 123");
		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);
		instructorDetail.setInstructor(instructor);

		// save the instructor
		// this will also save the instructor details via the association we just set up
		// and the CascadeType.ALL (will also work for the other Cascade List we set up that only excludes Remove

		System.out.println("Saving instructor...");
		appDAO.save(instructor);
		System.out.println(("---Save Successful!"));


	}

	private void deleteInstructorDetail(AppDAO appDAO)
	{
		int id = 3;
		System.out.println("Deleting Instructor Detail with ID: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Working....");
		System.out.println("Success! Instructor with ID " + id + " has been successfully Deleted");
	}

	private void findInstructorDetail(AppDAO appDAO)
	{
		int id = 2;
		System.out.println("Finding instructor detail by id: " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Success!!!");
		System.out.println("Instructor Detail id found: " + instructorDetail);
		System.out.println("The Actual Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO)
	{
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Delete Successful");
	}

	private void findInstructor(AppDAO appDAO)
	{
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Searching....");
		System.out.println("Found! Instructor: " + instructor);
		System.out.println("Details for this Instructor: " + instructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO)
	{
		Instructor instructor = new Instructor("Trevor", "Belmont", "tbelmont@castlevania.com");
		InstructorDetail instructorDetail = new InstructorDetail("www.castlevania.com/youtube","Slaying Vampires and Defeating Death");

		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);
		instructorDetail.setInstructor(instructor);

		// save the instructor
		// this will also save the instructor details via the association we just set up
		// and the CascadeType.ALL

		System.out.println("Saving instructor...");
		appDAO.save(instructor);
		System.out.println(("---Save Successful!"));

	}

}
