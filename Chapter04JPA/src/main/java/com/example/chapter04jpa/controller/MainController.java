package com.example.chapter04jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // http://localhost:8080/ =>  index.html
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
