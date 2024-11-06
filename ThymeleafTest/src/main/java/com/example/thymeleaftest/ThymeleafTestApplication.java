package com.example.thymeleaftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"thymeleaf.controller","thymeleaf.bean"})
@SpringBootApplication
public class ThymeleafTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafTestApplication.class, args);
    }

}
