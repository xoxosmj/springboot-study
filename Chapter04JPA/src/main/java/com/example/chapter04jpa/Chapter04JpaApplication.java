package com.example.chapter04jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"main.controller","member.controller"})
@SpringBootApplication
public class Chapter04JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter04JpaApplication.class, args);
    }

}
