package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ForkJoinTask;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {



    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {


        // print out method we are advising on
        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>>>> Executing @Around on method : " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now let's execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        }catch (Exception exc){
            // log the exception
            System.out.println(exc.getMessage());

            // rethrow the exception
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute the duration and display it
        long duration = end - begin;

        System.out.println("\n =====> Duration : " + duration / 1000.0 + "seconds");

        return result;

    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void AfterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>>>> Executing @After (finally) on method : " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>>>> Executing @AfterThrowing on method : " + method);

        // log the exception
        System.out.println("\n =====>>>>> the exception is : " + theExc);

    }
    // add a new advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>>>> Executing @AfterReturning on method : " + method);

        // print out the results of the method call
        System.out.println("\n =====>>>>> result is : " + result);

        // let's post-process the data ... modify it before it comes back to prgrm

        // convert the account name to uppercase
        convertAccountNameToUpperCase(result);
        System.out.println("\n =====>>>>> result is : " + result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        // loop through the account
        for(Account tempAccount: result){
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method addAcount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method <<=====" + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for(Object tempArgs : args){
            System.out.println(tempArgs);
            if(tempArgs instanceof Account){

                // downCast and print Account specific stuff
                Account theAcount = (Account) tempArgs;

                System.out.println("account name : " + theAcount.getName());
                System.out.println("account lvl: " + theAcount.getLevel());



            }
        }
    }

}
