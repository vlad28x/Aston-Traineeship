package com.vlad28x.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;

@RequestMapping("/")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }


}
