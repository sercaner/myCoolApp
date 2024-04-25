package com.udemy.myCoolApp.controller;

import com.udemy.myCoolApp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

     @Autowired
    public DemoController(Coach coach){  //constructor injection
        this.coach=coach;
    }
    /*
    @Autowired
    public void setCoach(Coach coach) {    //setter injection
        this.coach = coach;
    }*/

    @GetMapping("/dailyworkout")
    public String dailyWorkOut() {
        return coach.getDailyWorkout();
    }
}
