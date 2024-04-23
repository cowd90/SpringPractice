package com.cowd.identifyservice.controller;

import com.cowd.identifyservice.dto.request.UserCreationRequest;
import com.cowd.identifyservice.dto.request.UserUpdateRequest;
import com.cowd.identifyservice.entity.User;
import com.cowd.identifyservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String id) {
        return userService.getUser(id);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request,
                    @PathVariable("userId") String id) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String id) {
        userService.deleteUser(id);
        return "User has been deleted!";
    }

}
