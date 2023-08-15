package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
             deleteInstructorDetail(appDAO);
        };
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
