package com.cowd.identifyservice.controller;

import com.cowd.identifyservice.dto.request.UserCreationRequest;
import com.cowd.identifyservice.entity.User;
import com.cowd.identifyservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

}
