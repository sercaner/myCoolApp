package com.udemy.myCoolApp.controller;

import com.udemy.myCoolApp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    /* @Autowired
    public DemoController( Coach coach){
        this.coach=coach;
    } */
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkOut() {
        return coach.getDailyWorkout();
    }
}
