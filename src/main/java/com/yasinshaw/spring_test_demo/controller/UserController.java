package com.yasinshaw.spring_test_demo.controller;

import com.yasinshaw.spring_test_demo.entity.User;
import com.yasinshaw.spring_test_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return userService.getUsers(null);
    }
}
