package com.ritvik.springecom_backend.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public String greet(){
        return "Welcome to App";
    }
}
