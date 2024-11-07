package com.example.chapter02mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = {"user.controller","user.service","user.dao"})
@EnableTransactionManagement
@MapperScan("user.dao") //왓??
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Chapter02MySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter02MySqlApplication.class, args);
    }

}
