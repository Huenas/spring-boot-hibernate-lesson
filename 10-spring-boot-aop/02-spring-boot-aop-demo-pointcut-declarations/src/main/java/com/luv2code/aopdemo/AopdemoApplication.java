package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
                                               MembershipDAO theMembershipDAO,
                                               TrafficFortuneService theTrafficFortuneService){

        return runner -> {
            // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDAO);
            // demoTheAfterThrowingAdvice(theAccountDAO);
            // demoTheAfterAdvice(theAccountDAO);
            // demoTheAroundAdvice(theTrafficFortuneService);
            // demoTheAroundAdviceHandleException(theTrafficFortuneService);
            demoTheAroundAdviceRethrowException(theTrafficFortuneService);
        };
    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main program: demoTheAroundAdviceRethrowException");
        System.out.println("calling getFortune()");

        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\n My fortune is : " + data);

        System.out.println("Finished ");

    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\n Main program: demoTheAroundAdviceHandleException");
        System.out.println("calling getFortune()");

        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\n My fortune is : " + data);

        System.out.println("Finished ");


    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main program: demoTheAroundService");
        System.out.println("calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\n My fortune is : " + data);

        System.out.println("Finished ");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        // call method to find the accounts
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate the exception
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }catch(Exception exc){
            System.out.println("\n\nMain Program ... caught exception " + exc);
        }
        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("--------");
        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        // call method to find the accounts
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate the exception
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }catch(Exception exc){
            System.out.println("\n\nMain Program ... caught exception " + exc);
        }
        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("--------");
        System.out.println(theAccounts);
        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: demoAfterReturningAdvice");
        System.out.println("--------");
        System.out.println(theAccounts);
        System.out.println("\n");

    }


    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call the business method
        Account myAccount = new Account();
        myAccount.setName("Manu");
        myAccount.setLevel("testLevel");
        theAccountDAO.addAccount(myAccount, true);

        theAccountDAO.doWork();

        // call the accountDAO getter/setter methods
        theAccountDAO.setName("foorbar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

    }
}
