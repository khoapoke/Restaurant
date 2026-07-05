package com.springboot.restaurant.modules.users.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.modules.users.dtos.response.UserResponse;

import com.springboot.restaurant.modules.users.services.interfaces.UserServiceInterface;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponse> getUsers() {

        return userService.getList();

    }

}
