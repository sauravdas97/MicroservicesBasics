package com.microservice.user.controller;

import com.microservice.user.ValueObject.ResponseTemplate;
import com.microservice.user.entity.User;
import com.microservice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of controller");
        return userService.saveUser(user);
    }


    @GetMapping("/{userId}")
    public ResponseTemplate getUserWithDepartment(@PathVariable Long userId) {
        log.info("Inside saveUser of controller");
        return userService.getUserWithDepartment(userId);
    }
}
