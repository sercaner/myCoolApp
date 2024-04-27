package com.udemy.myCoolApp.config;

import com.udemy.myCoolApp.common.Coach;
import com.udemy.myCoolApp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("sercan")
    public Coach swimCoach() {
        return new SwimCoach();
        // swimCoach -> sercan
    }
}
