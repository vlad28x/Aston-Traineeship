package com.vlad28x.app.controller;

import com.vlad28x.app.entity.User;
import com.vlad28x.app.repository.impl.UserRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloController {

    private final UserRepositoryImpl userRepository;

    public HelloController(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public User hello() {
        return userRepository.findById(1L).orElse(new User());
    }


}
