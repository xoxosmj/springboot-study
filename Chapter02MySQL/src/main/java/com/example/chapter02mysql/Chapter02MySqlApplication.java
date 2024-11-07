package com.example.chapter02mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"user.controller"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Chapter02MySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter02MySqlApplication.class, args);
    }

}
