package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String Hello(){
        return "hello ssw";
    }

    //endpoint workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "do a 5k";
    }

    //endpoint
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your luck";
    }
}
