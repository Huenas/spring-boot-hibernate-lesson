package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("in Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "swim 1k as a warmup" ;
    }
}
