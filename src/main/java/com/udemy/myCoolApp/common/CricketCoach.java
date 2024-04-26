package com.udemy.myCoolApp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

    // define out destroy method
    @PreDestroy
    public void doMyCleanStuff() {
        System.out.println("In doMyCleanStuff(): " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
