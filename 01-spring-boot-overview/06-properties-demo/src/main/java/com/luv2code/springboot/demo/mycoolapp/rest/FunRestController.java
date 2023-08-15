package com.luv2code.springboot.demo.mycoolapp.rest;
import org.springframework.beans.factory.annotation.Value; // Importation ajoutée

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for : coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for teamInfo
    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "coach: " + coachName + "team: " + teamName;
    }

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
