package com.udemy.myCoolApp.controller;

import com.udemy.myCoolApp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    private Coach anotherCoach;


    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkOut() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: coach == anotherCoach : " + (coach == anotherCoach);
        // singleton:true
        // prototype:false
    }
}
