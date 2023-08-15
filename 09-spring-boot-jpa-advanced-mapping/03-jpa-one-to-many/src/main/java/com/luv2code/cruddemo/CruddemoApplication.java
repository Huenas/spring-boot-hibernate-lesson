package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            // createCourseAndReviews(appDAO);
            // retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int courseId = 10;
        System.out.println("deleting course id of :" + courseId);
        appDAO.deleteCourseById(courseId);
        System.out.println("done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
        // print the course
        System.out.println(tempCourse);
        // print the reviews
        System.out.println(tempCourse.getReviews());
        System.out.println("done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {

        // create the course
        Course tempCourse = new Course("Pacman - Course");
        // add some reviews
        tempCourse.addReview(new Review("Was a nice course, love it"));
        tempCourse.addReview(new Review("Was a really nice course"));
        tempCourse.addReview(new Review("Was all right"));

        // save the course
        System.out.println("saving the ourse");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());
        appDAO.save(tempCourse);
        System.out.println("done !");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        // find the course
        System.out.println("Course id : " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        tempCourse.setTitle("Enjoy simple things");

        appDAO.update(tempCourse);
        System.out.println("course updated");
    }

    private void updateInstructor(AppDAO appDAO) {

        int theId = 1;

        // find the instructor
        System.out.println("finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        tempInstructor.setFirstName("Manu");

        appDAO.update(tempInstructor);
        System.out.println("done, instructor updated");
    }

    private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {

        int theId = 1;
        //find the instructor
        System.out.println("the instructor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempinstructor : " + tempInstructor);
        System.out.println("associated courses : " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesByInstructorId(AppDAO appDAO) {
        int theId = 1;
        System.out.println("find courses id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempinstructor : " + tempInstructor);

        // find course for instructor
        System.out.println("finding courses for instructor id  : " + theId );
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);
        System.out.println("the associated courses : " + tempInstructor.getCourses() );
        System.out.println("done ! ");
    }

    private void findInstructorWithCourse(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Find instructor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor : " + tempInstructor);
        System.out.println("the associated course : " + tempInstructor.getCourses());

        System.out.println("done! ");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor = new Instructor("Susan","Darby","susan@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/youtube",
                "video games");
        Course tempCourse1 = new Course("course 1 - piano ");
        Course tempCourse2 = new Course("course 2 - guitar ");

        // add course to instructor
        tempInstructor.add(tempCourse1 );
        tempInstructor.add(tempCourse2 );

        // save instructor
        // NOTE : this will also save the course
        // because of CascadeType.PERSIST
        System.out.println("saving instructor : " + tempInstructor);
        System.out.println("the courses : " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("DONE");

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("deleting instructorDetail with id : " + theId);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
        // print the instructor detail
        System.out.println("the instructor detail is : " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("associated instructor : " + tempInstructorDetail.getInstructor());



    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("deleting instructor id of : " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("done");

    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("finding instructor id : " + theId );

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor : " + tempInstructor );
        System.out.println(" the associated instructordetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        /*
        // create the instructor
        Instructor tempInstructor = new Instructor("Chad","Darby","chademail@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
                "luv 2 code");
        */
        // create the instructor
        Instructor tempInstructor = new Instructor("Chad","Darby","chademail@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
                "luv 2 code");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // NOTE : this will also save the details objects
        // because of cascadetype.ALL
        System.out.println("saving instrucotr : " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("done!");
    }
}
