package com.cowd.identifyservice.controller;

import com.cowd.identifyservice.dto.request.ApiResponse;
import com.cowd.identifyservice.dto.request.UserCreationRequest;
import com.cowd.identifyservice.dto.request.UserUpdateRequest;
import com.cowd.identifyservice.dto.response.UserResponse;
import com.cowd.identifyservice.entity.User;
import com.cowd.identifyservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(request));

        return response;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String id) {
        return userService.getUser(id);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@RequestBody UserUpdateRequest request,
                    @PathVariable("userId") String id) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String id) {
        userService.deleteUser(id);
        return "User has been deleted!";
    }

}
