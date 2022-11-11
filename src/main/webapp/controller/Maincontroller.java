package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maincontroller {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }
}
