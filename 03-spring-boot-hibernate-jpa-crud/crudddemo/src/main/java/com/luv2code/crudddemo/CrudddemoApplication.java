package com.luv2code.crudddemo;

import com.luv2code.crudddemo.dao.StudentDao;
import com.luv2code.crudddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDao studentDAO) {
		System.out.println("deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleting : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDAO) {
	int studentId = 3;
	System.out.println("student to delete : " + studentId);
	studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDao studentDAO) {
		// retrieve student based on the id : primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student mystudent = studentDAO.findById(studentId);
		// change the first name to "scooby"
		System.out.println("updating student ...");
		mystudent.setFirstname("scooby");

		// update the student
		studentDAO.update(mystudent);
		// display the updated student
		System.out.println("updated student : " + mystudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDAO) {
		// get a list of Students
		List<Student> theStudents = studentDAO.findByLastName("jackzz");
		// display the list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();
		// display that list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDAO) {

		//create a student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("Julios","jackss","paul@gmail.com");

		// save the student
		System.out.println("saving student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student, generated id is : " + theId);

		//retrieve student based  on the id : primary key
		System.out.println("retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("found student : " + myStudent);

	}

	private void createMultipleStudent(StudentDao studentDAO) {
		// create multiple students
		Student tempStudent = new Student("paulqqq","jackss","paul@gmail.com");
		Student tempStudent1 = new Student("jean","jackzz","paul@gmail.com");
		Student tempStudent2 = new Student("juju","jackss","paul@gmail.com");

		//save the student objects
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
	}

	private void createStudent(StudentDao studentDAO) {
		// create the student object
		System.out.println("creating student object ... ");
		Student tempStudent = new Student("paul","jack","paul@gmail.com");
		// save the student object
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("saved student. Generated id : " + tempStudent.getId());
	}
}