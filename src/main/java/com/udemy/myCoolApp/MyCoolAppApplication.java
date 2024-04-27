package com.udemy.myCoolApp;

import com.udemy.myCoolApp.dao.StudentDAO;
import com.udemy.myCoolApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*scanBasePackages = {"com.udemy.myCoolApp",
		"com.udemy.util"})
 */
@SpringBootApplication
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy.mail");

		// save the student
		studentDAO.save(tempStudent);
		System.out.println("Saving the student ...");

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("Oguz", "Mete","oğuz.221@gmail.com");
		Student tempStudent2 = new Student("Deniz", "Mete","deniz.221@gmail.com");
		Student tempStudent3 = new Student("Mehmet", "Han","Mehmet.221@gmail.com");
		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Sercan", "Er","sercaner.221@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
