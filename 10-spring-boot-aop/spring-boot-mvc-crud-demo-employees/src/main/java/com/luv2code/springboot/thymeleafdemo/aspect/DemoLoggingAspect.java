package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup loger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){ }

    // do the same for service and dao
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forServicePackage(){ }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forDaoPackage(){ }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
        private void forAppFlow(){}

    // add @Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @Before: calling method: "+ theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through and display those arguments
        for (Object tempArgs : args){
            myLogger.info("=====> argument: " + tempArgs);
        }

    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display the method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @AfterReturning: calling method: "+ theMethod);
        // display data returned
        myLogger.info("=====>the result: " + theResult);
    }

}
