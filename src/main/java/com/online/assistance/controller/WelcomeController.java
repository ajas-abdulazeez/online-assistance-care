package com.online.assistance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {


    @GetMapping("/ping")
    public String ping(){
        return "pong!!!";
    }

}
