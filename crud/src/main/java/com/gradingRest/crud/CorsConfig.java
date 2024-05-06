package com.gradingRest.crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Set class as Config class
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    //Set method from WebMvc and allow head methods
    /*
    Allowing cors connection for everybody in terms of testing,
    internet is not a safe place where you can allow access to * and **
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }



}
